package cn.cat.service.order_detail;

import cn.cat.pojo.OrderDetail;

/**
 * @author yinxiaochen
 * 2017/12/20 13:51
 */
public interface OrderDetailService {
    /**
     * 添加新的订单详情
     * @param orderDetail
     * @return 受影响的行数
     * @throws Exception
     */
    int  addOrderDetail(OrderDetail orderDetail)throws Exception;
}
