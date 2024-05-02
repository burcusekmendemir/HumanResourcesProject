package com.project.rabbitmq.model;

import com.project.utility.enums.ERole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class CreateUserModel implements Serializable {

    private Long authId;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String company;
    private String taxNo;
    private ERole role;
    private Long createAt;

}
