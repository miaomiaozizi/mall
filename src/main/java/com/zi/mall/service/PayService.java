/**
 * Copyright (C), 2015-2019, XXX有限公司
 * FileName: PayService
 * Author: Zi
 * Date: 2019/5/8 14:38
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
package com.zi.mall.service;

import com.zi.mall.vo.PayVo;

/**
 * 〈〉
 * @author Zi
 * @create 2019/5/8
 * @since 1.0.0
 */
public interface PayService {
    String toPay(PayVo payVo);

}