/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: MarkCompany
 * Author:   Chen FZ
 * Date:     2021/2/8 11:45
 * Description: Mark代购公司
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 〈一句话功能简述〉<br>
 * 〈Mark代购公司〉
 *
 * @author Chen FZ
 * @create 2021/2/8
 * @since 1.0.0
 */
public class MarkCompany implements InvocationHandler {

    /***
     * 持有真实对象
     */
    private Object factory;

    public Object getFactory() {
        return factory;
    }

    public void setFactory(Object factory) {
        this.factory = factory;
    }

    public MarkCompany(Object factory) {
        this.factory = factory;
    }

    public MarkCompany() {
    }

    /*
    *   通过proxy获取动态代理对象
    */
    public Object getProxyInstance(){
        return Proxy.newProxyInstance(factory.getClass().getClassLoader(),
                factory.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        doSthBefore();
        Object invoke = method.invoke(factory, args);
        doSthAfter();
        return null;
    }

    /***
     * 后置处理器
     */
    private void doSthAfter() {
        System.out.println("精美包装，快递一条龙服务");
    }

    /***
     * 前置处理器
     */
    private void doSthBefore() {

        System.out.println("根据需求进行市场调研和产品分析");

    }
}
