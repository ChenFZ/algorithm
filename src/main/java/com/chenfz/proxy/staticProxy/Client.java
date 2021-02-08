/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: Client
 * Author:   Chen FZ
 * Date:     2021/2/8 11:09
 * Description: 张三
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.proxy.staticProxy;

import com.chenfz.proxy.dynamicProxy.MarkCompany;

/**
 * 〈一句话功能简述〉<br> 
 * 〈张三〉
 *
 * @author Chen FZ
 * @create 2021/2/8
 * @since 1.0.0
 */
public class Client {

    public static void main(String[] args) {
        //静态代理
        Mark mark = new Mark(new AaFactory());
        mark.saleManTools("20");

    //    动态代理
        AaFactory aaFactory = new AaFactory();
        MarkCompany markCompany = new MarkCompany();
    //    张三来了
        markCompany.setFactory(aaFactory);
        ManToolsFactory instance = (ManToolsFactory)markCompany.getProxyInstance();
        instance.saleManTools("E");
    //    老婆来了
        BbFactory bbFactory = new BbFactory();
        markCompany.setFactory(bbFactory);
        WomenToolFactory emploee2 = (WomenToolFactory)markCompany.getProxyInstance();
        emploee2.saleWomanTools("1.8f");

    }
}
