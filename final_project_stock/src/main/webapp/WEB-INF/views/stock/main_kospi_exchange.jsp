<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
	rel="stylesheet" />
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet" />
<!-- MDB -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.css"
	rel="stylesheet" />
<link href='//spoqa.github.io/spoqa-han-sans/css/SpoqaHanSansNeo.css'
	rel='stylesheet' type='text/css'>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.1/sockjs.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/exporting.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<script src="/js/exchangekospi.js"></script>
<style type="text/css">
h2, h4 {
	font-family: 'Spoqa Han Sans Neo', 'sans-serif';
}

#kospichart {
	margin: auto;
	font-family: 'Spoqa Han Sans Neo', 'sans-serif';
}

#exchangechart {
	margin: auto;
	font-family: 'Spoqa Han Sans Neo', 'sans-serif';
}

canvas {
	margin-left: auto;
	margin-right: auto;
	margin-bottom: auto;
	margin-top: auto;
}

body {
	background-color: #fbfbfb;
}

@media ( min-width : 991.98px) {
	main {
		padding-left: 240px;
	}
}

/* Sidebar */
.sidebar {
	position: fixed;
	top: 0;
	bottom: 0;
	left: 0;
	padding: 58px 0 0; /* Height of navbar */
	box-shadow: 0 2px 5px 0 rgb(0 0 0/ 5%), 0 2px 10px 0 rgb(0 0 0/ 5%);
	width: 240px;
	z-index: 600;
	font-family: 'Spoqa Han Sans Neo', 'sans-serif';
}

.imagemoney {
	margin-top: 13px;
}

@media ( max-width : 991.98px) {
	.sidebar {
		width: 100%;
	}
}

.sidebar .active {
	border-radius: 5px;
	box-shadow: 0 2px 5px 0 rgb(0 0 0/ 16%), 0 2px 10px 0 rgb(0 0 0/ 12%);
}

