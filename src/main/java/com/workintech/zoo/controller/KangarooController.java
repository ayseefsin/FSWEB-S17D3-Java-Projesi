package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import jakarta.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Target;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/kangaroos")
public class KangarooController {
    Map< Integer ,Kangaroo> kangaroos;

    @PostConstruct
    public void init() {
        kangaroos=new HashMap<>();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Kangaroo> allKangaroos(){
        return kangaroos.values().stream().toList();
    }
    @GetMapping("/{id}")
    public Kangaroo getKangarooById(@PathVariable("id") Integer id){
        return kangaroos.get(id);
    }
    @PostMapping
    public Kangaroo addKangaroo(@RequestBody Kangaroo kangaroo){
        kangaroos.put(kangaroo.getId(),kangaroo);
        return kangaroos.get(kangaroo.getId());
    }
    @PutMapping("/{id}")
    public Kangaroo updateKangaroo(@PathVariable("id") Integer id, @RequestBody Kangaroo kangaroo){
        if(kangaroos.containsKey(id)){
            kangaroo.setId(id);
            kangaroos.put(id, kangaroo);
            return kangaroos.get(id);
        }else{
            return addKangaroo(kangaroo);
        }
    }
    @DeleteMapping("/{id}")
    public Kangaroo deleteKangaroo(@PathVariable("id") Integer id){
       return kangaroos.remove(id);
    }


}
