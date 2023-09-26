package com.example.ntsdesigntest.Service;




import com.example.ntsdesigntest.Repository.LoggerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LoggerService {
    private final LoggerRepo repo;
    @Autowired
    public LoggerService( LoggerRepo repo) {

        this.repo = repo;
    }

    public String getBasicAnalytics()  {

       long records = 0;
       long upload = 0;
       long download =0;

        records = repo.count();
        upload = repo.countByMessage("Upload");
        download = repo.countByMessage("Download");


        return "All logs number is: "+records +"\n"
                +"Uploaded file number is: "+upload+"\n"
                +"Downloaded file number is: "+download+".";

    }

}
