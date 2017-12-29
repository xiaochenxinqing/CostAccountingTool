package cn.cat.controller;


import cn.cat.pojo.AlipayOrder;
import cn.cat.pojo.AlipayResult;
import cn.cat.pojo.TmallResult;
import cn.cat.service.alipay_order.AlipayOrderService;
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
@RequestMapping("/alipayOrder")
public class AlipayOrderController {
    @Resource
    private AlipayOrderService alipayOrderService;

    @RequestMapping(value = "/uploadAlipayOrder.do", method = RequestMethod.POST)
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

                        AlipayOrder alipayOrder = null;

                        String accountingCode = "";//账务流水号
                        String businessCode;//业务流水号
                        String orderCode;//商户订单号
                        String goodsName;//商品名称
                        Date occuredTime;//发生时间
                        Double revenueAmount;//收入金额
                        Double disbursementAmount;//支出金额
                        Double accountBalance;//账户余额
                        csvReader.setUseComments(true);
                        csvReader.setComment('#');
                        csvReader.readHeaders();//读表头
                        System.out.println("表头是" + csvReader.getHeaders()[0]);
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");

                        while (csvReader.readRecord()) {
                            // 读一整行
                            // System.out.println("这一列是"+csvReader.getRawRecord());
                            // 读这行的某一列

                            accountingCode = csvReader.get("账务流水号") == null ? null : csvReader.get("账务流水号").trim();
                            businessCode = csvReader.get("业务流水号") == null ? null : csvReader.get("业务流水号").trim();
                            orderCode = csvReader.get("商户订单号") == null ? null : csvReader.get("商户订单号").trim();

                            if (orderCode == null || orderCode.indexOf("T200P") == 0) {
                                orderCode = orderCode.substring(5);
                            } else {
                                continue;
                            }
                            goodsName = csvReader.get("商品名称") == null ? null : csvReader.get("商品名称").trim();
                            occuredTime = csvReader.get("发生时间") == null || csvReader.get("发生时间").trim().equals("") ? null : sdf.parse(csvReader.get("发生时间"));
                            revenueAmount = csvReader.get("收入金额（+元）") == null || csvReader.get("收入金额（+元）").trim().equals("") ? null : Double.parseDouble(csvReader.get("收入金额（+元）").trim());
                            disbursementAmount =csvReader.get("支出金额（-元）")==null|| csvReader.get("支出金额（-元）").trim().equals("") ?null: Double.parseDouble(csvReader.get("支出金额（-元）").trim());
                            accountBalance =csvReader.get("账户余额（元）")==null|| csvReader.get("账户余额（元）").trim().equals("") ?null: Double.parseDouble(csvReader.get("账户余额（元）").trim());
                            //开始赋值
                            alipayOrder = new AlipayOrder();
                            alipayOrder.setAccountingCode(accountingCode);
                            alipayOrder.setBusinessCode(businessCode);
                            alipayOrder.setOrderCode(orderCode);
                            alipayOrder.setGoodsName(goodsName);
                            alipayOrder.setOccuredTime(occuredTime);
                            alipayOrder.setRevenueAmount(revenueAmount);
                            alipayOrder.setDisbursementAmount(disbursementAmount);
                            alipayOrder.setAccountBalance(accountBalance);

                            alipayOrderService.addAlipayOrder(alipayOrder);

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


    @RequestMapping(value = "/countCostForAlipayOrder.do", method = RequestMethod.POST)
    @ResponseBody
    public String countCost(@RequestParam(value = "chooseMonth", required = false) String chooseMonth) {

        Double totalCount = null;
        String reInfo = "success";
        ;//用来保存返回信息
        try {
            totalCount = alipayOrderService.countCostForMonth(chooseMonth);
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
        List<AlipayResult> alipayResultList = null;
        String reInfo = "";
        alipayResultList = alipayOrderService.showMergeResult(chooseMonth);
        System.out.println("长度是" + alipayResultList.size());
        //开始导入


        String fileName = System.currentTimeMillis() + RandomUtils.nextInt(1000000) + "_mergeData.csv";
        File filedir = new File("/mergeData");
        if (!filedir.exists()) {
            filedir.mkdirs();
        }
        File file = new File("/mergeData/" + fileName);
        file.createNewFile();

        CsvWriter csvWriter = new CsvWriter(new FileOutputStream(file), ',', Charset.forName("UTF-8"));
        String[] headers = {"支付宝订单表订单号", "发生时间", "详情表订单编号", "购买数量", "详情表货号", "成本表货号", "成本表价格", ""};
        csvWriter.writeRecord(headers);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String[] content = new String[7];
        for (AlipayResult alipayResult : alipayResultList) {
            content[0] = alipayResult.getAliordercode();
            content[1] = alipayResult.getOccuredTime() == null ? null : sdf.format(alipayResult.getOccuredTime());
            content[2] = alipayResult.getDetailordercode();
            content[3] = alipayResult.getQuantity() == null ? null : alipayResult.getQuantity().toString();
            content[4] = alipayResult.getDetailproductcode();
            content[5] = alipayResult.getProproductcode();
            content[6] = alipayResult.getCostPrice() == null ? null : alipayResult.getCostPrice().toString();
            csvWriter.writeRecord(content);

        }
        csvWriter.close();
        reInfo = "success";

        return "{\"status\":\"" + reInfo + "\",\"fileName\":\"" + fileName + "\"}";

    }

}
