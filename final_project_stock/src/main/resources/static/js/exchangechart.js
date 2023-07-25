const exchangechart = Highcharts.chart('exchangechart', {
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
        text: '환율',
      },
    },
    series: [
      {
        name: '환율',
        data: [],
      },
    ],
    credits: {
      enabled: false,
    },
  });
  const socketexchange = new SockJS('/websocket');
  const stompClientexchange = Stomp.over(socketexchange);
  let exchangedate;
  stompClientexchange.connect({}, function (frame) {
    stompClientexchange.subscribe('/stock/exchangedatemin', function (message) {
      exchangedate = message.body;
    });
    stompClientexchange.subscribe('/stock/exchangeusdmin', function (message) {
      const exchangeusd = JSON.parse(message.body);
 
      // 차트에 데이터 추가
      const x = exchangedate;
      const y = parseFloat(exchangeusd);
 
      if (x && y) {
        exchangechart.series[0].addPoint({ name: x, y }, true, exchangechart.series[0].data.length >= 360);
      }
    });
  });
 