package com.java.study.standard.ch11_collection;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

public class ExpValidCheck {

    public static void main(String[] args) {
        System.out.println("args = " + Arrays.toString(args));
        System.out.println("args.length = " + args.length);

        if (args.length != 1) {
            System.out.println("Usage : java ExpValidCheck \"EXPRESSION\"");
            System.out.println("Example : java ExpValidCheck \"((2+3)*1)+3\"");
            System.exit(0);
        }

        Stack st = new Stack();
        String expression = args[0];

        System.out.println("expression = " + expression);

        try {
            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);

                if (ch == '(') {
                    st.push(ch + "");
                } else if (ch == ')') {
                    st.pop();
                }
            }

            System.out.println("st = " + st);

            if (st.isEmpty()) {
                System.out.println("괄호가 일치합니다");
            } else {
                System.out.println("괄호가 일치하지 않습니다");
            }

        } catch(EmptyStackException e) {
            e.printStackTrace();
            System.out.println("괄호가 일치하지 않습니다");
        }
    }
}
