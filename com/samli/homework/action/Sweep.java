package com.samli.homework.action;

import com.samli.homework.entity.MineSquare;

import java.util.*;

public class Sweep {
    public static void main(String[] args) {
        // 1. 从前端传入第一个翻开的方块的坐标，因为第一个不可能是雷。此处假设第一个翻开的是（0，1）
        int firstHorizontal = 0;
        int firstVertical = 1;

        System.out.println("游戏开始，第一个翻开了"+firstHorizontal+","+firstVertical);

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
                //System.out.println("这个坐标和第一个重复啦！第一颗不可能是雷。");
            } else {
                // 3.2.1 构造雷的对象
                Map<Integer, Integer> mine = new HashMap<>();
                mine.put(horizontalRandom, verticalRandom);
                // 3.2.2 判断雷是否已经生成过了
                if (mines.contains(mine)) {
                    //System.out.println("重复啦，雷的坐标为：" + horizontalRandom + "," + verticalRandom);
                    continue;
                }
                mines.add(mine);
                count++;
                //System.out.println("第" + count + "颗雷的坐标为：" + horizontalRandom + "," + verticalRandom);
            }
        }


        List<MineSquare> mineSquares = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                MineSquare mineSquare = new MineSquare();
                mineSquare.setHorizontal(i);
                mineSquare.setVertical(j);
                Map<Integer, Integer> mine = new HashMap<>();
                mine.put(i, j);
                if (mines.contains(mine)) {
                    mineSquare.setHasMine(true);
                } else {
                    mineSquare.setHasMine(false);
                }
                mineSquare.setInfoNumber(calculateInfo(i, j, mines));
                mineSquares.add(mineSquare);
            }
        }
        System.out.println(mineSquares.size());

        mineSquares.forEach(a -> System.out.println("方块坐标："+a.getHorizontal()+","+a.getVertical()+";当前是否为雷"+a.getHasMine()+";当前方块周围有"+a.getInfoNumber()+"颗雷。"));
    }

    public static Integer calculateInfo(Integer horizontal, Integer vertical, List<Map<Integer, Integer>> mines) {
        int count = 0;
        Map<Integer, Integer> mine1 = new HashMap<>();
        mine1.put(horizontal - 1, vertical - 1);
        if (mines.contains(mine1)) {
            count++;
        }
        Map<Integer, Integer> mine2 = new HashMap<>();
        mine2.put(horizontal - 1, vertical);
        if (mines.contains(mine2)) {
            count++;
        }
        Map<Integer, Integer> mine3 = new HashMap<>();
        mine3.put(horizontal - 1, vertical + 1);
        if (mines.contains(mine3)) {
            count++;
        }
        Map<Integer, Integer> mine4 = new HashMap<>();
        mine4.put(horizontal, vertical - 1);
        if (mines.contains(mine4)) {
            count++;
        }
        Map<Integer, Integer> mine5 = new HashMap<>();
        mine5.put(horizontal, vertical + 1);
        if (mines.contains(mine5)) {
            count++;
        }
        Map<Integer, Integer> mine6 = new HashMap<>();
        mine6.put(horizontal + 1, vertical - 1);
        if (mines.contains(mine6)) {
            count++;
        }
        Map<Integer, Integer> mine7 = new HashMap<>();
        mine7.put(horizontal + 1, vertical);
        if (mines.contains(mine7)) {
            count++;
        }
        Map<Integer, Integer> mine8 = new HashMap<>();
        mine8.put(horizontal + 1, vertical + 1);
        if (mines.contains(mine8)) {
            count++;
        }
        return count;
    }
}
