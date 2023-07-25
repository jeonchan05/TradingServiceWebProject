const socket = new SockJS('/websocket');
const stompClient = Stomp.over(socket);
stompClient.connect({}, function (frame) {
    stompClient.subscribe('/stock/kospivalue', function (message) {
        const data = JSON.parse(message.body);
        document.getElementById('kospidata').innerText = data; 
    });
    stompClient.subscribe('/stock/kospidate', function (message) {
        const data = message.body
        document.getElementById('date').innerText = data+' 기준'; 
    });
     stompClient.subscribe('/stock/exchangeusd', function (message) {
        const data = JSON.parse(message.body);
        document.getElementById('exchangeusd').innerText = data; 
    });
     stompClient.subscribe('/stock/exchangecny', function (message) {
        const data = JSON.parse(message.body);
        document.getElementById('exchangecny').innerText = data;
    });
});




