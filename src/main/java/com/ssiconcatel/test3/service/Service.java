package com.ssiconcatel.test3.service;

import com.ssiconcatel.test3.Rebel;
import com.ssiconcatel.test3.controller.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

@org.springframework.stereotype.Service
public class Service {


    Logger logger = LoggerFactory.getLogger(RestController.class);

    //add rebel by json
    public ResponseEntity<Object> addRebel(Rebel rebelInfo) throws IOException{
        logger.info("Entering addRebel service");
        try{
            FileWriter rebelDocumentation = new FileWriter("rebelDocumentation.txt", true);
            Date currentDate = new Date();
            rebelDocumentation.write("Rebel " + rebelInfo.getName() + " on " + rebelInfo.getPlanet() + " at " + currentDate + "\n");
            rebelDocumentation.close();
            return new ResponseEntity<>("true", HttpStatus.CREATED);
        }catch (IOException e){
            logger.error("Error saving rebel info: " +e);
            return new ResponseEntity<>("error saving rebel info", HttpStatus.FORBIDDEN);
        }
    }

    //add rebel by list Strings
    public ResponseEntity<Object> addRebelList(Rebel rebelInfo) throws IOException{
        logger.info("Entering addRebel service");
        try{
            FileWriter rebelDocumentation = new FileWriter("C:/Personal/SII Concatel Test/test3/rebelDocumentation.txt", true);
            Date currentDate = new Date();
            rebelDocumentation.write("Rebel " + rebelInfo.getRebelInfo().get(0) + " on " + rebelInfo.getRebelInfo().get(1) + " at " + currentDate + "\n");
            rebelDocumentation.close();
            return new ResponseEntity<>("true", HttpStatus.CREATED);
        }catch (IOException e){
            logger.error("Error saving rebel info: " +e);
            return new ResponseEntity<>("error saving rebel info", HttpStatus.FORBIDDEN);
        }
    }


    //return rebel information
    public String getRebelInfoService() throws FileNotFoundException{
        logger.info("Entering getRebelInfo Service");
        try{
            FileReader rebelInfo = new FileReader("rebelDocumentation.txt");
            String message = new String();
            int value = rebelInfo.read();
            while (value!=-1){
                value = rebelInfo.read();
                char letter = (char)value;
                message += letter;
            }
            return message;
        }catch(IOException e){
            logger.error("Error getRebelInfoService.." + e);
            return e.toString();
        }
    }
}
