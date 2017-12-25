package cn.cat.controller;

import cn.cat.pojo.OrderDetail;
import cn.cat.service.order_detail.OrderDetailService;
import com.csvreader.CsvReader;
import org.apache.commons.io.FilenameUtils;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author yinxiaochen
 * 2017/12/22 14:20
 */
@Controller
@RequestMapping("/orderDetail")
public class OrderDetailController {
    @Resource
    private OrderDetailService orderDetailService;


    @RequestMapping(value = "/uploadOrderDetail.do", method = RequestMethod.POST)
    @ResponseBody
    public String uploadFile(HttpServletRequest request, HttpSession session, @RequestParam(value = "attachs", required = false)
            MultipartFile[] attachs) {
        System.out.println("文件的个数为:" + attachs.length);

        String reInfo = null;//用来保存返回信息
        MultipartFile attach;
        try {
            for (int i = 0; i < attachs.length; i++) {
                attach = attachs[i];
                if (!attach.isEmpty()) {
                    String oldFileName = attach.getOriginalFilename();//获得原文件名
                    String prefix = FilenameUtils.getExtension(oldFileName);//获得原文件名后缀
                    /*判断文件格式是否正确*/
                    if(prefix.equalsIgnoreCase("csv")) {
                        InputStream is = attach.getInputStream();//获取is对象
                        CsvReader csvReader =new CsvReader(new BufferedReader(new InputStreamReader(is)));

                        OrderDetail orderDetail=null;

                        String orderCode = "";//订单编号
                        Double price = null;//价格
                        Integer quantity = null;//购买数量
                        String productCode = "";//外部系统编号（货号）
                        String orderStatus = "";//订单状态
                        csvReader.setUseComments(true);
                        csvReader.setComment('#');
                        csvReader.readHeaders();
                        while (csvReader.readRecord()){
                            // 读一整行
                            //System.out.println(csvReader.getRawRecord());
                            // 读这行的某一列
                            orderCode = csvReader.get("订单编号").trim().split("\"")[1];
                            price = Double.parseDouble(csvReader.get("价格").trim());
                            quantity = Integer.parseInt(csvReader.get("购买数量").trim());
                            productCode = csvReader.get("外部系统编号").trim();
                            orderStatus = csvReader.get("订单状态").trim();
                            //开始赋值
                            orderDetail = new OrderDetail();
                            orderDetail.setOrderCode(orderCode);
                            orderDetail.setPrice(price);
                            orderDetail.setQuantity(quantity);
                            orderDetail.setProductCode(productCode);
                            orderDetail.setOrderStatus(orderStatus);
                            orderDetailService.addOrderDetail(orderDetail);
                        }
                        reInfo = "导入数据成功";
                    }else{
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

}
