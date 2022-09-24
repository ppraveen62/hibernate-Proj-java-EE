package com;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class product {
	@Id
	@Column(name="Id")
	public int uid;
	@Column(name="Name")
	public String uname;
	@Column(name="Price")
	public int uprice;
	@Column(name="SellerDetails")
	public String usd;
	

	public product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public int getUprice() {
		return uprice;
	}
	public void setUprice(int uprice) {
		this.uprice = uprice;
	}
	public String getUsd() {
		return usd;
	}
	public void setUsd(String usd) {
		this.usd = usd;
	}


	@Override
	public String toString() {
		return "product [uid=" + uid + ", uname=" + uname + ", uprice=" + uprice + ", usd=" + usd + "]";
	}
	
	
	
	
	
	

}
