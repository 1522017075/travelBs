package com.fanjie.travel.service;

import com.fanjie.travel.model.dto.AdminDTO;
import com.fanjie.travel.model.po.AdminExample;
import com.fanjie.travel.model.vo.AdminVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AdminService {
    List<String> saveVideo(MultipartFile file);

    List<AdminDTO> selectByExample(AdminVO vo);
}
