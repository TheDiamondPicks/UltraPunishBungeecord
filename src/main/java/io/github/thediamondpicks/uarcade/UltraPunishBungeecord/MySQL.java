package io.github.thediamondpicks.uarcade.UltraPunishBungeecord;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQL {

	   
private final String host, database, user, password;

    private Connection con;

    public MySQL(String host, String database, String user, String password) {
        this.host= host;
        this.database= database;
        this.user= user;
        this.password= password;

        connect();
    }

    public void connect() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + host+ ":3306/" + database+ "?autoReconnect=true",
                    user, password);
            System.out.println("§b[Ultra Staff Utilies - Proxy Backend] §3Server Protected - Connection to MySQL database was sucessful");
        } catch (SQLException e) {
            System.out.println("§4--- WARNING ---\n§cULTRA STAFF UTILTES COULD NOT CONNECT TO THE MySQL SERVER. AS THIS WOULD LEAVE THE SERVER UNPROTECTED FROM RULE BREAKERS THE PROXY WILL BE SHUTDOWN!!! THE ERROR MESSAGE IS AS FOLLOWS, PLEASE DEBUG YOUR MySQL CONNECTION!: §R" + e.getMessage());
        }
    }

    public void close() {
        try {
            if (con != null) {
                con.close();
                System.out.println("§b[Ultra Utilites] §3The connection to MySQL has ended successfully!");
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public PreparedStatement prepareStatement(String qry) {
        PreparedStatement st = null;
        try {
            st = con.prepareStatement(qry);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return st;
    }

    public void update(PreparedStatement statement) {
        try {
            statement.executeUpdate();    
        } catch (SQLException e) {
            connect();
            e.printStackTrace();
        }finally{
           try {
             statement.close();
           } catch (SQLException e) {
             e.printStackTrace();
           }
        }
    }

    public boolean hasConnection() {
        return con != null;
    }

    public ResultSet query(PreparedStatement statement) {
        try {
            return statement.executeQuery();
        } catch (SQLException e) {
            connect();
            e.printStackTrace();
        }
        return null;
    }
}
