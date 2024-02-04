package com.java.study.jdk9.proxy;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
public class TimeProxy implements InvocationHandler {

    private Book book;


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String value = String.valueOf(method.invoke(book));
        return value;
    }
}
