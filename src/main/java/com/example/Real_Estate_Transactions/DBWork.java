package com.example.Real_Estate_Transactions;

import java.sql.*;
import java.util.ArrayList;

public class DBWork {
    String url = "jdbc:mysql://localhost:3306/real_estate_transactions?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String userName = "root";
    String password = "mysqlpassword";

    public Connection con(){
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public String selectOneValFromOneRow(String select, String from, String where, String equals){
        String result = "";
        try {
            Statement st = con().createStatement();
            ResultSet rs = st.executeQuery("SELECT " + select + " FROM " + from + " WHERE " + where + "='" + equals + "';");
            if(rs.next()){
                result = rs.getString(select);
            } else{
                result = null;
            }
            rs.close();
            st.close();
            con().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    public void insertQuery(String query){
        try {
            Statement st = con().createStatement();
            st.executeUpdate(query);
            st.close();
            con().close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
