package com.fanjie.travel.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UpLoadService {
    String upLoadImg(MultipartFile file);

    List<String> saveVideo(MultipartFile file);
}
