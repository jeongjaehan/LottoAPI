package com.lotto.dto;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="lotto")
public class LottoDTO {
	private int n;
	private int y;
	private String dd;
	private int wc1; 
	private long wa1;
	private int wc2;
	private int wa2;
	private int wc3;
	private int wa3;
	private int wc4;
	private int wa4;
	private int wc5;
	private int wa5;
	private int wn1;
	private int wn2;
	private int wn3;
	private int wn4;
	private int wn5;
	private int wn6;
	private int wnb;


	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public String getDd() {
		return dd;
	}

	public void setDd(String dd) {
		this.dd = dd;
	}

	public int getWc1() {
		return wc1;
	}

	public void setWc1(int wc1) {
		this.wc1 = wc1;
	}
	
	public long getWa1() {
		return wa1;
	}

	public void setWa1(long wa1) {
		this.wa1 = wa1;
	}

	public int getWc2() {
		return wc2;
	}

	public void setWc2(int wc2) {
		this.wc2 = wc2;
	}

	public int getWa2() {
		return wa2;
	}

	public void setWa2(int wa2) {
		this.wa2 = wa2;
	}

	public int getWc3() {
		return wc3;
	}

	public void setWc3(int wc3) {
		this.wc3 = wc3;
	}

	public int getWa3() {
		return wa3;
	}

	public void setWa3(int wa3) {
		this.wa3 = wa3;
	}

	public int getWc4() {
		return wc4;
	}

	public void setWc4(int wc4) {
		this.wc4 = wc4;
	}

	public int getWa4() {
		return wa4;
	}

	public void setWa4(int wa4) {
		this.wa4 = wa4;
	}

	public int getWc5() {
		return wc5;
	}

	public void setWc5(int wc5) {
		this.wc5 = wc5;
	}

	public int getWa5() {
		return wa5;
	}

	public void setWa5(int wa5) {
		this.wa5 = wa5;
	}

	public int getWn1() {
		return wn1;
	}

	public void setWn1(int wn1) {
		this.wn1 = wn1;
	}

	public int getWn2() {
		return wn2;
	}

	public void setWn2(int wn2) {
		this.wn2 = wn2;
	}

	public int getWn3() {
		return wn3;
	}

	public void setWn3(int wn3) {
		this.wn3 = wn3;
	}

	public int getWn4() {
		return wn4;
	}

	public void setWn4(int wn4) {
		this.wn4 = wn4;
	}

	public int getWn5() {
		return wn5;
	}

	public void setWn5(int wn5) {
		this.wn5 = wn5;
	}

	public int getWn6() {
		return wn6;
	}

	public void setWn6(int wn6) {
		this.wn6 = wn6;
	}

	public int getWnb() {
		return wnb;
	}

	public void setWnb(int wnb) {
		this.wnb = wnb;
	}

	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	@Override
	public String toString() {
		return "LottoDTO [n=" + n + ", y=" + y + ", dd=" + dd + ", wc1=" + wc1
				+ ", wa1=" + wa1 + ", wc2=" + wc2 + ", wa2=" + wa2 + ", wc3="
				+ wc3 + ", wa3=" + wa3 + ", wc4=" + wc4 + ", wa4=" + wa4
				+ ", wc5=" + wc5 + ", wa5=" + wa5 + ", wn1=" + wn1 + ", wn2="
				+ wn2 + ", wn3=" + wn3 + ", wn4=" + wn4 + ", wn5=" + wn5
				+ ", wn6=" + wn6 + ", wnb=" + wnb + "]";
	}
	
	

}
