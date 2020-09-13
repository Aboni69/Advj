package kz.aitu.project;

import kz.aitu.project.entity.Group;
import kz.aitu.project.entity.Student;

import java.util.*;
import java.sql.*;
public class Main {
    public static void main(String[] args) {
        Student student = new Student(1, "Abat", 1,"87081882574");
        Group group = new Group(1,"CS-1905");
        Connection conn = null;

        try {
            // db parameters
            String url = "jdbc:postgresql://localhost:5432/Uni";
            String user = "postgres";
            String password = "123";


            conn = DriverManager.getConnection(url, user, password);

            Statement stmt = conn.createStatement();
            ResultSet resultSet ;
            Scanner q = new Scanner(System.in);
            String group_name = q.next();
            String query = "SELECT \"Student\".id,\"Student\".name,\"Student\".phone," +
                    "\"Student\".group_id FROM" +
                    "\"Student\" JOIN \"Group\" ON \"Student\".id = \"Group\".id WHERE"+
                    "\"Group\".name = \'"+group_name+"\'";
            resultSet  = stmt.executeQuery(query);
            while (resultSet .next() ) {
                System.out.print(resultSet.getString("id")+" ");
                System.out.print(resultSet.getString("name")+" ");
                System.out.print(resultSet.getString("phone")+" ");
                System.out.print(resultSet.getString("group_id") );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }


    }
}
