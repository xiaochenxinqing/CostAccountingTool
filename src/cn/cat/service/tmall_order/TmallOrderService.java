package cn.cat.service.tmall_order;

import cn.cat.pojo.TmallOrder;
import cn.cat.pojo.TmallResult;

import java.util.List;

/**
 * @author yinxiaochen
 * 2017/12/22 17:29
 */
public interface TmallOrderService {
    int  addTmallOrder (TmallOrder tmallOrder)throws Exception;
    Double countCostForMonth(String chooseMonth) throws Exception;
    List<TmallResult> showMergeResult( String chooseMonth) throws Exception;
}
