const socket = new SockJS('/websocket');
const stompClient = Stomp.over(socket);
stompClient.connect({}, function (frame) {
    stompClient.subscribe('/stock/kospivalue', function (message) {
        const data = JSON.parse(message.body);
        const kospivalue = parseFloat(data)
    	result = kospivalue.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
        document.getElementById('kospidata').innerText = result; 
    });
    stompClient.subscribe('/stock/kospidate', function (message) {
        const data = message.body
        document.getElementById('date').innerText = data+' 기준'; 
    });
     stompClient.subscribe('/stock/exchangeusd', function (message) {
        const data = JSON.parse(message.body);
        const exchange = parseFloat(data)
    	result = exchange.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
        document.getElementById('exchangeusd').innerText = result; 
    });
     stompClient.subscribe('/stock/exchangecny', function (message) {
        const data = JSON.parse(message.body);
        document.getElementById('exchangecny').innerText = data;
    });
});




