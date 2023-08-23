package com.github.cuifuan.mp.test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.cuifuan.mp.domain.User;
import com.github.cuifuan.mp.util.ObjUtil;

import java.time.LocalDateTime;

public class UserTest {
    public static void main(String[] args) throws JsonProcessingException {
        User user = new User();
        user.setBrithday(LocalDateTime.now());
        user.setName("张三");
        ObjectMapper objectMapper = ObjUtil.objectMapper();
        String result = objectMapper.writeValueAsString(user);
        System.out.println("User ==> " + result);
        ObjectNode jsonNode = (ObjectNode) objectMapper.readTree(result);
        jsonNode.put("remark", "精英");
        System.out.println("jsonNode ==> " + objectMapper.writeValueAsString(jsonNode));
    }
}
