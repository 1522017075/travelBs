package com.fanjie.travel.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fanjie.travel.model.dto.UserDTO;
import com.fanjie.travel.model.result.Result;
import com.fanjie.travel.model.vo.UserVO;
import com.fanjie.travel.service.UpLoadService;
import com.fanjie.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private UpLoadService upLoadService;

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
    @RequestMapping("/update")
    public String updateUser(@RequestBody UserVO vo) {
        int success = userService.updateByPrimaryKey(vo);
        Result result = new Result();
        if (success == 1) {
            List<UserDTO> userDTOS = userService.selectByPhone(vo);
            result.setCode(200);
            result.setData(userDTOS);
        } else {
            result.setCode(404);
        }
        return JSON.toJSONString(result);
    }
    @CrossOrigin
    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestBody UserVO vo) {
        int delete = userService.deleteByPrimaryKey(vo.getId());
        Result result = new Result();
        if (delete == 1) {
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

    @CrossOrigin
    @RequestMapping("/up")
    public String up(MultipartFile file) throws Exception {
        return upLoadService.upLoadImg(file);
    }

    @CrossOrigin
    @RequestMapping("/list")
    public String getList(@RequestBody UserVO vo) {
        List<UserDTO> userDTOS = userService.selectAll();
        Result result = new Result();
        if (CollectionUtils.isEmpty(userDTOS)) {
            result.setCode(404);
        } else {
            result.setCode(200);
        }
        result.setData(userDTOS);
        return JSON.toJSONString(result);
    }

    @CrossOrigin
    @RequestMapping("/getUser")
    public String getUser(@RequestBody UserVO vo) {
        List<UserDTO> userDTOS = userService.selectAllBySelect(vo.getPhone());
        Result result = new Result();
        if (CollectionUtils.isEmpty(userDTOS)) {
            result.setCode(404);
        } else {
            result.setCode(200);
        }
        result.setData(userDTOS);
        return JSON.toJSONString(result);
    }
}
