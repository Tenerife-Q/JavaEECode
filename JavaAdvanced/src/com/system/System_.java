package com.system;

import java.util.Arrays;

/**
 * @author Tenerife
 * Su san
 * @date 2025/10/23 15:48
 */
public class System_ {
    public static void main(String[] args) {

        //arraycopy 复制数组元素 适合底层调用
        int[] src = {1,2,3};
        int[] dest = new int[3];
        System.arraycopy(src,1,dest,0,1);
        System.out.println("desc = " + Arrays.toString(dest));
        /*
        Params:
            src – the source array.
            srcPos – starting position in the source array.
            dest – the destination array.
            destPos – starting position in the destination data.
            length – the number of array elements to be copied.原数组要复制的成员长度
         */


        //currentTimeMillens
        System.out.println(System.currentTimeMillis());


        //exit
        //0表示正常状态 退出
        System.out.println("df");
        System.exit(0);
        System.out.println("fd");


    }
}
