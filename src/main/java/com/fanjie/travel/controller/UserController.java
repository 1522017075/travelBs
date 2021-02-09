package com.fanjie.travel.controller;

import com.alibaba.fastjson.JSON;
import com.fanjie.travel.model.dto.UserDTO;
import com.fanjie.travel.model.result.Result;
import com.fanjie.travel.model.vo.UserVO;
import com.fanjie.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin
    @RequestMapping("/checkUser")
    public String list(@RequestBody UserVO vo) {
        List<UserDTO> userDTO = userService.selectByPhoneAndPass(vo);
        Result result = new Result();
        if (CollectionUtils.isEmpty(userDTO)) {
            result.setCode(404);
        } else {
            result.setCode(200);
        }
        result.setData(userDTO);
        return JSON.toJSONString(result);
    }

    @CrossOrigin
    @RequestMapping("/registe")
    public String register(@RequestBody UserVO vo) {
        List<UserDTO> userDTO = userService.selectByPhone(vo);
        Result result = new Result();
        if (CollectionUtils.isEmpty(userDTO)) { // 没这个手机号
            userService.insert(vo);
            result.setCode(200);
        } else {
            result.setCode(404);
        }
        return JSON.toJSONString(result);
    }

    @CrossOrigin
    @RequestMapping("/getCode")
    public String getCode(@RequestBody UserVO vo) { // 获取验证码
        Integer code = userService.getCode(vo);
        List<Integer> list = new ArrayList<>();
        Result result = new Result();
        if (code != 0) {
            list.add(code);
            result.setCode(200);
            result.setData(list);
        } else {
            result.setCode(404);
        }
        return JSON.toJSONString(result);
    }
}
