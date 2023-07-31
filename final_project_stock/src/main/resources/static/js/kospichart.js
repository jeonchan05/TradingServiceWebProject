document.addEventListener('DOMContentLoaded', function() {
	// Function to update the chart with new data
	function updateChart(chart, x, y) {
		if (x && y) {
			chart.series[0].addPoint({ name: x, y }, true, chart.series[0].data.length >= 100);
		}
	}

	// 서버에서 KOSPI 데이터 가져오는 API 호출
	fetch('/api/kospichart')
		.then(response => response.json())
		.then(data => {
			// 데이터 날짜 기준으로 오름차순 정렬
			data.sort((a, b) => new Date(a.date) - new Date(b.date));

			// 데이터 가공
			const dates = data.map(entry => entry.date.substring(11));
			const values = data.map(entry => parseFloat(entry.value));

			// Highcharts를 이용하여 초기 그래프 생성
			const kospichart = Highcharts.chart('kospichart', {
				chart: {
					type: 'line',
				},
				title: {
					text: 'KOSPI',
				},
				xAxis: {
					type: 'category',
					categories: dates, // X축: 날짜
					title: {
						text: '날짜'
					},
				},
				yAxis: {
					title: {
						text: 'KOSPI Value',
					},
				},
				series: [
					{
						name: 'KOSPI',
						data: values, // Y축: KOSPI 지수
						color:'rgba(95, 4, 159, 1)'
					},
				],
				credits: {
					enabled: false,
				},
			});

			// Real-time updates via WebSocket
			const socketkospi = new SockJS('/websocket');
			const stompClientkospi = Stomp.over(socketkospi);
			let kospidate;
			stompClientkospi.connect({}, function(frame) {
				stompClientkospi.subscribe('/stock/kospidatemin', function(message) {
					kospidate = message.body;
					kospidate = kospidate.substring(11);
					// 새로운 데이터가 들어올 때마다 dates 배열에 날짜를 추가
					dates.push(kospidate);
					// 배열이 20개 이상이면 가장 오래된 데이터를 삭제하여 제한
					if (dates.length > 60) {
						dates.shift();
					}
					// X축의 카테고리 데이터를 업데이트
					kospichart.xAxis[0].update({ categories: dates });
				});
				stompClientkospi.subscribe('/stock/kospivaluemin', function(message) {
					const kospidata = JSON.parse(message.body);

					const x = kospidate;
					const y = parseFloat(kospidata);
					updateChart(kospichart, x, y); // Pass the chart as a parameter
				});
			});
		});
});