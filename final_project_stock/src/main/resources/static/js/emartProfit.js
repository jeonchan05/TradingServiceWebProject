document.addEventListener('DOMContentLoaded', function() {
	// Function to update the chart with new data
	function updateChart(chart, x, y) {
		if (x && y) {
			chart.series[0].addPoint({ name: x, y }, true, chart.series[0].data.length >= 100);
		}
	}

	// 서버에서 KOSPI 데이터 가져오는 API 호출
	fetch('/api/stockprofitemart')
		.then(response => response.json())
		.then(data => {
			// 데이터 날짜 기준으로 오름차순 정렬
			data.sort((a, b) => new Date(a.datetime) - new Date(b.datetime));

			// 데이터 가공
			const dates = data.map(entry => entry.datetime.substring(11));
			const emartprofit = data.map(entry => parseFloat(entry.emartprofit));

			// Highcharts를 이용하여 초기 그래프 생성
			const emartprofitchart = Highcharts.chart('emartprofitchart', {
				chart: {
					type: 'line',
				},
				title: {
					text: '',
				},
				xAxis: {
					type: 'category',
					categories: dates
					, // X축: 날짜
					title: {
						text: '시간'
					},
				},
				yAxis: {
					title: {
						text: '이마트 수익률',
					},
				},
				series: [{
						name: '이마트 수익률',
						data: emartprofit,
						color: 'rgba(251, 180, 22, 1)',
				}],
				credits: {
					enabled: false,
				},
			});

			// Real-time updates via WebSocket
			const socketemartprofit = new SockJS('/websocket');
			const stompClientemartprofit = Stomp.over(socketemartprofit);
			let emartprofitdate;
			stompClientemartprofit.connect({}, function(frame) {
				stompClientemartprofit.subscribe('/stock/datetime', function(message) {
					emartprofitdate = message.body;
					emartprofitdate = emartprofitdate.substring(11);
					// 새로운 데이터가 들어올 때마다 dates 배열에 날짜를 추가
					dates.push(emartprofitdate);
					// 배열이 20개 이상이면 가장 오래된 데이터를 삭제하여 제한
					if (dates.length > 60) {
						dates.shift();
					}
					// X축의 카테고리 데이터를 업데이트
					emartprofitchart.xAxis[0].update({ categories: dates });
				});
				stompClientemartprofit.subscribe('/stock/emartprofit', function(message) {
					const emartprofitddata = JSON.parse(message.body);

					const x = emartprofitdate;
					const y = parseFloat(emartprofitddata);
					updateChart(emartprofitchart, x, y); // Pass the chart as a parameter
				});
			});
		});
});