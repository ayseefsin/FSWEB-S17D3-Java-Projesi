package com.workintech.zoo.entity;

import com.workintech.zoo.controller.KoalaController;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class Koala {
    Integer id;
    String name;
    Double weight;
    Integer sleepHour;
    Gender gender;
}
