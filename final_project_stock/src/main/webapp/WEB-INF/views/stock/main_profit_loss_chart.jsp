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
<script src="https://code.highcharts.com/highcharts.js"></script>
<script src="https://code.highcharts.com/modules/export-data.js"></script>
<script src="https://code.highcharts.com/modules/accessibility.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.1/sockjs.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script src="/js/predict.js"></script>
<style type="text/css">
h2, h4 {
	font-family: 'Spoqa Han Sans Neo', 'sans-serif';
}

#shinchart {
	align-content: center;
	font-family: 'Spoqa Han Sans Neo', 'sans-serif';
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
<title>AI 추천 투자 차트</title>
</head>
<body>
	<!--Main Navigation-->
	<header>
		<!-- Sidebar -->
		<nav id="sidebarMenu"
			class="collapse d-lg-block sidebar collapse bg-white">
			<div class="position-sticky">
				<div class="list-group list-group-flush mx-3 mt-4">
					<a href="/rainbowcompany/login/kospi&exchange"
						class="list-group-item list-group-item-action py-2 ripple"
						aria-current="true"> <i class="fa-solid fa-won-sign me-3"></i><span>코스피,
							환율</span>
					</a> <a href="/rainbowcompany/login/stockchart"
						class="list-group-item list-group-item-action py-2 ripple"> <i
						class="fa-solid fa-chart-column me-3"></i><span>종목 차트</span>
					</a> <a href="/rainbowcompany/login/accountinfo"
						class="list-group-item list-group-item-action py-2 ripple"> <i
						class="fa-solid fa-address-card me-3"></i><span>계좌정보</span>
					</a><a href="/rainbowcompany/login/profit&losschart"
						class="list-group-item list-group-item-action py-2 ripple active"><i
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
	<!--Main Navigation-->

	<!--Main layout-->
	<main style="margin-top: 58px">
		<div class="container pt-4">
			<section>
				<div class="row">
					<div class="col-3xl-6 col-md-12 mb-4">
						<div class="card">
							<div class="card-body">
								<div class="d-flex justify-content-between p-md-1">
									<div class="d-flex flex-row">
										<div class="align-self-center">
											<h2 class="h5 mb-0 me-4">AI 3개 종목 (매수, 매도, 관망) 추천</h2>
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
											<h2 class="h5 mb-0 me-4" id="shintime">${shinpredict.shinpreddate} 기준</h2>
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
											<h2 class="h5 mb-0 me-4" id="shinfoodtime">${shinfoodpredcit.shinfoodpreddate} 기준</h2>
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
											<h2 class="h5 mb-0 me-4" id="emarttime">${emartpredcit.emartpreddate} 기준</h2>
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
											<h2 class="h1 mb-0 me-4" id="shinpredict">${shinpredict.shinpredresult} 추천</h2>
										</div>
										<div>
											<h4>신세계 예측</h4>
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
											<h2 class="h1 mb-0 me-4" id="shinfoodpredict">${shinfoodpredcit.shinfoodpredresult} 추천</h2>
										</div>
										<div>
											<h4>신세계푸드 예측</h4>
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
											<h2 class="h1 mb-0 me-4" id="emartpredict">${emartpredcit.emartpredresult} 추천</h2>
										</div>
										<div>
											<h4>이마트 예측</h4>
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
							<div class="card-header text-center py-3">
								<h5 class="mb-0 text-center">
									<strong id="title">3종목 종합 수익률(%)</strong>
								</h5>
							</div>
							<div class="card-body">
								<div id="totalprofitchart" style="width: 600px; height: 500px;"></div>
								<script src="/js/allProfit.js"></script>
							</div>
						</div>
					</div>
					<div class="col-xl-6 col-md-12 mb-4">
						<div class="card">
							<div class="card-header text-center py-3">
								<h5 class="mb-0 text-center">
									<strong id="title">신세계 수익률(%)</strong>
								</h5>
							</div>
							<div class="card-body">
								<div id="shinprofitchart" style="width: 600px; height: 500px;"></div>
								<script src="/js/shinProfit.js"></script>
							</div>
						</div>
					</div>
					<div class="col-xl-6 col-md-12 mb-4">
						<div class="card">
							<div class="card-header text-center py-3">
								<h5 class="mb-0 text-center">
									<strong id="title">신세계 푸드 수익률(%)</strong>
								</h5>
							</div>
							<div class="card-body">
								<div id="shinfoodprofitchart"
									style="width: 600px; height: 500px;"></div>
								<script src="/js/shinFoodProfit.js"></script>
							</div>
						</div>
					</div>
					<div class="col-xl-6 col-md-12 mb-4">
						<div class="card">
							<div class="card-header text-center py-3">
								<h5 class="mb-0 text-center">
									<strong id="title">이마트 수익률(%)</strong>
								</h5>
							</div>
							<div class="card-body">
								<div id="emartprofitchart" style="width: 600px; height: 500px;"></div>
								<script src="/js/emartProfit.js"></script>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>
	</main>
	<!--Main layout-->
</body>
<%@include file="footer.jsp"%>
<!-- MDB -->
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.4.0/mdb.min.js"></script>
</html>