package br.com.devdojo.awesome.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private String name ;
    private int age ;
    private char genger;
    public Student(String name) {
        this.name = name;
    }

    public Student(String name, int age, char genger) {
        this.name = name;
        this.age = age;
        this.genger = genger;

    }

    public Student(){}
}
