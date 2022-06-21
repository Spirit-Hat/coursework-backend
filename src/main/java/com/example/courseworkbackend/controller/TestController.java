package com.example.courseworkbackend.controller;

import com.example.courseworkbackend.exception.NotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("message")
public class TestController {

    public List<Map<String,String>> messages = new ArrayList<Map<String,String>>(){{
    add(new HashMap<String,String >() {{put("id", "1"); put("text", "First Message"); }});
    add(new HashMap<String,String >() {{put("id", "2"); put("text", "2 Message"); }});
    add(new HashMap<String,String >() {{put("id", "3"); put("text", "3 Message"); }});

    }};

    @GetMapping
    public List<Map<String, String>> list(){
        return this.messages;
    }

    @GetMapping("{id}")
    public Map<String,String> getOne(@PathVariable String id){
        return messages.stream().
                filter(messages -> messages.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

//    @PutMapping("{id}")
//    public Map<String,String> update(@PathVariable String id, @RequestBody Map<String,String>){
//        return messages.stream().
//                filter(messages -> messages.get("id").equals(id))
//                .findFirst()
//                .orElseThrow(NotFoundException::new);
//    }
}
