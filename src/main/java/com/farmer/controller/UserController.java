package com.farmer.controller;

import com.farmer.model.FarmerInfo;
import com.farmer.service.FarmerService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  Logger logger = LoggerFactory.getLogger(UserController.class);

  private FarmerService farmerService;

  public UserController(FarmerService farmerService) {
    this.farmerService = farmerService;
  }

  @GetMapping("get/{id}")
  public ResponseEntity<FarmerInfo> getUser(@PathVariable("id") long id) {
    logger.info(String.format("Get Farmer Info for id: %s", id));
    FarmerInfo user = farmerService.getFarmerInfo(id);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @GetMapping("/getAll")
  public ResponseEntity<List<FarmerInfo>> getAllUser() {
    logger.info("Get All Farmer Info");
    List<FarmerInfo> users = farmerService.getAllFarmerInfo();
    return new ResponseEntity<>(users, HttpStatus.OK);
  }

  @PostMapping("/add")
  public ResponseEntity<FarmerInfo> saveUser(@RequestBody FarmerInfo user) {
    logger.info("Save Farmer Info RequestBody : [ %s ]", user.toString());
    FarmerInfo savedItem = farmerService.saveFarmerInfo(user);
    return new ResponseEntity<>(savedItem, HttpStatus.CREATED);
  }
}
