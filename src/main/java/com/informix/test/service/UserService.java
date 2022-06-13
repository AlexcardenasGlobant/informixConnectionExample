package com.informix.test.service;

import com.informix.test.model.domain.UserDAO;
import com.informix.test.util.TemplateResponseUtil;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    public List<UserDAO> findAll() throws SQLException;

    public UserDAO findById(Long id) throws SQLException;

    public TemplateResponseUtil insert(List<UserDAO> users);
}
