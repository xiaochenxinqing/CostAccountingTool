package cn.cat.pojo;


import java.util.Date;

public class AlipayOrder {

  private Integer id;//订单唯一编号
  private String accountingCode;//账务流水号
  private String businessCode;//业务流水号
  private String orderCode;//商户订单号
  private String goodsName;//商品名称
  private Date occuredTime;//发生时间
  private Double revenueAmount;//收入金额
  private Double disbursementAmount;//支出金额
  private Double accountBalance;//账户余额

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getAccountingCode() {
    return accountingCode;
  }

  public void setAccountingCode(String accountingCode) {
    this.accountingCode = accountingCode;
  }

  public String getBusinessCode() {
    return businessCode;
  }

  public void setBusinessCode(String businessCode) {
    this.businessCode = businessCode;
  }

  public String getOrderCode() {
    return orderCode;
  }

  public void setOrderCode(String orderCode) {
    this.orderCode = orderCode;
  }

  public String getGoodsName() {
    return goodsName;
  }

  public void setGoodsName(String goodsName) {
    this.goodsName = goodsName;
  }

  public Date getOccuredTime() {
    return occuredTime;
  }

  public void setOccuredTime(Date occuredTime) {
    this.occuredTime = occuredTime;
  }


  public Double getRevenueAmount() {
    return revenueAmount;
  }

  public void setRevenueAmount(Double revenueAmount) {
    this.revenueAmount = revenueAmount;
  }

  public Double getDisbursementAmount() {
    return disbursementAmount;
  }

  public void setDisbursementAmount(Double disbursementAmount) {
    this.disbursementAmount = disbursementAmount;
  }

  public Double getAccountBalance() {
    return accountBalance;
  }

  public void setAccountBalance(Double accountBalance) {
    this.accountBalance = accountBalance;
  }
}
