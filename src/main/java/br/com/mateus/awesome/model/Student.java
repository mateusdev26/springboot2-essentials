package br.com.mateus.awesome.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Student {
    private String name ;
    private int age ;
    private char genger;
    public Student(String name) {
        this.name = name;
    }
    public Student(){}
}
