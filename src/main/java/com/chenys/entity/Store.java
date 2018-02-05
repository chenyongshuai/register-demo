package com.chenys.entity;
/**
 * 对应HR下的SKY_STORE表
 * @author cys19
 *
 */
public class Store {
    
    private int storeId;
	private String storeName;
	private String storeLevel;
	private String storePhone;
	private String storeCellPhone;
	private String storePayType;
	private String storeEmail;
	private int storeState;
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getStoreLevel() {
		return storeLevel;
	}
	public void setStoreLevel(String storeLevel) {
		this.storeLevel = storeLevel;
	}
	public String getStorePhone() {
		return storePhone;
	}
	public void setStorePhone(String storePhone) {
		this.storePhone = storePhone;
	}
	public String getStoreCellPhone() {
		return storeCellPhone;
	}
	public void setStoreCellPhone(String storeCellPhone) {
		this.storeCellPhone = storeCellPhone;
	}
	public String getStorePayType() {
		return storePayType;
	}
	public void setStorePayType(String storePayType) {
		this.storePayType = storePayType;
	}
	public String getStoreEmail() {
		return storeEmail;
	}
	public void setStoreEmail(String storeEmail) {
		this.storeEmail = storeEmail;
	}
	public int getStoreState() {
		return storeState;
	}
	public void setStoreState(int storeState) {
		this.storeState = storeState;
	}
	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", storeName=" + storeName
				+ ", storeLevel=" + storeLevel + ", storePhone=" + storePhone
				+ ", storeCellPhone=" + storeCellPhone + ", storePayType="
				+ storePayType + ", storeEmail=" + storeEmail + ", storeState="
				+ storeState + "]";
	}
	
	
	
}
