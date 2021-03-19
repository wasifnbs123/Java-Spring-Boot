package com.example.myapp.service;

import com.example.myapp.model.Profile;
import com.example.myapp.repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileRepo profileRepo;

    @Override
    public Profile createProfile(Profile profile, MultipartFile multipartFile) throws IOException {
        profile.setImage(multipartFile.getBytes());
        profile.setImageOriginalName(multipartFile.getOriginalFilename());
        profile.setImageContentType(multipartFile.getContentType());
        return profileRepo.save(profile);
    }

    @Override
    public Profile updateProfile(Profile profile, MultipartFile multipartFile) throws IOException {
        Optional<Profile> profileDB = this.profileRepo.findById(profile.getId());
        if (profileDB.isPresent()) {
            Profile profileUpdate = profileDB.get();
            profileUpdate.setFirstName(profile.getFirstName());
            profileUpdate.setLastName(profile.getLastName());
            profileUpdate.setGender(profile.getGender());
            profileUpdate.setAddress(profile.getAddress());
            profileUpdate.setAge(profile.getAge());
            profileUpdate.setEmail(profile.getEmail());
            profileUpdate.setPassword(profile.getPassword());
            profileUpdate.setLikes(profile.getLikes());
            profileUpdate.setImage(multipartFile.getBytes());
            profileUpdate.setImageOriginalName(multipartFile.getOriginalFilename());
            profileUpdate.setImageContentType(multipartFile.getContentType());
            return profileRepo.save(profileUpdate);
        } else {
            return null;
        }
    }

    @Override
    public List<Profile> getAllProfile() {
        return profileRepo.findAll();
    }

    @Override
    public Profile getProfileById(Long id) {
        return profileRepo.findById(id).get();

    }

    @Override
    public void deleteProfile(Long id) {
        profileRepo.deleteById(id);
    }

}
