package com.example.final_project.mapper;

import com.example.final_project.dto.UserDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class UserMapperTest {
    @Autowired
    UserMapper userMapper;
    
    UserDto userDto;
    
    @BeforeEach
    void setUp() {
        userDto = new UserDto();
        userDto.setUserId("aaa");
        userDto.setUserPassword("1234");
        userDto.setUserGender("M");
        userDto.setUserEmail("aaa@naver.com");
        userDto.setUserAddress("서울시");
    }
    

    @Test
    void selectUserNumber() {
//        given
        userMapper.insert(userDto);
//        when
        Long foundNumber = userMapper.selectUserNumber(userDto.getUserId(), userDto.getUserPassword());
//        then
        assertThat(foundNumber).isEqualTo(userDto.getUserNumber());
    }
}