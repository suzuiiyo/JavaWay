package com.example.demo.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
public class Hero {
    private int id;
    private String name;
    public static void main(String[] args){
        System.out.println(new Hero().);
    }
}
