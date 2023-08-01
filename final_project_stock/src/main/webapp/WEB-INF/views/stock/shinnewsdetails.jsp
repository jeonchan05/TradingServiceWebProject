<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
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
<link
	href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css"
	type="text/css" rel="stylesheet">
<link
	href="https://cdn.datatables.net/buttons/1.5.1/css/buttons.dataTables.min.css"
	type="text/css" rel="stylesheet">
<script type="text/javascript"
	src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="/js/main_news.js"></script>
<style type="text/css">
body {
	background-color: #fbfbfb;
}

@media ( min-width : 991.98px) {
	main {
		padding-left: 240px;
	}
}

#refresh {
	float: left;
	margin-left: 23px;
}

.newscontent {
	font-size: 20px;
	font-family: 'Spoqa Han Sans Neo', 'sans-serif';
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

#Transaction_details {
	
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

#title {
	font-family: 'Spoqa Han Sans Neo', 'sans-serif';
	font-size: 30px;
}
</style>
<title>뉴스</title>
<script src="/js/datatables.js"></script>
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
						class="list-group-item list-group-item-action py-2 ripple"><i
						class="fas fa-chart-line fa-fw me-3"></i><span>AI 추전 투자 차트</span></a>
					<a href="/rainbowcompany/login/news"
						class="list-group-item list-group-item-action py-2 ripple active"><i
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
	<main style="margin-top: 58px;">
		<div class="container pt-4">
			<div class="col-3xl-6 col-md-12 mb-4">
				<div class="card">
					<div class="card-body">
						<div class="d-flex justify-content-between p-md-1">
							<div class="d-flex flex-row">
								<div class="align-self-center">
									<h2 class="h5 mb-0 me-4"><a class="text-reset fw-bold" href="/rainbowcompany/login/news">CHANMONGNEWS</a></h2>
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
			<section class="mb-4">
				<div class="card">
					<div class="card-header text-left py-3">
						<h5 class="mb-0 text-left">
							<strong id="title">${shinNews.shintitle}</strong>
						</h5>
						<p class="mt-3">입력 ${shinNews.shindate}</p>
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<!-- <button onClick="window.location.reload()" id="refresh">
								<i class="fa-solid fa-rotate-right">매매내역 새로고침</i>
							</button> -->
							<div style="width: 1200px; margin: 40px auto 0">
								<div class="newscontent">${shinNews.shincontent}</div>
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