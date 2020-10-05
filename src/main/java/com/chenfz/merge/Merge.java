/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Merge
 * Author:   chenfz
 * Date:     2019/3/13 10:30
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.merge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author chenfz
 * @create 2019/3/13
 * @since 1.0.0
 */
public class Merge {
    public static void main(String[] args) {
        List<Interval> list = new ArrayList();
        list.add(new Interval(1,3));
        list.add(new Interval(0,0));

        list.add(new Interval(2,6));
        list.add(new Interval(8,10));
        list = merge(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static List<Interval> merge(List<Interval> intervals) {
        if(intervals==null||intervals.size()==0) return intervals;
        intervals.sort(new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
//        intervals.forEach(item-> System.out.println(item));
        int i =0;
        Iterator<Interval> iterator = intervals.iterator();
        while (iterator.hasNext()){
            Interval interval = iterator.next();
            // 前面的尾超过后面的头
            if(i!=0&&(intervals.get(i-1).end-interval.start)>=0){
                if(i!=0&&(intervals.get(i-1).start-interval.start)>0){
                    intervals.get(i-1).start = interval.start;
                }
                if(i!=0&&(intervals.get(i-1).end-interval.end)<0){
                    intervals.get(i-1).end = interval.end;
                }
                iterator.remove();
            }else
                i++;
        }
        return intervals;
    }
}
