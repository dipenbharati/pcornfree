package com.apps.pcornfree.dto;
// This class is used to transfer data between client and server

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AppUserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}