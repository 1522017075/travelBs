package com.fanjie.travel.service.Impl;

import com.fanjie.travel.mapper.ReserveMapper;
import com.fanjie.travel.model.dto.ReserveDTO;
import com.fanjie.travel.model.po.ReserveExample;
import com.fanjie.travel.model.vo.ReserveVO;
import com.fanjie.travel.service.ReserveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReserveServiceImpl implements ReserveService {

    @Autowired
    private ReserveMapper reserveMapper;

    @Override
    public int insert(ReserveVO vo) {
        return reserveMapper.insert(vo);
    }

    @Override
    public List<ReserveDTO> myReserve(ReserveVO vo) {
        return reserveMapper.selectByPhone(vo.getPhone());
    }

    @Override
    public int updateByPrimaryKeySelective(ReserveVO vo) {
        return reserveMapper.updateByPrimaryKeySelective(vo);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return reserveMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<ReserveDTO> selectAll() {
        return reserveMapper.selectAll();
    }

    @Override
    public List<ReserveDTO> selectAllBySelect(String phone) {
        return reserveMapper.selectAllBySelect(phone);
    }
}
