package com.example.vs.testing.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RestController
@CrossOrigin
public class controller {


        @GetMapping("/path")
        public String welocme() {
            System.out.println("hello");
            return "hello";
        }



      private static final String UPLOAD_DIR = "C:\\Users\\Mukul\\Desktop\\New folder (2)\\";
    @CrossOrigin
    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return new ResponseEntity<>("No file uploaded", HttpStatus.BAD_REQUEST);
        }

        try {
            // Save the file
            String fileName = file.getOriginalFilename();
            assert fileName != null;
            file.transferTo(new File(UPLOAD_DIR + fileName));
            return new ResponseEntity<>("File uploaded successfully", HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>("Failed to upload file", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//    @PostMapping("/upload")
//    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//        if (file.isEmpty()) {
//            return ResponseEntity.badRequest().body("Please select a file to upload");
//        }
//
//        try (InputStream inputStream = file.getInputStream();
//             OutputStream outputStream = new FileOutputStream("uploads/" + file.getOriginalFilename())) {
//            byte[] buffer = new byte[1024];
//            int bytesRead;
//            while ((bytesRead = inputStream.read(buffer)) != -1) {
//                outputStream.write(buffer, 0, bytesRead);
//            }
//        } catch (IOException e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
//        }
//
//        return ResponseEntity.ok("File uploaded successfully");
//    }


}