import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
public class SessionTrackingUsingHiddenFormField1 extends HttpServlet
 {
 public void doGet(HttpServletRequest request,HttpServletResponse response)
 {
 try
 {
 response.setContentType("text/html");
 PrintWriter out = response.getWriter();
 String n=request.getParameter("username");
 String c=request.getParameter("usercity");
 out.println("<center><h4>Name:Vinod Kumar L</h4>");
 out.println("<h4>RegNo:950019104050</h4></center>");
 out.print("<form action=\"SessionTrackingUsingHiddenFormField2\">");
 out.print("<input type='hidden' name='uname' value="+n+"'>");
 out.print("<input type='submit' value='Just click here'>");
 out.print("<input type='hidden' name='usercity' value="+c+"'>"); 
 out.print("</form>");
 out.close();
 }
 catch(Exception e)
 {
 System.out.println(e);
 }
 }
 } 
