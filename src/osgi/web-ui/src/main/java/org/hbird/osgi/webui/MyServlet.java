package org.hbird.osgi.webui;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = -1689860299877290542L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlet GET called");
    	PrintWriter out = response.getWriter();
        out.println("Hello World");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("servlet POST called");
    }

}