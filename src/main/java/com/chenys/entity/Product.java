package com.chenys.entity;
/**
 * 对应HR下的SKY_PRODUCT表
 * @author cys19
 *
 */
public class Product {
     private int proId;
	 private String proName;
	 private Category category;
	 private int proPrice;
	 private int proDiscount;
	 private int proVolume;
	 private Store store;
	 private int proRepertory;
	 private String proIntroduce;
	 private String proPicture;
	 private String proType;
	 private int proState;
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getProVolume() {
		return proVolume;
	}
	public void setProVolume(int proVolume) {
		this.proVolume = proVolume;
	}
	public Store getStore() {
		return store;
	}
	public void setStore(Store store) {
		this.store = store;
	}
	public int getProRepertory() {
		return proRepertory;
	}
	public void setProRepertory(int proRepertory) {
		this.proRepertory = proRepertory;
	}
	public String getProIntroduce() {
		return proIntroduce;
	}
	public void setProIntroduce(String proIntroduce) {
		this.proIntroduce = proIntroduce;
	}
	public String getProPicture() {
		return proPicture;
	}
	public void setProPicture(String proPicture) {
		this.proPicture = proPicture;
	}
	public String getProType() {
		return proType;
	}
	public void setProType(String proType) {
		this.proType = proType;
	}
	public int getProState() {
		return proState;
	}
	public void setProState(int proState) {
		this.proState = proState;
	}
	@Override
	public String toString() {
		return "Product [proId=" + proId + ", proName=" + proName
				+ ", category=" + category + ", proPrice=" + proPrice
				+ ", proDiscount=" + proDiscount + ", proVolume=" + proVolume
				+ ", store=" + store + ", proRepertory=" + proRepertory
				+ ", proIntroduce=" + proIntroduce + ", proPicture="
				+ proPicture + ", proType=" + proType + ", proState="
				+ proState + "]";
	}
	public int getProPrice() {
		return proPrice;
	}
	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}
	public int getProDiscount() {
		return proDiscount;
	}
	public void setProDiscount(int proDiscount) {
		this.proDiscount = proDiscount;
	}
	 
	 
}
