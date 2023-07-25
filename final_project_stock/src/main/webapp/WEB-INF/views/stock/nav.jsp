<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='//spoqa.github.io/spoqa-han-sans/css/SpoqaHanSansNeo.css'
	rel='stylesheet' type='text/css'>
<style type="text/css">
.mainlogo{
margin-left: 21%;
}

.rounded-circle {
	width: 35px;
	height: 35px;
	border-radius: 50px;
}

.username {
	float: right;
	margin-top: 13px;
	margin-right: 10px;
	font-size: 17px;
	font-family: 'Spoqa Han Sans Neo', 'sans-serif';
}
</style>
<script>
	const dpTime = function() {
		const now = new Date()
		let hours = now.getHours()
		let minutes = now.getMinutes()
		let seconds = now.getSeconds()
		let ampm = ''
		if (hours > 12) {
			hours -= 12
			ampm = '오후'
		} else {
			ampm = '오전'
		}
		if (hours < 10) {
			hours = '0' + hours
		}
		if (minutes < 10) {
			minutes = '0' + minutes
		}
		if (seconds < 10) {
			seconds = '0' + seconds
		}
		document.querySelector('#time').innerHTML = ampm + " " + hours + ":"
				+ minutes + ":" + seconds
	}
	setInterval(dpTime, 1000) // 1초마다 함수 실행되도록 설정
</script>
</head>
<body>
	<nav id="main-navbar"
		class="navbar navbar-expand-lg navbar-light bg-white fixed-top">
		<a href="/rainbowcompany/login/kospi&exchange"><img src="/images/mainlogo.png"
				class="mainlogo" width="160px" height="60px" alt="rainbow" /></a>
		<!-- Container wrapper -->
		<div class="container-fluid">
			<!-- Toggle button -->
			<button class="navbar-toggler" type="button"
				data-mdb-toggle="collapse" data-mdb-target="#sidebarMenu"
				aria-controls="sidebarMenu" aria-expanded="false"
				aria-label="Toggle navigation">
				<i class="fas fa-bars"></i>
			</button>

			<!-- Brand -->
			<a class="navbar-brand" href="/rainbowcompany/login/kospi&exchange"> <!-- <img
				src="/images/mainlogo5.jpg" height="40"  alt="rainbow" loading="lazy" /> -->
				<!-- <strong id="main">RAINBOW COMPANY</strong> -->
			</a>
				<div class="autocomplete"></div>
			<!-- Right links -->
			<ul class="navbar-nav ms-auto d-flex flex-row">
				<!-- Icon -->
				<li class="nav-item me-3 me-lg-0">
					<div class="username" id="time"></div>
				</li>
				<li class="nav-item me-3 me-lg-0">
					<div class="username">${username}님 환영합니다</div>
				</li>

				<!-- Avatar -->
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle hidden-arrow d-flex align-items-center"
					href="#" id="navbarDropdownMenuLink" role="button"
					data-mdb-toggle="dropdown" aria-expanded="false"> <img
						src="${image.imgnm}" class="rounded-circle" height="22"
						alt="프로필 사진" />
				</a>
					<ul class="dropdown-menu dropdown-menu-end"
						aria-labelledby="navbarDropdownMenuLink">
						<li><a class="dropdown-item">${username}</a></li>
						<li><a class="dropdown-item" href="/rainbowcompany/login/accountinfo">내
								계좌정보</a></li>
						<li><a class="dropdown-item" href="/rainbowcompany/removesession">로그아웃</a>
						</li>
					</ul></li>
			</ul>
		</div>
		<!-- Container wrapper -->
	</nav>
</body>
</html>