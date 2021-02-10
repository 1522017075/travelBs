package com.fanjie.travel.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fanjie.travel.model.dto.UserDTO;
import com.fanjie.travel.model.result.Result;
import com.fanjie.travel.model.vo.UserVO;
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

        // 随机生成6位字符
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }

        // 文件地址名
        String staticPath = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
        File imageFolder = new File(staticPath);
        File f = new File(imageFolder, sb.toString() + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
        f.getParentFile().mkdirs();

        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8888/bs/static/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
