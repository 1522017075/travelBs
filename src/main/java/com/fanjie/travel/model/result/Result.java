package com.fanjie.travel.model.result;

import lombok.Data;

import java.util.List;

@Data
public class Result<T> {

    private int code;
    private List<T> data;
}
