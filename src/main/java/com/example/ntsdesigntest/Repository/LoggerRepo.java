package com.example.ntsdesigntest.Repository;

import com.example.ntsdesigntest.Domain.MyLogger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepo extends CrudRepository<MyLogger,Long> {
    long countByMessage(String message);
    long countByFileName(String name);

}
