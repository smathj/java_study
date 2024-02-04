package com.java.study.jdk9.proxy;

import java.lang.reflect.Proxy;

public class ProxyTest1 {

    public static void main(String[] args) throws Exception {


        Book target = new Book("이거시 자바다");

        TimeProxy timeHandler = new TimeProxy(target);

        BookInterface proxy = (BookInterface) Proxy.newProxyInstance(TimeProxy.class.getClassLoader(), new Class[]{BookInterface.class}, timeHandler);

        String s = proxy.bookName();
        System.out.println("s = " + s);


    }

}
