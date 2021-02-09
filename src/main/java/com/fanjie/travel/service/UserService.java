package com.fanjie.travel.service;

import com.fanjie.travel.model.dto.UserDTO;
import com.fanjie.travel.model.po.TravelUser;
import com.fanjie.travel.model.vo.UserVO;

import java.util.List;

public interface UserService {

    List<UserDTO> selectByPhone(UserVO vo);

    int deleteByPrimaryKey(Integer id);
    int insert(UserVO vo);
    List<TravelUser> selectAll();
    int updateByPrimaryKey(UserVO vo);
    int getCode(UserVO vo);
}
