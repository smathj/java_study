//package com.java.study.option;
//
//
//import java.util.Optional;
//
///*
//* Optional 클래스의 map과 orElse를 사용하여 if ~ else 문을 대신한 결과
// */
//class ContInfo {
//    String phone;   // null 일수 있음
//    String adrs;   // null 일수 있음
//
//    public ContInfo(String phone, String adrs) {
//        this.phone = phone;
//        this.adrs = adrs;
//    }
//
//    public String getPhone() {
//        return phone;
//    }
//
//    public String getAdrs() {
//        return adrs;
//    }
//}
//
//public class MapElseOptional {
//    public static void main(String[] args) {
//        Optional<ContInfo> ci = Optional.of(new ContInfo(null, "Republic of Korea"));
//        String phone = ci.map(c -> c.getPhone()).orElse("There is no phone number");
//        String addr = ci.map(c -> c.getAdrs()).orElse("There is no address");
//
//        System.out.println(phone);
//        System.out.println(addr);
//    }
//}
