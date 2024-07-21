package com.apps.pcornfree.service.impl;

import com.apps.pcornfree.dto.AppUserDto;
import com.apps.pcornfree.entity.AppUser;
import com.apps.pcornfree.exception.ResourceNotFoundException;
import com.apps.pcornfree.mapper.AppUserMapper;
import com.apps.pcornfree.repository.AppUserRepository;
import com.apps.pcornfree.service.AppUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppUserServiceImpl implements AppUserService {

    private AppUserRepository appUserRepository;

    @Override
    public AppUserDto createAppUser(AppUserDto appUserDto) {

        AppUser appUser = AppUserMapper.mapToAppUser(appUserDto);
        AppUser savedAppUser = appUserRepository.save(appUser);
        return AppUserMapper.mapToUserDto(savedAppUser);
    }

    @Override
    public AppUserDto getAppUserById(Long appUserId) {
        AppUser appUser = appUserRepository.findById(appUserId)
                .orElseThrow(() -> new ResourceNotFoundException(" Employee doesn't exist for given id : " + appUserId));
        return AppUserMapper.mapToUserDto(appUser);
    }

    @Override
    public List<AppUserDto> getAllAppUsers() {
        List<AppUser> appUsers = appUserRepository.findAll();
        return appUsers.stream().map((appUser) -> AppUserMapper.mapToUserDto(appUser))
                .collect(Collectors.toList());
    }

    @Override
    public AppUserDto updateAppUser(Long appUserId, AppUserDto updatedAppUser) {
        AppUser appUser = appUserRepository.findById(appUserId).orElseThrow(() -> new ResourceNotFoundException(" AppUser doesn't exist with given id: " + appUserId));

        appUser.setFirstName(updatedAppUser.getFirstName());
        appUser.setLastName(updatedAppUser.getLastName());
        appUser.setEmail(updatedAppUser.getEmail());

        AppUser updatedAppUserObj = appUserRepository.save(appUser);
        return AppUserMapper.mapToUserDto(updatedAppUserObj);
    }

    @Override
    public Void deleteEmployee(Long appUserId) {
        AppUser appUser = appUserRepository.findById(appUserId).orElseThrow(() -> new ResourceNotFoundException(" AppUser doesn't exist with given id: " + appUserId));
        appUserRepository.deleteById(appUserId);
        return null;
    }

}
