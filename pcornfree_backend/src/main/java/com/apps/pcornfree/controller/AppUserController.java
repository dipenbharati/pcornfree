package com.apps.pcornfree.controller;

import com.apps.pcornfree.dto.AppUserDto;
import com.apps.pcornfree.entity.AppUser;
import com.apps.pcornfree.service.AppUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// Postman -> DTO ->  Controller Layer(Rest API) -> Service Layer -> Repository Layer -> DB
@RestController // Capable to handle http request
@RequestMapping("/api/appUsers")
public class AppUserController {

    private AppUserService appUserService;

    //Build Add AppUser REST API
    @PostMapping
    // for Post request, @RequestBody= extracts the json from http request body and convert to appUserDto object
    public ResponseEntity<AppUserDto> createAppUser(@RequestBody AppUserDto appUserDto){
        AppUserDto savedAppUser = appUserService.createAppUser(appUserDto);
        return new ResponseEntity<>(savedAppUser, HttpStatus.CREATED);
    }
    // Build Get AppUser REST API
    @GetMapping("{id}")
    public ResponseEntity<AppUserDto> getAppUserById(@PathVariable("id") Long appUserId){
        AppUserDto appUserDto = appUserService.getAppUserById(appUserId);
        return ResponseEntity.ok(appUserDto);
    }
    // Build Get ALL AppUsers REST API
    @GetMapping
    public ResponseEntity<List<AppUserDto>> getAllAppUsers(){
        List<AppUserDto> appUsers = appUserService.getAllAppUsers();
        return ResponseEntity.ok(appUsers);
    }
    // Build Update AppUser REST API
    @PutMapping
    public ResponseEntity<AppUserDto> updateAppUser(@PathVariable("id") Long appUserId,
                                                    @RequestBody AppUserDto updatedAppUser){
        AppUserDto appUserDto = appUserService.updateAppUser(appUserId, updatedAppUser);
        return ResponseEntity.ok(appUserDto);
    }
    // Build Delete AppUser REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAppUser(@PathVariable("id") Long appUserId){
        appUserService.deleteEmployee(appUserId);
        return ResponseEntity.ok("AppUser deleted Successfully");
    }
}
