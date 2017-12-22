package cn.cat.service.local_order;

import cn.cat.dao.local_order.LocalOrderMapper;
import cn.cat.pojo.LocalOrder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yinxiaochen
 * 2017/12/20 13:46
 */
@Service
public class LocalOrderServiceImpl implements  LocalOrderService {
    @Resource
    private LocalOrderMapper localOrderMapper;

    /**
     * 添加新的本地订单表
     *
     * @param localOrder
     * @return
     * @throws Exception
     */
    @Override
    public int addLocalOrder(LocalOrder localOrder) throws Exception {
        return localOrderMapper.addLocalOrder(localOrder);
    }
}
