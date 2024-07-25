package com.shashi.microservices.limitsservice.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

@Component
public class FileService {

    public ResponseEntity<String> uploadFile(File conn, MultipartFile file) throws IOException {
        String filename=file.getOriginalFilename();
        String filePath=conn+File.separator+filename;
        File folder=new File(String.valueOf(conn));
        if(!folder.exists()){
            folder.mkdir();
        }else{
            Files.copy(file.getInputStream(),Paths.get(filePath));
        }
        return ResponseEntity.ok("File upload Successfully.");
    }

    public ResponseEntity<Map<String,String>> uploadAllFile(File path, MultipartFile file) {
        Map<String,String> map=new HashMap<>();
        map.put("fileContentType", file.getContentType());
        map.put("filename", file.getOriginalFilename());
        map.put("fileSize", String.valueOf(file.getSize()));
        map.put("Message","File Successfully uploaded");
        return ResponseEntity.ok(map);
    }


    public void uploadFiles(File path, MultipartFile file) {
    }
}
