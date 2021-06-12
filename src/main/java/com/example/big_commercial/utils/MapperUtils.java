package com.example.big_commercial.utils;

import com.example.big_commercial.dto.UserDTO;
import com.example.big_commercial.entity.UserEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class MapperUtils {

    public static void dto2Entity(UserDTO dto, UserEntity userEntity) {
        userEntity.setEmail( dto.getEmail() );
        userEntity.setPassword( dto.getPassword() );
        userEntity.setFirstName( dto.getFirstName() );
        userEntity.setLastName( dto.getLastName() );
        userEntity.setCompany( dto.getCompany() );
        userEntity.setImagUrl( dto.getImagUrl() );
        userEntity.setPhone( dto.getPhone() );
        userEntity.setStoreCredit( dto.getStoreCredit() );
        userEntity.setRole( dto.getRole() );
        try {
            if ( dto.getJoinDate() != null ) {
                userEntity.setJoinDate( new SimpleDateFormat().parse( dto.getJoinDate() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        try {
            if ( dto.getLastLogin() != null ) {
                userEntity.setLastLogin( new SimpleDateFormat().parse( dto.getLastLogin() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        try {
            if ( dto.getLastLoginDisplay() != null ) {
                userEntity.setLastLoginDisplay( new SimpleDateFormat().parse( dto.getLastLoginDisplay() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        userEntity.setIsActive( dto.getIsActive() );
        userEntity.setIsNotLocked( dto.getIsNotLocked() );
    }


}
