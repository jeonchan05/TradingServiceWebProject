document.addEventListener('DOMContentLoaded', function() {
	// Function to update the chart with new data
	function updateChart(chart, x, y) {
		if (x && y) {
			chart.series[0].addPoint({ name: x, y }, true, chart.series[0].data.length >= 100);
		}
	}

	// 서버에서 totalprofit 데이터 가져오는 API 호출
	fetch('/api/totalprofit')
		.then(response => response.json())
		.then(data => {
			// 데이터 날짜 기준으로 오름차순 정렬
			data.sort((a, b) => new Date(a.datetime) - new Date(b.datetime));

			// 데이터 가공
			const dates = data.map(entry => entry.datetime.substring(11));
			const values = data.map(entry => parseFloat(entry.totalProfit.substring(0,4)));
			// Highcharts를 이용하여 초기 그래프 생성
			const totalprofitchart = Highcharts.chart('totalprofitchart', {
				chart: {
					type: 'line',
				},
				title: {
					text: '',
				},
				xAxis: {
					type: 'category',
					categories: dates, // X축: 날짜
					title: {
						text: '시간'
					},
				},
				yAxis: {
					title: {
						text: '전체 수익률',
					},
				},
				series: [
					{
						name: '전체 수익률',
						data: values, // Y축: totalprofit 지수
						color:'rgba(18, 175, 79, 1)'
					},
				],
				credits: {
					enabled: false,
				},
			});

			// Real-time updates via WebSocket
			const sockettotalprofit = new SockJS('/websocket');
			const stompClienttotalprofit = Stomp.over(sockettotalprofit);
			let totalprofitdate;
			stompClienttotalprofit.connect({}, function(frame) {
				stompClienttotalprofit.subscribe('/stock/datetime', function(message) {
					totalprofitdate = message.body;
					totalprofitdate = totalprofitdate.substring(11);
					// 새로운 데이터가 들어올 때마다 dates 배열에 날짜를 추가
					dates.push(totalprofitdate);
					// 배열이 20개 이상이면 가장 오래된 데이터를 삭제하여 제한
					if (dates.length > 60) {
						dates.shift();
					}
					// X축의 카테고리 데이터를 업데이트
					totalprofitchart.xAxis[0].update({ categories: dates });
				});
				stompClienttotalprofit.subscribe('/stock/profitratechart', function(message) {
					totalprofitdata = JSON.parse(message.body);
					totalprofitdata = totalprofitdata.toString().substring(0,4);

					const x = totalprofitdate;
					const y = parseFloat(totalprofitdata);
					updateChart(totalprofitchart, x, y); // Pass the chart as a parameter
				});
			});
		});
});