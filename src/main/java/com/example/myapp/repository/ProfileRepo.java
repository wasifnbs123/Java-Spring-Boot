package com.example.myapp.repository;

import com.example.myapp.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface ProfileRepo extends JpaRepository<Profile, Long> {
}
