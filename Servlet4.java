//Servlet4 and jspfile13 and jspfile14
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

import org.json.JSONObject;

@WebServlet("/Servlet4")
public class Servlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Servlet4(){super();}
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
	      JSONObject myresponse=null;
	      int lengthOfJsonObject=0;
	      try {
	        myresponse=new JSONObject(response1.toString());
	        lengthOfJsonObject=myresponse.names().length();
	      }
	      catch(Exception e) {
	    	  System.out.println("Exce : "+e);
	      }
	      RequestDispatcher rd;
	     for(int i=0;i<lengthOfJsonObject;i++){
	     	 JSONObject myresponse1=new JSONObject(myresponse.getJSONObject(i+"").toString());
	     	 double r=myresponse1.getDouble("ramUsed");
	     	 double d=myresponse1.getDouble("diskUsed");
	     	 double c=myresponse1.getDouble("cpuUtilization");
	     	 String s=myresponse1.getString("readDateTime");
	     	 System.out.println(r+"  "+d+"  "+"  "+c+"  "+s);
	     	 request.setAttribute("ram",r);
	     	 request.setAttribute("disk",d);
	     	 request.setAttribute("cpu",c);
	     	 request.setAttribute("readDateTime",s);
	     	 rd=request.getRequestDispatcher("jspfile14.jsp");
			 rd.include(request, response);
	       }
	}
}
