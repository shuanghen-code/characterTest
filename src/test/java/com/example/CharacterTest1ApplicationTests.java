package com.example;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootTest
class CharacterTest1ApplicationTests {

    @Test
    void contextLoads() {
        List<Integer> menuIds = new ArrayList<>();
//        if (menuIds != null && menuIds.size() != 0){
        if (menuIds.isEmpty()) {
            System.out.println("menuIds为空");
        } else {
            System.out.println("menuIds不为空");
        }


    }


}
