package com.informix.test.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserEntity {

    @NotEmpty
    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    private String description;

    private String status;
}
