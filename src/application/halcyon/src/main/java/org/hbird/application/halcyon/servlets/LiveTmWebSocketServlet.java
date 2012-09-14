/**
 * 
 */
package org.hbird.application.halcyon.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.websocket.WebSocket;
import org.eclipse.jetty.websocket.WebSocketServlet;
import org.hbird.application.halcyon.tm.LiveTmStreamingWebSocket;

/**
 * @author Mark Doyle
 *
 */
public class LiveTmWebSocketServlet extends WebSocketServlet {
	private static final long serialVersionUID = -645861775618085268L;

	/**
	 * 
	 */
	public LiveTmWebSocketServlet() {
		System.out.println("Constructed LiveTmWebSocketServlet");
	}

	@Override
	protected void doGet(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.getWriter().println("Gaben says SOCKET!");
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jetty.websocket.WebSocketFactory.Acceptor#doWebSocketConnect(javax.servlet.http.HttpServletRequest, java.lang.String)
	 */
	@Override
	public WebSocket doWebSocketConnect(final HttpServletRequest request, final String protocol) {
		System.out.println("doWebSocketConnect called with protocol " + protocol);
		return new LiveTmStreamingWebSocket();
	}
}
