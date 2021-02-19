package com.fanjie.travel.service;

import com.fanjie.travel.model.dto.SceneDTO;
import com.fanjie.travel.model.vo.SceneVO;

import java.util.List;

public interface SceneService {

    List<SceneDTO> list(SceneVO vo);

    int updateSceneLikeByPrimaryKey(SceneVO vo);

    int updateByPrimaryKey(SceneVO vo);

    List<SceneDTO> selectByPrimaryKey(Integer id);

    int insert(SceneVO vo);

    int deleteByPrimaryKey(Integer id);
}
