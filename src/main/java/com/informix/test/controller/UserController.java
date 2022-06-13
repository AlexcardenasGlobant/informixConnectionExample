package com.informix.test.controller;

import com.informix.test.config.ConnectionConfig;
import com.informix.test.model.domain.UserDAO;
import com.informix.test.service.UserService;
import com.informix.test.util.TemplateResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private ConnectionConfig connection;

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDAO>> findAll() throws SQLException {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.FOUND);
    }

    @GetMapping("/findById")
    public ResponseEntity<UserDAO> findById(@RequestParam Long id) throws SQLException {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.FOUND);
    }

    @PostMapping
    public ResponseEntity<TemplateResponseUtil> insert(@RequestBody List<UserDAO> users){
        return  new ResponseEntity<>(userService.insert(users), HttpStatus.CREATED);
    }

}
