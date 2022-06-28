package com.example.courseworkbackend.controller;

import com.example.courseworkbackend.dao.Categories;
import com.example.courseworkbackend.dao.Favorite;
import com.example.courseworkbackend.dao.Product;
import com.example.courseworkbackend.dao.User;
import com.example.courseworkbackend.exception.NotFoundException;
import models.categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("message")
public class TestController {
    final private Categories categories;
    final private Product product;
    final private Favorite favorite;
    final private User user;
    private int user_id;

    public TestController(Categories categories, Product product, Favorite favorite, User user) {
        this.categories = categories;
        this.product = product;
        this.favorite = favorite;
        this.user = user;
    }

    public List<Map<String, String>> messages = new ArrayList<Map<String, String>>() {{
        add(new HashMap<String, String>() {{
            put("id", "1");
            put("text", "First Message");
        }});
        add(new HashMap<String, String>() {{
            put("id", "2");
            put("text", "2 Message");
        }});
        add(new HashMap<String, String>() {{
            put("id", "3");
            put("text", "3 Message");
        }});

    }};


    @GetMapping
    public List<Map<String, String>> list() {
        return this.messages;
    }

    @GetMapping("colomns")
    public List<models.categories> categories() {
        return this.categories.categories();
    }

    @GetMapping("product/{id}")
    public List<models.product> product(@PathVariable int id) {
        return this.product.getproduct(id);
    }

    @GetMapping("product")
    public List<models.product> product() {
        return this.product.getproduct(2);
    }

    @GetMapping("test")
    public int  test(@RequestParam("login") String login, @RequestParam("password") String password) {
        System.out.println(user_id);
        this.user_id = user.getUserId(login);
        System.out.println(login + " " + password);
        System.out.println(this.user_id);

        return user_id;
    }

    @GetMapping("{id}")
    public Map<String, String> getOne(@PathVariable String id) {
        return messages.stream().
                filter(messages -> messages.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }
    //    @GetMapping("favorire/{user_id}")
//    public List<models.favorite> favorites(@PathVariable int user_id){
//        return this.favorite.getListFavoriteByID(user_id);
//    }
    @GetMapping("favorire")
    public List<models.product> favorites() {
        if(user_id != -1) {
            return this.favorite.getFavoriteProdictList(user_id);
        }else return null;
    }
//    @GetMapping("favorire")
//    public List<models.favorite> favorites() {
//        if(user_id != -1) {
//            return this.favorite.getListFavoriteByID(user_id);
//        }else return null;
//    }

    @PostMapping("favorire/{user_id}")
    public List<models.favorite> AddFavorite(@PathVariable int user_id) {
        return this.favorite.getListFavoriteByID(user_id);
    }

//    @PutMapping("{id}")
//    public Map<String,String> update(@PathVariable String id, @RequestBody Map<String,String>){
//        return messages.stream().
//                filter(messages -> messages.get("id").equals(id))
//                .findFirst()
//                .orElseThrow(NotFoundException::new);
//    }
}
