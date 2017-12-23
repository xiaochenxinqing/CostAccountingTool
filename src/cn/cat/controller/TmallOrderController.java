package cn.cat.controller;


import cn.cat.pojo.TmallOrder;
import cn.cat.service.tmall_order.TmallOrderService;
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
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yinxiaochen
 * 2017/12/22 14:20
 */
@Controller
@RequestMapping("/tmallOrder")
public class TmallOrderController {
    @Resource
    private TmallOrderService tmallOrderService;


    @RequestMapping(value = "/uploadTmallOrder.do", method = RequestMethod.POST)
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
                    if (prefix.equalsIgnoreCase("csv")) {
                        InputStream is = attach.getInputStream();//获取is对象
                        CsvReader csvReader = new CsvReader(new BufferedReader(new InputStreamReader(is)));

                        TmallOrder tmallOrder = null;

                        String orderCode;//订单编号
                        Double totalAmount;//总金额
                        Double actualAmount;//买家实际支付金额
                        Date buildTime;//订单创建时间
                        Date payTime;//订单付款时间
                        Integer totalCount;//宝贝总数量
                        String closeReason;//订单关闭原因
                        Double refundAmount;//退款金额
                        Date confirmTime;//确认收货时间
                        Double alreadyPayAmount;//打款商家金额

                        csvReader.readHeaders();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        while (csvReader.readRecord()) {
                            // 读一整行
                            //System.out.println(csvReader.getRawRecord());
                            // 读这行的某一列
                            orderCode = csvReader.get("订单编号").trim().split("\"")[1];
                            totalAmount = Double.parseDouble(csvReader.get("总金额").trim());
                            actualAmount = Double.parseDouble(csvReader.get("买家实际支付金额").trim());
                            buildTime =csvReader.get("订单创建时间")==null||csvReader.get("订单创建时间").trim().equals("")?null: sdf.parse(csvReader.get("订单创建时间"));
                            payTime = csvReader.get("订单付款时间")==null||csvReader.get("订单付款时间").trim().equals("")?null: sdf.parse(csvReader.get("订单付款时间"));
                            totalCount = Integer.parseInt(csvReader.get("宝贝总数量"));
                            closeReason = csvReader.get("订单关闭原因").trim();
                            refundAmount = Double.parseDouble(csvReader.get("退款金额").trim());
                            confirmTime = csvReader.get("确认收货时间")==null||csvReader.get("确认收货时间").trim().equals("")?null: sdf.parse(csvReader.get("确认收货时间"));
                            alreadyPayAmount = Double.parseDouble(csvReader.get("打款商家金额").trim().split("元")[0]);
                            //开始赋值
                            tmallOrder = new TmallOrder();
                            tmallOrder.setOrderCode(orderCode);
                            tmallOrder.setTotalAmount(totalAmount);
                            tmallOrder.setActualAmount(actualAmount);
                            tmallOrder.setBuildTime(buildTime);
                            tmallOrder.setPayTime(payTime);
                            tmallOrder.setTotalCount(totalCount);
                            tmallOrder.setCloseReason(closeReason);
                            tmallOrder.setRefundAmount(refundAmount);
                            tmallOrder.setConfirmTime(confirmTime);
                            tmallOrder.setAlreadyPayAmount(alreadyPayAmount);
                            tmallOrderService.addTmallOrder(tmallOrder);
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

}
