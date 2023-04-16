package com.samli.homework.entity;

import java.util.*;

public class Sweep {
    public static void main(String[] args) {

//        List<MineSquare> mineSquares = new ArrayList<>();
//
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//                MineSquare mineSquare = new MineSquare();
//                mineSquare.setHorizontal(i);
//                mineSquare.setVertical(j);
//                mineSquares.add(mineSquare);
//            }
//        }

        int fisrt = 0;
        int first2 = 1;


        List<Map<Integer, Integer>> a = new ArrayList<>();
        int count = 0;
        while (count <= 9) {
            Random r = new Random();
            Random r2 = new Random();
            int i1 = r.nextInt(8); // 生成[0,8]区间的整数
            int i2 = r2.nextInt(8); // 生成[0,8]区间的整数
            System.out.println("======================");
            if (i1 == fisrt && i2 == first2) {
                System.out.println("第一颗不是雷");
            } else {
                Map<Integer, Integer> m = new HashMap<>();
                m.put(i1, i2);
                if (a.contains(m)) {
                    System.out.println("重复啦，雷的坐标为：" + i1 + "," + i2);
                    continue;
                }
                a.add(m);

                count++;
                System.out.println("第" + count + "颗雷的坐标为：" + i1 + "," + i2);
            }
        }


    }
}
