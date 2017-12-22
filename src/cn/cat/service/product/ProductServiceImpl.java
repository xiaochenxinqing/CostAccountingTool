package cn.cat.service.product;

import cn.cat.dao.product.ProductMapper;
import cn.cat.pojo.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yinxiaochen
 * 2017/12/20 13:56
 */
@Service
public class ProductServiceImpl implements  ProductService {
    @Resource
    private ProductMapper productMapper;
    /**
     * 添加新的商品
     *
     * @param product
     * @return
     * @throws Exception
     */
    @Override
    public int addProduct(Product product) throws Exception {
        return productMapper.addProduct(product);
    }
}
