//package com.java.study.option;
//
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
//public class IfElseOptional {
//    public static void main(String[] args) {
//        ContInfo ci = new ContInfo(null, "Republic of Korea");
//        String phone;
//        String addr;
//
//        if (ci.phone != null) {
//            phone = ci.getPhone();
//        } else {
//            phone = "There is no phone number";
//        }
//
//        if (ci.adrs != null) {
//            addr = ci.getAdrs();
//        } else {
//            addr = "There is no address";
//        }
//
//        System.out.println("phone = " + phone);
//        System.out.println("addr = " + addr);
//    }
//}
