/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: Logarithm
 * Author:   chenfz
 * Date:     2019/3/24 21:57
 * Description: 求对数的工具
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.Util;

/**
 * 〈一句话功能简述〉<br>
 * 〈求对数的工具〉
 *
 * @author chenfz
 * @create 2019/3/24
 * @since 1.0.0
 */
public class Logarithm {
    public static double log(double value, double base) {
        return Math.log(value) / Math.log(base);
    }
}
