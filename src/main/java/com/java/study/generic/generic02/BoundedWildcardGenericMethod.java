package com.java.study.generic.generic02;

class Box10<T> {
    private T ob;     
    public void set(T o) { ob = o; }
    public T get() { return ob; }
}

class Toy4 {
    @Override 
    public String toString() { 
        return "I am a Toy";
    }
}

class Robot {
    @Override 
    public String toString() { 
        return "I am a Robot";
    }
}

class BoxHandler3 {
    public static <T> void outBox(Box10<? extends T> box) {
        T t = box.get();
        System.out.println(t);
    }

    public static <T> void inBox(Box10<? super T> box, T n) {
        box.set(n); 
    }
}

class BoundedWildcardGenericMethod {
    public static void main(String[] args) {
        Box10<Toy4> tBox = new Box10<>();
        BoxHandler3.inBox(tBox, new Toy4());
        BoxHandler3.outBox(tBox);

        Box10<Robot> rBox = new Box10<>();
        BoxHandler3.inBox(rBox, new Robot());
        BoxHandler3.outBox(rBox);
    }
}