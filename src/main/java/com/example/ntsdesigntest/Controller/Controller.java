package com.example.ntsdesigntest.Controller;


import com.example.ntsdesigntest.dto.DownloadResponse;
import com.example.ntsdesigntest.dto.SocketRequest;
import com.example.ntsdesigntest.dto.SocketResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import com.example.ntsdesigntest.Service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.HtmlUtils;

import java.io.IOException;


@CrossOrigin
@RestController
@RequestMapping("/api/file")
public class Controller {
    @Autowired
    private FileService service;



    @PostMapping("/upload")
    public ResponseEntity<Object> uploadFile(@RequestParam("file") MultipartFile file ) throws IOException {
        service.store(file);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PostMapping("/download")
    public ResponseEntity<Object> downloadFile(@RequestParam String fileInfo,@RequestParam String fileName ) throws IOException {
        DownloadResponse file=service.getResource(fileName);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "File name: "+file.getName()
                                +",\n Date: "+file.getData()
                                +",\n Path: "+file.getPath())
                .body(file.getResource());
    }
}
