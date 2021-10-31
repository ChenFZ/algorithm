/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: Run
 * Author:   chenfz
 * Date:     2021/9/9 11:37
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.testlombok;

import lombok.extern.slf4j.Slf4j;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author chenfz
 * @create 2021/9/9
 * @since 1.0.0
 */
@Slf4j
public class Run {
    public static void main(String[] args) {
        Run run = new Run();
        run.printLog();
    }

    public void printLog(){
        log.info("test log");
    }
}
