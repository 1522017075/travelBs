package com.fanjie.travel.service;

import com.fanjie.travel.model.dto.ReserveDTO;
import com.fanjie.travel.model.vo.ReserveVO;

import java.util.List;

public interface ReserveService {

    int insert(ReserveVO vo);

    List<ReserveDTO> myReserve(ReserveVO vo);
}
