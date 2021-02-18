package com.fanjie.travel.model.dto;

import lombok.Data;

@Data
public class AdminDTO {
    private Integer id;

    private String name;

    private String password;

    private String phone;

    private Integer level;
}
