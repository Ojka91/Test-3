package com.ssiconcatel.test3.controller;
import com.ssiconcatel.test3.Rebel;
import com.ssiconcatel.test3.Test3Application;
import com.ssiconcatel.test3.service.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {

    Logger logger = LoggerFactory.getLogger(RestController.class);

    @Autowired
    private Service service;

    //test api connection
    @RequestMapping("")
    public String testApi(){
        logger.info("Entering testApi");
        try{
            return "Api OK";
        }catch (Exception e) {
            logger.error("Error testApi:" + e);
            return "Error: " + e.toString();
        }
    }

    //Add new rebels and write it on a txt document from json
    @RequestMapping(path = "/addRebel", method = RequestMethod.POST)
    public ResponseEntity<Object> addRebel(@RequestBody Rebel rebel){
        logger.info("Entering addRebel API");
        try{
            return service.addRebel(rebel);
        }catch (Exception e){
            logger.error("Error saving Rebel info: " + e);
            return new ResponseEntity<>("error saving rebel info", HttpStatus.FORBIDDEN);
        }
    }

    //Add new rebels and write it on a txt document from list of strings
    @RequestMapping(path = "/addRebelList", method = RequestMethod.POST)
    public ResponseEntity<Object> addRebelList(@RequestBody Rebel rebel){
        logger.info("Entering addRebel API");
        try{
            return service.addRebelList(rebel);
        }catch (Exception e){
            logger.error("Error saving Rebel info: " + e);
            return new ResponseEntity<>("error saving rebel info", HttpStatus.FORBIDDEN);
        }
    }

    //get information from rebels
    @RequestMapping("/getRebelInfo")
    public String getRebelInfo() {
        logger.info("Entering getRebelInfo...");
        try{
            return service.getRebelInfoService();
        }catch (FileNotFoundException e){
            logger.error("Error getting rebel info:  " + e);
            return e.toString();
        }
    }
}
