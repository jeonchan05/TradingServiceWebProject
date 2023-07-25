const socket = new SockJS('/websocket');
const stompClient = Stomp.over(socket);
stompClient.connect({}, function (frame) {
    stompClient.subscribe('/stock/004170action_channel', function (message) {
        const data = JSON.parse(message.body);
        document.getElementById('shinpredict').innerText = data; 
    });
    stompClient.subscribe('/stock/031440action_channel', function (message) {
        const data = JSON.parse(message.body);
        document.getElementById('shinfoodpredict').innerText = data; 
    });
     stompClient.subscribe('/stock/031440action_channel', function (message) {
        const data = JSON.parse(message.body);
        document.getElementById('emartpredict').innerText = data; 
    });
});
