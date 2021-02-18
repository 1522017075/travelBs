package com.fanjie.travel.controller;

import com.alibaba.fastjson.JSON;
import com.fanjie.travel.model.dto.AdminDTO;
import com.fanjie.travel.model.result.Result;
import com.fanjie.travel.model.vo.AdminVO;
import com.fanjie.travel.service.AdminService;
import com.fanjie.travel.service.UpLoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.*;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;
    @Autowired
    private UpLoadService upLoadService;

    @CrossOrigin
    @PostMapping("/videoUpload")
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

    @CrossOrigin
    @RequestMapping("/imgUpload")
    public String saveImg(MultipartFile file) throws Exception {
        String s = upLoadService.upLoadImg(file);
        List<String> resultString = new ArrayList<>();
        Result result = new Result();
        if(StringUtils.isEmpty(s)){
            result.setCode(404);
        } else {
            result.setCode(200);
            resultString.add(s);
            result.setData(resultString);
        }
        return JSON.toJSONString(result);
    }

    @CrossOrigin
    @RequestMapping("/checkAdmin")
    public String checkAdmin(@RequestBody AdminVO vo){
        vo.setName(vo.getPhone());
        List<AdminDTO> adminDTOS = adminService.selectByExample(vo);
        Result result = new Result();
        if(CollectionUtils.isEmpty(adminDTOS)){
            result.setCode(404);
        } else {
            AdminDTO adminDTO = adminDTOS.get(0);
            adminDTO.setPhone(adminDTO.getName());
            adminDTOS.clear();
            adminDTOS.add(adminDTO);
            result.setCode(200);
            result.setData(adminDTOS);
        }
        return JSON.toJSONString(result);
    }
}
