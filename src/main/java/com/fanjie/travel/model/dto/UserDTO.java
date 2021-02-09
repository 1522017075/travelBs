package com.fanjie.travel.model.dto;

import lombok.Data;

@Data
public class UserDTO {
    private Integer id;
    private String phone;
    private String password;
    private String gender;
    private Integer age;
    private String mail;
    private String profile;
    private String head;
}
