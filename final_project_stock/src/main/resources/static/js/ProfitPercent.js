const percentsocket = new SockJS('/websocket');
const percentstompClient = Stomp.over(percentsocket);
percentstompClient.connect({}, function (frame) {
    percentstompClient.subscribe('/stock/shinprofit', function (message) {
        const data = JSON.parse(message.body);
        const shin = parseFloat(data)
        document.getElementById('shin').innerText = shin; 
    });
    percentstompClient.subscribe('/stock/foodprofit', function (message) {
        const data = JSON.parse(message.body);
        const shinfood = parseFloat(data)
        document.getElementById('shinfood').innerText = shinfood; 
    });
    percentstompClient.subscribe('/stock/emartprofit', function (message) {
        const data = JSON.parse(message.body);
        const emart = parseFloat(data)
        document.getElementById('emart').innerText = emart; 
    });
    percentstompClient.subscribe('/stock/profitratechart', function (message) {
        const data = JSON.parse(message.body);
        const total = parseFloat(data)
        document.getElementById('total').innerText = total; 
    });
});