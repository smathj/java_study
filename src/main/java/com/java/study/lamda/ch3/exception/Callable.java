package com.java.study.lamda.ch3.exception;

@FunctionalInterface
public interface Callable<E extends Exception> {
    void call() throws E;
}
