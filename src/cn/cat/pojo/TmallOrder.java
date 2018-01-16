package cn.cat.pojo;

import java.util.Date;

public class TmallOrder {
  private Integer id;//订单唯一标识(自动生成)
  private String orderCode;//订单编号
  private Double totalAmount;//总金额
  private Double actualAmount;//实际金额
  private Date buildTime;//订单创建时间
  private Date payTime;//订单付款时间
  private Integer totalCount;//宝贝总数量
  private String orderStatus;//订单状态
  private String customerAddress;//收货地址
  private Double refundAmount;//退款金额
  private Date confirmTime;//确认收货时间
  private Double alreadyPayAmount;//已打款商家金额

  public String getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(String orderStatus) {
    this.orderStatus = orderStatus;
  }

  public String getCustomerAddress() {
    return customerAddress;
  }

  public void setCustomerAddress(String customerAddress) {
    this.customerAddress = customerAddress;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getOrderCode() {
    return orderCode;
  }

  public void setOrderCode(String orderCode) {
    this.orderCode = orderCode;
  }

  public Double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public Double getActualAmount() {
    return actualAmount;
  }

  public void setActualAmount(Double actualAmount) {
    this.actualAmount = actualAmount;
  }

  public Date getBuildTime() {
    return buildTime;
  }

  public void setBuildTime(Date buildTime) {
    this.buildTime = buildTime;
  }

  public Date getPayTime() {
    return payTime;
  }

  public void setPayTime(Date payTime) {
    this.payTime = payTime;
  }

  public Integer getTotalCount() {
    return totalCount;
  }

  public void setTotalCount(Integer totalCount) {
    this.totalCount = totalCount;
  }


  public Double getRefundAmount() {
    return refundAmount;
  }

  public void setRefundAmount( Double  refundAmount) {
    this.refundAmount = refundAmount;
  }

  public Date getConfirmTime() {
    return confirmTime;
  }

  public void setConfirmTime(Date confirmTime) {
    this.confirmTime = confirmTime;
  }

  public Double getAlreadyPayAmount() {
    return alreadyPayAmount;
  }

  public void setAlreadyPayAmount(Double alreadyPayAmount) {
    this.alreadyPayAmount = alreadyPayAmount;
  }
}
