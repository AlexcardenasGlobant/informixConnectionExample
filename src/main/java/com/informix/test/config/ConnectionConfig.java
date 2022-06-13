package com.informix.test.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@PropertySource("classpath:application.properties")
@Component
public class ConnectionConfig {


    @Value("${connection.jdbcUrl}")
    private String jdbcUrl;
    @Value("${connection.user}")
    private String user;
    @Value("${connection.password}")
    private String password;

    public Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcUrl,user, password);
            System.out.println("Conectado a la bd");
        } catch (SQLException exception){
            exception.printStackTrace();
        }
        return connection;
    }

    public boolean closeConnection(Connection connection) throws SQLException{
        if (connection != null){
            connection.close();
        }
        return true;
    }
}
