package cn.cat.pojo;

import java.util.Date;

public class AlipayOrder {
  private Integer id;//订单唯一标识(自动生成)
  private String orderCode;//订单编号
  private Double totalAmount;//总金额
  private Double actualAmount;//实际金额
  private Date buildTime;//订单创建时间
  private Date payTime;//订单付款时间
  private Integer totalCount;//宝贝总数量
  private String closeReason;//订单关闭原因
  private String refundAmount;//退款原因
  private Date confirmTime;//确认收货时间
  private Double alreadyPayAmount;//已打款商家金额

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

  public String getCloseReason() {
    return closeReason;
  }

  public void setCloseReason(String closeReason) {
    this.closeReason = closeReason;
  }

  public String getRefundAmount() {
    return refundAmount;
  }

  public void setRefundAmount(String refundAmount) {
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
