package cn.cat.service.tmall_order;

import cn.cat.dao.tmall_order.TmallOrderMapper;
import cn.cat.pojo.TmallOrder;
import cn.cat.pojo.TmallResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public Double countCostForMonth(String chooseMonth,String orderCode) throws Exception {
        return tmallOrderMapper.countCostForMonth(chooseMonth,orderCode);
    }

    @Override
    public List<TmallResult> showMergeResult(String chooseMonth) throws Exception {
        return tmallOrderMapper.showMergeResult(chooseMonth);
    }
}
