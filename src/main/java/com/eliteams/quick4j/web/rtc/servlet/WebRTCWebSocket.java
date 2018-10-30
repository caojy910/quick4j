package com.eliteams.quick4j.web.rtc.servlet;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

/**
 *
 * Created by zengxm on 2014/11/4.
 */
@ServerEndpoint("/websocket/{jobid}/{user}")
public class WebRTCWebSocket {

	private static Map<String, Session> sessions = new HashMap<String, Session>();
	private static Map<String, WebRTCWebSocket> webUserSocketMap = new HashMap<String, WebRTCWebSocket>();
	private static Map<String, Map<String, WebRTCWebSocket> > webRoomSocketMap = new HashMap<String, Map<String, WebRTCWebSocket> >();

	private Session session;

	public WebRTCWebSocket(){
		System.out.println("--------------------------------------");
	}



	@OnMessage
	public void onMessage(Session session, String msg){
		System.out.println("收到信息");
		try {
			webUserSocketMap.get(session).sendMessage(msg);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	@OnOpen
	public void onOpen(@PathParam("jobid") String jobid, @PathParam("user") String user, Session session, EndpointConfig config){
		this.session = session;
		sessions.put(session.getId(), session);

//		Map<String, WebRTCWebSocket> map = webRoomSocketMap.get(jobid);
//		if (map == null) {
//			map = new HashMap<String, WebRTCWebSocket>();
//			webRoomSocketMap.put(jobid, map);
//		}
//		WebRTCWebSocket socket = map.get(user);
//		if (socket == null) {
//			map.put(user, this);
//		}

		webUserSocketMap.put(user, this);
	}

	@OnError
	public void onError(Session session, Throwable throwable){

	}

	@OnClose
	public void onClose(Session session, CloseReason reason){
		String userName = "";
		Principal principal = session.getUserPrincipal();
		if (principal != null)
			userName = principal.getName();
		sessions.remove(session.getId());
		webUserSocketMap.remove(userName);
	}

	public void sendMessage(String message) throws IOException {
		this.session.getBasicRemote().sendText(message);
	}

	public static void sendMessage(String user, String message) throws IOException {
		webUserSocketMap.get(user).session.getBasicRemote().sendText(message);
	}
}