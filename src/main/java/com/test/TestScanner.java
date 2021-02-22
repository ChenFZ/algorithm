/**
 * Copyright (C), 2015-2021, 航天广信有限公司
 * FileName: TestScanner
 * Author:   chenfz
 * Date:     2021/2/22 22:05
 * Description: 获取⽤键盘输⼊常⽤的两种⽅法
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 〈一句话功能简述〉<br> 
 * 〈获取⽤键盘输⼊常⽤的两种⽅法〉
 *
 * @author chenfz
 * @create 2021/2/22
 * @since 1.0.0
 */
public class TestScanner {

    public static void main(String[] args) {
        try {
            showBufferedReader();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showScanner(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.nextLine());
        scanner.close();
    }

    public static void showBufferedReader() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(reader.readLine());
        reader.close();
    }
}
