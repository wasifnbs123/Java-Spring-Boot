package com.example.myapp.controller;

import com.example.myapp.model.Profile;
//import com.example.myapp.model.User;
import com.example.myapp.service.ProfileService;
//import com.example.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RequestMapping("/")
@RestController
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping("alive")
    public String heartBeat() {
        return "Ping-Pong";
    }

    @GetMapping("profiles")
    public ResponseEntity<List<Profile>> getAllProfiles() {
        return ResponseEntity.ok().body(profileService.getAllProfile());
    }

    @GetMapping("profiles/{id}")
    public ResponseEntity<Profile> getProfileById(@PathVariable long id) {
        return ResponseEntity.ok().body(profileService.getProfileById(id));
    }

    @PostMapping(value = "profiles", consumes = { "multipart/form-data" } )
    public ResponseEntity<Profile> createProfile(Profile profile, @RequestParam("file")MultipartFile multipartFile) throws IOException {
        return ResponseEntity.ok().body(this.profileService.createProfile(profile, multipartFile));
    }

    @PutMapping(value = "profiles/{id}", consumes = { "multipart/form-data" } )
    public ResponseEntity<Profile> updateProfile(@PathVariable long id, Profile profile, @RequestParam("file")MultipartFile multipartFile) throws IOException {
        profile.setId(id);
        return ResponseEntity.ok().body(this.profileService.updateProfile(profile, multipartFile));
    }

    @DeleteMapping("profiles/{id}")
    public HttpStatus deleteProfile(@PathVariable long id) {
        this.profileService.deleteProfile(id);
        return HttpStatus.OK;
    }

}
