package cn.cat.service.product;

import cn.cat.pojo.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yinxiaochen
 * 2017/12/20 13:55
 */
public interface ProductService {
    /**
     * 添加新的商品
     *
     * @param product
     * @return
     * @throws Exception
     */
    int addProduct(Product product) throws Exception;

    List<Product> getAllProducts() throws Exception;

    int updateProduct(Product product) throws Exception;

    int delProductByid(Integer id) throws Exception;

    List <Product> getAllNoPriceList()throws  Exception;
    List <Product> getTmallNoPriceList( String chooseMonth )throws  Exception;
    List <Product> getAlipayNoPriceList(String chooseMonth )throws  Exception;

}
