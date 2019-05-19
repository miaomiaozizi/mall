/**
 * Copyright (C), 2018-2019, XXX有限公司
 * FileName: PayServiceImpl
 * Author: Zi
 * Date: 2019/5/8 14:39
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */

package com.zi.mall.service.impl;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.zi.mall.config.AlipayConfig;
import com.zi.mall.service.PayService;
import com.zi.mall.vo.PayVo;

import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;

import ch.qos.logback.core.net.SyslogOutputStream;

/**
 *
 *
 * @author Zi
 * @create 2019/5/8
 * @since 1.0.0
 */
@Service
public class PayServiceImpl implements PayService {

    @Override
    public String toPay(PayVo payVo) {
        //获得初始化的AlipayClient，就是为和对支付包发起请求
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        try {
            //商户订单号，商户网站订单系统中唯一订单号
            String out_trade_no = new String(payVo.getOrderid().getBytes("ISO-8859-1"),"UTF-8");
            //付款金额，必填
            String total_amount = new String(payVo.getMoney().getBytes("ISO-8859-1"),"UTF-8");
            //订单名称，必填
            String subject=payVo.getOrderName();
            //商品描述，可空
            String body = new String(payVo.getGoodsDesc().getBytes("ISO-8859-1"),"UTF-8");
            alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                    + "\"total_amount\":\""+ total_amount +"\","
                    + "\"subject\":\""+ subject +"\","
                    + "\"body\":\""+ body +"\","
                    + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String result = null;
        try {
            /**
             * 支付宝给我们生成了一个网页
             */
            result = alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return result;
    }
}
