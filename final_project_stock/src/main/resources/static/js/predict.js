const socket = new SockJS('/websocket');
const stompClient = Stomp.over(socket);
stompClient.connect({}, function (frame) {
    stompClient.subscribe('/stock/004170action_channel', function (message) {
        const data = message.body;
        document.getElementById('shinpredict').innerText = data + " 추천"; 
    });
    stompClient.subscribe('/stock/031440action_channel', function (message) {
        const data = message.body;
        document.getElementById('shinfoodpredict').innerText = data + " 추천"; 
    });
     stompClient.subscribe('/stock/139480action_channel', function (message) {
        const data = message.body;
        document.getElementById('emartpredict').innerText = data + " 추천"; 
    });
    stompClient.subscribe('/stock/004170timepv', function (message) {
        const data = message.body;
        const shintime = data
        document.getElementById('shintime').innerText = shintime; 
    });
    stompClient.subscribe('/stock/031440timepv', function (message) {
        const data = message.body;
        const shinfoodtime = data
        document.getElementById('shinfoodtime').innerText = shinfoodtime; 
    });
    stompClient.subscribe('/stock/139480timepv', function (message) {
        const data = message.body;
        const emarttime = data
        document.getElementById('emarttime').innerText = emarttime; 
    });
});
