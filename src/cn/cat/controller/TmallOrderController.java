package cn.cat.controller;


import cn.cat.pojo.TmallOrder;
import cn.cat.pojo.TmallResult;
import cn.cat.service.tmall_order.TmallOrderService;
import com.alibaba.fastjson.JSON;
import com.csvreader.CsvReader;
import com.csvreader.CsvWriter;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
                        CsvReader csvReader = new CsvReader(is, Charset.forName("gbk"));
                        TmallOrder tmallOrder = null;

                        String orderCode;//订单编号
                        Double totalAmount;//总金额
                        Double actualAmount;//买家实际支付金额
                        Date buildTime;//订单创建时间
                        Date payTime;//订单付款时间
                        Integer totalCount;//宝贝总数量
                        String orderStatus;//订单状态
                        String customerAddress;//收货地址
                        Double refundAmount;//退款金额
                        Date confirmTime;//确认收货时间
                        Double alreadyPayAmount;//打款商家金额
                        csvReader.setUseComments(true);
                        csvReader.setComment('#');
                        csvReader.readHeaders();
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        while (csvReader.readRecord()) {
                            // 读一整行
                            //System.out.println(csvReader.getRawRecord());
                            // 读这行的某一列
                            if (csvReader.get("订单编号") == null) {
                                orderCode = null;
                            } else {
                                if (csvReader.get("订单编号").contains("=")) {
                                    orderCode = csvReader.get("订单编号").trim().split("\"")[1];
                                } else {
                                    orderCode = csvReader.get("订单编号").trim();
                                }
                            }
                            totalAmount = csvReader.get("总金额") == null ? null : Double.parseDouble(csvReader.get("总金额").trim());
                            actualAmount = csvReader.get("买家实际支付金额") == null ? null : Double.parseDouble(csvReader.get("买家实际支付金额").trim());
                            buildTime = csvReader.get("订单创建时间") == null || csvReader.get("订单创建时间").trim().equals("") ? null : sdf.parse(csvReader.get("订单创建时间"));
                            payTime = csvReader.get("订单付款时间 ") == null || csvReader.get("订单付款时间 ").trim().equals("") ? null : sdf.parse(csvReader.get("订单付款时间 "));
                            totalCount = csvReader.get("宝贝总数量") == null || csvReader.get("宝贝总数量").trim().equals("") ? null : Integer.parseInt(csvReader.get("宝贝总数量"));
                            orderStatus = csvReader.get("订单状态") == null ? null : csvReader.get("订单状态").trim();
                            customerAddress = csvReader.get("收货地址 ") == null ? null : csvReader.get("收货地址 ").trim().substring(0, 20);
                            refundAmount = csvReader.get("退款金额") == null || csvReader.get("退款金额").trim().equals("") ? null : Double.parseDouble(csvReader.get("退款金额").trim());
                            confirmTime = csvReader.get("确认收货时间") == null || csvReader.get("确认收货时间").trim().equals("") ? null : sdf.parse(csvReader.get("确认收货时间"));
                            alreadyPayAmount = csvReader.get("打款商家金额") == null || csvReader.get("打款商家金额").trim().equals("") ? null : Double.parseDouble(csvReader.get("打款商家金额").trim().split("元")[0]);
                            //开始赋值
                            tmallOrder = new TmallOrder();
                            tmallOrder.setOrderCode(orderCode);
                            tmallOrder.setTotalAmount(totalAmount);
                            tmallOrder.setActualAmount(actualAmount);
                            tmallOrder.setBuildTime(buildTime);
                            tmallOrder.setPayTime(payTime);
                            tmallOrder.setTotalCount(totalCount);
                            tmallOrder.setOrderStatus(orderStatus);
                            tmallOrder.setCustomerAddress(customerAddress);
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


    @RequestMapping(value = "/countCostForTmallOrder.do", method = RequestMethod.POST)
    @ResponseBody
    public String countCost(@RequestParam(value = "chooseMonth", required = false) String chooseMonth
            , @RequestParam(value = "orderCode", required = false) String orderCode) {

        Double totalCount = null;
        String reInfo = "success";
        ;//用来保存返回信息
        try {
            totalCount = tmallOrderService.countCostForMonth(chooseMonth, orderCode);
        } catch (Exception e) {
            reInfo = "未知错误！";
            e.printStackTrace();
        } finally {

            return "{\"status\":\"" + reInfo + "\",\"cost\":\"" + totalCount + "\"}";
        }

    }


    @RequestMapping("/showMergeResult.do")
    @ResponseBody
    public Object showMergeResult(HttpServletRequest request, @RequestParam(value = "chooseMonth", required = false) String chooseMonth) throws Exception {
        List<TmallResult> tmallResultList = null;
        String reInfo = "";
        tmallResultList = tmallOrderService.showMergeResult(chooseMonth);
        //开始导入


        String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + "_mergeData.csv";
        File filedir = new File("D:\\mergeData");
        if (!filedir.exists()) {
            filedir.mkdirs();
        }
        File file = new File("D:\\mergeData\\" + fileName);
        file.createNewFile();

        CsvWriter csvWriter = new CsvWriter(new FileOutputStream(file), ',', Charset.forName("GBK"));
        String[] headers = {"天猫表订单号", "创建时间", "付款时间", "详情表订单编号", "购买数量", "详情表外部属性", "成本表货号", "成本表价格", ""};
        csvWriter.writeRecord(headers);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String[] content = new String[8];
        for (TmallResult tmallResult : tmallResultList) {
            content[0] = "=\"" + tmallResult.getTmallordercode() + "\"";
            content[1] = tmallResult.getBuildTime() == null ? null : sdf.format(tmallResult.getBuildTime());
            content[2] = tmallResult.getPayTime() == null ? null : sdf.format(tmallResult.getPayTime());
            content[3] = tmallResult.getDetailordercode();
            content[4] = tmallResult.getQuantity() == null ? null : tmallResult.getQuantity().toString();
            content[5] = tmallResult.getDetailproductcode();
            content[6] = tmallResult.getProproductcode();
            content[7] = tmallResult.getCostPrice() == null ? null : tmallResult.getCostPrice().toString();
            csvWriter.writeRecord(content);

        }
        csvWriter.close();
        reInfo = "success";

        return "{\"status\":\"" + reInfo + "\",\"fileName\":\"" + fileName + "\"}";

    }

}
