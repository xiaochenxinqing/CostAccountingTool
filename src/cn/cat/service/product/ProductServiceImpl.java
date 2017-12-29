package cn.cat.service.product;

import cn.cat.dao.product.ProductMapper;
import cn.cat.pojo.Product;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<Product> getAllProducts() throws Exception {
        return productMapper.getAllProducts();
    }

    @Override
    public int updateProduct(Product product) throws Exception {
        return productMapper.updateProduct(product);
    }

    @Override
    public int delProductByid(Integer id) throws Exception {
        return productMapper.delProductByid(id);
    }

    @Override
    public List<Product> getAllNoPriceList() throws Exception {
        return productMapper.getAllNoPriceList();
    }

    @Override
    public List<Product> getTmallNoPriceList(String chooseMonth) throws Exception {
        return productMapper.getTmallNoPriceList(chooseMonth);
    }

    @Override
    public List<Product> getAlipayNoPriceList(String chooseMonth) throws Exception {
        return productMapper.getAlipayNoPriceList(chooseMonth);
    }
}
