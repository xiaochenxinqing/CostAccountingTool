package cn.cat.service.alipay_order;

import cn.cat.pojo.AlipayOrder;

/**
 * @author yinxiaochen
 * 2017/12/20 13:43
 */
public interface AlipayOrderService {

    int  addAlipayOrder(AlipayOrder alipayOrder)throws Exception;

}
