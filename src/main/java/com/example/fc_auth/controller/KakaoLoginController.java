package com.example.fc_auth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class KakaoLoginController {

    @GetMapping("/kakao/callback")
    public ResponseEntity callback(@RequestParam("code")String code){
        log.info("code " + code);
        return new ResponseEntity(HttpStatus.OK);
    }
}
