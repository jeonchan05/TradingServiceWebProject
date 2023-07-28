const socket = new SockJS('/websocket');
const stompClient = Stomp.over(socket);
stompClient.connect({}, function (frame) {
    stompClient.subscribe('/stock/price_004170', function (message) {
        const data = JSON.parse(message.body);
        const shin = parseInt(data)
    	result = shin.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
        document.getElementById('shinprice').innerText = result; 
    });
    stompClient.subscribe('/stock/price_031440', function (message) {
        const data = message.body
        const shinfood = parseInt(data)
    	result = shinfood.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
        document.getElementById('shinfoodprice').innerText = result; 
    });
     stompClient.subscribe('/stock/price_139480', function (message) {
        const data = JSON.parse(message.body);
        const emart = parseInt(data)
     	result = emart.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ',');
        document.getElementById('emartprice').innerText = result; 
    });
     
});




