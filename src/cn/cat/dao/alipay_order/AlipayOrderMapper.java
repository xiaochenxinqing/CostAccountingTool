package cn.cat.dao.alipay_order;


import cn.cat.pojo.AlipayOrder;
import org.apache.ibatis.annotations.Param;

/**
 * @author yinxiaochen
 * 2017/12/20 13:14
 */
public interface AlipayOrderMapper {

   int  addAlipayOrder(AlipayOrder alipayOrder)throws Exception;
   Double countCostForMonth(@Param("chooseMonth") String chooseMonth) throws Exception;





}
