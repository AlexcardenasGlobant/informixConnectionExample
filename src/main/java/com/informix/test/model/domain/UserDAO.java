package com.informix.test.model.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDAO {

    private Long id;

    private String name;

    private String description;

    private String status;
}
