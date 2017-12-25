package cn.cat.dao.tmall_order;

import cn.cat.pojo.TmallOrder;
import org.apache.ibatis.annotations.Param;

/**
 * @author yinxiaochen
 * 2017/12/22 17:13
 */
public interface TmallOrderMapper {
    int addTmallOrder(TmallOrder tmallOrder)throws  Exception;
    Double countCostForMonth(@Param("chooseMonth") String chooseMonth) throws Exception;

}
