package com.java.study.fire.nested.anonymous;

interface Printable {
    void print();
}

class Papers {
    private String con;
    public Papers(String s) { this.con = s; }

    // 메서드
    public Printable getPrinter() {
        // 익명 클래스의 정의와 인스턴스 생성
        return new Printable() {
            public void print() {
                System.out.println(con);
            }
        };
    } 


}


public class UserAnonymousInner {
    public static void main(String[] args) {
        Papers p = new Papers("서류 내용: 행복합니다.");
        Printable prn = p.getPrinter();
        prn.print();
    }
}
