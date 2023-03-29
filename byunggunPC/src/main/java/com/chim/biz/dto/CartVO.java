package com.chim.biz.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CartVO {
	private int cseq;
	private String id;
	private int pseq;
	private int quantity;
	private String result;
	private Date indate;
	private String mname;
	private String pname;
	private int price2;
	
}
