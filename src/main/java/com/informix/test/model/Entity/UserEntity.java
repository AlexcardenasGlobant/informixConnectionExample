package com.informix.test.model.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEntity {

    private Long id;

    private String name;

    private String description;

    private String status;
}
