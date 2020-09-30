package com.cg.gops.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Product_Table")

public class Product {
	
	
		@Id
		
		@Column(name= "product_id", length=25)
		private String productId;
		@Column(name= "product_name", length=25)
		private String productName;
		@Column(name= "product_price", length=10)
		private int productPrice;
		@Column(name= "product_colour", length=25)
		private String productColour;
		@Column(name= "product_specification", length=25)
		private String specification;
		@Column(name= "brand_name", length=25)
		private String brandName;
		@Column(name= "product_quantity", length=25)
		private int productQuantity;
		@Column(name= "product_category", length=25)
		private String productCategory;
		
		public Product() {
			
		}
		
		public Product(String productId, String productName, int productPrice, String productColour,
				String specification, String brandName, int productQuantity, String productCategory) {
			super();
			this.productId = productId;
			this.productName = productName;
			this.productPrice = productPrice;
			this.productColour = productColour;
			this.specification = specification;
			this.brandName = brandName;
			this.productQuantity = productQuantity;
			this.productCategory = productCategory;
		}
		public String getProductId() {
			return productId;
		}
		public void setProductId(String productId) {
			this.productId = productId;
		}
		public String getProductName() {
			return productName;
		}
		public void setProductName(String productName) {
			this.productName = productName;
		}
		public int getProductPrice() {
			return productPrice;
		}
		public void setProductPrice(int productPrice) {
			this.productPrice = productPrice;
		}
		public String getProductColour() {
			return productColour;
		}
		public void setProductColour(String productColour) {
			this.productColour = productColour;
		}
		public String getSpecification() {
			return specification;
		}
		public void setSpecification(String specification) {
			this.specification = specification;
		}
		public String getBrandName() {
			return brandName;
		}
		public void setBrandName(String brandName) {
			this.brandName = brandName;
		}
		public int getProductQuantity() {
			return productQuantity;
		}
		public void setProductQuantity(int productQuantity) {
			this.productQuantity = productQuantity;
		}
		public String getProductCategory() {
			return productCategory;
		}
		public void setProductCategory(String productCategory) {
			this.productCategory = productCategory;
		}
		@Override
		public String toString() {
			return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
					+ ", productColour=" + productColour + ", specification=" + specification + ", brandName="
					+ brandName + ", productQuantity=" + productQuantity + ", productCategory=" + productCategory + "]";
		}
		
		
		
}
