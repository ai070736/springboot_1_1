package com.simk.service;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.simk.entities.UserJpa;
import com.simk.mapper.UserJapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class UserJpaService {
    @Autowired
    UserJapRepository userJapRepository;
    @Autowired
    RedisTemplate redisTemplate;

    ObjectMapper objectMapper = new ObjectMapper();
    public UserJpa findAllById(Integer id)  {
        Object o = redisTemplate.opsForValue().get("UserJpa_" + id);
        if (o != null) {
            UserJpa u = JSON.parseObject(JSON.toJSONString(o),UserJpa.class);
            return u;
        }
        List<UserJpa> allById = userJapRepository.findAllById(Collections.singleton(id));
        UserJpa userJpa = allById.get(0);

        redisTemplate.opsForValue().set("UserJpa_" + id, userJpa, 1, TimeUnit.MINUTES);
        return userJpa;
    }
}
