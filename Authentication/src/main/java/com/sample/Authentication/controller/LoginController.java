package com.sample.Authentication.controller;

import com.sample.Authentication.cn.APIResponse;
import com.sample.Authentication.dto.LoginDto;
import com.sample.Authentication.dto.SignupDto;
import com.sample.Authentication.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping("/signup")
    public ResponseEntity<APIResponse> signup(@RequestBody SignupDto signupDto)
    {
        APIResponse apiResponse = loginService.signup(signupDto);

        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }
    @PostMapping("/login")
    public ResponseEntity<APIResponse> signup(@RequestBody LoginDto loginDto)
    {
        APIResponse apiResponse = loginService.login(loginDto);

        return ResponseEntity
                .status(apiResponse.getStatus())
                .body(apiResponse);
    }
}
