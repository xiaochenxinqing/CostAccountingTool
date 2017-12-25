package cn.cat.dao.product;

import cn.cat.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yinxiaochen
 * 2017/12/20 13:14
 */
public interface ProductMapper {


    int  addProduct(Product product)throws Exception;

    List<Product> getAllProducts()throws Exception;

    int updateProduct(Product product)throws  Exception;
    int delProductByid(@Param("id") Integer id)throws  Exception;



}
