package com.fanjie.travel.service.Impl;

import com.fanjie.travel.service.UpLoadService;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@Service
public class UpLoadServiceImpl implements UpLoadService {
    @Override
    public String upLoadImg(MultipartFile file){
        // 随机生成6位字符
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }

        // 文件地址名
        String staticPath = ClassUtils.getDefaultClassLoader().getResource("static").getPath();
        File imageFolder = new File(staticPath);
        File f = new File(imageFolder, sb.toString() + file.getOriginalFilename()
                .substring(file.getOriginalFilename().length() - 4));
        if (!f.getParentFile().exists())
            f.getParentFile().mkdirs();

        try {
            file.transferTo(f);
            String imgURL = "http://localhost:8888/bs/static/" + f.getName();
            return imgURL;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override
    public List<String> saveVideo(MultipartFile file) {
        return null;
    }
}
