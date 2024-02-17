package com.workintech.zoo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Getter
@Setter
public class Kangaroo {
   Integer id;
   String name;
   Double height;
   Double weight;
   Gender gender;
   Boolean isAggressive;
}
