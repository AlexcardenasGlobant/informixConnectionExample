package com.informix.test.service;

import com.informix.test.ConnectionConfig;
import com.informix.test.model.domain.UserDAO;
import com.informix.test.util.TemplateResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
@PropertySource("classpath:queries.properties")
public class UserService {

    @Autowired
    private ConnectionConfig connectionConfig;

    @Value("${findById}")
    private String queryFindbyId;
    
    public List<UserDAO> findAll() throws SQLException {
        List<UserDAO> users = new ArrayList<>();
        Connection connection = connectionConfig.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from todo_items");
        try {
            while (resultSet.next()){
                UserDAO user = new UserDAO();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setDescription(resultSet.getString("description"));
                user.setStatus(resultSet.getString("status"));
                users.add(user);
            }
        } catch (SQLException e){

        } finally {
            resultSet.close();
            statement.close();
            connectionConfig.closeConnection(connection);
        }


        return users;
    }

    public UserDAO findById(Long id) throws SQLException {
        UserDAO user = new UserDAO();
        Connection connection = connectionConfig.getConnection();
        PreparedStatement ps = connection.prepareStatement(queryFindbyId);
        ps.setLong(1, id);
        ResultSet resultSet = ps.executeQuery();
        try {
            while (resultSet.next()){
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setDescription(resultSet.getString("description"));
                user.setStatus(resultSet.getString("status"));
            }
        } catch (SQLException e){

        } finally {
            resultSet.close();
            ps.close();
            connectionConfig.closeConnection(connection);
        }
        return user;
    }

    public TemplateResponseUtil insert(List<UserDAO> users) {
        return null;
    }
}
