// Servlet5 and jspfile15 
package com.testexample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet5")
public class Servlet5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Servlet5() {super(); }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		URL url = new URL("http://localhost:8181/ClientGetProg/getResource1/getdata");
	      HttpURLConnection con = (HttpURLConnection) url.openConnection();
	      con.setRequestMethod("GET");
	      con.setRequestProperty("Accept", "application/json");
	      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
	      String inputLine;
	      StringBuffer response1=new StringBuffer();
	      while ((inputLine = in.readLine()) != null) {
	    	response1.append(inputLine);
	      }
	      System.out.println(response1);
	      in.close();
	      con.disconnect();
	      
	      request.setAttribute("jsonData",response1);
	      RequestDispatcher rd=request.getRequestDispatcher("jspfile15.jsp");
		  rd.forward(request, response);
	}
}
