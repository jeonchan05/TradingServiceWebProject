document.addEventListener('DOMContentLoaded', function() {
	// Function to update the chart with new data
	function updateChart(chart, x, y) {
		if (x && y) {
			chart.series[0].addPoint({ name: x, y }, true, chart.series[0].data.length >= 100);
		}
	}

	// 서버에서 KOSPI 데이터 가져오는 API 호출
	fetch('/api/exchangechart')
		.then(response => response.json())
		.then(data => {
			// 데이터 날짜 기준으로 오름차순 정렬
			data.sort((a, b) => new Date(a.date) - new Date(b.date));

			// 데이터 가공
			const dates = data.map(entry => entry.date);
			const usd = data.map(entry => parseFloat(entry.usd));

			// Highcharts를 이용하여 초기 그래프 생성
			const exchangechart = Highcharts.chart('exchangechart', {
				chart: {
					type: 'line',
				},
				title: {
					text: '환율',
				},
				xAxis: {
					type: 'category',
					categories: dates
					, // X축: 날짜
					title: {
						text: '날짜'
					},
				},
				yAxis: {
					title: {
						text: '환율',
					},
				},
				series: [{
						name: '환율',
						data: usd,
						color: 'rgba(239, 68, 6, 1)',
				}],
				credits: {
					enabled: false,
				},
			});

			// Real-time updates via WebSocket
			const socketexchange = new SockJS('/websocket');
			const stompClientexchange = Stomp.over(socketexchange);
			let exchangedate;
			stompClientexchange.connect({}, function(frame) {
				stompClientexchange.subscribe('/stock/exchangedatemin', function(message) {
					exchangedate = message.body;
					// 새로운 데이터가 들어올 때마다 dates 배열에 날짜를 추가
					dates.push(exchangedate);
					// 배열이 20개 이상이면 가장 오래된 데이터를 삭제하여 제한
					if (dates.length > 60) {
						dates.shift();
					}
					// X축의 카테고리 데이터를 업데이트
					exchangechart.xAxis[0].update({ categories: dates });
				});
				stompClientexchange.subscribe('/stock/exchangeusdmin', function(message) {
					const usddata = JSON.parse(message.body);

					const x = exchangedate;
					const y = parseFloat(usddata);
					updateChart(exchangechart, x, y); // Pass the chart as a parameter
				});
			});
		});
});