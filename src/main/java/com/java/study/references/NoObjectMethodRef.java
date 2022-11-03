package com.java.study.references;


import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;

class IBox {
    private int n;
    public IBox(int i) {
        this.n = i;
    }

    public int larger(IBox b) {
        if (n > b.n) {
            return n;
        } else {
            return b.n;
        }
    }

}

public class NoObjectMethodRef {
    public static void main(String[] args) {
        IBox ib1 = new IBox(5);
        IBox ib2 = new IBox(7);

        // 두 상자에 저장된 값 비교하여 더 큰 값 반환
//        ToIntBiFunction<IBox, IBox> bf = (b1, b2) -> b1.larger(b2);
        ToIntBiFunction<IBox, IBox> bf = IBox::larger;  // 정적 메서드 참조가아닌 인스턴스 메서드 참조이다
        int bigNum = bf.applyAsInt(ib1, ib2);
        System.out.println(bigNum);

        // * ToIntBiFunction<T,U>   int applyAsInt(T t, U u)
    }
}
