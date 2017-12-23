package cn.cat.service.tmall_order;

import cn.cat.dao.tmall_order.TmallOrderMapper;
import cn.cat.pojo.TmallOrder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yinxiaochen
 * 2017/12/22 17:29
 */
@Service
public class TmallOrderServiceImpl  implements  TmallOrderService{
    @Resource
    private TmallOrderMapper tmallOrderMapper;
    @Override
    public int addTmallOrder(TmallOrder tmallOrder) throws Exception {
        return tmallOrderMapper.addTmallOrder(tmallOrder);
    }
}
