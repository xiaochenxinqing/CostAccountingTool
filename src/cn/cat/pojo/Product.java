package cn.cat.pojo;


public class Product {

  private Integer id;//商品唯一标识
  private String productCode;//商品货号
  private Double CostPrice;//成本价格


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getProductCode() {
    return productCode;
  }

  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  public Double getCostPrice() {
    return CostPrice;
  }

  public void setCostPrice(Double costPrice) {
    CostPrice = costPrice;
  }
}
