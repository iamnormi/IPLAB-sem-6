    import java.sql.*;  
    class MysqlCon{  
    public static void main(String args[]){  
    try{  
    Class.forName("com.mysql.jdbc.Driver");  
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam?characterEncoding=latin1","root","toor");  
    System.out.println("Connections Success!!");
    //here sonoo is database name, root is username and password  
    Statement stmt=con.createStatement();  
    ResultSet rs=stmt.executeQuery("select * from emp");  
    while(rs.next())  
    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
    System.out.println("Connection Closed:) :)");
    con.close();  
    }catch(Exception e){ System.out.println(e);}  
    }  
    }  
