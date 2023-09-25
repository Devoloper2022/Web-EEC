package com.example.ntsdesigntest.Service;

import com.example.ntsdesigntest.CustomTemplates.StorageException;
import com.example.ntsdesigntest.CustomTemplates.StorageFileNotFoundException;
import com.example.ntsdesigntest.Domain.FileInfo;
import com.example.ntsdesigntest.Repository.FileRepo;
import com.example.ntsdesigntest.dto.DownloadResponse;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.tool.schema.spi.SqlScriptException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class FileService {
    private final FileRepo repo;

    @Value("${upload.path}")
    private String path;

    @Autowired
    public FileService(FileRepo repo) {
        this.repo = repo;
    }

    static Logger log = LoggerFactory.getLogger(FileService.class);


    public void store(MultipartFile file)  {
        if (file.isEmpty()) {
            log.error("Failed to store empty file.");
            throw new StorageException("Failed to store empty file.");
        }


        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy_hhmmss");

        Date date= new Date();
        try {
             date = formatter.parse(file.getOriginalFilename());
        } catch (ParseException e) {
            log.error("Invalid Name");
            throw new StorageException("Invalid Name");
        }

        try {
            file.transferTo(new File(path+"/"+file.getOriginalFilename()));
            FileInfo info=new FileInfo(file.getOriginalFilename(),date,path);
            repo.save(info);
            log.info("created");
        } catch (IOException e){
            log.error("File Exist");
            throw new StorageException("File Exist");
        } catch (Exception e){
            log.error("File Exist");
            throw new StorageException("File Exist");
        }

    }



    public DownloadResponse getResource(String fileName) throws IOException {
      FileInfo info=repo.findFileByFileName(fileName).get();
       if (info==null){
            throw new StorageFileNotFoundException("Could not read file: " + fileName);
       }
        Resource resource = loadResource(fileName);

       DownloadResponse response=new DownloadResponse();

       response.setName(info.getFileName());
       response.setData(info.getFileDate());
       response.setPath(info.getFilePath());
       response.setResource(resource);

       return response;
    }





    public Resource loadResource(String filename) {
        try {
            Path p1 = Paths.get(path);
            Path file = p1.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {


                return resource;
            }
            else {
                throw new StorageFileNotFoundException(
                        "Could not read file: " + filename);

            }
        }
        catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

}