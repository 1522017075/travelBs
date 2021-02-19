package com.fanjie.travel.mapper;

import com.fanjie.travel.model.dto.SceneDTO;
import com.fanjie.travel.model.po.Scene;
import com.fanjie.travel.model.po.SceneExample;
import java.util.List;

import com.fanjie.travel.model.vo.SceneVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SceneMapper {
    long countByExample(SceneExample example);

    int deleteByExample(SceneExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SceneVO vo);

    int insertSelective(Scene record);

    List<SceneDTO> selectByExample(SceneExample example);

    List<SceneDTO> selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Scene record, @Param("example") SceneExample example);

    int updateByExample(@Param("record") Scene record, @Param("example") SceneExample example);

    int updateByPrimaryKeySelective(SceneVO vo);

    int updateSceneLikeByPrimaryKey(SceneVO vo);
}
