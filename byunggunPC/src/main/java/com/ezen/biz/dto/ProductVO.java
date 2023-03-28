package com.ezen.biz.dto;

import java.util.Date;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString  
public class ProductVO {
	private int pseq;
	private String name;
	private String kind;
	private int price1;
	private int price2;
	private int price3;
	private String content;
	private String image;
	private String bestyn;
	private int quantity;
	private Date regdate;
}
