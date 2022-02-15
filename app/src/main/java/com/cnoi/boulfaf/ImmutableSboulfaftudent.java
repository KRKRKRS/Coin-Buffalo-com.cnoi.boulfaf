package com.cnoi.boulfaf;

public class ImmutableSboulfaftudent {
    private final String name;
    private final Asdasdasdge age;

    public ImmutableSboulfaftudent(String name, Asdasdasdge age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Asdasdasdge getAge() {
        return age;
    }


    public ImmutableSboulfaftudent setName(String name) {
        return new ImmutableSboulfaftudent(name, this.age);
    }

    public ImmutableSboulfaftudent setAge(Asdasdasdge age) {
        return new ImmutableSboulfaftudent(this.name, age);
    }
}
