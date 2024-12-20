package com.domorecode.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
private Integer productId;
private String productName;
private Double productPrice;
public Integer getProductId() {
	return productId;
}
public void setProductId(Integer productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public Double getProductPrice() {
	return productPrice;
}
public void setProductPrice(Double productPrice) {
	this.productPrice = productPrice;
}
//public Product() {
//	super();
//}
//public Product(Integer productId, String productName, Double productPrice) {
//	super();
//	this.productId = productId;
//	this.productName = productName;
//	this.productPrice = productPrice;
//}
@Override
public String toString() {
	return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice + "]";
}


}
