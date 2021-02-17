package com.fanjie.travel.controller;

import com.alibaba.fastjson.JSON;
import com.fanjie.travel.model.dto.SceneDTO;
import com.fanjie.travel.model.result.Result;
import com.fanjie.travel.model.vo.SceneVO;
import com.fanjie.travel.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/scene")
public class SceneController {

    @Autowired
    private SceneService sceneService;

    @CrossOrigin
    @RequestMapping("/list")
    public String list(SceneVO vo){
        List<SceneDTO> list = sceneService.list(vo);
        Result result = new Result();
        if(CollectionUtils.isEmpty(list)){
            result.setCode(404);
        } else {
            result.setData(list);
            result.setCode(200);
        }
        return JSON.toJSONString(result);
    }

    @CrossOrigin
    @RequestMapping("recommend")
    public String recommend(SceneVO vo){
        int update = sceneService.updateSceneLikeByPrimaryKey(vo);
        Result result = new Result();
        if(update == 1){
            result.setCode(200);
        } else {
            result.setCode(404);
        }
        return JSON.toJSONString(result);
    }
    @CrossOrigin
    @RequestMapping("getScene")
    public String getScene(@RequestBody SceneVO vo){
        List<SceneDTO> sceneDTOS = sceneService.selectByPrimaryKey(vo.getId());
        Result result = new Result();
        if(CollectionUtils.isEmpty(sceneDTOS)){
            result.setCode(404);
        } else {
            result.setData(sceneDTOS);
            result.setCode(200);
        }
        return JSON.toJSONString(result);
    }
}
