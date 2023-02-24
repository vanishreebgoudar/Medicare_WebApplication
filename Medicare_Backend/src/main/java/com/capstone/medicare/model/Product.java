package com.capstone.medicare.model;

import javax.persistence.*;

@Entity
@Table(name="Products")

public class Product
{
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="productId")
		private long productId;
		
		@Column(name="productName")
		private String productName;
		 
		private String Brand;  
		private int Qty;
		
		@Column(name="productPrice")
		private double productPrice;
		@Column(name="productDesc")
		private String productDesc;
		
		@Column(name="productImg")
		private String productImg;
		
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "categoryId")
		private Category category;
         
		

		public long getProductId() {
			return productId;
		}


		public void setProductId(long productId) {
			this.productId = productId;
		}


		public String getProductName() {
			return productName;
		}


		public void setProductName(String productName) {
			this.productName = productName;
		}


		public String getBrand() {
			return Brand;
		}


		public void setBrand(String brand) {
			Brand = brand;
		}


		public int getQty() {
			return Qty;
		}


		public void setQty(int qty) {
			Qty = qty;
		}


		public double getProductPrice() {
			return productPrice;
		}


		public void setProductPrice(double productPrice) {
			this.productPrice = productPrice;
		}


		public String getProductDesc() {
			return productDesc;
		}


		public void setProductDesc(String productDesc) {
			this.productDesc = productDesc;
		}


		public Category getCategory() {
			return category;
		}


		public void setCategory(Category category) {
			this.category = category;
		}


		public String getProductImg() {
			return productImg;
		}


		public void setProductImg(String productImg) {
			this.productImg = productImg;
		}

}

