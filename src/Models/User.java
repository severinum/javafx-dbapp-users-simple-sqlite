package Models;

import database.DbConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String fname;
    private String lname;
    private String username;
    private String password;

    public User(){

    }

    public User(int id, String fname, String lname, String username, String password) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
    }

    public List<User> getUsers() throws SQLException, ClassNotFoundException {
        List<User> users = new ArrayList<>();
        DbConnector dbConnector = new DbConnector();
        Connection conn = dbConnector.getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
        //conn.close();
        while(resultSet.next()){
            User user = new User(resultSet.getInt("id"),
                    resultSet.getString("fname"),
                    resultSet.getString("lname"),
                    resultSet.getString("username"),
                    resultSet.getString("password"));
            users.add(user);
        }
        return users;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
