package com.fanjie.travel.service.Impl;

import com.fanjie.travel.mapper.SceneMapper;
import com.fanjie.travel.model.dto.SceneDTO;
import com.fanjie.travel.model.po.SceneExample;
import com.fanjie.travel.model.vo.SceneVO;
import com.fanjie.travel.service.SceneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SceneServiceImpl implements SceneService {

    @Autowired
    private SceneMapper sceneMapper;
    @Override
    public List<SceneDTO> list(SceneVO vo) {
        SceneExample sceneExample = new SceneExample();
        return sceneMapper.selectByExample(sceneExample);
    }

    @Override
    public int updateSceneLikeByPrimaryKey(SceneVO vo) {
        return sceneMapper.updateSceneLikeByPrimaryKey(vo);
    }

    @Override
    public List<SceneDTO> selectByPrimaryKey(Integer id) {
        return sceneMapper.selectByPrimaryKey(id);
    }
}
