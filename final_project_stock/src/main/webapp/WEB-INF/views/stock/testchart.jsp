<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>실시간 차트</title>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.1/sockjs.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
</head>
<body>

	<div id="exchangechart" style="width: 550px; height: 400px;"></div>
</body>
<script type="text/javascript">
//초기 차트 설정
 const chart = Highcharts.chart('exchangechart', {
   chart: {
     type: 'line',
   },
   title: {
     text: '실시간 동적 차트',
   },
   xAxis: {
     type: 'category',
   },
   yAxis: {
     title: {
       text: 'exchangeusd',
     },
   },
   series: [
     {
       name: 'exchangeusd',
       data: [],
     },
   ],
   credits: {
     enabled: false,
   },
 });

 const socket = new SockJS('/websocket');
 const stompClient = Stomp.over(socket);
 let kospidate;
 stompClient.connect({}, function (frame) {
   stompClient.subscribe('/stock/kospidate', function (message) {
     kospidate = message.body;
   });
   stompClient.subscribe('/stock/exchangeusd', function (message) {
     const data = JSON.parse(message.body);

     // 차트에 데이터 추가
     const x = kospidate;
     const y = parseFloat(data);

     if (x && y) {
       chart.series[0].addPoint({ name: x, y }, true, chart.series[0].data.length >= 20);
     }
   });
 });

 </script>
</html>
