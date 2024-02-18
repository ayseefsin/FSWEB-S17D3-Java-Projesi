package com.workintech.zoo.validation;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.exceptions.ZooException;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class ZooValidation {
    public static void isValid(Integer id){
        if(id==null || id<0){
            throw new ZooException("id can not be null or smaller than zero: " + id, HttpStatus.BAD_REQUEST);
        }
    }
    public static void checkExistence (Map<Integer, Kangaroo> kangoroos, int id , boolean shouldBeExist){
        if(shouldBeExist){
            if(!kangoroos.containsKey(id)){
                throw new ZooException("id is not exist: " + id, HttpStatus.BAD_REQUEST);
            }else{
                if(kangoroos.containsKey(id)){
                    throw new ZooException("id already exist: " + id, HttpStatus.BAD_REQUEST);
                }
            }
        }
    }

    public static void  checkKangarooWeight(Double weight){
        if(weight == null || weight<=0){
            throw new ZooException("Weight should not be null or less then zero: "+weight,HttpStatus.BAD_REQUEST);
        }
    }


}
