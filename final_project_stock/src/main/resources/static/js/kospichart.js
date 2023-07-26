const kospichart = Highcharts.chart('kospichart', {
    chart: {
      type: 'line',
    },
    title: {
      text: '',
    },
    xAxis: {
      type: 'category',
    },
    yAxis: {
      title: {
        text: 'KOSPI',
      },
    },
    series: [
      {
        name: 'KOSPI',
        data: [],
      },
    ],
    credits: {
      enabled: false,
    },
  });
  const socketkospi = new SockJS('/websocket');
  const stompClientkospi = Stomp.over(socketkospi);
  let kospidate;
  stompClientkospi.connect({}, function (frame) {
    stompClientkospi.subscribe('/stock/kospidatemin', function (message) {
      kospidate = message.body;
    });
    stompClientkospi.subscribe('/stock/kospivaluemin', function (message) {
      const kospidata = JSON.parse(message.body);
 
      // 차트에 데이터 추가
      const x = kospidate;
      const y = parseFloat(kospidata);
 
      if (x && y) {
        kospichart.series[0].addPoint({ name: x, y }, true, kospichart.series[0].data.length >= 100);
      }
    });
  });
 