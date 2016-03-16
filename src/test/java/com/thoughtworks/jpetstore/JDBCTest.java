package com.thoughtworks.jpetstore;

import com.thoughtworks.jpetstore.domain.Account;
import com.thoughtworks.jpetstore.domain.Student;

import java.sql.*;

/**
 * Created by coderliu on 3/4/16.
 */
public class JDBCTest {


    public static void main(String[] args) throws Exception {

        // JDBCTest driver name and database URL
        final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        final String DB_URL = "jdbc:mysql://localhost:3306/jpetstore";
        //  Database credentials
        final String USER = "root";
        final String PASS = "123456";

        Connection conn = null;
        Statement stmt = null;

        //STEP 1: 注册驱动
        Class.forName(JDBC_DRIVER);
        //STEP 2: 建立连接
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
       //conn.setAutoCommit(false);
        //STEP 3:创建Statment
        stmt = conn.createStatement();
        //STEP 4:执行操作
        String sql = "SELECT\n" +
                "          ACCOUNT.USERID USERNAME,\n" +
                "          ACCOUNT.EMAIL,\n" +
                "          ACCOUNT.FIRSTNAME,\n" +
                "          ACCOUNT.LASTNAME,\n" +
                "          ACCOUNT.STATUS,\n" +
                "          ACCOUNT.ADDR1 AS address1,\n" +
                "          ACCOUNT.ADDR2 AS address2,\n" +
                "          ACCOUNT.CITY,\n" +
                "          ACCOUNT.STATE,\n" +
                "          ACCOUNT.ZIP,\n" +
                "          ACCOUNT.COUNTRY,\n" +
                "          ACCOUNT.PHONE\n" +
                "    FROM ACCOUNT\n" +
                "    WHERE ACCOUNT.USERID = 'google'";
        ResultSet resultSet = stmt.executeQuery(sql);

        while (resultSet.next()){
            Account account= new Account();
            account.setUserName(resultSet.getString("USERNAME"));
            System.out.println("account userName = [" + account.getUserName() + "]");
        }
        String insertsql="insert into student values(6,'sa',3)";
        String insertsql2="insert into student values(1,'sd',2)";
        String delsql="delete from student where id=1";
        String querysql="select * from student,course where student.id=course.id and course.cname='chinese' and course.grade>60";
        //stmt.executeUpdate(insertsql);
        //stmt.executeUpdate(insertsql2);
        //stmt.executeUpdate(delsql);
        ResultSet resultSet2 = stmt.executeQuery(querysql);
        while (resultSet2.next()){
            //Student account= new Student();
            //account.getName();
            System.out.println("id : " + resultSet2.getString("id") + "  "+ resultSet2.getString("name") + "  "+ resultSet2.getString("cname") + "  "+ resultSet2.getString("classes") + "  "+ resultSet2.getString("grade") + "  ");
        }
        //conn.rollback();
       // conn.commit();
        //STEP 5: 关闭资源
        try {
            if (stmt != null)
                conn.close();
            if (conn != null)
                conn.close();
        } catch (SQLException se) {
        }

    }

}
