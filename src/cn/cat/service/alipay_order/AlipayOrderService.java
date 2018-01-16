package cn.cat.service.alipay_order;

import cn.cat.pojo.AlipayOrder;
import cn.cat.pojo.AlipayResult;

import java.util.List;

/**
 * @author yinxiaochen
 * 2017/12/20 13:43
 */
public interface AlipayOrderService {

    int  addAlipayOrder(AlipayOrder alipayOrder)throws Exception;
    Double countCostForMonth(String chooseMonth, String orderCode) throws Exception;

    List<AlipayResult> showMergeResult(String chooseMonth) throws Exception;

}
