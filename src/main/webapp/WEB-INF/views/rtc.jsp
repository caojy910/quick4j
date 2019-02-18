<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
	<head>
		<base href="<%=basePath%>">
		<link rel="canonical" href="${roomLink}" />
		<meta http-equiv="X-UA-Compatible" content="chrome=1" />
		<%--<script src="https://talkgadget.google.com/talkgadget/channel.js"></script>--%>
		<!-- type="text/javascript">
		  (function() {
			var po = document.createElement('script'); po.type = 'text/javascript'; po.async = true;
			po.src = 'https://apis.google.com/js/plusone.js';
			var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(po, s);
		  })();
		-->
		<!-- BEGIN GLOBAL MANDATORY STYLES -->
		<link href="assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
		<link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
		<link href="assets/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css" />
		<!-- END GLOBAL MANDATORY STYLES -->

		<!-- BEGIN THEME STYLES -->

		<link href="assets/css/plugins.css" rel="stylesheet" type="text/css" />
		<link href="assets/css/pages/tasks.css" rel="stylesheet" type="text/css" />
		<link href="assets/css/themes/default.css" rel="stylesheet" type="text/css" id="style_color" />
		<link href="assets/css/custom.css" rel="stylesheet" type="text/css" />
		<!-- END THEME STYLES -->

		<link href="assets/global/plugins/jquery-ui/jquery-ui.min.css" rel="stylesheet" type="text/css" />

		<style type="text/css">
			a:link {
				color: #ffffff;
			}

			a:visited {
				color: #ffffff;
			}

			html,body {
				/*background-color: #000000;*/
				height: 100%;
				font-family: Verdana, Arial, Helvetica, sans-serif;
			}

			body {
				margin: 2em;
				padding: 0;
			}

			div {
				color: white;
			}

			#container {
				background-color: #000000;
				position: relative;
				min-height: 100%;
				width: 100%;
				margin: 0px auto;
			}

			#card {
				-webkit-transition-property: rotation;
				-webkit-transition-duration: 2s;
				-webkit-transform-style: preserve-3d;
			}

			#local {
				position: absolute;
				width: 100%;
				-webkit-transform: scale(-1, 1);
				-webkit-backface-visibility: hidden;
			}

			#remote {
				position: absolute;
				width: 100%;
				-webkit-transform: rotateY(180deg);
				-webkit-backface-visibility: hidden;
			}

			#mini {
				position: absolute;
				height: 30%;
				width: 30%;
				bottom: 32px;
				right: 4px;
				-webkit-transform: scale(-1, 1);
				opacity: 1.0;
			}

			/*#localVideo {*/
			/*opacity: 0;*/
			/*-webkit-transition-property: opacity;*/
			/*-webkit-transition-duration: 2s;*/
			/*}*/

			#remoteVideo {
				opacity: 0;
				-webkit-transition-property: opacity;
				-webkit-transition-duration: 2s;
			}

			/*#miniVideo {*/
			/*opacity: 0;*/
			/*-webkit-transition-property: opacity;*/
			/*-webkit-transition-duration: 2s;*/
			/*}*/

			#footer {
				spacing: 4px;
				/*position: absolute;*/
				bottom: 0;
				width: 100%;
				height: 28px;
				background-color: #3F3F3F;
				color: rgb(255, 255, 255);
				font-size: 13px;
				font-weight: bold;
				line-height: 28px;
				text-align: center;
			}

			#hangup {
				font-size: 13px;
				font-weight: bold;
				color: #FFFFFF;
				width: 128px;
				height: 24px;
				background-color: #808080;
				border-style: solid;
				border-color: #FFFFFF;
				margin: 2px;
			}

			#logo {
				display: block;
				top: 4;
				right: 4;
				position: absolute;
				float: right;
				opacity: 0.5;
			}

			.videoblcok {
				margin: 2em;
				border: solid grey 6px;
				border-radius: 20px;
				padding: 2em;
				text-align:center;
			}

			.screenshotblock {
				margin: 2em;
				border: solid grey 6px;
				border-radius: 20px;
				padding: 2em;
			}

			.receiveblock {
				margin: 2em;
				border: solid grey 6px;
				border-radius: 20px;
				padding: 2em;
			}
			.chatblock {
				margin: 2em;
				border: solid grey 6px;
				border-radius: 20px;
				padding: 2em;
			}
			.messageblock{
				width: 100%;
				height: 200px;
				margin: 0.5em;
				border: solid grey 2px;
				background-color: white;
				padding: 0.5em;
				/*display: flex;*/
				overflow-y:scroll;
				word-wrap:break-word;
			}
			.msginput {
				width: 100%;
				padding: 0.5em;
				margin: 0.5em;
			}
			.msgsendbtn{
				margin: 0.5em;
				padding: 0.5em;
				text-align:right;
			}
			.leftmsg {
				width: 48%;
				margin:1em auto 1em 0;
				color:black;
				background-color: gainsboro;
				border-radius: 5px;
				padding: 3px;
			}
			.rightmsg {
				width: 48%;
				margin:1em 0 1em auto;
				color:black;
				background-color: #2fff56;
				border-radius: 5px;
				padding: 3px;
			}

		</style>

	</head>
