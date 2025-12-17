import java.sql.*;
public class JdbcConn {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // import package
        // load and register
        // create connection
        // create statement
        // execute the statement
        // Process the results
        // close
        String url="jdbc:postgresql://localhost:5432/Student";
        String uname="postgres";
        String password="your password ";
        String query="delete from student where sid=15";
        Class.forName("org.postgresql.Driver");

        Connection con =DriverManager.getConnection(url,uname,password);
        System.out.println("Connection Established");
        Statement st=con.createStatement();
        st.execute(query);
        //boolean status= st.execute(query);
        //System.out.println(status);



       // ResultSet rs=st.executeQuery(query);
////        rs.next();
//        String sname=rs.getString("name");
//        System.out.println(sname);

 /*      while(rs.next()){
            System.out.print(rs.getString(1)+"-");
            System.out.print(rs.getInt(2)+"-");
            System.out.println(rs.getInt(3));



        }

  */
        con.close();
        System.out.println("connection Closed");




    }
}
