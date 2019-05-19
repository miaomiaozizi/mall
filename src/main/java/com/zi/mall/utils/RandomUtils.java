/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: RandomUtils
 * Author: Zi
 * Date: 2019/4/23 15:22
 * Description: 随机工具类
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 随机工具类
 *
 * @author Zi
 * @create 2019/4/23
 * @since 1.0.0
 */
public class RandomUtils {
    static SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmssSSS");
    static Random random=new Random();

    /**
     * 根据文件名生成新名字---根据时间+4四位随机数
     * @param oldName   aaaaa.png   aaaa.aaa.aaa.png
     */
    public static String createFileNameUseTime(String oldName){
        String suffix=oldName.substring(oldName.lastIndexOf("."));
        String time=format.format(new Date());
        Integer random4=random.nextInt(9000)+1000;
        return time+random4+suffix;
    }
    //随机生成一个订单流水号
    public static String randomOrderId(){
        String orderId="";
        orderId+=new SimpleDateFormat("yyMMdd").format(new Date());
        orderId+=random.nextInt(10000);
        return orderId;
    }

}