.sidebar-sticky {
	position: relative;
	top: 0;
	height: calc(100vh - 48px);
	padding-top: 0.5rem;
	overflow-x: hidden;
	overflow-y: auto;
}
</style>
<title>코스피&환율</title>
</head>
<body>
	<!--Main Navigation-->
	<header>
		<!-- Sidebar -->
		<nav id="sidebarMenu"
			class="collapse d-lg-block sidebar collapse bg-white">
			<p class="mb-0"></p>
			<div class="position-sticky">
				<div class="list-group list-group-flush mx-3 mt-4">
					<a href="/rainbowcompany/login/kospi&exchange"
						class="list-group-item list-group-item-action py-2 ripple active"
						aria-current="true"> <i class="fa-solid fa-won-sign me-3"></i><span>코스피,
							환율</span>
					</a> <a href="/rainbowcompany/login/stockchart"
						class="list-group-item list-group-item-action py-2 ripple"> <i
						class="fa-solid fa-chart-column me-3"></i><span>종목 차트</span>
					</a> <a href="/rainbowcompany/login/accountverify"
						class="list-group-item list-group-item-action py-2 ripple">
						<i class="fa-solid fa-address-card me-3"></i><span>계좌정보</span>
					</a><a href="/rainbowcompany/login/profit&losschart"
						class="list-group-item list-group-item-action py-2 ripple"><i
						class="fas fa-chart-line fa-fw me-3"></i><span>AI 추전 투자 차트</span></a>
					<a href="/rainbowcompany/login/news"
						class="list-group-item list-group-item-action py-2 ripple"><i
						class="fa-solid fa-newspaper fa-fw me-3"></i><span>주요 종목 뉴스</span></a>
					<a href="/rainbowcompany/login/siteintroduce"
						class="list-group-item list-group-item-action py-2 ripple"><i
						class="fa-solid fa-building fa-fw me-3"></i><span>소개</span></a>
				</div>
			</div>
		</nav>
		<!-- Sidebar -->

		<!-- Navbar -->
		<%@include file="nav.jsp"%>
		<!-- Navbar -->
	</header>
	<main style="margin-top: 58px">
		<div class="container pt-4">
			<section class="mt-4">
				<div class="row">
					<div class="col-3xl-6 col-md-12 mb-4">
						<div class="card">
							<div class="card-body">
								<div class="d-flex justify-content-between p-md-1">
									<div class="d-flex flex-row">
										<div class="align-self-center">
											<h2 class="h5 mb-0 me-4" id="date">시간</h2>
										</div>
										<div>
											<h4></h4>
											<p class="mb-0"></p>
										</div>
									</div>
									<div class="align-self-center"></div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-4 col-md-12 mb-4">
						<div class="card">
							<div class="card-body">
								<div class="d-flex justify-content-between p-md-1">
									<div class="d-flex flex-row">
										<div class="align-self-center">
											<h2 class="h1 mb-0 me-4" id="exchangeusd">로딩중...</h2>
										</div>
										<div>
											<h4>USD-KRW</h4>
											<h4>환율 (초)</h4>
											<p class="mb-0"></p>
										</div>
									</div>
									<div class="align-self-center"></div>
									<img src="/images/won.png" height="45" alt="won"
										class="imagemoney" />
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-4 col-md-12 mb-4">
						<div class="card">
							<div class="card-body">
								<div class="d-flex justify-content-between p-md-1">
									<div class="d-flex flex-row">
										<div class="align-self-center">
											<h2 class="h1 mb-0 me-4" id="exchangecny">로딩중...</h2>
										</div>
										<div>
											<h4>USD-CNY</h4>
											<h4>환율 (초)</h4>
											<p class="mb-0"></p>
										</div>
									</div>
									<div class="align-self-center"></div>
									<img src="/images/cny.png" height="45" alt="cny"
										class="imagemoney" />
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-4 col-md-12 mb-4">
						<div class="card">
							<div class="card-body">
								<div class="d-flex justify-content-between p-md-1">
									<div class="d-flex flex-row">
										<div class="align-self-center">
											<h2 class="h1 mb-0 me-4" id="kospidata">로딩중...</h2>
										</div>
										<div>
											<h4>KOSPI 코스피</h4>
											<h4>지수 (초)</h4>
											<p class="mb-0"></p>
										</div>
									</div>
									<div class="align-self-center"></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>

			<section>
				<div class="row">
					<div class="col-xl-6 col-md-12 mb-4">
						<div class="card">
							<div class="card-header py-3">
								<h5 class="mb-0 text-center">
									<strong>환율 실시간 그래프(분 단위)</strong>
								</h5>
							</div>
							<div class="card-body"></div>
							<div id="exchangechart" style="width: 600px; height: 450px;"></div>
						</div>
					</div>
					<div class="col-xl-6 col-md-12 mb-4">
						<div class="card">
							<div class="card-header py-3">
								<h5 class="mb-0 text-center">
									<strong>코스피지수 실시간 그래프(분 단위)</strong>
								</h5>
							</div>
							<div class="card-body"></div>
							<div id="kospichart" style="width: 600px; height: 450px;"></div>
						</div>
					</div>
				</div>
			</section>
			<section>
				<div class="row">
					<div class="col-xl-6 col-md-12 mb-4">
						<div class="card">
							<div class="card-header py-3">
								<h5 class="mb-0 text-center">
									<strong>코스피지수 과거 그래프(일 단위)</strong>
								</h5>
							</div>
							<div class="card-body">
								<div class="tradingview-widget-container">
									<div id="tradingview_a3bfb"></div>
									<script type="text/javascript"
										src="https://s3.tradingview.com/tv.js"></script>
									<script type="text/javascript">
										new TradingView.widget(
												{
													"width" : 550,
													"height" : 400,
													"symbol" : "KRX:KOSPI",
													"interval" : "D",
													"timezone" : "Asia/Seoul",
													"theme" : "light",
													"style" : "1",
													"locale" : "kr",
													"toolbar_bg" : "#f1f3f6",
													"enable_publishing" : false,
													"withdateranges" : true,
													"allow_symbol_change" : true,
													"container_id" : "tradingview_a3bfb"
												});
									</script>
								</div>
							</div>
						</div>
					</div>
					<div class="col-xl-6 col-md-12 mb-4">
						<div class="card">
							<div class="card-header py-3">
								<h5 class="mb-0 text-center">
									<strong>환율 과거 그래프(일 단위)</strong>
								</h5>
							</div>
							<div class="card-body">
								<div class="tradingview-widget-container">
									<div id="tradingview_b40c8"></div>
									<script type="text/javascript"
										src="https://s3.tradingview.com/tv.js"></script>
									<script type="text/javascript">
										new TradingView.widget(
												{
													"width" : 550,
													"height" : 400,
													"symbol" : "FX_IDC:USDKRW",
													"interval" : "D",
													"timezone" : "Asia/Seoul",
													"theme" : "light",
													"style" : "1",
													"locale" : "kr",
													"toolbar_bg" : "#f1f3f6",
													"enable_publishing" : false,
													"withdateranges" : true,
													"allow_symbol_change" : true,
													"container_id" : "tradingview_b40c8"
												});
									</script>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
	</main>
</body>
<%@include file="footer.jsp"%>
${msg}
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="/js/exchangechart.js"></script>
<script src="/js/kospichart.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.js"></script>
</html>