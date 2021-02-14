package com.fanjie.travel.service.Impl;

import com.fanjie.travel.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.*;

@Service
public class AdminServiceImpl implements AdminService {

    public List<String> saveVideo(MultipartFile file){
//        Map<String,String> resultMap = new HashMap<>();
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
            //构造Map将视频信息返回给前端
            //视频名称重构后的名称
//            resultMap.put("newVidoeName",newVidoeName);
//            resultList.add(newVidoeName);
            //正确保存视频则设置返回码为200
//            resultMap.put("resCode","200");
            //返回视频保存路径
//            resultMap.put("VideoUrl",staticPath + "/" + newVidoeName);
            resultList.add("http://localhost:8888/bs/static/" + newVidoeName);
            return  resultList;

        }catch (Exception e){
            e.printStackTrace();
            e.getMessage();
            //保存视频错误则设置返回码为400
//            resultMap.put("resCode","400");
            return  resultList ;

        }
    }

}
