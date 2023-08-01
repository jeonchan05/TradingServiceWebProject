const Portfoliochart = Highcharts.chart('Portfoliochart', {
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
        text: 'portfolio value',
      },
    },
    series: [
      {
        name: 'portfolio value',
        data: [],
      },
    ],
    credits: {
      enabled: false,
    },
  });
  const shinfoodchartsocket = new SockJS('/websocket');
  const stompClientshinfoodchart = Stomp.over(shinfoodchartsocket);
  let shinfoodchartdate;
  stompClientshinfoodchart.connect({}, function (frame) {
    stompClientshinfoodchart.subscribe('/stock/031440timepv', function (message) {
        shinfoodchartdate = message.body;
    });
    stompClientshinfoodchart.subscribe('/stock/031440pv', function (message) {
      const shinfoodpv = JSON.parse(message.body);
 
      // 차트에 데이터 추가
      const x = shinfoodchartdate;
      const y = parseInt(shinfoodpv);
 
      if (x && y) {
        Portfoliochart.series[0].addPoint({ name: x, y }, true, Portfoliochart.series[0].data.length >= 60);
      }
    });
  });
 