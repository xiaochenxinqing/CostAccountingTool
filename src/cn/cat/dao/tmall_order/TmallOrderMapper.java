package cn.cat.dao.tmall_order;

import cn.cat.pojo.TmallOrder;
import cn.cat.pojo.TmallResult;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;

/**
 * @author yinxiaochen
 * 2017/12/22 17:13
 */
public interface TmallOrderMapper {
    int addTmallOrder(TmallOrder tmallOrder)throws  Exception;
    Double countCostForMonth(@Param("chooseMonth") String chooseMonth) throws Exception;

    List<TmallResult> showMergeResult(@Param("chooseMonth") String chooseMonth) throws Exception;

}
