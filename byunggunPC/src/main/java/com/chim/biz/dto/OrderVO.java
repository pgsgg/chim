package com.chim.biz.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderVO {
	private int oseq;
	private int odseq;
	private Date indate;
	private int pseq;
	private int quantity;
	private String result;
	private String id;
	private String mname;
	private String zipNum;
	private String address;
	private String phone;
	private String pname;
	private int price2;
}
