package com.app.rest.mobileappws.service;

import com.app.rest.mobileappws.dto.UserDto;
import com.app.rest.mobileappws.dto.UserUpdateDto;
import com.app.rest.mobileappws.response.UserResponseEntity;
import com.app.rest.mobileappws.util.RandomUIDUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    private RandomUIDUtil randomUIDUtil;

    Map<String, UserResponseEntity> userEntityMap;

    public UserServiceImpl(RandomUIDUtil randomUIDUtil){
        userEntityMap = new HashMap<>();
        this.randomUIDUtil = randomUIDUtil;
    }

    @Override
    public UserResponseEntity createUser(UserDto userDto) {

        UserResponseEntity responseEntity = new UserResponseEntity();
        String userId = randomUIDUtil.getUUID();
        responseEntity.setUserId(userId);
        responseEntity.setFirstName(userDto.getFirstName());
        responseEntity.setLastName(userDto.getLastName());
        responseEntity.setEmailId(userDto.getEmailId());

        userEntityMap.put(userId, responseEntity);

        return responseEntity;
    }

    @Override
    public UserResponseEntity getUser(String userId) {
        if(userEntityMap!=null && userEntityMap.get(userId)!=null)
            return userEntityMap.get(userId);

        return null;
    }

    @Override
    public UserResponseEntity updateUser(String userId, UserUpdateDto userUpdateDto) {

        UserResponseEntity responseEntity = null;

        if(userEntityMap!=null && userEntityMap.get(userId)!=null) {
            responseEntity = userEntityMap.get(userId);

            if(responseEntity!=null) {
                responseEntity.setFirstName(userUpdateDto.getFirstName());
                responseEntity.setLastName(userUpdateDto.getLastName());
                userEntityMap.put(userId, responseEntity);

                return responseEntity;
            }
        }
        return null;
    }

    @Override
    public boolean deleteUser(String userId) {

        UserResponseEntity responseEntity = null;

        if(userEntityMap!=null && userEntityMap.get(userId)!=null) {
            userEntityMap.remove(userId);
        }

        return responseEntity != null ? true : false;
    }
}
