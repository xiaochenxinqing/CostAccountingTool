package cn.cat.pojo;

import java.util.Date;

/**
 * @author yinxiaochen
 * 2017/12/27 10:46
 */
public class AlipayResult {
    private String aliordercode;
    private Date occuredTime;
    private String detailordercode;
    private Integer quantity;
    private String detailproductcode;
    private String proproductcode;
    private Double costPrice;

    public String getAliordercode() {
        return aliordercode;
    }

    public void setAliordercode(String aliordercode) {
        this.aliordercode = aliordercode;
    }

    public Date getOccuredTime() {
        return occuredTime;
    }

    public void setOccuredTime(Date occuredTime) {
        this.occuredTime = occuredTime;
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
