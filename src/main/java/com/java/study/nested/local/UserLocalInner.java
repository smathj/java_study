package com.java.study.nested.local;

interface Printable {
    void print();
}

class Papers {
    private String con;
    public Papers(String s) { this.con = s; }

    // 메서드
    public Printable getPrinter() {
        // 로컬 클래스 정의
        class Printer implements Printable {
            public void print() {
                System.out.println(con);
            }
        }

        // 로컬 클래스 인스턴스 생성 및 반환
        return new Printer();
    }


}


public class UserLocalInner {
    public static void main(String[] args) {
        Papers p = new Papers("서류 내용: 행복합니다.");
        Printable prn = p.getPrinter();
        prn.print();
    }
}
