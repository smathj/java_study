package com.java.study.nested.inner;

interface Printable {
    void print();
}

class Papers {
    private String con;
    public Papers(String s) { this.con = s; }

    // 멤버 클래스 인스턴스 생성 및 반환
    public Printable getPrinter() {
        return new Printer();
    }


    // 멤버 클래스 정의
    private class Printer implements Printable {
        public void print() {
            System.out.println(con);
        }
    }
}


public class UserMemberInner {
    public static void main(String[] args) {
        Papers p = new Papers("서류 내용: 행복합니다.");
        Printable prn = p.getPrinter();
        prn.print();
    }
}
