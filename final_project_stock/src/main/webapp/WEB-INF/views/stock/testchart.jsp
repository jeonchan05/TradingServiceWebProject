<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>실시간 차트</title>
<!-- Highcharts 라이브러리 추가 -->
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
</head>

<body>
	<div id="kospiChart"></div>
</body>
<script type="text/javascript">
    document.addEventListener('DOMContentLoaded', function () {
        // 서버에서 KOSPI 데이터 가져오는 API 호출
        fetch('/api/kospiChart')
            .then(response => response.json())
            .then(data => {
                // 데이터 날짜 기준으로 오름차순 정렬
                data.sort((a, b) => new Date(a.date) - new Date(b.date));

                // 데이터 가공
                const dates = data.map(entry => entry.date);
                const values = data.map(entry => parseFloat(entry.value));

                // Highcharts를 이용하여 그래프 생성
                Highcharts.chart('kospiChart', {
                    chart: {
                        type: 'line' // 차트 유형: 선 그래프
                    },
                    title: {
                        text: 'KOSPI'
                    },
                    xAxis: {
                        categories: dates, // X축: 날짜
                        title: {
                            text: 'Date'
                        }
                    },
                    yAxis: {
                        title: {
                            text: 'KOSPI Value'
                        }
                    },
                    series: [{
                        name: 'KOSPI',
                        data: values // Y축: KOSPI 지수
                    }]
                });
            })
    });

</script>
</html>
