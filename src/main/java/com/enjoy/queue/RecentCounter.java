/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: RecentCounter
 * Author:   chenfz
 * Date:     2021/1/21 9:25
 * Description: 933. 最近的请求次数
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.enjoy.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 〈一句话功能简述〉<br>
 * 〈933. 最近的请求次数〉
 *
 * @author chenfz
 * @create 2021/1/21
 * @since 1.0.0
 */
public class RecentCounter {

    Queue<Integer> queue;

    public RecentCounter(){
        this.queue = new LinkedList<>();
    }

    public int ping(int t) {
        queue.offer(t);
        while (t - queue.peek()>3000){
            queue.poll();
        }
        return queue.size();
    }

}
