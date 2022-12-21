package com.java.study.fire.comparator;

import java.util.Comparator;

public class MyComparator implements Comparator<Point> {

    public int compare(Point p1, Point p2) {
        // x의 경우, 앞에꺼가 크면 뒤로보낸다 즉, 오름차순
        if (p1.x > p2.x) {
            return 1;

        // x와 y가 같은경우
        } else if (p1.x == p2.x) {
            if (p1.y < p2.y) { // y를 기준으로 내림차순
                return 1;
            }
        }

        // 양수 리턴이 아니면, 아무일 일어나지않음
        return -1;
    }
}