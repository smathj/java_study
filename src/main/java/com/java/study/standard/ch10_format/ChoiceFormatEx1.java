package com.java.study.standard.ch10_format;

import java.text.ChoiceFormat;

public class ChoiceFormatEx1 {

    public static void main(String[] args) {

        // 낮은 값부터
        double[] limits = {60, 70, 80, 90};
        // limits과 순서와 갯수를 맞춘다
        String[] grades = {"D", "C", "B", "A"};

        int[] scores = {100, 95, 88, 70, 52, 60, 70};

        ChoiceFormat form = new ChoiceFormat(limits, grades);

        for (int i = 0; i < scores.length; i++) {
            System.out.println(scores[i] + " : " + form.format(scores[i]));

        }

    }
}
