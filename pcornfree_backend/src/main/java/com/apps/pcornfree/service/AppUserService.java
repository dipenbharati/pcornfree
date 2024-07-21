package com.apps.pcornfree.service;

import com.apps.pcornfree.dto.AppUserDto;

import java.util.List;

public interface AppUserService {
    AppUserDto createAppUser(AppUserDto appUserDto);
    AppUserDto getAppUserById(Long appUserId);
    List<AppUserDto> getAllAppUsers();
    AppUserDto updateAppUser(Long appUserId, AppUserDto updatedAppUser);
    Void deleteEmployee(Long appUserId);
}