<body>
	<div style="margin:2em">
		<div class="videoblcok">
			<h2>远程协助</h2>
			<div id="videos">
				<video id="localVideo" height="300" autoplay muted playsinline poster="assets/img/video-preview.jpg"></video>
				<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
				<video id="remoteVideo" height="300" autoplay playsinline poster="assets/img/remotevideo-preview2.jpg"></video>
			</div>
		</div>


		<table width="100%">
			<tr>
				<td width="50%" height="100%" valign="top">
					<div class="screenshotblock">
						<h2>截图标记</h2>
						<div id="videoCanvas">
							<div id="controls">
								标记颜色：
								<select id="strokeStyleSelect">
									<option value="red" style="color:red">红色</option>
									<option value="green" style="color:green">绿色</option>
									<option value="blue" style="color:blue">蓝色</option>
									<option value="orange" style="color:orange">橙色</option>
								</select>

								<input type="button" name="eraseAllButton" id="eraseAllButton" value="清除标记" />
							</div>

							<canvas id="photo"></canvas>

						</div>

						<div id="buttons">
							<button id="snap">截屏</button><span>      </span><button id="send">发送图片</button>
							<%--<span> or </span>--%>
							<%--<button id="snapAndSend">Snap &amp; Send</button>--%>
						</div>
						<%--<div>--%>
						<%----%>
						<%--<div class="col-md-9">--%>
						<%--<input type="text"><span>      </span><button id="sendmessage">发送消息</button>--%>
						<%--</div>--%>
						<%--</div>--%>

					</div>
				</td>
				<td width="50%" height="100%" valign="top">
					<div id="chat" class="chatblock">
						<div id="message" class="messageblock"></div>
						<%--<input type="text" class="form-control">--%>
							<textarea class="scroll msginput" id="inputmsg" wrap="hard" placeholder="在此输入文字信息..."></textarea>
							<span class="input-group-btn msgsendbtn">
								<button id="sendmessage" type="button">发送</button>
							</span>
					</div>
				</td>
			</tr>
		</table>

		<table width="100%">
			<tr>
				<td width="50%" valign="top">
					<div id="incoming" class="receiveblock">
						<h2>接收图片</h2>
						<div id="trail"></div>
					</div>
				</td>
				<td width="50%" valign="top">

				</td>
			</tr>
		</table>


		<%--<div id="footer"></div>--%>
		<%--<a href="http://www.webrtc.org"> <img id="logo" alt="WebRTC"--%>
		<%--src="${ctx}images/webrtc_black_20p.png"> </a>--%>
	</div>

	<script type="text/javascript">
		var localVideo;
		var miniVideo;
		var remoteVideo;
		var localStream;
		var remoteStream;
		var channel;
		var channelReady = false;
		var pc;
		var socket;
		var initiator = ${initiator};
		var roomKey;
		var roomlink;
		var user;
		var started = false;
		var isRTCPeerConnection = true;
		var mediaConstraints = {
			'has_audio' : true,
			'has_video' : true
		};
		var isVideoMuted = false;
		var isAudioMuted = false;

        var dataChannel;

        var xhrequest;

        var photo = document.getElementById('photo');
        var photoContext = photo.getContext('2d');
        var trail = document.getElementById('trail');
        var snapBtn = document.getElementById('snap');
        var sendBtn = document.getElementById('send');
        var sendMsgBtn = document.getElementById('sendmessage');
        var inputmsg = document.getElementById('inputmsg');
        var msgwindow = document.getElementById('message');
        // var snapAndSendBtn = document.getElementById('snapAndSend');

        var photoContextW;
        var photoContextH;

        var renderPhotoContextW;
        var renderPhotoContextH;

        // Attach event handlers
        snapBtn.addEventListener('click', snapPhoto);
        sendBtn.addEventListener('click', sendPhoto);
        sendMsgBtn.addEventListener('click', sendmessagechatting);
        // snapAndSendBtn.addEventListener('click', snapAndSend);

        function initialize() {
			console.log("Initializing; room=${roomKey}.");
			card = document.getElementById("card");
			localVideo = document.getElementById("localVideo");
			miniVideo = document.getElementById("miniVideo");
			remoteVideo = document.getElementById("remoteVideo");


            localVideo.onloadedmetadata = function() {
                renderPhotoContextW = localVideo.videoWidth;
                renderPhotoContextH = localVideo.videoHeight;
                console.log('gotStream with width and height:', renderPhotoContextW, renderPhotoContextH);
            };


            remoteVideo.onloadedmetadata = function() {
                photo.width = photoContextW = remoteVideo.videoWidth;
                photo.height = photoContextH = remoteVideo.videoHeight;
                // remotePhotoContextW = remoteVideo.videoWidth;
                // remotePhotoContextH = remoteVideo.videoHeight;
                console.log('gotStream with width and height:', photoContextW, photoContextH);
            };

            join();
        }
		
		function getUserMedia() {
			try {
				navigator.webkitGetUserMedia({
					'audio' : true,
					'video' : true
				}, onUserMediaSuccess, onUserMediaError);
				console.log("Requested access to local media with new syntax.");
			} catch (e) {
				try {
					navigator.webkitGetUserMedia("video,audio",
							onUserMediaSuccess, onUserMediaError);
					console
							.log("Requested access to local media with old syntax.");
				} catch (e) {
					alert("webkitGetUserMedia() failed. Is the MediaStream flag enabled in about:flags?");
					console.log("webkitGetUserMedia failed with exception: "
							+ e.message);
				}
			}
		}
		
		function onUserMediaSuccess(stream) {
			console.log("User has granted access to local media.");
			// var url = URL.createObjectURL(stream);
			// localVideo.style.opacity = 1;
			// localVideo.src = url;
            localVideo.srcObject = stream;
            localStream = stream;
            remoteVideo.style.opacity = 1;
            // Caller creates PeerConnection.
			if (initiator == 1)
				maybeStart();
		}
		
		function maybeStart() {
			if (!started && localStream && channelReady) {
				setStatus("连接中...");
				console.log("Creating PeerConnection.");
				createPeerConnection();
				console.log("Adding local stream.");
				pc.addStream(localStream);
				started = true;
				// Caller initiates offer to peer.
				if (initiator == 1)
					doCall();
			}
		}

		function doCall() {
			console.log("Sending offer to peer.");
			if (isRTCPeerConnection) {
				pc.createOffer(setLocalAndSendMessage, createOfferError, mediaConstraints);
			} else {
				var offer = pc.createOffer(mediaConstraints);
				pc.setLocalDescription(pc.SDP_OFFER, offer);
				sendMessage({
					type : 'offer',
					sdp : offer.toSdp()
				});
				pc.startIce();
			}
		}

		function setLocalAndSendMessage(sessionDescription) {
			pc.setLocalDescription(sessionDescription);
			sendMessage(sessionDescription);
		}

        function createOfferError(error) {
		    console.log("createoffer error " + error);
        }

        function createAnswerError(error) {
            console.log("createanswer error " + error);
        }

        function sendMessage(message) {
            console.log("sendMessage " + message);
			var msgString = JSON.stringify(message);
			console.log('发出信息 : ' + msgString);
			path = 'message?r=' + roomKey + '&u=' + user;
			var xhr = new XMLHttpRequest();
			xhr.open('POST', path, true);
            xhr.onreadystatechange = sendMessageCallback;
            xhr.send(msgString);
		}

		function sendMessageCallback() {
            console.log(this);

            console.log("sendMessageCallback");
        }

		function sendmessagechatting() {
            if (!dataChannel) {
                logError('chat Connection has not been initiated. ' +
                    'Get two peers in the same room first');
                return;
            } else if (dataChannel.readyState === 'closed') {
                logError('chat Connection was lost. Peer closed the connection.');
                return;
            }

            var msg = inputmsg.value;
            console.log("msg:" + msg);
            dataChannel.send("msg:" + msg);
            msg = msg.replace(/msg:/,"");
            insertMsgToChatWindow(0, msg);
        }

        function insertMsgToChatWindow(remote, msg) {
            if (remote) {
                $("#message").append("<p class='leftmsg'>" + msg + "</p>");
			}
			else
                $("#message").append("<p class='rightmsg'>" + msg + "</p>");
            var div = document.getElementById('message');
            div.scrollTop = div.scrollHeight;
        }

		function join() {
			path = 'room?r=' + ${jobid};
            xhrequest = new XMLHttpRequest();
            xhrequest.open('POST', path, true);
            xhrequest.onreadystatechange = joincallback;
            xhrequest.send();
        }

        function joincallback() {
            if (xhrequest.readyState===4 && xhrequest.status===200) {
                // initiator = xhrequest.getAttribute("initiator");
                // roomlink = xhrequest.getAttribute("roomLink");
                // roomKey = xhrequest.getAttribute("roomKey");
                // user = xhrequest.getAttribute("user");
				console.log(xhrequest.responseText);
				console.log(xhrequest.responseXML);
                var responseText = xhrequest.responseXML;
                var nodes = responseText.getElementsByTagName("element");
                var node = nodes[0];
                initiator = getresponsevalue(node, "initiator");
                roomlink = getresponsevalue(node, "roomLink");
                roomKey = getresponsevalue(node, "roomKey");
                user = getresponsevalue(node, "user");

                console.log(user + " " + roomKey + " " + initiator);
                remoteconnect();
            }
        }

        function getresponsevalue(node, tag) {
            var nodes = node.getElementsByTagName(tag);
            var node = nodes[0];
            var text = node.firstChild.nodeValue;
            return text;
        }

		function openChannel() {
			console.log("Opening channel.");
            var jobid = ${jobid};
			socket = new WebSocket(
					"ws://"+window.location.host+"${ctx}/websocket/" + jobid + "/" + user);
			socket.onopen = onChannelOpened;
			socket.onmessage = onChannelMessage;
			socket.onclose = onChannelClosed;
		}

		function resetStatus() {
			if (initiator == 0) {
				setStatus("让别人加入视频聊天: <a href=\"${roomLink}\">${roomLink}</a>");
			} else {
				setStatus("初始化...");
			}
		}

		function createPeerConnection() {
			var pc_config = {
				"iceServers" : [ {
					"url" : "stun:stun.l.google.com:19302"
				} ]
			};
			try {
				pc = new webkitRTCPeerConnection(pc_config);
				pc.onicecandidate = onIceCandidate;
				console.log("Created webkitRTCPeerConnnection with config \""
						+ JSON.stringify(pc_config) + "\".");
			} catch (e) {
				try {
					var stun_server = "";
					if (pc_config.iceServers.length !== 0) {
						stun_server = pc_config.iceServers[0].url.replace(
								'stun:', 'STUN ');
					}
					pc = new webkitPeerConnection00(stun_server,
							onIceCandidate00);
					isRTCPeerConnection = false;
					console
							.log("Created webkitPeerConnnection00 with config \""
									+ stun_server + "\".");
				} catch (e) {
					console.log("Failed to create PeerConnection, exception: "
							+ e.message);
					alert("Cannot create PeerConnection object; Is the 'PeerConnection' flag enabled in about:flags?");
					return;
				}
			}

			pc.onconnecting = onSessionConnecting;
			pc.onopen = onSessionOpened;
			pc.onaddstream = onRemoteStreamAdded;
			pc.onremovestream = onRemoteStreamRemoved;

            if (initiator == 1) {
                console.log('Creating Data Channel');
                dataChannel = pc.createDataChannel("photos");
                onDataChannelCreated(dataChannel);
            }
			else {
                pc.ondatachannel = function(event) {
                    console.log('ondatachannel:', event.channel);
                    dataChannel = event.channel;
                    onDataChannelCreated(dataChannel);
                };
			}

		}

        function onDataChannelCreated(channel) {
            console.log('onDataChannelCreated:', channel);

            channel.onopen = function() {
                console.log('CHANNEL opened!!!');
                sendBtn.disabled = false;
                // snapAndSendBtn.disabled = false;
            };

            channel.onclose = function () {
                console.log('Channel closed.');
                sendBtn.disabled = true;
                // snapAndSendBtn.disabled = true;
            }

            channel.onmessage =  receiveDataChromeFactory();
        }


        function receiveDataChromeFactory() {
            var buf, count;
			console.log("receiveDataChromeFactory");
            return function onmessage(event) {
                console.log(event);
                console.log(event.data);
                if (typeof event.data === 'string') {
                    var msg = event.data;
                    if (msg.match("msg:") != null) {
                        msg = msg.replace(/msg:/,"");
                        console.log(msg);
                        insertMsgToChatWindow(1, msg);
                        return;
					}
                    buf = window.buf = new Uint8ClampedArray(parseInt(msg));
                    count = 0;
                    console.log('Expecting a total of ' + buf.byteLength + ' bytes');
                    return;
                }

                var data = new Uint8ClampedArray(event.data);
                buf.set(data, count);

                count += data.byteLength;
                console.log('count: ' + count);

                if (count === buf.byteLength) {
// we're done: all data chunks have been received
                    console.log('Done. Rendering photo.');
                    renderPhoto(buf);
                }
            };
        }

        function receiveDataFirefoxFactory() {
            var count, total, parts;

            return function onmessage(event) {
                if (typeof event.data === 'string') {
                    total = parseInt(event.data);
                    parts = [];
                    count = 0;
                    console.log('Expecting a total of ' + total + ' bytes');
                    return;
                }

                parts.push(event.data);
                count += event.data.size;
                console.log('Got ' + event.data.size + ' byte(s), ' + (total - count) +
                    ' to go.');

                if (count === total) {
                    console.log('Assembling payload');
                    var buf = new Uint8ClampedArray(total);
                    var compose = function(i, pos) {
                        var reader = new FileReader();
                        reader.onload = function() {
                            buf.set(new Uint8ClampedArray(this.result), pos);
                            if (i + 1 === parts.length) {
                                console.log('Done. Rendering photo.');
                                renderPhoto(buf);
                            } else {
                                compose(i + 1, pos + this.result.byteLength);
                            }
                        };
                        reader.readAsArrayBuffer(parts[i]);
                    };
                    compose(0, 0);
                }
            };
        }


        /****************************************************************************
         * Aux functions, mostly UI-related
         ****************************************************************************/

        function snapPhoto() {
            photoContext.drawImage(remoteVideo, 0, 0, photo.width, photo.height);
            saveDrawingSurface();
            show(photo, sendBtn);
        }

        function sendPhoto() {
            // Split data channel message in chunks of this byte length.
            var CHUNK_LEN = 64000;
            console.log('width and height ', photoContextW, photoContextH);
            var img = photoContext.getImageData(0, 0, photoContextW, photoContextH),
                len = img.data.byteLength,
                n = len / CHUNK_LEN | 0;

            console.log('Sending a total of ' + len + ' byte(s)');

            if (!dataChannel) {
                logError('Connection has not been initiated. ' +
                    'Get two peers in the same room first');
                return;
            } else if (dataChannel.readyState === 'closed') {
                logError('Connection was lost. Peer closed the connection.');
                return;
            }

            dataChannel.send(len);

            // split the photo and send in chunks of about 64KB
            for (var i = 0; i < n; i++) {
                var start = i * CHUNK_LEN,
                    end = (i + 1) * CHUNK_LEN;
                console.log(start + ' - ' + (end - 1));
                dataChannel.send(img.data.subarray(start, end));
            }

            // send the reminder, if any
            if (len % CHUNK_LEN) {
                console.log('last ' + len % CHUNK_LEN + ' byte(s)');
                dataChannel.send(img.data.subarray(n * CHUNK_LEN));
            }

        }

        function snapAndSend() {
            snapPhoto();
            sendPhoto();
        }

        function renderPhoto(data) {
            var canvas = document.createElement('canvas');
            canvas.width = renderPhotoContextW;
            canvas.height = renderPhotoContextH;
            canvas.classList.add('incomingPhoto');
            // trail is the element holding the incoming images
            trail.insertBefore(canvas, trail.firstChild);

            var context = canvas.getContext('2d');
            var img = context.createImageData(renderPhotoContextW, renderPhotoContextH);
            img.data.set(data);
            context.putImageData(img, 0, 0);
        }


        function show() {
            Array.prototype.forEach.call(arguments, function(elem) {
                elem.style.display = null;
            });
        }

        function hide() {
            Array.prototype.forEach.call(arguments, function(elem) {
                elem.style.display = 'none';
            });
        }


        function logError(err) {
            if (!err) return;
            if (typeof err === 'string') {
                console.warn(err);
            } else {
                console.warn(err.toString(), err);
            }
        }

        // draw
        var eraseAllButton = document.getElementById("eraseAllButton");
        var strokeStyleSelect = document.getElementById("strokeStyleSelect");

        var drawingSurfacsImageData = null;
        var mousedown = {};
        var dragging = false;
        var loc=null;


        photo.onmousedown = function(e) {
            loc = windowToCanvas(e.clientX, e.clientY);

            e.preventDefault();
            // saveDrawingSurface();
            mousedown.x = loc.x;
            mousedown.y = loc.y;
            dragging = true;
            photoContext.strokeStyle = strokeStyleSelect.value;
            photoContext.beginPath();
            photoContext.moveTo(loc.x, loc.y);
        };
        photo.onmousemove = function(e){

            //判断当前是否用户在拖动
            if(dragging) {
                e.preventDefault();
                loc = windowToCanvas(e.clientX, e.clientY);
                photoContext.lineTo(loc.x, loc.y);
                photoContext.stroke();
                // restoreDrawingSurface();
                // updateRubberband(loc);

            }
        };
        photo.onmouseup = function(e) {
            loc = windowToCanvas(e.clientX, e.clientY);
            // restoreDrawingSurface();
            // updateRubberband(loc);
            //鼠标抬起，拖动标记设为否
            dragging = false;
        };

        //获取实际的鼠标在canvas的位置
        function windowToCanvas(x, y) {
            var bbox = photo.getBoundingClientRect();
            return {
                x : x - bbox.left * (photo.width / bbox.width),
                y : y - bbox.top * (photo.height / bbox.height)
            };
        }


        //保存当前的canvas上的数据
        function saveDrawingSurface() {
            drawingSurfacsImageData = photoContext.getImageData(0, 0, photo.width, photo.height);
        }
        //恢复canvas的数据，主要用来显示最新的线段，擦除原来的线段
        function restoreDrawingSurface() {
            photoContext.putImageData(drawingSurfacsImageData,
                0, 0, 0, 0, photo.width, photo.height
            );
        }

        //更新
        function  updateRubberband(loc) {
            //此处在《HTML5 canvas核心技术——图形、动画与游戏开发》一书中
            //updateRubberbandRectangle方法是没有注释的，但是我不懂要这个
            //方法有什么作用，注释之后也不影响，话说我也不用话什么矩形哇
            //有知道这个方法在这里是做什么的同学在下方评论一下告知哈
            //updateRubberbandRectangle(loc);
            drawRubberbandShape(loc);
        }
        //画最新的线条
        function drawRubberbandShape(loc) {
            photoContext.beginPath();
            photoContext.moveTo(mousedown.x, mousedown.y);
            photoContext.lineTo(loc.x, loc.y);
            photoContext.stroke();
        }

        eraseAllButton.onclick = function(e){
            photoContext.clearRect(0, 0, photoContext.width, photoContext.height);
            restoreDrawingSurface();
            // photoContext.restore();
            // saveDrawingSurface();
        };

        strokeStyleSelect.onchange = function(e){
            photoContext.strokeStyle = strokeStyleSelect.value;
        };


        photoContext.strokeStyle = strokeStyleSelect.value;




        function setStatus(state) {
			// footer.innerHTML = state;
		}

		function doAnswer() {
			console.log("Sending answer to peer.");
			if (isRTCPeerConnection) {
				pc.createAnswer(setLocalAndSendMessage, createAnswerError);
			} else {
				var offer = pc.remoteDescription;
				var answer = pc.createAnswer(offer.toSdp(), mediaConstraints);
				pc.setLocalDescription(pc.SDP_ANSWER, answer);
				sendMessage({
					type : 'answer',
					sdp : answer.toSdp()
				});
				pc.startIce();
			}
		}

		function processSignalingMessage00(message) {
			var msg = JSON.parse(message);

			// if (msg.type === 'offer') should not happen here.
			if (msg.type === 'answer' && started) {
				pc.setRemoteDescription(pc.SDP_ANSWER, new SessionDescription(
						msg.sdp));
			} else if (msg.type === 'candidate' && started) {
				var candidate = new IceCandidate(msg.label, msg.candidate);
				pc.processIceMessage(candidate);
			} else if (msg.type === 'bye' && started) {
				onRemoteHangup();
			}
		}

		var channelOpenTime;
		var channelCloseTime;

		function onChannelOpened() {
			channelOpenTime = new Date();
			console.log("Channel opened.Open time is : "
					+ channelOpenTime.toLocaleString());
			channelReady = true;
			if (initiator == 1)
				maybeStart();
		}
		function onChannelMessage(message) {
			console.log('收到信息 : ' + message.data);
			if (isRTCPeerConnection)
				processSignalingMessage(message.data);//建立视频连接
			else
				processSignalingMessage00(message.data);
		}
		
		function processSignalingMessage(message) {
			var msg = JSON.parse(message);

			if (msg.type === 'offer') {
				// Callee creates PeerConnection
				if (initiator == 0 && !started)
					maybeStart();

				// We only know JSEP version after createPeerConnection().
				if (isRTCPeerConnection)
					pc.setRemoteDescription(new RTCSessionDescription(msg));
				else
					pc.setRemoteDescription(pc.SDP_OFFER,
							new SessionDescription(msg.sdp));

				doAnswer();
			} else if (msg.type === 'answer' && started) {
				pc.setRemoteDescription(new RTCSessionDescription(msg));
			} else if (msg.type === 'candidate' && started) {
				var candidate = new RTCIceCandidate({
					sdpMLineIndex : msg.label,
					candidate : msg.candidate
				});
				pc.addIceCandidate(candidate);
			} else if (msg.type === 'bye' && started) {
				onRemoteHangup();
			}
		}
		
		function onChannelError() {
			console.log('Channel error.');
		}
		function onChannelClosed() {
			if(!channelOpenTime){
				channelOpenTime = new Date();
			}
			channelCloseTime = new Date();
			console
					.log("Channel closed.Close time is "
							+ channelOpenTime.toLocaleString()
							+ " ,Keep time : "
							+ ((channelCloseTime.getTime() - channelOpenTime
									.getTime()) / 1000 + "s"));
			// openChannel();
		}

		function onUserMediaError(error) {
			console.log("Failed to get access to local media. Error code was "
					+ error.code);
			alert("Failed to get access to local media. Error code was "
					+ error.code + ".");
		}

		function onIceCandidate(event) {
			if (event.candidate) {
				sendMessage({
					type : 'candidate',
					label : event.candidate.sdpMLineIndex,
					id : event.candidate.sdpMid,
					candidate : event.candidate.candidate
				});
			} else {
				console.log("End of candidates.");
			}
		}

		function onIceCandidate00(candidate, moreToFollow) {
			if (candidate) {
				sendMessage({
					type : 'candidate',
					label : candidate.label,
					candidate : candidate.toSdp()
				});
			}

			if (!moreToFollow) {
				console.log("End of candidates.");
			}
		}

		function onSessionConnecting(message) {
			console.log("Session connecting.");
		}
		function onSessionOpened(message) {
			console.log("Session opened.");
		}

		function onRemoteStreamAdded(event) {
			console.log("Remote stream added.");
			console.log(event);
			// var url = URL.createObjectURL(event.stream);
			// miniVideo.src = localVideo.src;
			// remoteVideo.src = url;
			remoteVideo.srcObject = event.stream;
			remoteStream = event.stream;
			// waitForRemoteVideo();
		}
		function onRemoteStreamRemoved(event) {
			console.log("Remote stream removed.");
		}

		function onHangup() {
			console.log("Hanging up.");
			transitionToDone();
			stop();
			socket.close();

		}

		function onRemoteHangup() {
			console.log('Session terminated.');
			transitionToWaiting();
			stop();
			initiator = 0;
		}

		function stop() {
			started = false;
			isRTCPeerConnection = true;
			isAudioMuted = false;
			isVideoMuted = false;
			pc.close();
			pc = null;
		}

		function waitForRemoteVideo() {
            var videoTracks = remoteStream.getVideoTracks();
		    console.log(videoTracks);
			if (videoTracks.length === 0
					|| remoteVideo.currentTime > 0) {
				transitionToActive();
			} else {
				setTimeout(waitForRemoteVideo, 100);
			}
		}
		function transitionToActive() {
			// remoteVideo.style.opacity = 1;
			// card.style.webkitTransform = "rotateY(180deg)";
			setTimeout(function() {
				// localVideo.src = "";
			}, 500);
			setTimeout(function() {
				// miniVideo.style.opacity = 1;
			}, 1000);
			setStatus("<input type=\"button\" id=\"hangup\" value=\"Hang up\" onclick=\"onHangup()\" />");
		}
		function transitionToWaiting() {
			card.style.webkitTransform = "rotateY(0deg)";
			setTimeout(function() {
				// localVideo.src = miniVideo.src;
				// miniVideo.src = "";
				// remoteVideo.src = ""
			}, 500);
			// miniVideo.style.opacity = 0;
			// remoteVideo.style.opacity = 0;
			resetStatus();
		}
		function transitionToDone() {
			// localVideo.style.opacity = 0;
			// remoteVideo.style.opacity = 0;
			// miniVideo.style.opacity = 0;
			setStatus("You have left the call. <a href=\"{{ room_link }}\">Click here</a> to rejoin.");
		}
		function enterFullScreen() {
			container.webkitRequestFullScreen();
		}

		function toggleVideoMute() {
			if (localStream.videoTracks.length === 0) {
				console.log("No local video available.");
				return;
			}

			if (isVideoMuted) {
				for (i = 0; i < localStream.videoTracks.length; i++) {
					localStream.videoTracks[i].enabled = true;
				}
				console.log("Video unmuted.");
			} else {
				for (i = 0; i < localStream.videoTracks.length; i++) {
					localStream.videoTracks[i].enabled = false;
				}
				console.log("Video muted.");
			}

			isVideoMuted = !isVideoMuted;
		}

		function toggleAudioMute() {
			if (localStream.audioTracks.length === 0) {
				console.log("No local audio available.");
				return;
			}

			if (isAudioMuted) {
				for (i = 0; i < localStream.audioTracks.length; i++) {
					localStream.audioTracks[i].enabled = true;
				}
				console.log("Audio unmuted.");
			} else {
				for (i = 0; i < localStream.audioTracks.length; i++) {
					localStream.audioTracks[i].enabled = false;
				}
				console.log("Audio muted.");
			}

			isAudioMuted = !isAudioMuted;
		}

		setTimeout(initialize, 1);

		// Send BYE on refreshing(or leaving) a demo page
		// to ensure the room is cleaned for next session.
		window.onbeforeunload = function() {
			sendMessage({
				type : 'bye'
			});
		}

		// Ctrl-D: toggle audio mute; Ctrl-E: toggle video mute.
		// On Mac, Command key is instead of Ctrl.
		// Return false to screen out original Chrome shortcuts.
		document.onkeydown = function() {
			if (navigator.appVersion.indexOf("Mac") != -1) {
				if (event.metaKey && event.keyCode === 68) {
					toggleAudioMute();
					return false;
				}
				if (event.metaKey && event.keyCode === 69) {
					toggleVideoMute();
					return false;
				}
			} else {
				if (event.ctrlKey && event.keyCode === 68) {
					toggleAudioMute();
					return false;
				}
				if (event.ctrlKey && event.keyCode === 69) {
					toggleVideoMute();
					return false;
				}
			}
		}

		function remoteconnect() {
            resetStatus();
            openChannel();
            getUserMedia();
        }
	</script>
	<script src="assets/global/plugins/jquery.min.js" type="text/javascript"></script>
	<script src="assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
	<script src="assets/global/plugins/js.cookie.min.js" type="text/javascript"></script>
	<script src="assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
	<script src="assets/global/plugins/jquery.blockui.min.js" type="text/javascript"></script>
	<script src="assets/global/plugins/bootstrap-switch/js/bootstrap-switch.min.js" type="text/javascript"></script>
</body>
</html>
