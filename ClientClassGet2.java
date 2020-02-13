package com.fetchvalue.ClientGetProg;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet("/ClientClassGet2")
public class ClientClassGet2 extends HttpServlet{
   private static final long serialVersionUID = 1L;
   public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
	   URL url = new URL("http://localhost:8181/ClientGetProg/getResource1/getdata");
      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      con.setRequestMethod("GET");
      con.setRequestProperty("Accept", "application/json");
      BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
      String inputLine;
      StringBuffer response=new StringBuffer();
      while ((inputLine = in.readLine()) != null) {
    	response.append(inputLine);
      }
      //System.out.println(response);
      in.close();
      con.disconnect();
      JSONObject myresponse=new JSONObject(response.toString());
      int lengthOfJsonObject=myresponse.names().length();
      Readings readings=null;
      PrintWriter out=res.getWriter();
      
      out.println("<html><body><table color=\"green\" cellpadding=\"5\" border=\"3px solid gray;text-align:center;\">");
      out.println("<tr style=\"text-align:center;\">"
    		+ "<th>readDateTime</th>"+"<th>ramUsed</th>"
    		+ "<th>diskUsed</th>"+"<th>cpuUsed</th>"
      		+ "</tr>");
      
      for(int i=0;i<lengthOfJsonObject;i++){
    	 readings=new Readings();
    	 JSONObject myresponse1=new JSONObject(myresponse.getJSONObject(i+"").toString());
    	 float r=myresponse1.getFloat("ramUsed");
    	 readings.setRamUsed(r);
    	 float d=myresponse1.getFloat("diskUsed");
    	 readings.setDiskUsed(d);
    	 double c=myresponse1.getDouble("cpuUtilization");
    	 readings.setCpuUtilization(c);
    	 String s=myresponse1.getString("readDateTime");
    	 readings.setReadDateTime(s);
    	 
    	 out.println("<tr style=\"text-align:center;\">");
    	 out.println("<td>"+s+"</td>");
    	 out.println("<td>"+r+"</td>");
    	 out.println("<td>"+d+"</td>");
    	 out.println("<td>"+c+"</td>");
    	 out.println("</tr>");
    	 
    	 //System.out.println(r+"  "+d+"  "+"  "+c+"  "+s);
      }//end of loop
      
      out.println("</table></body></html>");
      
    }//end of service method
}//end of class
