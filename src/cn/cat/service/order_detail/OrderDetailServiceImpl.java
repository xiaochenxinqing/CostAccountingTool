package cn.cat.service.order_detail;

import cn.cat.dao.order_detail.OrderDetailMapper;
import cn.cat.pojo.OrderDetail;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yinxiaochen
 * 2017/12/20 13:52
 *
 */
@Service
public class OrderDetailServiceImpl implements  OrderDetailService {
    @Resource
    private OrderDetailMapper orderDetailMapper;
    /**
     * 添加新的订单详情
     *
     * @param orderDetail
     * @return 受影响的行数
     * @throws Exception
     */
    @Override
    public int addOrderDetail(OrderDetail orderDetail) throws Exception {
        return orderDetailMapper.addOrderDetail(orderDetail);
    }
}
