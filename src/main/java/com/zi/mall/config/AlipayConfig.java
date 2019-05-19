/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: AlipayConfig
 * Author: Zi
 * Date: 2019/5/8 15:50
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.config;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Zi
 * @create 2019/5/8
 * @since 1.0.0
 */
public class AlipayConfig {
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    /**
     * 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
     */
    public static String app_id = "2016092400585499";

    /**
     * 商户私钥，您的PKCS8格式RSA2私钥
     */
    public static String merchant_private_key ="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCXfdoA+dAG1TijoEUxx3pAfRH0YrSlYNpnFYHQNTiX1uEyfDM/9FnCJhCB0LKDmSmgIxhMABLw8aF9dzT4zWo6jDBZWkyC6ezL6YkvJJIsReY8moHVkf8djhyytJQzge5ly9Q86Qp38C5tnDQ5Af3IvF6dvt+IN58yIQpY6LSz3QSv9p77r+mHY07cKDN+5vLjANMPwqTjURoT5mw7CQU++I63rGD6nUWJ4MxMEhKDRGFJE1hYH/7JqO7oqjq7ZSXcKXEGsUnDQzdhZFIbevwbzq+LHByVml8vEb1El1YaONTK/o/RpIGHHTIvzZkou1biDl/nUU6UonKCbLdEUSWPAgMBAAECggEADPANlzm+f2bkUG0Wm7q6gRltWB656MnNvTIEBSEWdTk/wE0FH3gh1kfj7wJAzKZe/LMilxMGixdHwGxW1MzOPrPMSUVB9Yg+1eda9PC9nxRVJmXXosK2M/L4Fnb/lSqKjp0Kwizw3O9hN7E4cInv/52+wuATPRHrAZ/6vz8Yd6fMvcz01yWJz10dYnWZ+jjexJmkF0RW/ZA61b31Wwa8yxe/GPbnmY2AP684SLOdAalOu/svnJVW4tPQX/43WT2sP5B8SpFnCBb8lkFYWoycbfw1SLUSAWWs+xl1JGev0sMKqYEar01oEaJ1pC4hrgdw9OP/7cGG68eh2MtNkQq42QKBgQD/o13myDtUW88jRk+Kx+kYD/XcCvecmthUbbfDK/8QLivREepJIhIJFi+6jTYlinG9r/YGpRq9n7ZzvH9LrtwwnDQK3gUHA2zcglN7ZAxAJvR3xeVR0kR/iBo1b3O1734uwrgtNz8g/YSYL/yxWLdNdXIWuxgwC+PG2EMwf+RdbQKBgQCXtL8E8is4O8YVMVvdGAK0G5yQy/c//1NLNSvR8y4B+MMggJKLc95C2Mx34kP+qQo9RGjxqIxv2wQJG9uPtVsa+TZ98MtKOl7maMnTBDrGoc6t6uL3So3Lfd+ZIMyHT2rzw2cr1c53xVo/OWlb+1MqYwHhQ/DSLp008/pOuLPdawKBgQC3bNEDtshbT0ThWqHYQnjN+yW+LWBdzf1LFy6zq+3n/jkSWnhw4TFvs6urf4dKiHv0Tz2Ipw744JBZmvb7pwv3FR2CbqvMzHhgAGNGNhNUNJ9VEXnpq6XanB2yGbY85Qr1ImJkjy+MzFtHl6cI2U8tFQg3pydD0kQteR88vYduQQKBgCGyXx+dHuZ9uHDqpsoEVE1nOK6c742CjCDPba1Tw6ticw0cIfDhysO0Xi5eztWY/JJBSMIsuwz5a/sN+gYAtXzXUDhHLRCOyJeLPREnBlsqg7rzyng9UiOaEPl1ZJjFli8Q/zCobBUEfBhBC1sIByAKH9fGfI5jFj411yp3MlSDAoGAJmWD1FjFghXgVT9dAHzQciRZkAnDnLOR5yFiHJqEoLFHa0wasfA8Ar9XyB5CtsRT+Da/YnLEKKyoQB3lIGwB+0xuEZeM6QEzrgUyYa/3z2tA2+WXfwTcivXNYyHOxmGV0tnLd6mQgYmyPzZEWgOx1Qoid7dE3SDSXbVulJdtQ4g=";

    /** 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
     * *
     */
    public static String alipay_public_key ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEApvGYG9+FUFQUnAZy9JFqICe912XRPvt/B7PCzk+ozG1+GTDIM/RTCmeyMnN40dUEXOTrFGZ7GzZT8vXnNAgo/kZTiNXqV5bDcNo1ZPWPBTAqHj1yFcQ2IVXdTWaQ4mWl6cEXonR9FXLmgyu8GCdGUwf8BFltdFexqYtrHkcKCHgTz+zVgsyjBy60k1YFkN7XWlu1vIyxqbrGTgCmI8Uu3O2jWNuAkj1mjVKahABHN/OszhwXRsRvoCpabiYqlokyA5SsdH29Agtkm+UleyO89AJK7jFVZrlM9qQalGvZNu78t8sOCtdCJjD+p4oqhDu5uVIL1SUpRzz0OOG1wXY20wIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://39.108.175.200:8080/pay/notify";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://39.108.175.200:8080/pay/return";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "UTF-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";

//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     *
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis() + ".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
