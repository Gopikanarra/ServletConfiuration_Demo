package com.servletconfig;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TestServletConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public TestServletConfig() {
        super();
       System.out.println("servlet instantiation");
    }

	public void init()throws ServletException{
		System.out.println("servlet initialization..");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.println("<html><head><title>Output:</title></head>");
		pw.println("<body align='center'>");
		pw.println("<table border='1'");
		pw.println("<tr><th>ParameterName</th><th>ParameterValue</th></tr>");
		ServletConfig config=getServletConfig();
		
		Enumeration<String> paranames=config.getInitParameterNames();
		System.out.println(paranames);
		
		while(paranames.hasMoreElements()) {
			String paraname=(String)paranames.nextElement();
			String paravalue=config.getInitParameter(paraname);
			pw.println("<tr>");
			pw.println("<td>"+paraname+"</td><td>"+paravalue+"</td>");
			pw.println("</tr>");
		}
		
		pw.println("<tr><th>password</th><th>"+config.getInitParameter("password")+"</th></tr>");
		pw.print("</table></body></html>");
		
	}

}
