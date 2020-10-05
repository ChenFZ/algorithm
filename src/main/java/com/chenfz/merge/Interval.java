/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Interval
 * Author:   chenfz
 * Date:     2019/3/13 10:34
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.merge;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author chenfz
 * @create 2019/3/13
 * @since 1.0.0
 */
public class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
