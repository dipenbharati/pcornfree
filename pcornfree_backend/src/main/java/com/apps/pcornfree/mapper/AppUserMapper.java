package com.apps.pcornfree.mapper;

import com.apps.pcornfree.dto.AppUserDto;
import com.apps.pcornfree.entity.AppUser;

public class AppUserMapper {

    public static AppUserDto mapToUserDto(AppUser appUser){
        return new AppUserDto(
                appUser.getId(),
                appUser.getFirstName(),
                appUser.getLastName(),
                appUser.getEmail()
        );
    }
    public static AppUser mapToAppUser(AppUserDto appUserDto){
        return new AppUser(
                appUserDto.getId(),
                appUserDto.getFirstName(),
                appUserDto.getLastName(),
                appUserDto.getEmail()
        );
    }
}