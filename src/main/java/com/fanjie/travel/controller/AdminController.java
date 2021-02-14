package com.fanjie.travel.controller;

import com.alibaba.fastjson.JSON;
import com.fanjie.travel.model.dto.UserDTO;
import com.fanjie.travel.model.result.Result;
import com.fanjie.travel.model.vo.UserVO;
import com.fanjie.travel.service.AdminService;
import com.fanjie.travel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @CrossOrigin
    @PostMapping(value = "/videoUpload")
    @ResponseBody
    public String saveVideo(@RequestParam("file") MultipartFile file)
            throws IllegalStateException {
        List<String> resultString = adminService.saveVideo(file);
        Result result = new Result();
        if (CollectionUtils.isEmpty(resultString)) {
            result.setCode(404);
        } else {
            result.setCode(200);
            result.setData(resultString);
        }
        return JSON.toJSONString(result);

    }
}
