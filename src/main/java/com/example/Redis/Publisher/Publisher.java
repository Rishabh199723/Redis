package com.example.Redis.Publisher;

import com.example.Redis.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Publisher {

    @Autowired
    RedisTemplate<String,Object> template;
    @Autowired
    ChannelTopic topic;

    @PostMapping("/publish")
    public String publish(@RequestBody User userData) {
        template.convertAndSend(topic.getTopic(),userData.toString());
        return "Data Published";
    }

    @PostMapping("/publishCommon")
    public String publishToCommon(@RequestBody String data) {
        System.out.println("DATA==============="+data);
        template.convertAndSend(new ChannelTopic("common").getTopic(),data);
        return "Data Published";
    }
}
