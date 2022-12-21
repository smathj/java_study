package com.java.study.fire.relection.ex01;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Client {
    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {

        Class<?> book = Book.class;
        Constructor<?>[] constructors = book.getDeclaredConstructors();
        System.out.println("생성자 갯수 : " + constructors.length);
//        Book newBook = (Book)constructors[1].newInstance();

        for (Constructor<?> constructor : constructors) {
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            System.out.println("생성자의 파라미터 갯수 : " + parameterTypes.length);

            if (parameterTypes.length == 2) {
                Book newBook = (Book)constructor.newInstance("제목", 10000);
                System.out.println("newBook = " + newBook);
            }
        }

    }
}
