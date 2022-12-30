package com.java.study.first.reg;

public class Reg02 {
    public static void main(String[] args) {


        String deathNote = "2022년 12월 30일 수빈님은 아침부터 빡쳣다," +
                "왜냐하면 아침부터 황구와 짭구를 이야기를 들었기때문이다, " +
                "수빈님은 불안하다. 무엇이? IITP가 불안하다. " +
                "수빈님은 어쩌다가 IITP 참여가 된것인가? ";

        System.out.println("deathNote = " + deathNote);

        String newNote = deathNote.replaceAll("수빈님", "김성준");

        System.out.println("newNote = " + newNote);

        String message = "2022 카카오톡 2022";
        System.out.println("message = " + message);
        String newMessage = message.replaceAll("\\d+", "2023");
        System.out.println("newMessage = " + newMessage);

        String twoMessage = message.replaceAll("[가-힣]+", "짭카오톡");
        System.out.println("twoMessage = " + twoMessage);


        String textMessage = "가나다 123";
        String threeMessage = textMessage.replaceAll("^[가-힣]*$", "짭카오톡");
        System.out.println("threeMessage = " + threeMessage);

    }
}
