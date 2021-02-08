/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: AaFactory
 * Author:   Chen FZ
 * Date:     2021/2/8 11:06
 * Description: 目标对象工厂
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.proxy.staticProxy;

/**
 * 〈一句话功能简述〉<br> 
 * 〈目标对象工厂〉
 *
 * @author Chen FZ
 * @create 2021/2/8
 * @since 1.0.0
 */
public class AaFactory implements ManToolsFactory {
    @Override
    public void saleManTools(String size) {
        System.out.println("按需求定制了一个size为"+size+"的女model");
    }
}
