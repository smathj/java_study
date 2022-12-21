package com.java.study.fire.option;

import java.util.Optional;

class Friend2 {
    String name;
    Optional<Company2> cmp;    // null �� �� ����

    public Friend2(String n, Optional<Company2> c) {
        name = n;
        cmp = c;
    }
    public String getName() { return name; }
    public Optional<Company2> getCmp() { return cmp; }
}

class Company2 {
    String cName;
    Optional<ContInfo5> cInfo;    // null �� �� ����

    public Company2(String cn, Optional<ContInfo5> ci) {
        cName = cn;
        cInfo = ci;
    }
    public String getCName() { return cName; }
    public Optional<ContInfo5> getCInfo() { return cInfo; }

}

class ContInfo5 {
    Optional<String> phone;   // null �� �� ����
    Optional<String> adrs;    // null �� �� ����

    public ContInfo5(Optional<String> ph, Optional<String> ad) {
        phone = ph;
        adrs = ad;
    }
    public Optional<String> getPhone() { return phone; }
    public Optional<String> getAdrs() { return adrs; }

}

class NullPointerCaseStudy3 {
    public static void showCompAddr(Optional<Friend2> f) {

        String addr = f.flatMap(Friend2::getCmp)
                .flatMap(Company2::getCInfo)
                .flatMap(ContInfo5::getAdrs)
                .orElse("There's no address information.");

        System.out.println(addr);
    }

    public static void main(String[] args) {
        Optional<ContInfo5> ci = Optional.of(
                    new ContInfo5(Optional.ofNullable(null), Optional.of("Republic of Korea"))
        );
        Optional<Company2> cp = Optional.of(new Company2("YaHo Co., Ltd.", ci));
        Optional<Friend2> frn = Optional.of(new Friend2("LEE SU", cp));

        // ģ�� �������� ȸ�� �ּҸ� ���
        showCompAddr(frn);
    }
}