package com.samli.homework.action;

import java.util.*;

public class Sweep {
    public static void main(String[] args) {
        // 1. 从前端传入第一个翻开的方块的坐标，因为第一个不可能是雷。此处假设第一个翻开的是（0，1）
        int firstHorizontal = 0;
        int firstVertical = 1;

        // 2. 建立一个雷的集合
        List<Map<Integer, Integer>> mines = new ArrayList<>();
        // 3. 一共要生成10颗雷，count用来计算当前生成了第几颗。
        int count = 0;
        // 3. 开始循环生成
        while (count <= 9) {
            // 3.1 生成横纵坐标的随机数对象
            int horizontalRandom = new Random().nextInt(8); // 生成[0,8]区间的整数
            int verticalRandom = new Random().nextInt(8); // 生成[0,8]区间的整数
            // 3.2 判断是否是第一颗
            if (horizontalRandom == firstHorizontal && verticalRandom == firstVertical) {
                System.out.println("这个坐标和第一个重复啦！第一颗不可能是雷。");
            } else {
                // 3.2.1 构造雷的对象
                Map<Integer, Integer> mine = new HashMap<>();
                mine.put(horizontalRandom, verticalRandom);
                // 3.2.2 判断雷是否已经生成过了
                if (mines.contains(mine)) {
                    System.out.println("重复啦，雷的坐标为：" + horizontalRandom + "," + verticalRandom);
                    continue;
                }
                mines.add(mine);
                count++;
                System.out.println("第" + count + "颗雷的坐标为：" + horizontalRandom + "," + verticalRandom);
            }
        }
    }
}
