package com.java.study.fire.option;


import java.util.Optional;

class Friend {
    String name;
    Company cmp;    // null 가능


    public Friend(String name, Company cmp) {
        this.name = name;
        this.cmp = cmp;
    }

    public String getName() {
        return name;
    }

    public Company getCmp() {
        return cmp;
    }
}


class Company {
    String cName;
    ContInfo4 cInfo;

    public Company(String cName, ContInfo4 cinfo) {
        this.cName = cName;
        this.cInfo = cinfo;
    }

    public String getcName() {
        return cName;
    }

    public ContInfo4 getcInfo() {
        return cInfo;
    }
}

class ContInfo4 {
    String phone;   // null 일수 있음
    String adrs;   // null 일수 있음

    public ContInfo4(String phone, String adrs) {
        this.phone = phone;
        this.adrs = adrs;
    }

    public String getPhone() {
        return phone;
    }

    public String getAdrs() {
        return adrs;
    }
}


public class NullPointerCaseStudy2 {

    public static void showCompAddr(Optional<Friend> f) {


        String addr = f.map(Friend::getCmp)
                .map(Company::getcInfo)
                .map(ContInfo4::getAdrs)
                .orElse("There's no address information.");

        System.out.println(addr);

    }

    public static void main(String[] args) {
        ContInfo4 ci = new ContInfo4("123-456-789", "Republic of Korea");
        Company cp = new Company("도시이름", ci);
        Friend frn = new Friend("성준", cp);
        showCompAddr(Optional.of(frn));

    }
}
