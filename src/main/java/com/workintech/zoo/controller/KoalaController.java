package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Koala;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/koalas")
public class KoalaController {
    private Map< Integer, Koala> koalas;
    @PostConstruct
    public void init(){
        koalas=new HashMap<>();
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Koala> allKoalas(){
        return koalas.values().stream().toList();
    }
    @GetMapping("/{id}")
    public Koala getKoalaById(@PathVariable("id") Integer id){
        return koalas.get(id);
    }
    @PostMapping
    public Koala addKoala(@RequestBody Koala koala){
        koalas.put(koala.getId(),koala);
        return koalas.get(koala.getId());
    }
    @PutMapping("/{id}")
    public Koala updateKoala(@PathVariable("id") Integer id, @RequestBody Koala koala ){
        koala.setId(id);
        if(koalas.containsKey(id)){
           return koalas.put(id,koala);
        }else{
           return addKoala(koala);
        }
    }
    @DeleteMapping("/{id}")
    public Koala deleteKoala(@PathVariable("id") Integer id){
       return koalas.remove(id);
    }

}
