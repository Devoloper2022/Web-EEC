package com.example.ntsdesigntest.Repository;

import com.example.ntsdesigntest.Domain.FileInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileRepo extends CrudRepository<FileInfo,Long> {
    Optional<FileInfo> findFileByFileName(String name);
}