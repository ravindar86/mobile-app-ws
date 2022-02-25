package com.app.rest.mobileappws.service;

import com.app.rest.mobileappws.dto.UserDto;
import com.app.rest.mobileappws.dto.UserUpdateDto;
import com.app.rest.mobileappws.response.UserResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface UserService {

    UserResponseEntity createUser(UserDto userDto);

    UserResponseEntity getUser(String userId);

    UserResponseEntity updateUser(String userId, UserUpdateDto userUpdateDto);

    boolean deleteUser(String userId);
}
