package com.sample.Authentication.service;

import com.sample.Authentication.Repository.UserRepository;
import com.sample.Authentication.cn.APIResponse;
import com.sample.Authentication.dto.LoginDto;
import com.sample.Authentication.dto.SignupDto;
import com.sample.Authentication.jwt.Util;
import com.sample.Authentication.model.User;
import io.jsonwebtoken.Jwts;
import net.bytebuddy.description.ByteCodeElement;
import org.apache.tomcat.util.json.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
@Service
public class LoginService {
    @Autowired
     private UserRepository userRepository;
    @Autowired
    private Util util;

    public APIResponse signup(SignupDto signupDto) {
        APIResponse apiResponse = new APIResponse();
        User userentity = new User();
        userentity.setName(signupDto.getName());
        userentity.setEmail(signupDto.getEmail());
        userentity.setActive(Boolean.TRUE);
        userentity.setPhoneNumber(signupDto.getPhoneNumber());

        userentity = userRepository.save(userentity);

        String token = Util.generateToken(userentity);
        Map<String,Object> data = new HashMap<>();
        data.put("accessToken",token);

        apiResponse.setData(data);

        return apiResponse;
    }

    public APIResponse login(LoginDto loginDto)
    {
        APIResponse apiResponse = new APIResponse();
        User user = userRepository.findAllByEmailId(loginDto.getEmail(), loginDto.getPassword());
        String token = Util.generateToken(user);
        Map<String,Object> data = new HashMap<>();
        data.put("accessToken",token);

        apiResponse.setData(data);

        return apiResponse;
    }

}

