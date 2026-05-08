package com.test.Controller;

import com.test.Service.DbService;
import com.test.exception.UserDefineException;
import com.test.model.DbData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class HomeController {

    @Autowired
    private DbService dbService;


//    @Autowired
//    private DbJPA dbJPA;

    @GetMapping(path = "/dbData")
    public ResponseEntity<?>  getDbData(){
       List<DbData> dbDataList = dbService.getDbData();
//        List<DbData> dbDataList = dbJPA.findAll();
       if((int)dbDataList.size() > 0){
           return ResponseEntity.ok(dbDataList);
       }
       else{
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }
    }

    @GetMapping(path = "/")
    public ResponseEntity<?> login(){

        return ResponseEntity.ok("Hi there, Check the HTTP Status <br>"+
                HttpStatus.OK +"<br>"+
                HttpStatus.BAD_GATEWAY +"<br>"+
                HttpStatus.ACCEPTED +"<br>"+
                HttpStatus.FORBIDDEN +"<br>"+
                HttpStatus.UNAUTHORIZED +"<br>"+
                HttpStatus.BAD_REQUEST +"<br>"+
                HttpStatus.INTERNAL_SERVER_ERROR +"<br>"+
                HttpStatus.CREATED +"<br>"+
                HttpStatus.INSUFFICIENT_STORAGE +"<br>"+
                HttpStatus.NOT_FOUND +"<br>"+
                HttpStatus.PAYLOAD_TOO_LARGE +"<br>"+
                HttpStatus.REQUEST_TIMEOUT +"<br>"+
                HttpStatus.TOO_MANY_REQUESTS +"<br>"+
                HttpStatus.NO_CONTENT +"<br>"+
                HttpStatus.PAYMENT_REQUIRED +"<br>"+
                HttpStatus.PARTIAL_CONTENT +"<br>"+
                HttpStatus.FOUND +"<br>"+
                HttpStatus.PROCESSING +"<br>"
        );
    }

    @GetMapping(path = "/test/{arg}")
    public String testValidation(@PathVariable("arg") String arg)throws  Exception{
        try{
            if(arg.length() > 0){
                throw new UserDefineException("Error");
            }
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return exception.getMessage();
        }

        return "This is the default return value";
    }

}
