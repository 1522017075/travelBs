package com.fanjie.travel.service.Impl;

import com.fanjie.travel.mapper.AdminMapper;
import com.fanjie.travel.model.dto.AdminDTO;
import com.fanjie.travel.model.po.AdminExample;
import com.fanjie.travel.model.vo.AdminVO;
import com.fanjie.travel.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.*;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    public List<String> saveVideo(MultipartFile file){
        List<String> resultList = new ArrayList<>();
        try{
            //获取文件后缀，因此此后端代码可接收一切文件，上传格式前端限定
            String fileExt = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".") + 1)
                    .toLowerCase();

            // 重构文件名称
            String staticPath = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
            System.out.println("需要保存的路径："+staticPath);
            String pikId = UUID.randomUUID().toString().replaceAll("-", "");
            String newVidoeName = pikId + "." + fileExt;
            System.out.println("重构文件名防止上传同名文件："+newVidoeName);
            //保存视频
            File fileSave = new File(staticPath, newVidoeName);
            if (!fileSave.getParentFile().exists())
                fileSave.getParentFile().mkdirs();
            file.transferTo(fileSave);
            resultList.add("http://localhost:8888/bs/static/" + newVidoeName);
            return resultList;

        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
            return resultList;
        }
    }

    @Override
    public List<AdminDTO> selectByExample(AdminVO vo) {
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(vo.getName());
        criteria.andPasswordEqualTo(vo.getPassword());
        List<AdminDTO> adminDTOS = adminMapper.selectByExample(example);
        return adminDTOS;
    }

}
