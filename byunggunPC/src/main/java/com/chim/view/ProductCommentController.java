package com.chim.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chim.biz.dto.MemberVO;
import com.chim.biz.dto.ProductCommentVO;
import com.chim.biz.service.CommentService;

import utils.Criteria;
import utils.PageMaker;

@RestController
public class ProductCommentController {

	@Autowired
	private CommentService commentService;

	@RequestMapping(value = "/comment_list", produces = "application/json; charset=UTF-8")
	public Map<String, Object> listComment(ProductCommentVO vo, Criteria criteria) {
		Map<String, Object> map = new HashMap<String, Object>();

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCriteria(criteria);
		pageMaker.setTotalCount(commentService.getCountCommentList(vo.getPseq()));

		List<ProductCommentVO> commentList = commentService.getCommentListWithPaging(criteria, vo.getPseq());
		map.put("pageMaker", pageMaker);
		map.put("total", commentList.size());
		map.put("commentList", commentList);

		return map;
	}

	@RequestMapping("/comment_save")
	public String insertComment(ProductCommentVO vo, HttpSession session) {
		MemberVO loginUser = (MemberVO) session.getAttribute("loginUser");
		if (loginUser == null) {
			return "not_logedin";
		} else {
			vo.setWriter(loginUser.getId());

			int result = commentService.saveComment(vo);

			if (result > 0) { // 삽입성공
				return "success";
			} else {
				return "fail";
			}
		}
	}
}
