import java.io.*; 
import java.sql.*; 
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class Threetierapp extends HttpServlet{
	String message,Seat_no,Name,ans1,ans2,ans3,ans4,ans5; 
        int Total=0;
	Connection connect=null;
        Statement stmt=null; 
        ResultSet rs=null;
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");
		        Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","toor");
                        message="Thank you for participating in online Exam";
			}
			catch(ClassNotFoundException cnfex){ cnfex.printStackTrace();
			}
			catch(SQLException sqlex){ sqlex.printStackTrace();
			}
			catch(Exception excp){ excp.printStackTrace();
			}
			Seat_no=request.getParameter("Seat_no"); 
                        Name=request.getParameter("Name");
			ans1=request.getParameter("group1"); 
                        ans2=request.getParameter("group2");
			ans3=request.getParameter("group3"); 
                        ans4=request.getParameter("group4");
			ans5=request.getParameter("group5"); 
                        if(ans1.equals("True"))
				Total+=2;
			if(ans2.equals("False"))
				Total+=2;
			if(ans3.equals("True"))
				Total+=2;
			if(ans4.equals("False"))
				Total+=2;
			if(ans5.equals("False"))
				Total+=2; 
                        try{
					Statement stmt=connect.createStatement();
					String query="INSERT INTO student("+"Seat_no,Name,Total"+") VALUES('"+Seat_no+"','"+Name+"','"+Total+"')";
					int result=stmt.executeUpdate(query); 
					stmt.close();
					}
					catch(SQLException ex){}
					response.setContentType("text/html"); 
					PrintWriter out=response.getWriter();
					out.println("<html>"); 
                                        out.println("<head>"); 
					out.println("</head>"); 
                                        out.println("<bodybgcolor=cyan>"); 
					out.println("<center>"); 
                                        out.println("<h1>"+message+"</h1>\n");
					out.println("<h3>Yours results stored in our database</h3>"); 
					out.print("<br><br>");
					out.println("<b>"+"Participants and their Marks"+"</b>"); 
                                        out.println("<tableborder=5>");
					try{
						Statement stmt=connect.createStatement(); 
						String query="SELECT * FROM student"; 
						ResultSet rs =stmt.executeQuery(query); 
						out.println("<th>"+"Seat_no"+"</th>");
						out.println("<th>"+"Name"+"</th>"); 
						out.println("<th>"+"Marks"+"</th>");
						while(rs.next()){
							out.println("<tr>");
							out.print("<td>"+rs.getInt(1)+"</td>");
							out.print("<td>"+rs.getString(2)+"</td>");
							out.print("<td>"+rs.getString(3)+"</td>");
							out.println("</tr>");
							}
							out.println("</table>");
							}
							catch(SQLException ex){ } 
							finally{
								try{
									if(rs!=null)
										rs.close();
									if(stmt!=null)
										stmt.close();
									if(connect!=null)
										connect.close();
									}
									catch(SQLException e){ }
									}
									out.println("</center>");
									out.println("</body></html>");
									Total=0;
									} 
									}
