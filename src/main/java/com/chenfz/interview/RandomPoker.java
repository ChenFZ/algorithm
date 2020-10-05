/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: RandomPoker
 * Author:   chenfz
 * Date:     2019/3/24 21:16
 * Description: 设计一个洗牌程序（54张扑克牌洗成乱序）
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.interview;

import com.chenfz.Util.Logarithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 〈一句话功能简述〉<br> 
 * 〈设计一个洗牌程序（54张扑克牌洗成乱序）〉
 *
 * @author chenfz
 * @create 2019/3/24
 * @since 1.0.0
 */
public class RandomPoker {

    public static void main(String[] args) {
        String[] cardType = { "红桃", "黑桃", "方块", "梅花" };
        String[] cardValue = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K" };
        // 所有的卡牌，未打乱状态
        List<String> allCard = new ArrayList();
        // 生成52张牌，放到allCard数组里
        for (int i = 0; i < cardType.length; i++) {
            for (int j = 0; j < cardValue.length; j++) {
                allCard.add(cardType[i] + cardValue[j]);
            }
        }
        List<String> result = shuffle3(allCard,cardType.length*cardValue.length);
        result.forEach(item-> System.out.println(item));
    }

    /**
     * 第一种算法，直观的将数组元素按照随机数抽取出来
     * @param allCard
     * @param length
     * @return
     */
    public static List<String> shuffle(List<String> allCard,int length){
        List<String> result = new ArrayList();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            // 拿到0~列表长度的随机数，根据角标拿扑克，并移除原数组中的扑克
            int randomIndex  = random.nextInt(allCard.size());
            result.add(allCard.get(randomIndex));
            allCard.remove(randomIndex);
        }
        return result;
    }
    /**
     * 第二种算法，随机交换两个元素的位置
     * 这是一个常见的洗牌算法; 但是如何确定一个合适的交换次数?
     * 假设交换了m此,则某张牌始终没有被交换的概率为 (n-2)/n * (n-2)/n, ... ...* (n-2)/n = ((n-2)/n)^m;
     * 我们希望其概率小于摸个值,求出m的解.假设概率小于1/1000,对于n=52,m大概为176,实际上远远大于数组的长度.
     * @param allCard
     * @param length
     * @return
     */
    public static List<String> shuffle2(List<String> allCard,int length){
        double m = Logarithm.log(0.001d,(double)(length-2)/length);
        long round = Math.round(m);
        Random random = new Random();
        for (int i = 0; i < round; i++) {
            int a1 = random.nextInt(length);
            int a2 = random.nextInt(length);
            String temp = allCard.get(a1);
            allCard.set(a1,allCard.get(a2));
            allCard.set(a2,temp);
        }
        return allCard;
    }

    /**
     * 第三种算法
     * 每次随机选择一个数，与数组最后一个元素互换位置
     * 缩小数组角标范围
     * 该算法复杂度为O(n)，且各元素随机概率相等。
     */
    public static List<String> shuffle3(List<String> allCard,int length){
        Random random = new Random();
        int i = length -1;
        while (i>0){
            int randomInt = random.nextInt(i);
            String temp = allCard.get(i);
            allCard.set(i,allCard.get(randomInt));
            allCard.set(randomInt,temp);
            i--;
        }
        return allCard;
    }
}
class Poker{
    public String type;
    public String value;

    @Override
    public String toString() {
        return "Poker{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}