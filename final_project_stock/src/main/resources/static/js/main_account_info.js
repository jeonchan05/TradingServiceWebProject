const socket = new SockJS('/websocket');
const stompClient = Stomp.over(socket);
stompClient.connect({}, function(frame) {

	stompClient.subscribe('/stock/odrbqty', function(message) {
		const data = JSON.parse(message.body);
		document.getElementById('odrbqty').innerText = data;
	});

	stompClient.subscribe('/stock/trbqty', function(message) {
		const data = JSON.parse(message.body);
		document.getElementById('trbqty').innerText = data;
	});

	stompClient.subscribe('/stock/avalpri', function(message) {
		const data = JSON.parse(message.body);
		document.getElementById('avalpri').innerText = data;
	});

	stompClient.subscribe('/stock/valgalo', function(message) {
		const data = JSON.parse(message.body);
		const valgalo = parseFloat(data)
		const valgalodiv = document.getElementById('valgalo');
		if (valgalo < 0) {
			document.getElementById('valgalo').innerText = valgalo;
			valgalodiv.style.color = "blue";
		} else {
			document.getElementById('valgalo').innerText = valgalo;
			valgalodiv.style.color = "red";
		}
	});

	stompClient.subscribe('/stock/garate', function(message) {
		const data = message.body;
		const garate = parseFloat(data)
		const garatediv = document.getElementById('garate');
		if (garate < 0) {
			document.getElementById('garate').innerText = garate + "%";
			garatediv.style.color = "blue";
		} else {
			document.getElementById('garate').innerText = garate + "%";
			garatediv.style.color = "red";
		}

	});

});