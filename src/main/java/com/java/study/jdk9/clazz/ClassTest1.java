package com.java.study.jdk9.clazz;

import com.java.study.jdk9.collection.Human;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ClassTest1 {

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {

        Human human = new Human();

        Class<? extends Human> aClass = human.getClass();
        System.out.println("aClass = " + aClass);

        Class<Human> humanClass = Human.class;
        System.out.println("humanClass = " + humanClass);

        System.out.println(aClass.equals(humanClass));


        String packageName = aClass.getPackageName();
        System.out.println("packageName = " + packageName);

        Constructor<?>[] constructors = aClass.getConstructors();
        System.out.println(Arrays.toString(constructors));

        Constructor<?> constructor = constructors[1];
        Human asd = (Human) constructor.newInstance("사람", 10, "1반");
        System.out.println("asd = " + asd);


    }
}
