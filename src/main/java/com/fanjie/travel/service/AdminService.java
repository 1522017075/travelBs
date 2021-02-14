package com.fanjie.travel.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface AdminService {
    List<String> saveVideo(MultipartFile file);
}
