<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
div {
	border: solid 1px #000;
	font-weight: bold;
	font-size: 30px;
	text-align: center;
}

#wrap {
	width: 1024px;
	padding: 10px;
	background-color: #ccbaba;
	overflow: hidden;
	margin: 0 auto;
}

#po_card_num {
	background-color: #1ed741;
	height: 150px;
	color: #fff;
}

#container {
	padding: 10px;
	background-color: #3d3939;
	overflow: hidden;
	margin: 10px 0;
}

#sidebar {
	float: right;
	width: 200px;
	background-color: #f57373;
	height: 400px;
}

#content {
	float: left;
	width: 770px;
	background-color: #ccbaba;
	height: 400px;
}

#pt_card_num {
	background-color: #2f26e4;
	height: 150px;
	color: #fff;
}

#po_minions {
	height: 200px;
}

.po_span {
	background-color: #1ed741;
	display:inline-block; 
	width:80px; 
	height: 180px; 
	border:solid 1px; 
	font-size: 20px;
}

.pt_span {
	background-color: #2f26e4;
	display:inline-block; 
	width:80px; 
	height: 180px; 
	border:solid 1px; 
	font-size: 20px;
}


#pt_minions {
	height: 200px;
}

#po_deck {
	height: 170px;
}

#pt_deck {
	height: 170px;
}

#end_tern {
	height: 60px;
	background-color: #ccbaba;
}
</style>
<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<script>
	$(document).ready(
			function() {

				var my_info = document.getElementById("my_info");
				var webSocket = new WebSocket(
						'ws://localhost:8080/HearthStone/controller');

				webSocket.onerror = function(event) {
					onError(event)
				};
				webSocket.onopen = function(event) {
					onOpen(event)
				};
				webSocket.onmessage = function(event) {
					onMessage(event)
				};

				function onMessage(event) {

				}

				function onOpen(event) {
					alert(typeof (event.data));
					my_info.value += event.data;

				}
				function onError(event) {
					//alert(event.data);
				}

			});
</script>
</head>
<body>
	<div id="wrap">
		<div id="po_info">상대방 정보</div>
		<div id="po_card_num">상대방이 가진 카드의 수</div>
		<div id="container">
			<div id="content">
				<div id="po_minions">
					<span class="po_span" id="mo1">mo1</span>
					<span class="po_span" id="mo2">mo2</span>
					<span class="po_span" id="mo3">mo3</span>
					<span class="po_span" id="mo4">mo4</span>
					<span class="po_span" id="mo5">mo5</span>
					<span class="po_span" id="mo6">mo6</span>
					<span class="po_span" id="mo7">mo7</span>
				</div>

				<div id="pt_minions">
					<span class="pt_span" id="mt1">mt1</span>
					<span class="pt_span" id="mt2">mt2</span>
					<span class="pt_span" id="mt3">mt3</span>
					<span class="pt_span" id="mt4">mt4</span>
					<span class="pt_span" id="mt5">mt5</span>
					<span class="pt_span" id="mt6">mt6</span>
					<span class="pt_span" id="mt7">mt7</span>
				</div>
			</div>
			<div id="sidebar">
				<div id="po_deck">상대방 덱에 남은 카드의 수</div>
				<div id="end_tern">턴 넘기기</div>
				<div id="pt_deck">내 덱에 남은 카드의 수</div>
			</div>
		</div>
		<div id="pt_info">내 정보</div>
		<div id="pt_card_num">내가 가진 카드 목록</div>
	</div>
</body>
</html>