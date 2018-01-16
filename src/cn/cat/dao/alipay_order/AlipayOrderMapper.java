package cn.cat.dao.alipay_order;


import cn.cat.pojo.AlipayOrder;
import cn.cat.pojo.AlipayResult;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @author yinxiaochen
 * 2017/12/20 13:14
 */
public interface AlipayOrderMapper {

   int  addAlipayOrder(AlipayOrder alipayOrder)throws Exception;
   Double countCostForMonth(@Param("chooseMonth") String chooseMonth,@Param("orderCode") String orderCode) throws Exception;
  List<AlipayResult> showMergeResult(@Param("chooseMonth") String chooseMonth) throws Exception;




}
