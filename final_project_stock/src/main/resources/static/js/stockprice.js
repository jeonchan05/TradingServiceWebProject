const socket = new SockJS('/websocket');
const stompClient = Stomp.over(socket);
stompClient.connect({}, function (frame) {
    stompClient.subscribe('/stock/price_004170', function (message) {
        const data = JSON.parse(message.body);
        document.getElementById('shinprice').innerText = data; 
    });
    stompClient.subscribe('/stock/price_031440', function (message) {
        const data = message.body
        document.getElementById('shinfoodprice').innerText = data.substr(0, 5);; 
    });
     stompClient.subscribe('/stock/price_139480', function (message) {
        const data = JSON.parse(message.body);
        document.getElementById('emartprice').innerText = data; 
    });
     
});




