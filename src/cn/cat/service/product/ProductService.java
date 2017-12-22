package cn.cat.service.product;

import cn.cat.pojo.Product;

/**
 * @author yinxiaochen
 * 2017/12/20 13:55
 */
public interface ProductService {
    /**
     * 添加新的商品
     * @param product
     * @return
     * @throws Exception
     */
    int  addProduct(Product product)throws Exception;
}
