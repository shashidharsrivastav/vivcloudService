package com.shashi.microservices.limitsservice.controller;

import com.shashi.microservices.limitsservice.service.FileService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.util.*;


@RestController
public class FileController {
    private FileService service;
    @Value("${project.file}")
    private File path;

    @PostMapping("/fileUpload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file,FileService service) throws IOException {
        String store= service.uploadFile(path, file).toString();
        //location of uri file--->
        return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/file/").path(Objects.requireNonNull(file.getOriginalFilename())).toUriString());
    }
    @PostMapping("/allFiles")
    public ResponseEntity<String> uploadAllFile(@RequestParam("file") MultipartFile file,FileService service){
        service.uploadAllFile(path,file).toString();
        return ResponseEntity.ok("File upload successfully");
    }

    @PostMapping("/uploadAllFiles")
    public ResponseEntity<List<Map<String,String>>> uploadFiles(@RequestParam("files") List<MultipartFile> files){
        List<Map<String,String>> fileList=new LinkedList<>();
        for(MultipartFile file:files){
            Map<String,String> map=new HashMap<>();
            map.put("fileContentType", file.getContentType());
            map.put("filename", file.getOriginalFilename());
            map.put("fileSize", String.valueOf(file.getSize()));
            String filename = file.getOriginalFilename();
            String filePath = path + File.separator + filename; // Construct the file path
            try {
                file.transferTo(new File(filePath));
                map.put("fileSavedPath", filePath);
                map.put("Message","File Successfully uploaded");
            } catch (IOException e) {
                map.put("Message","Failed to save file: " + e.getMessage());
            }
            fileList.add(map);
        }
        return ResponseEntity.ok(fileList);
    }
}
