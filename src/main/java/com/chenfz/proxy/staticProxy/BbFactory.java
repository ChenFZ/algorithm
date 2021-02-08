/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: BbFactory
 * Author:   Chen FZ
 * Date:     2021/2/8 11:54
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.proxy.staticProxy;

/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author Chen FZ
 * @create 2021/2/8
 * @since 1.0.0
 */
public class BbFactory implements WomenToolFactory{
    @Override
    public void saleWomanTools(String size) {
        System.out.println("按需求定制了一个size为"+size+"的男model");
    }
}
