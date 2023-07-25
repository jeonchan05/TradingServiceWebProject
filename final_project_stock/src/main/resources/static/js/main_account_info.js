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
		document.getElementById('valgalo').innerText = data;
	});
	
	stompClient.subscribe('/stock/garate', function(message) {
		const data = message.body;
		document.getElementById('garate').innerText = data;
	});
	
});