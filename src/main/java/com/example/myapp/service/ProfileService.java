package com.example.myapp.service;

import com.example.myapp.model.Profile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ProfileService {

    public Profile createProfile(Profile profile, MultipartFile multipartFile) throws IOException;

    public Profile updateProfile(Profile profile, MultipartFile multipartFile) throws IOException;

    public List<Profile> getAllProfile();

    public Profile getProfileById(Long id);

    public void deleteProfile(Long id);

}
