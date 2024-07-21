package com.apps.pcornfree.repository;

import com.apps.pcornfree.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository <AppUser, Long> {
}