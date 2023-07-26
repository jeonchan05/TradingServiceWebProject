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
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.5.1/sockjs.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script src="/js/accountinfo.js"></script>
<script src="/js/livehistory.js"></script>
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

#title {
	font-family: 'Spoqa Han Sans Neo', 'sans-serif';
	font-size: 30px;
}
</style>
<title>계좌정보</title>
<script src="/js/datatables.js"></script>
<script src="/js/main_account_info.js"></script>
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
						class="list-group-item list-group-item-action py-2 ripple active">
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
	<!--Main Navigation-->

	<!--Main layout-->
	<main style="margin-top: 58px;">
		<div class="container pt-4">
			<section class="mb-4">
				<div class="card">
					<div class="card-header text-center py-3">
						<h5 class="mb-0 text-center">
							<strong id="title">계좌정보 및 사용자 정보</strong>
						</h5>
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<table class="table align-middle mb-0 bg-white">
								<thead class="bg-light">
									<tr>
										<th>사용자 정보</th>
										<th>계좌번호</th>
										<th>결제잔고수량</th>
										<th>체결잔고수량</th>
										<th>총평가금액</th>
										<th>평가손익</th>
										<th>수익율</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>
											<div class="d-flex align-items-center">
												<img src="${image.imgnm}" alt=""
													style="width: 45px; height: 45px" class="rounded-circle" />
												<div class="ms-3">
													<p class="fw-bold mb-1">${username}</p>
													<p class="text-muted mb-0">${userid}</p>
												</div>
											</div>
										</td>
										<td>
											<p class="fw-normal mb-1">333-016784</p>
											<p class="text-muted mb-0"></p>
										</td>
										<td>
											<p class="fw-normal mb-1" id="odrbqty">${Odrbqty}</p>
											<p class="text-muted mb-0"></p>
										</td>
										<td>
											<p class="fw-normal mb-1" id="trbqty">${Trbqty}</p>
											<p class="text-muted mb-0"></p>
										</td>
										<td>
											<p class="fw-normal mb-1" id="avalpri">${Avalpri}</p>
											<p class="text-muted mb-0"></p>
										</td>
										<td>
											<p class="fw-normal mb-1" id="valgalo">${Valgalo}</p>
											<p class="text-muted mb-0"></p>
										</td>
										<td>
											<p class="fw-normal mb-1" id="garate">${Garate}</p>
											<p class="text-muted mb-0"></p>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</section>
			<section class="mb-4">
				<div class="card">
					<div class="card-header text-center py-3">
						<h5 class="mb-0 text-center">
							<strong id="title">실시간 매매</strong>
						</h5>
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<div style="width: 1200px; margin: 40px auto 0">
								<table id="Transaction_details2" class="display">
									<thead>
										<tr>
											<th>날짜</th>
											<th>주문번호</th>
											<th>종목코드</th>
											<th>종목이름</th>
											<th>주문수량</th>
											<th>총체결수량</th>
											<th>체결수량</th>
											<th>체결단가</th>
											<th>정정취소구분내용</th>
											<th>매매구분</th>
										</tr>
									</thead>
									<tbody>
											<tr>
												<td id="datetime">없음</td>
												<td id="odrnum">없음</td>
												<td id="stcode">없음</td>
												<td id="stname">없음</td>
												<td id="odrqty">없음</td>
												<td id="trallqty">없음</td>
												<td id="trqty">없음</td>
												<td id="trprice">없음</td>
												<td id="odrgubun">없음</td>
												<td id="trgubun">없음</td>
											</tr>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</section>
			<!-- 매매내역 -->
			<section class="mb-4">
				<div class="card">
					<div class="card-header text-center py-3">
						<h5 class="mb-0 text-center">
							<strong id="title">매매내역</strong>
						</h5>
					</div>
					<div class="card-body">
						<div class="table-responsive">
							<div style="width: 1200px; margin: 40px auto 0">
								<table id="Transaction_details" class="display">
									<thead>
										<tr>
											<th>날짜</th>
											<th>주문번호</th>
											<th>종목코드</th>
											<th>종목이름</th>
											<th>주문수량</th>
											<th>총체결수량</th>
											<th>체결수량</th>
											<th>체결단가</th>
											<th>정정취소구분내용</th>
											<th>매매구분</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach var="TradingList" items="${AllTradingHistory}"
											varStatus="status">
											<tr>
												<td>${TradingList.datetime}</td>
												<td>${TradingList.odrnum}</td>
												<td>${TradingList.stcode}</td>
												<td>${TradingList.stname}</td>
												<td>${TradingList.odrqty}</td>
												<td>${TradingList.trallqty}</td>
												<td>${TradingList.trqty}</td>
												<td>${TradingList.trprice}</td>
												<td>${TradingList.odrgubun}</td>
												<td>${TradingList.trgubun}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
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
<script type="text/javascript">
let password
let count = 0
pw = '<%=(String) session.getAttribute("userpassword")%>';
	while (true) {
		password = prompt('비밀번호 입력');
		if (password == pw) {
			alert('인증되었습니다.');
			break;
		} else {
			alert('잘못 입력하셨습니다.');
			window.history.back();
			break;
		}
	}
</script>
</html>