package cn.cat.service.alipay_order;

import cn.cat.dao.alipay_order.AlipayOrderMapper;
import cn.cat.pojo.AlipayOrder;
import cn.cat.pojo.AlipayResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author yinxiaochen
 * 2017/12/20 13:44
 */
@Service
public class AlipayOrderServiceImpl implements AlipayOrderService{
    @Resource
    private AlipayOrderMapper alipayOrderMapper;

    @Override
    public int addAlipayOrder(AlipayOrder alipayOrder) throws Exception {
        return alipayOrderMapper.addAlipayOrder(alipayOrder);
    }

    @Override
    public Double countCostForMonth(String chooseMonth) throws Exception {
        return alipayOrderMapper.countCostForMonth(chooseMonth);
    }

    @Override
    public List<AlipayResult> showMergeResult(String chooseMonth) throws Exception {
        return alipayOrderMapper.showMergeResult(chooseMonth);
    }
}
