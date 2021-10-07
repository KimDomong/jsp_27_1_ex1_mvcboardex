package com.domong.ex.dto;

import java.sql.Timestamp;
	
	// DTO = 객체를 담아 움직일수 있도록 해주는 페이지

public class BDto {
	
	int bid;
	String bname;
	String btitle;
	String bcontent;
	Timestamp bdate;
	int bhit;
	int bgroup;
	int bstep;
	int bindent;
	
	public BDto() {
		//인트가 없어도 BDto가 생성되도록 빈 함수생성
	}
	
	public BDto(int bid, String bname, String btitle, String bcontent, Timestamp bdate, int bhit, int bgroup, int bstep, int bindent ) {
		//같은 메서드인데 인트를 다르게 한 오버로딩 이라고 함.
		this.bid = bid; 
		this.bname = bname;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bdate =bdate;
		this.bhit =bhit;
		this.bgroup =bgroup;
		this.bstep =bstep;
		this.bindent =bindent;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public Timestamp getBdate() {
		return bdate;
	}

	public void setBdate(Timestamp bdate) {
		this.bdate = bdate;
	}

	public int getBhit() {
		return bhit;
	}

	public void setBhit(int bhit) {
		this.bhit = bhit;
	}

	public int getBgroup() {
		return bgroup;
	}

	public void setBgroup(int bgroup) {
		this.bgroup = bgroup;
	}

	public int getBstep() {
		return bstep;
	}

	public void setBstep(int bstep) {
		this.bstep = bstep;
	}

	public int getBindent() {
		return bindent;
	}

	public void setBindent(int bindent) {
		this.bindent = bindent;
	}
}
