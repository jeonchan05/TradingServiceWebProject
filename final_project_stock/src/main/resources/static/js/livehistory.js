const socketlive = new SockJS('/websocket');
const stompClientlive = Stomp.over(socketlive);
stompClientlive.connect({}, function(frame) {

    stompClientlive.subscribe('/stock/ordertime', function(message) {
        const data = message.body;
        document.getElementById('ordertime').innerText = data;
    });

    stompClientlive.subscribe('/stock/excepttime', function(message) {
        const data = message.body;
        document.getElementById('excepttime').innerText = data;
    });

    stompClientlive.subscribe('/stock/ordernum', function(message) {
        const data = message.body;
        document.getElementById('ordernum').innerText = data;
    });

    stompClientlive.subscribe('/stock/stockname', function(message) {
        const data = message.body;
        document.getElementById('stockname').innerText = data;
    });

    stompClientlive.subscribe('/stock/orderprice', function(message) {
        const data = JSON.parse(message.body);
        document.getElementById('orderprice').innerText = data;
    });
    stompClientlive.subscribe('/stock/exceptprice', function(message) {
        const data = JSON.parse(message.body);
        document.getElementById('exceptprice').innerText = data;
    });

    stompClientlive.subscribe('/stock/exceptqty', function(message) {
        const data = JSON.parse(message.body);
        document.getElementById('exceptqty').innerText = data;
    });

    stompClientlive.subscribe('/stock/gubun', function(message) {
        const data = message.body;
        document.getElementById('gubun').innerText = data;
    });

});   