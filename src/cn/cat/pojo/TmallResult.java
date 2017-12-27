package cn.cat.pojo;

import java.util.Date;

/**
 * @author yinxiaochen
 * 2017/12/27 10:46
 */
public class TmallResult {
    private String tmallordercode;
    private Date buildTime;
    private Date payTime;
    private String detailordercode;
    private Integer quantity;
    private String detailproductcode;
    private String proproductcode;
    private Double costPrice;

    public String getTmallordercode() {
        return tmallordercode;
    }

    public void setTmallordercode(String tmallordercode) {
        this.tmallordercode = tmallordercode;
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

    public String getDetailordercode() {
        return detailordercode;
    }

    public void setDetailordercode(String detailordercode) {
        this.detailordercode = detailordercode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDetailproductcode() {
        return detailproductcode;
    }

    public void setDetailproductcode(String detailproductcode) {
        this.detailproductcode = detailproductcode;
    }

    public String getProproductcode() {
        return proproductcode;
    }

    public void setProproductcode(String proproductcode) {
        this.proproductcode = proproductcode;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }
}
