package com.fanjie.travel.model.dto;

import lombok.Data;

@Data
public class ReserveDTO {
    private Integer id;

    private String phone;

    private Integer num;

    private String bookdate;

    private Integer sceneid;

    private String scenename;

    private int isOut;
}
