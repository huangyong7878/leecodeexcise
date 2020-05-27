package siflo.dialy;

import java.util.Random;

/**
 * This problem was asked by Two Sigma.
 * <p>
 * Using a function rand5() that returns an integer from 1 to 5 (inclusive) with uniform probability, implement a function rand7() that returns an integer from 1 to 7 (inclusive).
 */
public class Daily527 {
    static Random ran = new Random();

    static int nextInt(int origin, int bound) {
        int n = bound - origin;
        if (n > 0) {
            return ran.nextInt(n) + origin;
        } else {  // range not representable as int
            int r;
            do {
                r = ran.nextInt();
            } while (r < origin || r >= bound);
            return r;
        }
    }

    static int rand5() {
        return nextInt(1, 6);
    }

    static int rand7() {
        int r1, r2, r3;
        do {
            r1 = rand5();
            r2 = rand5();
            r3 = r1 + r2;
        } while (r3 < 1 || r3 >= 8);
        return r3;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(rand7());
        }
    }
}

