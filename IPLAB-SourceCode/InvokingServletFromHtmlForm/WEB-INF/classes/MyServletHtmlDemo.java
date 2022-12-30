import java.io.*;
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
public class MyServletHtmlDemo extends HttpServlet
{
    public void service(HttpServletRequest req,HttpServletResponse res)throws
    ServletException,IOException
    {
        PrintWriter out=res.getWriter();
        Enumeration en=req.getParameterNames();
        while(en.hasMoreElements())
        {
            String name=(String)en.nextElement();
            out.print(name+"=");
            String value=req.getParameter(name);
            out.println(value);
            out.println(" ");
        }
    }
}
