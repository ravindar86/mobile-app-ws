package com.app.rest.mobileappws.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RandomUIDUtil {

    public String getUUID(){
        return  UUID.randomUUID().toString();
    }
}
