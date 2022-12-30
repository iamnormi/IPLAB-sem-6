    import java.sql.*;  
    class MysqlCon{  
    public static void main(String args[]){  
    try{  
    Class.forName("com.mysql.jdbc.Driver");  
    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/EmpDB?characterEncoding=latin1","root","toor");  
    System.out.println("Connections Success!!");
    //here sonoo is database name, root is username and password  
    Statement stmt=con.createStatement();  
    ResultSet rs=stmt.executeQuery("SELECT id, first, last, age FROM Employees");  
    while(rs.next()){
    	    System.out.print("ID: " + rs.getInt("id"));
            System.out.print(", Age: " + rs.getInt("age"));
            System.out.print(", First: " + rs.getString("first"));
            System.out.println(", Last: " + rs.getString("last"));
    } 
    System.out.println("Connection Closed:) :)");
    con.close();  
    }catch(Exception e){ System.out.println(e);}  
    }  
    }  
