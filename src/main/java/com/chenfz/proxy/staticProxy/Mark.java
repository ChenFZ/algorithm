/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: Mark
 * Author:   Chen FZ
 * Date:     2021/2/8 11:07
 * Description: 代理对象 mark
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.chenfz.proxy.staticProxy;

/**
 * 〈一句话功能简述〉<br> 
 * 〈代理对象 mark〉 静态代理
 * 这样的话，张三和工厂没有任何联系，而是通过mark这个代理买来了要给size是D的女model 这就是静态代理模式，
 * 因为真实对象，和代理对象是一对一存在的 静态代理模式有什么缺点呢 违反开闭原则：扩展能力差，可维护性差
 *
 * @author Chen FZ
 * @create 2021/2/8
 * @since 1.0.0
 */
public class Mark implements ManToolsFactory {

    public Mark(AaFactory aaFactory) {
        this.aaFactory = aaFactory;
    }

    public AaFactory aaFactory;

    @Override
    public void saleManTools(String size) {
        doSthBefore();
        aaFactory.saleManTools(size);
        doSthAfter();
    }

    /***
     * 后置处理器
     */
    private void doSthAfter(){
        System.out.println("精美包装，快递一条龙服务");
    }

    /***
     * 前置处理器
     */
    private  void doSthBefore(){

        System.out.println("根据需求进行市场调研和产品分析");

    }

}
