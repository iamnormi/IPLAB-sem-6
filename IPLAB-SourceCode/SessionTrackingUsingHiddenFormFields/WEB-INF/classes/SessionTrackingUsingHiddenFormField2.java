import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
public class SessionTrackingUsingHiddenFormField2 extends HttpServlet
{
 public void doGet(HttpServletRequest request,HttpServletResponse response)
 {
 try
 {
 response.setContentType("text/html");
 PrintWriter out = response.getWriter();
 out.println("<center><h4>Name:Vinod Kumar L</h4>");
 out.println("<h4>RegNo:950019104050</h4></center>");
 String n=request.getParameter("uname");
 out.println("Hello"+n);
 String c=request.getParameter("usercity");
 out.print("you are from"+c);
 out.close();
 }
 catch(Exception e)
 {
 System.out.println(e);
 }
 }
 }
