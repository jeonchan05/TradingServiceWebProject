const socket = new SockJS('/websocket');
const stompClient = Stomp.over(socket);
stompClient.connect({}, function(frame) {

	stompClient.subscribe('/stock/balanceevaluationamount', function(message) {
		const data = JSON.parse(message.body);
		const balanceevaluationamount = parseFloat(data)
		result = balanceevaluationamount.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
		document.getElementById('balanceevaluationamount').innerText = result+"원";
	});

	stompClient.subscribe('/stock/jejus', function(message) {
		const data = JSON.parse(message.body);
		const jejus = parseFloat(data)
		result = jejus.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
		document.getElementById('jejus').innerText = result+"원";
	});
	
	stompClient.subscribe('/stock/d1jejus', function(message) {
		const data = JSON.parse(message.body);
		const d1jejus = parseFloat(data)
		result = d1jejus.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
		document.getElementById('d1jejus').innerText = result+"원";
	});
	
	stompClient.subscribe('/stock/d2jejus', function(message) {
		const data = JSON.parse(message.body);
		const d2jejus = parseFloat(data)
		result = d2jejus.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
		document.getElementById('d2jejus').innerText = result+"원";
	});


	stompClient.subscribe('/stock/investmentincome', function(message) {
		const data = message.body;
		const investmentincome = parseInt(data)
		const investmentincomediv = document.getElementById('investmentincome');
		if (investmentincome < 0) {
			result = investmentincome.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
			document.getElementById('investmentincome').innerText = result+"원";
			investmentincomediv.style.color = "blue";
		} else {
			result = investmentincome.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
			document.getElementById('investmentincome').innerText = result+"원";
			investmentincomediv.style.color = "red";
		}
	});

	stompClient.subscribe('/stock/profitrate', function(message) {
		const data = message.body;
		const profitrate = parseFloat(data)
		const profitratediv = document.getElementById('profitrate');
		if (profitrate < 0) {
			document.getElementById('profitrate').innerText = profitrate + "%";
			profitratediv.style.color = "blue";
		} else {
			document.getElementById('profitrate').innerText = profitrate + "%";
			profitratediv.style.color = "red";
		}

	});

});