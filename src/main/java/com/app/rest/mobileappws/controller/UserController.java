package com.app.rest.mobileappws.controller;

import com.app.rest.mobileappws.dto.UserDto;
import com.app.rest.mobileappws.dto.UserUpdateDto;
import com.app.rest.mobileappws.exception.CustomException;
import com.app.rest.mobileappws.response.UserResponseEntity;
import com.app.rest.mobileappws.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    public UserService userService;

    Map<String, UserResponseEntity> userEntityMap;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUser(@RequestParam(defaultValue = "1") int page,
                          @RequestParam(defaultValue = "10") int limit,
                          @RequestParam(defaultValue = "asc", required = false) String sort){
        return "User Details fetched for page "+page+" and limit "+limit+" with sort "+sort;
    }

    @GetMapping(path = "/{userId}",
            produces = {MediaType.APPLICATION_JSON_VALUE,
                        MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserResponseEntity> getUser(@PathVariable String userId){

        UserResponseEntity responseEntity = userService.getUser(userId);

        if(responseEntity!=null)
            return new ResponseEntity<>(responseEntity, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(
            consumes = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserResponseEntity> createUser(@Valid @RequestBody UserDto userDto){

/*        UserResponseEntity responseEntity = null;

        if(responseEntity==null) {
            throw new CustomException("Custom Exception is Thrown");
        } */

        UserResponseEntity responseEntity = userService.createUser(userDto);
        return new ResponseEntity<>(responseEntity, HttpStatus.CREATED);
    }

    @PutMapping(path="/{userId}",
            consumes = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserResponseEntity> updateUser(@PathVariable String userId,
                                                         @Valid @RequestBody UserUpdateDto userUpdateDto) {

        UserResponseEntity responseEntity = userService.updateUser(userId, userUpdateDto);

        if(responseEntity!=null) {
            return new ResponseEntity<>(responseEntity, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {

        if(userService.deleteUser(userId)) {
            return ResponseEntity.accepted().build();
        }

        return ResponseEntity.notFound().build();
    }
}
