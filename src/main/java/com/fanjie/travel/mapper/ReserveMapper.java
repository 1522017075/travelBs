package com.fanjie.travel.mapper;

import com.fanjie.travel.model.dto.ReserveDTO;
import com.fanjie.travel.model.po.Reserve;
import com.fanjie.travel.model.po.ReserveExample;
import java.util.List;

import com.fanjie.travel.model.vo.ReserveVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ReserveMapper {
    long countByExample(ReserveExample example);

    int deleteByExample(ReserveExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ReserveVO record);

    int insertSelective(Reserve record);

    List<ReserveDTO> selectByExample(ReserveExample example);

    Reserve selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Reserve record, @Param("example") ReserveExample example);

    int updateByExample(@Param("record") Reserve record, @Param("example") ReserveExample example);

    int updateByPrimaryKeySelective(Reserve record);

    int updateByPrimaryKey(Reserve record);
}
