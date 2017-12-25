package cn.cat.controller;

import cn.cat.pojo.Product;
import cn.cat.pojo.User;
import cn.cat.service.product.ProductService;
import cn.cat.tools.ExcelUtil;
import com.alibaba.fastjson.JSON;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author yinxiaochen
 * 2017/12/21 9:13
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService productService;

    @RequestMapping(value = "/uploadProduct.do", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(HttpServletRequest request, HttpSession session, @RequestParam(value = "attachs", required = false)
            MultipartFile[] attachs) {
        System.out.println("文件的个数为:" + attachs.length);

        String reInfo = null;//用来保存返回信息
        // String path = request.getSession().getServletContext().getRealPath("statics/uploadfiles");
        MultipartFile attach;
        try {
            for (int i = 0; i < attachs.length; i++) {
                attach = attachs[i];
                if (!attach.isEmpty()) {
                    String oldFileName = attach.getOriginalFilename();//获得原文件名
                    String prefix = FilenameUtils.getExtension(oldFileName);//获得原文件名后缀
                    /*判断文件格式是否正确*/
                    if (prefix.equalsIgnoreCase("xlsx") || prefix.equalsIgnoreCase("xls")
                            || prefix.equalsIgnoreCase("csv")) {
                        InputStream is = attach.getInputStream();//获取is对象
                        //POIFSFileSystem fs = new POIFSFileSystem(is);
                        XSSFWorkbook wb = new XSSFWorkbook(is);
                        XSSFSheet sheetMain = wb.getSheetAt(0);//获取sheet对象
                        is.close();
                        int rowLens = sheetMain.getLastRowNum() + 1;//获取行的总数（获取的是下标所以要+1）
                        XSSFRow row = null;

                        XSSFCell cell0 = null;
                        XSSFCell cell1 = null;

                        String prodcutCode = "";
                        Double costPrice = null;

                        Product product = null;
                        for (int j = 0; j < rowLens; j++) {//行循环
                            row = sheetMain.getRow(j);

                            //首行判断
                            cell0 = row.getCell(0);
                            if (cell0 == null || cell0.toString().trim().equals("")) {
                                System.out.println("###遇到空行###");
                                continue;
                            }
                            cell0.setCellType(Cell.CELL_TYPE_STRING);
                            prodcutCode = cell0.getStringCellValue().trim();

                            if (prodcutCode.indexOf("#") == 0 || prodcutCode.equals("货号")) {
                                System.out.println("###注释行或者列名行###");
                                continue;
                            } else {

                                cell1 = row.getCell(1);
                                cell1.setCellType(Cell.CELL_TYPE_STRING);
                                costPrice = Double.parseDouble(cell1.getStringCellValue().trim());
                                product = new Product();
                                product.setProductCode(prodcutCode);
                                product.setCostPrice(costPrice);
                                productService.addProduct(product);
                            }
                        }
                        reInfo = "导入数据成功";
                    } else {
                        reInfo = "部分文件上传文件格式不正确，已弃用，请更改后重新上传";
                    }


                }
            }
        } catch (Exception e) {
            reInfo = "表数据不规范，导入中断，请联系管理员";
            e.printStackTrace();
        } finally {
        }
        return "{\"status\":\"" + reInfo + "\"}";

    }

    @RequestMapping("/getAllProducts.do")
    @ResponseBody
    public Object getAllProducts() throws Exception {

        System.out.println("长度是"+productService.getAllProducts().size());
        return JSON.toJSONString(productService.getAllProducts());


    }

    @RequestMapping("/addNewProduct.do")
    @ResponseBody
    public Object addNewProduct(Product product) throws Exception {
       String reInfo ="";
        int result = -1;
        result =productService.addProduct(product);
        if(result>0){
            reInfo ="success";
        }
        return "{\"status\":\"" + reInfo + "\"}";
    }

    @RequestMapping("/changeProduct.do")
    @ResponseBody
    public Object changeProduct(Product product) throws Exception {
        String reInfo ="";
        int result = -1;
        result =productService.updateProduct(product);
        if(result>0){
            reInfo ="success";
        }
        return "{\"status\":\"" + reInfo + "\"}";
    }
    @RequestMapping("/delProduct.do")
    @ResponseBody
    public Object delProduct(@RequestParam("id") Integer id) throws Exception {
        String reInfo ="";
        int result = -1;
        result =productService.delProductByid(id);
        if(result>0){
            reInfo ="success";
        }
        return "{\"status\":\"" + reInfo + "\"}";
    }


}
