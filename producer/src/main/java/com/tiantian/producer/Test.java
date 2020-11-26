package com.tiantian.producer;

import java.util.Random;

public class Test {
    public static void main(String[] args) {
        // random is not real random
        Random random = new Random(10);

        for (int i = 0; i < 10; i ++) {
            System.out.println(random.nextInt(10));
        }
        System.out.println("------ Separator line ------");
        Random randomKai = new Random(10);

        for (int i = 0; i < 10; i ++) {
            System.out.println(randomKai.nextInt(10));
        }
    }
}
