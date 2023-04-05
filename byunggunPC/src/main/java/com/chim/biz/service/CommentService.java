package com.chim.biz.service;

import java.util.List;

import com.chim.biz.dto.ProductCommentVO;

import utils.Criteria;

public interface CommentService {

	int getCountCommentList(int pseq);

	List<ProductCommentVO> getCommentListWithPaging(Criteria criteria, int pseq);

	public int saveComment(ProductCommentVO vo);
}