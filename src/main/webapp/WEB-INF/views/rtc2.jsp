<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	String ctx = request.getContextPath() + "/";
	pageContext.setAttribute("ctx", ctx);
%>
<html>

<head>

	<title>Realtime communication with WebRTC</title>

	<link rel="stylesheet" href="/css/main.css" />

</head>

<body>

<h1>Realtime communication with WebRTC</h1>

<div id="videos">
	<video id="localVideo" autoplay muted playsinline></video>
	<video id="remoteVideo" autoplay playsinline></video>
</div>


<div id="videoCanvas">
	<div id="controls">
		Stroke color:
		<select id="strokeStyleSelect">
			<option value="red">red</option>
			<option value="green">green</option>
			<option value="blue">blue</option>
			<option value="orange">orange</option>
		</select>

		<input type="button" name="eraseAllButton" id="eraseAllButton" value="Erase all" />
	</div>

	<canvas id="photo"></canvas>

</div>


<div id="buttons">
	<button id="snap">Snap</button><span> then </span><button id="send">Send</button>
	<span> or </span>
	<button id="snapAndSend">Snap &amp; Send</button>
</div>

<div id="incoming">
	<h2>Incoming photos</h2>
	<div id="trail"></div>
</div>


<!-- This file is automatically added/served when running "node index.js". -->
<script src="/socket.io/socket.io.js"></script>
<script src="https://webrtc.github.io/adapter/adapter-latest.js"></script>
<script src="app/js/main2.js"></script>

</body>

</html>
