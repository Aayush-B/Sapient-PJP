package com.assignment.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter() ;
		
		String url=request.getRequestURL().toString() ;
		
		url = url.substring(url.lastIndexOf("/") + 1, url.length());
		
		out.println("<html><body>") ;
		
		switch(url) {
		case "hello":
			out.println("<h2>You are in Hello</h2>") ;
			break ;
			
		case "hi":
			out.println("<h2>You are in Hi</h2>") ;
			break ;
			
		case "bye":
			out.println("<h2>You are in Bye</h2>") ;
			break ;
			
		default:
			out.println("<h2>You are in Hello</h2>") ;
		}
		
		out.println("</body></html>") ;
}

}
