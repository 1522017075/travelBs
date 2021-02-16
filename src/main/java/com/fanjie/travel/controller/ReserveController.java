package com.fanjie.travel.controller;

import com.alibaba.fastjson.JSON;
import com.fanjie.travel.model.dto.ReserveDTO;
import com.fanjie.travel.model.result.Result;
import com.fanjie.travel.model.vo.ReserveVO;
import com.fanjie.travel.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/reserve")
public class ReserveController {

    @Autowired
    private ReserveService orderService;

    @CrossOrigin
    @RequestMapping("/add")
    public String addOrder(@RequestBody ReserveVO vo){
        int insert = orderService.insert(vo);
        Result result = new Result();
        if(insert == 1){
            result.setCode(200);
        } else {
            result.setCode(404);
        }
        return JSON.toJSONString(result);
    }

    @CrossOrigin
    @RequestMapping("/myReserve")
    public String myOrder(@RequestBody ReserveVO vo){
        List<ReserveDTO> reserveDTOS = orderService.myReserve(vo);
        Result result = new Result();
        if(CollectionUtils.isEmpty(reserveDTOS)){
            result.setCode(404);
        } else {
            result.setData(reserveDTOS);
            result.setCode(200);
        }
        return JSON.toJSONString(result);
    }

}
