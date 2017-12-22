package cn.cat.service.local_order;

import cn.cat.pojo.LocalOrder;

/**
 * @author yinxiaochen
 * 2017/12/20 13:46
 */
public interface LocalOrderService {
    /**
     * 添加新的本地订单表
     * @param localOrder
     * @return
     * @throws Exception
     */
    int  addLocalOrder(LocalOrder localOrder)throws Exception;
}
