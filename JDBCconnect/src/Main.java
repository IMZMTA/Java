//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/javaser";
        String uname = "root";
        String pass = "root@123";
        String query = "select * from students";

        // 1 -> import the package -> import java.sql.*; -> Have or Buy Mobile

        // 2 -> Load and Register the Driver. -> Establish the Sim and Mobile
        Class.forName("com.mysql.cj.jdbc.Driver");

        // 3 -> Establish the connection -> On the dialer pad
        Connection con = DriverManager.getConnection(url,uname,pass);

        // 4 -> Create a statement -> Dial the number and call
        Statement st = con.createStatement();

        // 5 -> Execute the query -> Click the green button;
        ResultSet rs = st.executeQuery(query);

        // 6 -> Process the result -> Have a conversation
        rs.next();
        String name = rs.getString("Name") + " " + rs.getString(3);
        System.out.println(name);
        System.out.println(con);

        // 7 -> Close the statement and connection -> Disconnect the call
        st.close();
        con.close();
    }
}