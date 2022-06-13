package com.informix.test.model.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    @Test
    void idTest(){
        UserDAO userDAO = new UserDAO();
        userDAO.setId(1L);
        assertEquals(1L, userDAO.getId());
    }

    @Test
    private void idName(){
        UserDAO userDAO = new UserDAO();
        userDAO.setName("Alex");
        assertEquals("Alex", userDAO.getName());
    }

    @Test
    private void idDescription(){
        UserDAO userDAO = new UserDAO();
        userDAO.setDescription("DescriptionTest");
        assertEquals("DescriptionTest", userDAO.getDescription());
    }

    @Test
    private void idStatus(){
        UserDAO userDAO = new UserDAO();
        userDAO.setStatus("A");
        assertEquals("A", userDAO.getStatus());
    }
}