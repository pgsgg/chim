/**
 * 
 */

	function MyNoticeTimeLineScript(MNTLNo,Ty,Ty2){
		if((MNTLNo || Ty) && $(".AllClass").hasClass('AllClass')){
			$.ajax({
				url: "../include/top_ajax_function.php",
				type: 'POST',
				dataType: 'text',
				data : {
					'actype' : 'ChangeTimeLine',
					'MNTLNo' : MNTLNo,
					'Ty' : Ty,
					'Ty2' : Ty2
				},
				async: true,
				success:function(dom){
					console.log(dom);
					var data_arr = dom.split("|");
					$(".TimeLineNum").html(data_arr[1]);
					if(Ty2 == 'Read' && $(".AllClass").hasClass('AllClass')){
						if(data_arr[0] == 'ReadAll'){
							$(".AllClass").addClass('old');
							$(".AllClass2").removeAttr("onClick");
						}else{
							$(".MNTK_"+data_arr[0]).addClass('old');
							$(".MNTK2_"+data_arr[0]).removeAttr("onClick");
						}
					}else if(Ty2 == 'Del' && $(".AllClass").hasClass('AllClass')){
						if(data_arr[0] == 'DelReadAll'){
							if(confirm("삭제된 알림은 복구가 불가합니다.")){
								$(".old").remove();
								if(!$(".AllClass").hasClass('AllClass')){
									var AddHtml = '<div class="bell_cont bell_nocont">';
											AddHtml += '<div class="bell_nocont_inner">';
											AddHtml += '<span><img src="//image5.compuzone.co.kr/img/images/main/no_notice.png" alt=""></span>';
											AddHtml += '<p>새로운 알림이 없습니다.</p>';
											AddHtml += '</div>';
											AddHtml += '</div>';
									$(".TimeLineUl").html(AddHtml);
								}
							}
						}else if(data_arr[0] == 'DelAll'){
							if(confirm("삭제된 알림은 복구가 불가합니다.")){
								$(".AllClass").remove();
								var AddHtml = '<div class="bell_cont bell_nocont">';
										AddHtml += '<div class="bell_nocont_inner">';
										AddHtml += '<span><img src="//image5.compuzone.co.kr/img/images/main/no_notice.png" alt=""></span>';
										AddHtml += '<p>새로운 알림이 없습니다.</p>';
										AddHtml += '</div>';
										AddHtml += '</div>';
								$(".TimeLineUl").html(AddHtml);
							}
						}else{
							$(".MNTK_"+data_arr[0]).remove();
						}
					}
				}
			});	
		}
	}
	function fn_OpenCS(){
		window.open('https://www.compuzone.co.kr/cscenter/main.htm');
	}
	//[90274] 이벤트 당첨자 팝업 닫기
	function custEvtWinner_popClose(){
		$('.custEvtWinner_pop').hide();
	}
	//[90274] 이벤트 당첨자 팝업 다시보지않기 
	function notice_pop_del(){
		$('.custEvtWinner_pop').hide();
		$.ajax({
			url: "../event_zone/eventzone_function.php",
			type: "POST",
			async: true,

			data: {
				actype: 'notice_pop_del', 
				member_id : '',
			},
		});
	}
	//[90274] 이벤트 당첨자 팝업 해당 이벤트 당첨자 발표 이동
	function winner_open(EventNo){
		location.href = 'https://www.compuzone.co.kr'+"/event_zone/eventzone_win_view.htm?EventNo="+EventNo;
	}

	$(document).ready(function () {
		$('.categroup_all > a').on("click", function(){
			if($("#is_get_abnr").val()=="N"){
				$.ajax({
					url: "../include/top_ajax_function.php",
					type: 'POST',
					dataType: 'json',
					data : {
						'actype' : 'GetMainRollingBannerAll'
					},
					async: true,
					success:function(dom){
						if(dom.length>0){
							var html="";
							$.each(dom,function(k,data){
								html+='<li>';
								html+='<a href="'+data.BannerLink+'">';
								html+='<img alt="" src="//image5.compuzone.co.kr/img/images/main2014/H/MainRollingBanner_'+data.BannerNo+'.jpg">';
								html+='<span></span>';
								html+='<i></i>';
								html+='<h1>'+data.BannerTitle+'</h1>';
								html+='<p>'+data.BannerContents+'</p>';
								html+='	</a>';
								html+='</li>';
							});
						}
						$("#mainBanner_content_ul").empty();
						$("#mainBanner_content_ul").html(html);
						$("#is_get_abnr").val("Y");
					}
				});
			}
			$('body').css({"overflow":"hidden"});
			$('.mainBanner_Layer').css({"display":"block"});
		});
	});
	function mainBnr_close() {
		$('body').css({'overflow':'inherit'});
		$('.mainBanner_Layer').css({'display':'none'});
	}
	
	$(window).ready(function () {
		//신규 등록 상품 슬라이드
		$(".new_item_slide_wrap").slick({
			slidesToShow : 4,
			slidesToScroll : 1,
			autoplay : true,
			autoplaySpeed : 4000,
			speed : 500,
			infinite : true,
			dots : false,
			pauseOnHover: false,
			arrows : true,
			prevArrow : $('.est_pc_wrap .prev'),
			nextArrow : $('.est_pc_wrap .next')
		});
		$(".new_item_roll").css({"display":"inline-block"});
		//월간견적 슬라이드
		$(".mth_est_slide").slick({
			slidesToShow : 1,
			fade: true,
			autoplay : true,
			autoplaySpeed : 4000,
			speed : 700,
			infinite : true,
			dots : false,
			arrows : true,
			prevArrow : $('.mth_est_wrap .prev'),
			nextArrow : $('.mth_est_wrap .next')
		});
		$(".mth_est_slide").css({"display":"inline-block"});
	});
	
	function show_estimate_detail(EseNo){
		history.pushState({
			'Page':'list',
			'SelOrder':$('select[name="SelOrder"]').val()
		}, null, '../main/main.htm');
		location.href='../exc_event/ask_estimate_detail.htm?ESE_No='+EseNo+'&bannerest='+EseNo;
	}
	
	(function(i,s,o,g,r,a,m){i["GoogleAnalyticsObject"]=r;i[r]=i[r]||function(){
		(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
		m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
		})(window,document,"script","https://www.google-analytics.com/analytics.js","ga");
		ga("create", "UA-11726784-1", "auto");
		ga("send", "pageview");
		ga("require", "displayfeatures");
		ga("require", "linkid", "linkid.js");

		// 브라우저 사이즈에 따른 우측 메뉴 활성화 처리
		$.isChkRghtMenu = function (){
			var w_w = $(window).width();
			if (w_w < 1260) {
				$('#jqIdRgtMn').hide();
			} else {
				$('#jqIdRgtMn').show();
			}
		};
		$(window).resize(function (){
			$.isChkRghtMenu();
		});

		$.isChkRghtMenu();
	
		if(!wcs_add) var wcs_add = {};
		wcs_add["wa"] = "186f0bac9005820";
		if(window.wcs) {
		wcs_do();
		}
	
		(function(a,g,e,n,t){a.enp=a.enp||function(){(a.enp.q=a.enp.q||[]).push(arguments)};n=g.createElement(e);n.async=!0;n.defer=!0;n.src="https://cdn.megadata.co.kr/dist/prod/enp_tracker_self_hosted.min.js";t=g.getElementsByTagName(e)[0];t.parentNode.insertBefore(n,t)})(window,document,"script");
		enp('create', 'common', 'avalinc', { device: 'W' });  // W:웹, M: 모바일, B: 반응형
		enp('send', 'common', 'avalinc');
	
	
	
		var timeStamp = 1680671179;
	
	
		var delayTimer = null; 
		
		$(function(){
			
			//My컴퓨존 레이어 
			$("#my_cpz_info").bind("mouseenter",function(){
				if($("#isMyCpzInfo").val() == 'N'){
					$.ajax({
						type : "get",
						dataType:"json",
				  	url: "../include/top_ajax_function.php?actype=getMyCpzInfo",
				  	success:function(data){
							if(data){
								$("#gnb_lyr_coupon_count").text(data.CouponTotCount);
								$("#gnb_lyr_cyber_price").text(data.PersonTotPoint);
								$("#gnb_lyr_wish_count").text(data.WishListTotCount);
								$("#gnb_lyr_cart_count").text(data.CartTotCount);
								
							}
						}
					});
					$("#isMyCpzInfo").val("Y");
				}
				$("#top_gnb_login_memerLayer").show();
			});		
			$("#my_cpz_info").bind("mouseleave",function(){
				$("#top_gnb_login_memerLayer").hide();
			});	
		});
		
		//남은시간 구하기 
		function remaindTime(ed) {
			var now = new Date();
	    var end = new Date(ed);
	    var distance = end - now;
	    
			var _second = 1000;
			var _minute = _second * 60;
			var _hour = _minute * 60;
			var _day = _hour * 24;
			var timer;

			var day = Math.floor(distance / _day);
			var hour = Math.floor((distance % _day) / _hour);
			var minutes = Math.floor((distance % _hour) / _minute);
			var seconds = Math.floor((distance % _minute) / _second);
			
	    if(hour<10){hour="0"+hour;}
	    if(minutes<10){minutes="0"+minutes;}
	    if(seconds<10){seconds="0"+seconds;}
	    var TimeArr = [];
	    
	    TimeArr[0] = hour;
	    TimeArr[1] = minutes;
	    TimeArr[2] = seconds;
	    TimeArr[3] = day;
	    
	    return TimeArr;
		 }	
		 
		 var LivePrdIsPause = true;
		 var LivePrdTimer;
		 function LiveCountDown(ed,live_prd_enddate,Today){
			 var TimeArr = remaindTime(ed);
			 if( Today != live_prd_enddate){
			   $(".Live_dt_countDown > .Live_detail_day_area > .Live_detail_D").text( TimeArr[3] );
			 }	
			 $(".Live_dt_countDown > .Live_detail_H").text( TimeArr[0] );
			 $(".Live_dt_countDown > .Live_detail_M").text( TimeArr[1] );
			 $(".Live_dt_countDown > .Live_detail_S").text( TimeArr[2] );
			 LivePrdIsPause = false;
		 }
		$(document).ready(function(){
		
			// 카테고리 메뉴 함수 호출 소스 재 사용
			var defCateLyrSrc = $("#defCateBtn").next(".cpz_category_layer").html(); // 기본 메뉴 카테고리
			var fixedCateLyrObj = $("#fixedCateBtn").next(".cpz_category_layer"); // 고정 메뉴 카테고리
			if (typeof fixedCateLyrObj.html() !== "undefined" && fixedCateLyrObj.html().length <= 0) {
				fixedCateLyrObj.html(defCateLyrSrc);
			}

			$(".catebnr_imgbx img").lazyload();
			// use top_body - start
			// 검색폼에 입력
			var target_input = $("#HeadSearchKeyword");
			var tg = target_input.target;

			var chk_short = true;
			//우측 날개윙 초기화
			InitRightWingSize();

			$("input, textarea").bind("blur", function(e) {
				chk_short = true;
			});

			$(document).bind('click', function(e) {
				// 자동 or 수동 클릭 여부
				if (e.originalEvent !== undefined) {
			  	if(!$(e.target).parents(".search_box").length && !$(e.target).parent(".jqClsSchLi").length) {
			  		sch_lyr_cls();
			  	}
			  }
			});

			// 상단 서브메뉴가 존재하는 메뉴 마우스 오버시
			$(".menuCtgr_li").find("a").mouseenter(function(){ $(this).siblings(".menuCtgrLayer").show(); });
			$(".menuCtgrLayer").mouseenter(function(){ $(this).show(); });
			$(".menuCtgr_li").mouseleave(function(){ $(this).find(".menuCtgrLayer").hide(); });

			// 마이페이지 마우스 오버
			$(".arrowDown").mouseenter(function(){ $(".dropdown").show(); $(".dropdown2, #directpop_2").hide();  });
			$(".dropdown").mouseenter(function(){ $(this).show(); });

			// 공통
			$(".ie_none_layer").mouseenter(function(){ $(".info_layer").hide();});
			$(".inner_wrap").mouseleave(function(){ $(".dropdown, .dropdown2").hide(); });
			// use top_body_login - end

			// 다이렉트콜 관련
			$('.jqClsTglDCPop').mouseenter(function(){ $("#directpop_2").show(); });
			$('.gnb').mouseleave(function(){ $("#directpop_2").hide(); });
			$('#directpop_2').mouseleave(function(){ $("#directpop_2").hide(); });

			// use top_body - start
			//  top 롤링 배너
			$(".sta_rolling_banner").slides({ container: "top_bnr_container", next: "head_rolling_next", prev: "head_rolling_prev", pagination: false, generatePagination: false, effect: "slide", start : $('#top_bnr_rand_num').val(), play: 5000, hoverPause : true });
			$(".head_rolling_prev, .head_rolling_next").css("display","");
			// 좌측 롤링
			$(".left_wing_rolling").slides({ container: "left_wing_rolling_item", next: "left_rolling_next", prev: "left_rolling_prev", pagination: false, generatePagination: false, effect: "slide", play: 3000});
			// 우측 최근 본 상품 롤링
			$(".goods_rolling_banner").slides({ container: "goods_rolling_container", next: "goods_rolling_next", prev: "goods_rolling_prev", pagination: false, generatePagination: false, effect: "slide"});

			//급상승 검색어 슬라이더
			$(".pwords_slider").slick({
				autoplay : true,
				autoplaySpeed :2000,
				arrows : false,
				dots: false,
	    	vertical:true,
	    	draggable : false,
	    	adaptiveHeight: true
			});

			//급상승 검색어 슬라이더
			$(".pwords_slider_flxed").slick({
				autoplay : true,
				autoplaySpeed :2000,
				arrows : false,
				dots: false,
	    	vertical:true,
	    	draggable : false,
	    	adaptiveHeight: true
			});
			$(".live_prd_item").bind("mouseenter",function(){
				LivePrdIsPause = true;
				var idx = $(this).attr('idx');
				var live_prd_title = $("#live_prd_title_"+idx).val();
				var live_prd_price = $("#live_prd_price_"+idx).val();
				var live_prd_saleper = $("#live_prd_saleper_"+idx).val();
				var live_prd_img = $("#live_prd_img_"+idx).val();
				var live_prd_enddate = $("#live_prd_enddate_"+idx).val();
				var live_prd_enddatetime = $("#live_prd_enddatetime_"+idx).val();
				var live_prd_diffdate = $("#live_prd_diffdate_"+idx).val();
				var live_prd_productno = $("#live_prd_productno_"+idx).val();
				var live_prd_productname = $("#live_prd_productname_"+idx).val();
				var live_prd_link = $("#live_prd_link_"+idx).val();
				
				var now = new Date();
				var Today = "2023-04-05";
				
				var saleper = "";
				
				if( parseInt(live_prd_saleper) > 0){
					saleper = "<span class='discount_per'>"+live_prd_saleper+"%</span>";
				}
				
				$(".Live_dt_txt").text(live_prd_title);
				$(".Live_dt_prd_name").text(live_prd_productname);
				$(".Live_dt_prd_price").html(saleper+live_prd_price);
				$(".Live_dt_prd_img > img").attr('src',live_prd_img);
				$(".Live_bnr_link").attr('href',live_prd_link);
				
				if( Today <= live_prd_enddate){
					live_prd_enddatetime = $("#live_prd_enddatetime_"+idx).val();
				  var TimeArr = remaindTime(live_prd_enddatetime);
				  if(LivePrdIsPause){
				  	clearInterval(LivePrdTimer);
					  LivePrdTimer = setInterval(function(){
						   LiveCountDown(live_prd_enddatetime,live_prd_enddate,Today);
						}, 1000);	
					}
				  $(".Live_dt_countDown > .Live_detail_H").text( TimeArr[0] );
				  $(".Live_dt_countDown > .Live_detail_M").text( TimeArr[1] );
				  $(".Live_dt_countDown > .Live_detail_S").text( TimeArr[2] );
					if( Today != live_prd_enddate){
						$(".Live_dt_countDown > .Live_detail_day_area > .Live_detail_D").text( TimeArr[3] );
					  $(".Live_detail_D").show();
					  $(".Live_detail_day_area").show();
					}else{
						$(".Live_detail_day_area").hide();
					}
					$(".Live_detail_H").show();
					$(".Live_detail_M").show();
					$(".Live_detail_S").show();
					$(".Live_detail_comma").show();
					$(".Live_detail_dday").hide();
				}else{
					clearInterval(LivePrdTimer);
					$(".Live_detail_day_area").hide();
					$(".Live_detail_H").hide();
					$(".Live_detail_M").hide();
					$(".Live_detail_S").hide();
					$(".Live_detail_comma").hide();
					$(".Live_detail_dday").show();
					$(".Live_dt_countDown > .Live_detail_dday").text( live_prd_diffdate );
				}
				$(".Live_Dday_contents").addClass('on');
			});
			$(".Live_Dday_contents").bind("mouseleave",function(){
				$(".Live_Dday_contents").removeClass('on');
			});
			$(".nano").nanoScroller({alwaysVisible:true});
			

			$(".cpz_open_btn").bind('click',function(){
				if($(this).hasClass('on')){
					$('.cpz_category_layer').removeClass('_on');
					$(".second_cate_area").hide();
					$(".BigDivLi > a").removeClass('active');
					$(".MediumDivLi > a").removeClass('active');
					$(".cpz_open_btn").removeClass('on');
					$('.cpz_category_layer').removeClass('onscroll');
				}else{
					$('.cpz_open_btn').addClass('on');
					$('.cpz_category_layer').addClass('onscroll');
				}
			});

			$(".cate_close_btn").bind('click',function(){
				$('.cpz_category_layer').removeClass('_on');
				$(".second_cate_area").hide();
				$(".BigDivLi > a").removeClass('active');
				$(".MediumDivLi > a").removeClass('active');
				$(".cpz_open_btn").removeClass('on');
				$('.cpz_category_layer').removeClass('onscroll');
			});

			$(".cpz_category_layer").bind("mouseleave",function(){
				$(".BigDivLi > a").removeClass('active');
				$(this).find('.witharrow').removeClass('active');
				$(".second_cate_area").hide();
				$('.'+$(this).attr('id')).show();
				$('.cpz_category_layer').removeClass('_on');
			});

			// 카테고리 마우스오버 이벤트
			$(".BigDivLi").bind("mouseenter",function(){
				$(".cpz_category_layer").removeClass("cozM");
				$(".BigDivLi > a").removeClass('active');
				$(this).find('.witharrow').addClass('active');
				$(".second_cate_area").hide();
				$(".BigDivLi_gamezone").hide();
				$(".BigDivLi_service").hide();
				$('.'+$(this).attr('id')).show();
				$('.cpz_category_layer').addClass('_on');
			});

			$(".MediumDivLi").bind("mouseenter",function(){
				$(".MediumDivLi > a").removeClass('active');
				$(this).find('.witharrow').addClass('active');
				$(".cozme > a").removeClass('active');
				$(".third_cate_area").hide();
				$('.'+$(this).attr('id')).show();
			});

//			$(".hide_submenu").bind("mouseenter",function(){
//				$(".cpz_category_layer").removeClass("cozM");
//				$(".BigDivLi > a").removeClass('active');
//				$(".second_cate_area").hide();
//				$('.'+$(this).attr('id')).show();
//				$('.cpz_category_layer').removeClass('_on');
//			});

			$("#BigDivLi_gamezone").bind("mouseenter",function(){
				$(".BigDivLi > a").removeClass('active');
				$(".cpz_category_layer").removeClass("cozM");
				$(this).find('.witharrow').addClass('active');
				$(".second_cate_area2").hide();
				$(".BigDivLi_gamezone").show();
				$('.cpz_category_layer').addClass('_on');
			});

			$("#BigDivLi_service").bind("mouseenter",function(){
				$(".BigDivLi > a").removeClass('active');
				$(".cpz_category_layer").removeClass("cozM");
				$(this).find('.witharrow').addClass('active');
				$(".second_cate_area3").hide();
				$(".BigDivLi_service").show();
				$('.cpz_category_layer').addClass('_on');
			});

			$(".cpz_category_layer").bind("mouseleave",function(){
				//$(".cpz_category_layer").removeClass("cozM");
				$(".second_cate_area").hide();
			});

			// 이용후기 레이어 노출
			$("#forusedLayer").bind("mouseenter",function(){
				$(".layerpop").css("display","none");
				$(".iworks").css("display","");
			});

			// 이용후기 레이어 숨김
			$("#forusedLayer").bind("mouseleave",function(){
				$(".iworks").css("display","none");
			});

			// 다이렉트콜 레이어 노출
			$("#direct_call_rgt").bind("mouseenter",function(){
				$(".directpop").hide();
				$(".direct_call_lyr").show();
			});

			$("#direct_call_rgt").bind("mouseleave",function(){
				$(".directpop, .direct_call_lyr").hide();
			});

			//메인 스크롤 상단 고정 스크립트
			if($("#line").length > 0){
				var osTop = $("#line").offset().top;
				var $AllSearchKeyword = $("#HeadSearchKeyword, #fixedSearchKeyword");

				$(window).scroll(function(){
					var position = $(window).scrollTop();
					$AllSearchKeyword.blur();

					if(position < osTop){
						$("#top_fix_head").removeClass('on');
						$(".search21_cover").removeClass('on');
						$("#rightwing_section").removeClass("_fixed");
						$(".pwords_slider_flxed").slick('slickNext');
//						$("#rightwing_section").addClass("_fixed");
					}else{
						$("#top_fix_head").addClass('on');
						$(".search21_cover").addClass('on').hide();
						$("#rightwing_section").addClass("_fixed");
						
					}
				});
			}

			$(window).resize(function(){
				InitRightWingSize();
			});

			//상담센터 우측 날개 롤링
		  $(".counselling_ul").slick({
				autoplay : true,
				autoplaySpeed :3000,
				arrows : true,
				prevArrow: '.cscenter_prev',
				nextArrow: '.cscenter_next',
				dots: false,
				vertical:false,
				draggable : false,
				variableWidth: true,
				adaptiveHeight: true
			});
			
			//나의담당자 마우스오버
			$("#my_manager_info").bind("mouseenter",function(){
				if($("#isManagerShow").val() == 'N'){
					$.ajax({
						dataType:"json",
						async : false,
				  	url: "../include/top_ajax_function.php?actype=getChgCsStaffInfo",
				  	success:function(data){
							if(data.StaffNo != ''){
								$("#managerpop").find(".id_msg").text(data.ChargePart); //상단 텍스트
								$("#managerpop").find(".name").text(data.StaffName); 
								$("#managerpop").find(".id_img > img").attr('src' , '//image3.compuzone.co.kr/img/staff/'+data.StaffNo+'_150.jpg');
								$("#managerpop").find(".id_tel").text(data.PartTel); 
								$("#managerpop").find(".id_lunchtime").text(data.StaffLunchTime); 
								// $(".managerpop > .mymanager > .csinfo > dl > .csinfo_email").text(data.StaffEmail); 
								if(data.StaffVaction == 'Y'){
									$("#managerpop").find("#manager_vaction > #manager_v_name").text(data.OriginStaffName); 
									$("#managerpop").find("#manager_vaction > #manager_v_txt").text("담당자 휴무로 대신 상담해 드립니다."); 
									$("#managerpop").find("#manager_vaction").show();
								}
								if(data.StaffAFK == "Y"){
									$("#managerpop").find("#manager_vaction > #manager_v_name").text(data.StaffName); 
									$("#managerpop").find("#manager_vaction > #manager_v_txt").html("담당자 부재로 대체 담당자가<br>대신 답변 드릴 예정입니다."); 
									$("#managerpop").find("#manager_vaction").show();
								}
								$("#managerpop").find(".id_field_wrap").empty();
								$html = "";
								$(data.ProfArr).each(function(){
									$html += '<span class="id_field blue">'+$(this)[0]+'</span>';
								});
								$html += '<span class="id_field">컴퓨터·부품</span>';
								$("#managerpop").find(".id_field_wrap").append($html);
								$("#isManagerShow").val("Y");
							}
						}
					});
				}
			});

			$('ul.search21_tab li').click(function(){
				var tab_id = $(this).attr('data-tab');
				$('ul.search21_tab li').removeClass('current');
				$('.search21_tabCon').removeClass('current');
				$(this).addClass('current');
				$("#"+tab_id).addClass('current');
			});

			if($(".rankInfo").length >= 2){
				var search21_slide = $('.search21_slide');
				search21_slide.slick({
					slide : 'div',
					slidesToShow:1,
					slidesToScroll:1,
					autoplay:true,
					autoplaySpeed:4000,
					speed:1,
					fade:false,
					cssEase:'linear',
					infinite:true,
					pauseOnHover:false,
					arrows:true,
					prevArrow : $('.search21_btn_L'),
					nextArrow : $('.search21_btn_R'),
					dots:true,
					draggable:true
				});
			}
			
			// 클릭시 검색창 영역
			$(".OpenSearchLayer").click(function(){
				var $thisEl = $(this);
				var $search21_cover = $(".search21_cover");
				var $search21_slide = $(".search21_slide");
				var isEvent = document.search_form.IsEventSearch.value;

				if($thisEl.data("searchtype") == "fixedSearchKeyword"){
					if(isEvent){
						clearBg('fixedSearchKeyword');
					}
					$search21_cover.addClass("on");
				}else{
					if(isEvent){
						clearBg('HeadSearchKeyword');
					}
					$search21_cover.removeClass("on");
				}

				if(isEvent && !$("input[name=SearchProductKey]").val()){
					$thisEl.val("");
					$(".sch_Wdel, sch_Wdel_Bar").hide();
				}
				
				$search21_cover.slideToggle("fast");
				$search21_slide.slick('slickGoTo',0);
			});
			
			$(".OpenSearchLayer").blur(function(){
				var $thisEl = $(this);
				var isEvent = document.search_form.IsEventSearch.value;
				
				if(!isEvent){
					return_search_txt($thisEl.data("searchtype"));
				}
			});
			
					$(".sch_Wdel, .sch_Wdel_Bar").on("click", function(){
				var $thisEl = $(this);
				var $search21_boxWrap  = $(".search21_boxWrap");
				var $search21_boxWrap2 = $(".search21_boxWrap2");
		
				if($thisEl.hasClass("sch_Wdel")){
					var $SearchKeyword = $("#HeadSearchKeyword");
					return_search_txt('HeadSearchKeyword');
				}else if($thisEl.hasClass("sch_Wdel_Bar")){
					var $SearchKeyword = $("#fixedSearchKeyword");
					return_search_txt('fixedSearchKeyword');
				}
				
				$SearchKeyword.val("").focus();
				$(".search21_slide").slick('slickGoTo',0);
				$search21_boxWrap.show();
				$search21_boxWrap2.hide();
				$thisEl.hide();
			});
			
			$("#HeadSearchKeyword, #fixedSearchKeyword").on("paste", function(){
				document.search_form.IsEventSearch.value = "";
				$(".sch_Wdel").show();
			});
			
			var searchItem = -1;
			var searchTimer;
			$(document).on("keyup", function(e){

				var $thisTarget = $(e.target);
				if(($thisTarget.is("input") || $thisTarget.is("textarea")) && $thisTarget.attr('id') != "HeadSearchKeyword" && $thisTarget.attr('id') != "fixedSearchKeyword"){
					return;
				}

				var $thisEl = $(this);
				var $search21_boxWrap = $(".search21_boxWrap");
				var $search21_boxWrap2 = $(".search21_boxWrap2");
				var content = "";
				var isEvent = document.search_form.IsEventSearch.value;
				var isUpDown = false;
				var $HeadSearchKeyword = $("#HeadSearchKeyword");
				var $fixedSearchKeyword = $("#fixedSearchKeyword");
				
				var $searchLayerEl = $('.search21_cover');
				var pressKeyCode = (e.keyCode) ? e.keyCode : e.which;
				var isEventKeyCode = (e.keyCode == 39 || e.keyCode == 145 || e.keyCode == 192 || 
				(e.keyCode >= 9 && e.keyCode <= 20) || (e.keyCode >= 32 && e.keyCode <= 37) || 
				(e.keyCode >= 44 && e.keyCode <= 46) || (e.keyCode >= 91 && e.keyCode <= 123) || 
				(e.keyCode >= 186 && e.keyCode <= 191) || (e.keyCode >= 219 && e.keyCode <= 222) ||
				((e.keyCode == 38 || e.keyCode == 40) && !$searchLayerEl.is(':visible')));
				
				if(e.keyCode == 27){
					$searchLayerEl.hide();
					return;
				}else{
					if(isEventKeyCode){
						return;
					}else if((e.shiftKey || e.ctrlKey || e.altKey) && !$searchLayerEl.is(':visible')){
						return;
					}
				}
				
				if($thisTarget.attr('id') == "HeadSearchKeyword" || $thisTarget.attr('id') == "fixedSearchKeyword"){
					remove_search_txt($thisTarget.attr('id'));
					
					if($thisTarget.attr('id') == "HeadSearchKeyword"){
						$fixedSearchKeyword.val("");
					}else if($thisTarget.attr('id') == "fixedSearchKeyword"){
						$HeadSearchKeyword.val("");
					}
				}

				if($thisTarget.attr('id') == undefined && !$("input[name=SearchProductKey]").val()){
					if(document.search_form.IsEventSearchFixed.value == 1){
						$HeadSearchKeyword.val("");
						$fixedSearchKeyword.val("");
					}
					$(".sch_Wdel, sch_Wdel_Bar").hide();
				}
				
				if($(".top_fix_head").hasClass("on")){
					var $sch_Wdel = $(".sch_Wdel_Bar");
					
					if($thisTarget.attr('id') != "fixedSearchKeyword"){
						var len = $fixedSearchKeyword.val().length;
						$fixedSearchKeyword.focus();
						$fixedSearchKeyword[0].setSelectionRange(len, len);
						$fixedSearchKeyword.val($fixedSearchKeyword.val());
					}
					
					content = $fixedSearchKeyword.val();
				}else{
					var $sch_Wdel = $(".sch_Wdel");
		
					if($thisTarget.attr('id') != "HeadSearchKeyword"){
						var len = $HeadSearchKeyword.val().length;
						$HeadSearchKeyword.focus();
						$HeadSearchKeyword[0].setSelectionRange(len, len);
						$HeadSearchKeyword.val($HeadSearchKeyword.val());
					}
					
					content = $HeadSearchKeyword.val();
				}

				if(content.length == 0 || !content){
					$(".search21_slide").slick('slickGoTo',0);
					$sch_Wdel.hide();
					return;
				}

				$(".sch_Wdel, .sch_Wdel_Bar").hide();
				
				if (content.length >= 1){
					remove_search_txt($thisTarget.attr('id'));
					$sch_Wdel.show();
				}else{
					$(".search21_slide").slick('slickGoTo',0);
					//return_search_txt($thisTarget.attr('id'));
					$sch_Wdel.hide();
					$search21_boxWrap.show();
					$search21_boxWrap2.hide();
				}
				
				if(e.keyCode == 8){
					searchItem = -1;
				}

				if(!isEventKeyCode){
					if((pressKeyCode >= 65 && pressKeyCode <= 90) || (pressKeyCode >= 48 && pressKeyCode <= 57)){
						if(!$searchLayerEl.is(':visible')){
							if($(".top_fix_head").hasClass("on")){
								if(document.search_form.IsEventSearchFixed.value == 1){
									$fixedSearchKeyword.val("");
								}

								document.search_form.IsEventSearchFixed.value = "";
								$searchLayerEl.slideToggle("fast");
								$(".search21_slide").slick('slickGoTo',0);
								$sch_Wdel.hide();
							}else{
								if(document.search_form.IsEventSearchFixed.value == 1){
									$HeadSearchKeyword.val("");
								}

								document.search_form.IsEventSearchFixed.value = "";
								$searchLayerEl.slideToggle("fast");
								$(".search21_slide").slick('slickGoTo',0);
								$sch_Wdel.hide();
							}
						}
						searchItem = -1;
					}else if(pressKeyCode == 38){
						isUpDown = true;
						searchItem--;
					}else if(pressKeyCode == 40){
						isUpDown = true;
						searchItem++;
					}
				}else{
					searchItem = -1;
				}

				if(isUpDown){
					var $searchKeyword = $(".searchKeyword");
					if($thisTarget.attr('id') == "fixedSearchKeyword"){
						var $HeadSearchKeyword = $("#fixedSearchKeyword");
					}else{
						var $HeadSearchKeyword = $("#HeadSearchKeyword");
					}

					if($searchKeyword.length > 0){
						
						if(searchItem < 0){
							searchItem = 0;
						}
						
						if(searchItem >= $searchKeyword.length){
							searchItem = $searchKeyword.length-1;
						}
						
						var $eqSearchItem = $(".eq_"+searchItem);
						
						$searchKeyword.removeClass("on");
						if($eqSearchItem.text()){
							$HeadSearchKeyword.val($eqSearchItem.text());
							$eqSearchItem.addClass("on");
							$sch_Wdel.show();
						}
					}
					return false;
				}


				if (content.length >= 2){
					if (content.length > 80){
						alert("최대 80자까지 입력 가능합니다.");
						$(this).val(content.substring(0, 80));
					}
					clearTimeout(searchTimer);
					$searchLayerEl.show();
					$search21_boxWrap.hide();
					$search21_boxWrap2.show();

					if(delayTimer) {
						console.log(delayTimer);
					  window.clearTimeout( delayTimer );
					}

					delayTimer = window.setTimeout( getSearchResults(content), 400 ); 

				}else{
					$search21_boxWrap.show();
					$search21_boxWrap2.hide();
				}
			});
			
			// [72953] 우측 날개 히스토리 클릭시 dudfkd1223 2021-06-02
			$('.history_tit').click(function() {
				$('.history_popup').show();
			});
			
			$('.history_popup_btn').click(function() {
				$('.history_popup').hide();
				if( $(".miniwingNew").css('display') == 'block'){
					$("#rightwing_section").removeClass('_minisection');
				}
			});
			
			$('.rightwing_xbtn').click(function() {
				$('.miniwingNew').css('display','block');
				$('.rightwing_wrapNew').css('display','none');
			});
			
			$('.miniWzoom').click(function() {
				$('.miniwingNew').css('display','none');
				$('.rightwing_wrapNew').css('display','block');
			});
			
			$('.miniWhistory').click(function() {
				if( $(".miniwingNew").css('display') == 'block'){
					$("#rightwing_section").addClass('_minisection');
				}
				$('.history_popup').css('display','block');
				GetHistoryInfo();
			});
			
			$('.PD_right_recom_box').click(function() {
					$('PD_right_recom_box').css('display','block');
			});
			
		}); // end jQuery
		
		function getSearchResults(content) { 
		  $.ajax({
				type : "POST",
				url : "/search/search_function.php",
				data : { "actype" : "integrateSearch", "keyWord" : content },
				dataType : "html",
				async : true,
				success : function(result) {
					$(".search21_boxWrap2").html(result);
					//console.log(JSON.stringify(result, undefined, 4));
				},
				minLength: 3,
				autoFocus: false,
				error : function(exception) {
					console.log("[Exception] 요청 실패");
					//console.log(JSON.stringify(exception, undefined, 4));
				}
			});
		  delayTimer = null; 
		}

		function InitRightWingSize(){
			if($(window).width() < 1570){
				if( !$("#rightwing_section").hasClass('_minisection')){
					ToggleRightWingBox('out');
					$('.rightwing_wrapNew').hide();
				}
			}else{
				ToggleRightWingBox('in');
				$('.rightwing_wrapNew').show();
			}
		}

		function ToggleRightWingBox(tp){
			if(tp == 'out'){
				$("#rightwing_section").addClass('_minisection');
				$(".miniwingNew").show();
				$("#rightwing_wrap").hide();
				$.cookie("ToggleRightWingBox", 0, { expires: 1, path:"/" });
			}else{
				if($(window).width() >= 1570){
					$("#rightwing_section").removeClass('_minisection');
				}
				$(".miniwingNew").hide();
				$("#rightwing_wrap").show();
				$.cookie("ToggleRightWingBox", 1, { expires: 1, path:"/" });
			}
		}

		// use top_body - start
		function setCookie(name, value, expiredays) {
			var todayDate = new Date();
			todayDate.setDate(todayDate.getDate() + expiredays);
			document.cookie = name + "=" + escape(value) + "; path=/; expires=" + todayDate.toGMTString() + ";"
		}

		function getCookie(name) {
			var nameOfCookie = name + "=";
			var x = 0;
			while (x <= document.cookie.length) {
				var y = (x + nameOfCookie.length);
				if (document.cookie.substring(x, y) == nameOfCookie) {
					if ((endOfCookie = document.cookie.indexOf(";", y)) == -1) {
						endOfCookie = document.cookie.length;
					}
					return unescape(document.cookie.substring(y, endOfCookie));
				}
				x = document.cookie.indexOf(" ", x) + 1;
				if (x == 0)
					break;
			}
			return "";
		}

		// 검색어 제거
		function clearBg(el) {
			if($("#"+el).val()){
				var IsEventSearch = document.search_form.IsEventSearch.value;
				if (IsEventSearch == "1") {
					document.search_form.SearchEventAction.value = document.search_form.action;
					document.search_form.SearchEventText.value = $("#"+el).val();
					document.search_form.SearchEventTarget.value = document.search_form.target;

					document.search_form.SearchProductKey.value = "";
					$("#"+el).val("");
					document.search_form.IsEventSearch.value = "";
					$("#"+el).css("color","");
				}
				$("#"+el).removeClass("blue11").addClass("txt");
				document.search_form.target = '_self';
				document.search_form.action = "https://www.compuzone.co.kr/search/search.htm";
				var jqClsAutoCmpWrap = ".jqClsAutoCmpWrap";
				var jqClsRecentWrap = ".jqClsRecentWrap";
				if(el == 'fixedSearchKeyword') {
					jqClsAutoCmpWrap = ".jqClsAutoCmpWrapFixed";
					jqClsRecentWrap = ".jqClsRecentWrapFixed";
				}
				
				// 새로 정의된 최근 검색어 치환
				if ($("#tmpNewCookSchWord").val()) cook_list.replace($("#tmpNewCookSchWord").val());
			}else{
				return;
			}
			
			if(!$("#"+el).val()){
				$(".search21_boxWrap").show();
				$(".search21_boxWrap2").hide();
				$(".sch_Wdel, .sch_Wdel_Bar").hide();
			}
		}

		// 이벤트 광고 문구 복구
		function return_search_txt(el){
			if($("#"+el).val() == ""){
				$("#"+el).removeClass("txt").addClass("blue11");
				document.search_form.SearchProductKey.value = "";
				$("#"+el).val(document.search_form.SearchEventText.value);
				document.search_form.IsEventSearch.value = "1";
				document.search_form.action = document.search_form.SearchEventAction.value;
				document.search_form.target = document.search_form.SearchEventTarget.value;
			}
		}
		
		// 이벤트 광고 문구 삭제
		function remove_search_txt(el){
			if(document.search_form.IsEventSearch.value == "1"){
				document.search_form.IsEventSearch.value = "";
				document.search_form.action = "";
				document.search_form.target = "";
			}
		}

		// 서브페이지 전체보기 - 카테고리 메뉴로 변경되면서 필요한 부분 2013-02-17 leesb999
		function menu_view(){
			var this_Display = $("#view_Cate").css("display");
			var sele_num = parseInt(0) + 1;
		//	$("#all_category_div").slideToggle("fast");
			$(".AllBrand").removeClass("menuCtgr_2_ON");
			$(".AllBrand").addClass("menuCtgr_2");
			$(".allbrand_menu").css("display","none");
			if(this_Display == "block"){
				$("#view_Cate").css("display","none");
				//카테고리 + - 표시 변경
				//$("#all_cate_li").removeClass("menuCtgr_1_ON");
				//$("#all_cate_li").addClass("menuCtgr_1");
			}else{
				$("#view_Cate").slideDown("fast");
			}
		}

		// 2016-06-13_ne0j0ys_https -> http의 경우 한글 깨짐으로 인하여 url encode 진행함..
		function recom_word_link(sch_key){
			var enc_key = encodeURI(sch_key);
			document.location.href = "https://www.compuzone.co.kr/search/search.htm?SearchProductKey="+enc_key+"&bannerid=RecomSearchTerm";
		}

		$.cookie("search_PcType","",{path:"/online"});
		$.cookie("search_BigDivNo","",{path:"/online"});

		//영타 한글로 변환하는 스크립트
		var e2k = (function() {
			var en_h = "rRseEfaqQtTdwWczxvg";
			var reg_h = "[" + en_h + "]";
			var en_b = {k:0,o:1,i:2,O:3,j:4,p:5,u:6,P:7,h:8,hk:9,ho:10,hl:11,y:12,n:13,nj:14,np:15,nl:16,b:17,m:18,ml:19,l:20};
			var reg_b = "hk|ho|hl|nj|np|nl|ml|k|o|i|O|j|p|u|P|h|y|n|b|m|l";
			var en_f = {"":0,r:1,R:2,rt:3,s:4,sw:5,sg:6,e:7,f:8,fr:9,fa:10,fq:11,ft:12,fx:13,fv:14,fg:15,a:16,q:17,qt:18,t:19,T:20,d:21,w:22,c:23,z:24,x:25,v:26,g:27};
			var reg_f = "rt|sw|sg|fr|fa|fq|ft|fx|fv|fg|qt|r|R|s|e|f|a|q|t|T|d|w|c|z|x|v|g|";
			var reg_exp = new RegExp("("+reg_h+")("+reg_b+")(("+reg_f+")(?=("+reg_h+")("+reg_b+"))|("+reg_f+"))","g");

			var replace = function(str,h,b,f) {
				return String.fromCharCode(en_h.indexOf(h) * 588 + en_b[b] * 28 + en_f[f] + 44032);
			};
			return (function(str) {
				return str.replace(reg_exp,replace);
			});
		})();

		// 검색 시작
		function searchr(el){
			var NowSearchKeyword = $("#"+el);
			var SearchProductKeyView = $("#SearchProductKeyView");
			var HeadSearchKeyword = $("#HeadSearchKeyword");
			var SearchProductKey = $("#SearchProductKey");
			var IsEventSearch = $("#IsEventSearch");
			var IsEventSearchFixed = $("#IsEventSearchFixed");

			if(SearchProductKeyView.val() || !IsEventSearchFixed.val()){
				document.search_form.IsEventSearch.value = "";
			}

			if(!document.search_form.IsEventSearch.value && NowSearchKeyword.val()){
				SearchProductKeyView.val(NowSearchKeyword.val());
			}else{
				if(!document.search_form.IsEventSearch.value && HeadSearchKeyword.val()){
					SearchProductKeyView.val(HeadSearchKeyword.val());
				}
			}
			
			if (!cook_list){
				var cook_list = new cookieList("_coz_recent_word"); // 최근 검색어
			}

			if (SearchProductKeyView.val()) {
				var spKey = specialCharTest(SearchProductKeyView.val().trim());
				SearchProductKeyView.val(spKey);
				cook_list.add(spKey);
			}

			if(!IsEventSearch.val().trim() && !SearchProductKeyView.val().trim() && !HeadSearchKeyword.val().trim() && !NowSearchKeyword.val().trim()){
				alert("검색어를 입력해주세요.");
				NowSearchKeyword.focus();
				return false;
			}
			$.cookie("search_SearchText","",{ expires: -1 });
			if( $("#SearchProductKeyEvtNo").val() ){
				document.location.href = "../event_zone/eventzone_view.htm?EventNo=" + $("#SearchProductKeyEvtNo").val();
			}
			else{
				//post시 브라우져 인코딩이 유니코드의 경우 한글이 깨져 encodeURI를 해준다 단 받는 페이지에서
				//rawurldecode($SearchProductKey);와 iconv("utf-8","CP949",$SearchProductKey);로 변환해줘야 한다.
				//search/search.htm search_list.php페이지에 있음
				if(document.search_form.IsEventSearch.value == "1"){
					document.search_form.submit();
				}else{
					// 중복 검색 방지
					if(document.search_form.SearchProductKeyView.value != document.getElementById("TmpSearchProductKeyView").value){
						document.search_form.SearchProductKey.value = encodeURI(document.search_form.SearchProductKeyView.value.replace(/ /gi,"+"));
						document.location.href = "https://www.compuzone.co.kr/search/search.htm?Seargbl="+document.search_form.Seargbl.value+"&hidden_Txt="+document.search_form.hidden_Txt.value+"&IsEventSearch="+encodeURI(document.search_form.IsEventSearch.value)+"&SearchProductKey="+document.search_form.SearchProductKey.value;
						document.getElementById("TmpSearchProductKeyView").value = document.search_form.SearchProductKeyView.value;
					}
				}
			}
		}
		// use top_body - end

		// use top_body_login - start
		function sub_view(etype){
			if(etype=="Y"){
				document.getElementById("mypage_sub").style.display="";
			}else{
				document.getElementById("mypage_sub").style.display="none";
			}
		}
		// use top_body_login - end

		// 다이렉트 콜 신청
		function direct_call_req(arg){
			$.post('../commfaq/qna_function.php',{'actype':'getDirectCallState','CallType':arg},function (ret_data){
				if (ret_data == '0') {
					alert('죄송합니다.\n다이렉트콜 신청 중 오류가 발생하였습니다.\n잠시 후 다시 시도해주시기 바랍니다.');
					return;
				} else {
					if (confirm(ret_data)) {
						$.post('../commfaq/qna_function.php',{'actype':'reqDirectCall','CallType':arg},function (ret_data){
							if (ret_data == '0') {
								alert('죄송합니다.\n다이렉트콜 신청 중 오류가 발생하였습니다.\n잠시 후 다시 시도해주시기 바랍니다.');
								return;
							} else {
								alert('정상적으로 신청되었습니다.\n답변 예상 시간 : '+ret_data);
								$('.directpop, .direct_call_lyr').hide();
							}
						});
					}
				}
			});
		}

		/**
			2017-10-11_ne0j0ys_최근 검색어 관련
		*/
		// 쿠키 배열 처리
		var cookieList = function (cook_name){
			var exist_cook = ($.cookie(cook_name)) ? $.cookie(cook_name) : "";
			var _items = exist_cook ? exist_cook.split("^") : new Array();

			return {
				"add"	: function (cVal){
					cVal = encodeURIComponent(cVal);
					_items.unshift(cVal);
					if(_items.length > 20) _items.length = 20;
					$.cookie(cook_name, _items.join('^'), {expires:30, path:'/'});
				},
				"remove" : function (cVal){
					var idx = exist_cook.indexOf(cVal);
					if (idx != -1) {
						var itemCnt = _items.length;
						var tmpCook = '';
						for( i = 0 ; i < itemCnt ; i++ ){
							if( _items[i] == cVal ){
								continue;
							}
							if( tmpCook ){ tmpCook += '^'; }
							tmpCook += _items[i];
						}
						$.cookie(cook_name, tmpCook, {expires:30, path:'/'});
						$("#tmpNewCookSchWord").val(tmpCook);
					}
				},
				"replace" : function (cVal){
					$.cookie(cook_name, cVal, {expires:30, path:'/'});
				},
				"clear" : function (){
					_items = null;
					$.removeCookie(cook_name, {path:'/'});
				},
				"items" : function (){
					return _items;
				}
			}
		}

		// 검색어 삭제
		function del_cook_word(arg, word, idx){
			if (arg == "clear") {
				$("#tmpNewCookSchWord").val("");
				cook_list.clear();
				$(".jqClsSchUl").replaceWith("<div class=\"listnone\">최근 검색 내역이 없습니다.</div>");
			} else {
				$(".jqClsSchLi_" + idx).remove();
				cook_list.remove(word);
				if (!$(".jqClsSchLi").length) {
					$(".jqClsSchUl").replaceWith("<div class=\"listnone\">최근 검색 내역이 없습니다.</div>");
				}
			}
		}
		
		// 레이어 검색어 삭제
		function del_layer_cook_word(arg, word, idx){
			if (arg == "clear") {
				$("#tmpNewCookSchWord").val("");
				cook_list.clear();
				$(".recent_search_word_list").replaceWith("<div class=\"search_nothing\">최근 검색내역이 없습니다.</div>");
				$(".lastKeywordAllDel").hide();
			} else {
				$(".recent_search_word_" + idx).remove();
				cook_list.remove(word);
				if (!$(".recent_search_word").length) {
					$(".recent_search_word_list").replaceWith("<div class=\"search_nothing\">최근 검색내역이 없습니다.</div>");
				}
			}
		}
		
		// 검색어 선택
		function sch_cook_word(word,evtno){
			if( evtno ){
				document.location.href = "../event_zone/eventzone_view.htm?EventNo=" + evtno;
			}
			else{
				clearBg("HeadSearchKeyword");
				$("#SearchProductKeyView, #HeadSearchKeyword").val(word);
				searchr();
			}
		}

		//급상승 검색어에서 검색
		function sch_rank_word(word,rank){
			var SearchProductKeyView = $("#SearchProductKeyView");
			SearchProductKeyView.val(word);
			if(document.search_form.SearchProductKeyView.value != document.getElementById("TmpSearchProductKeyView").value){
				document.search_form.SearchProductKey.value = encodeURI(document.search_form.SearchProductKeyView.value.replace(/ /gi,"+"));
				document.location.href = "https://www.compuzone.co.kr/search/search.htm?Seargbl="+document.search_form.Seargbl.value+"&hidden_Txt="+document.search_form.hidden_Txt.value+"&IsEventSearch="+encodeURI(document.search_form.IsEventSearch.value)+"&SearchProductKey="+document.search_form.SearchProductKey.value+"&IsSoaring=Y&SKL_Rank="+rank;
				document.getElementById("TmpSearchProductKeyView").value = document.search_form.SearchProductKeyView.value;
			}
			
			var cook_list = new cookieList("_coz_recent_word");
			if (SearchProductKeyView.val()) {
				var spKey = specialCharTest(SearchProductKeyView.val());
				SearchProductKeyView.val(spKey);
				cook_list.add(spKey);
			}
		}

		// 검색어 레이어 제거
		function sch_lyr_cls(){
			$(".search_dropbox").hide();
		}

		// 최근 검색어
		var cook_list = new cookieList("_coz_recent_word");
		// use right_menu_body - end

		// 특수문자 검증
		function specialCharTest(str){
			var retStr = str;
			//var specialRegExp = /[\{\}\[\]\/?.,;:|\)*~`!^\-_+<>@\#$%&\\\=\(\'\"]/gi;
			// 아이웍스 네이밍 변경에 따른 하이픈(\-) 예외처리	newcozlch	2019-08-12 오후 2:23:10
			// : + ~ ( ) , 허용 newcozlch 	2022-04-20 09:27:37
			var specialRegExp = /[\{\}\[\]\/?;|*`!^_<>@\#$%&\\\=\'\"]/gi;

		  if (specialRegExp.test(str)) {
		 		retStr = str.replace(specialRegExp, "");
		  }
		  return retStr;
		}

		function couponClose(){
			$(".bonus").hide();
			$.cookie("noAlertCoupon", 1, { expires: 7, path:"/" });
		}

		// 급상승 검색어 탭
		function pwordsTab(el){
			$(".pwords_tab").removeClass('on');
			$(".fixed_pwords_tab").removeClass('on');
			$("."+el).addClass('on');
			$(".pwords_list").removeClass('on');
			$("."+el).addClass('on');

		}
		
		//나의담당자 리스트 노출
		function getChgCsStaff(){
			$.ajax({
		  	url: "../include/top_ajax_function.php?actype=getChgCsStaff",
		  	success:function(html){
					$("#staff_info_box").html(html);
					$("#staff_chg_dimmed").show();
					TabChgCsStaff();
	  		}
			});
		}
		
		//나의담당자 레이어 닫기
		function closeChgCsStaff(){
			$("#staff_chg_dimmed").hide();
			$("#staff_info_box").empty();
		}
		
		//나의담당자 탭변경 
		function TabChgCsStaff(){
			$('.top_tabcontent > div').hide();
			$('.top_tabnav a').click(function () {
				$('.top_tabcontent > div').hide().filter(this.hash).fadeIn();
				$('.top_tabnav a').removeClass('active');
				$(this).addClass('active');
				return false;
			}).filter(':eq(0)').click();
		}
		
		//나의담당자 변경
		function ActChgCsStaff(staffName){
			// 동명이인 처리 : 이름에 2 제거
			//if($Staff_Name=='db 이름')
			//	$Staff_Name = '노출 이름';
			if(staffName == "") return;
			if(staffName=='김민성') staffName = '김민성2';
			
			if(confirm("담당자를 변경하시겠습니까?")){
				$.ajax({
					dataType:"json",
					async : false,
					url: "../mypage/mypage_function.php?actype=select_charger&staff_name="+staffName+"&fromPage=topPage",
					success:function(data){
						$('#manager_vaction').css('display', 'none'); 
						getChgCsStaffInfo(staffName);
						alert('변경되었습니다.');
						closeChgCsStaff();
					},
					error:function(request,status,error){
					 	closeChgCsStaff();
					}
				});
			}
		}
		//담당자 변경후 봐꿔치기하기 
		function getChgCsStaffInfo(StaffName){
			$.ajax({
				dataType:"json",
				async : false,
				url: "../include/top_ajax_function.php?actype=getChgCsStaffInfo&StaffName="+StaffName,
				success:function(data){
					if(data.StaffNo != ''){
						$("#managerpop").find(".id_msg").text(data.ChargePart); //상단 텍스트
						$("#managerpop").find(".name").text(data.StaffName); 
						$("#managerpop").find(".id_img > img").attr('src' , '//image3.compuzone.co.kr/img/staff/'+data.StaffNo+'_150.jpg');
						$("#managerpop").find(".id_tel").text(data.PartTel); 
						$("#managerpop").find(".id_lunchtime").text(data.StaffLunchTime); 
						// $(".managerpop > .mymanager > .csinfo > dl > .csinfo_email").text(data.StaffEmail); 
						if(data.StaffVaction == 'Y'){
							$('#manager_vaction').css('display', 'block'); 
							$("#managerpop").find("#manager_vaction > #manager_v_name").text(data.OriginStaffName); 
							$("#managerpop").find("#manager_vaction > #manager_v_txt").text("담당자 휴무로 대신 상담해 드립니다."); 
							$("#managerpop").find("#manager_vaction").show();
						}
						if(data.StaffAFK == "Y"){
							$('#manager_vaction').css('display', 'block'); 
							$("#managerpop").find("#manager_vaction > #manager_v_name").text(data.StaffName); 
							var manager_v_txt = "담당자 부재로 대체 담당자가 <br> 대신 답변 드릴 예정입니다"; 
							$("#managerpop").find("#manager_vaction > #manager_v_txt").html(manager_v_txt);  
							$("#managerpop").find("#manager_vaction").show();
						}
						$("#managerpop").find(".id_field_wrap").empty();
						$html = "";
						$(data.ProfArr).each(function(){
							$html += '<span class="id_field blue">'+$(this)[0]+'</span>';
						});
						$html += '<span class="id_field">컴퓨터·부품</span>';
						$("#managerpop").find(".id_field_wrap").append($html);
						$("#isManagerShow").val("Y");
					}
				},
				error:function(request,status,error){
					console.log(error);
				}
			});		
		}
		
		// 내 검색어 저장
		$(document).on("click", ".search_strGray", function(){
			var searchWord = $(this).data("word");
			var myFavoriteWordCount = $(".myFavoriteWordList").length;

			$.ajax({
				type : "POST",
				url : "/search/search_function.php",
				data : {"actype" : "myFavoriteWord", "searchWord" : searchWord },
				dataType : "json",
				async : false,
				success : function(result) {
					$(".addStar").text(result.message);
					$(".latelyKeyword").fadeIn(function(){
						setTimeout(function(){
							$(".latelyKeyword").fadeOut();
						},1000);
					});
					
					if(result.code == 200){
						var html = '';
						if(myFavoriteWordCount <= 0){
							html += '<div id="tab-2" class="search21_tabCon myFavoriteWordArea current">';
							html += '<div class="search21_word">';
							html += '<ul class="myFavoriteWordInfo">';
						}
						html += '<li class="words_list myFavoriteWordList">';
						html += '	<i class=""></i><a href="javascript:void(0);" onclick="sch_cook_word(\''+searchWord+'\');">'+searchWord+'</a>';
						html += '	<button class="search21_wordX searchWordDelete" data-word="'+searchWord+'"></button>';
						html += '</li>';
						if(myFavoriteWordCount <= 0){
							html += '</ul>';
							html += '<div class="btm"><button type="button" class="searchWordDelete all_x" data-word="전체삭제">전체삭제</button></div>';
							html += '</div>';
							
							$("#tab-2").remove();
							$("div.MyKeywordNone").remove();
							$("div.search21_wordTab").append(html);
						}else{
							$("ul.myFavoriteWordInfo").append(html);
						}
						$('[data-tab="tab-2"]').trigger("click");
					}
				},
				error : function(exception) {
					alert("[Exception] 요청 실패");
					console.log(JSON.stringify(exception, undefined, 4));
				}
			});
		});

		// 내 검색어 삭제
		$(document).on("click", ".searchWordDelete", function(){
			var searchWord = $(this).data("word");
			var thisLi = $(this).parent("li");
			var allDelete = $(this).hasClass("all_x") ? "Y" : "N";
			if(!$(".myFavoriteWordList").length){
				alert("삭제할 내역이 없습니다.");
				return false;
			}

			$.ajax({
				type : "POST",
				url : "/search/search_function.php",
				data : {"actype" : "myFavoriteWordDelete", "searchWord" : searchWord , "allDelete" : allDelete },
				dataType : "json",
				async : false,
				success : function(result) {
					
					if(allDelete == "N"){
						thisLi.remove();
					}

					if (!$(".myFavoriteWordList").length || allDelete == "Y") {
						$(".myFavoriteWordArea").replaceWith("<div class=\"search_nothing MyKeywordNone\">저장된 내 검색어가 없습니다.</div>");
					}
				},
				error : function(exception) {
					alert("[Exception] 요청 실패");
					console.log(JSON.stringify(exception, undefined, 4));
				}
			});
		});
		
		// 조회수
		$(document).on("click", ".searchLog", function(){
			var logType = $(this).data("ltype");
			var searchKeyword = $(this).data("word");

			$.ajax({
				type : "POST",
				url : "/search/search_function.php",
				data : {"actype" : "SearchKeywordViewLog", "logType" : logType , "searchKeyword" : searchKeyword },
				dataType : "json",
				async : false,
				success : function(result) {
					if(!result.isSeccess){
						console.log("failed search..");
						return false;
					}
				},
				error : function(exception) {
					alert("[Exception] 요청 실패");
					console.log(JSON.stringify(exception, undefined, 4));
				}
			});
		});
		
		$(document).on("click", ".search_closeX", function(){
			$(".search21_cover").slideToggle("fast");
		});

		$(document).click(function(e){
			var $search21_boxWrap = $(".search21_boxWrap");
			var $search21_boxWrap2 = $(".search21_boxWrap2");
		
			if(!$(e.target).hasClass("sch_Wdel") && !$(e.target).hasClass("sch_Wdel_Bar") && !$(e.target).hasClass("OpenSearchLayer") && !$(e.target).hasClass("searchWordDelete") && !$(e.target).hasClass("search21_wordX") && !$search21_boxWrap.is(e.target) && $search21_boxWrap.has(e.target).length === 0 && !$search21_boxWrap2.is(e.target) && $search21_boxWrap2.has(e.target).length === 0){
				$(".search21_cover").hide();
			}
		});
		
			// [72953] 우측 퀵 메뉴 개선 dudfkd1223 2021-06-01
		function GetProductInfo(ProductNo){
			var chk = false;
			var ajax_url = "../include/top_ajax_function.php?actype=GetProductInfo&ProductNo="+ProductNo;
			if($("#pd_price_info_"+ProductNo).hasClass('info_ck') == false){
				$.ajax({
					type:'post',
					url:ajax_url,
					success:function(html){
						if(html != 0){
							$("#pd_price_info_"+ProductNo).append(html);
							$("#pd_price_info_"+ProductNo).addClass('info_ck');
						}
					}
				});	
			}
		}
		
		// [72953] 우측 퀵 메뉴 개선 dudfkd1223 2021-06-01
		function GetEventInfo(EventNo){
			var chk = false;
			var ajax_url = "../include/top_ajax_function.php?actype=GetEventInfo&EventNo="+EventNo;
			if($("#pd_price_info_"+EventNo).hasClass('info_ck') == false){
				$.ajax({
					type:'post',
					url:ajax_url,
					success:function(html){
						if(html != 0){
							$("#pd_price_info_"+EventNo).append(html);
							$("#pd_price_info_"+EventNo).addClass('info_ck');
						}
					}
				});	
			}
		}
		
		// [72953] 히스토리 레이어 dudfkd1223 2021-06-01
		function GetHistoryInfo(){
			var chk = false;
			var ajax_url = "../include/top_ajax_function.php?actype=GetHistoryInfo";
			if($("#tset_history").hasClass('history_ck') == false){
				$.ajax({
					type:'post',
					url:ajax_url,
					success:function(html){
						if(html != 0){
							$("#tset_history").append(html);
							$("#tset_history").addClass('history_ck');
						}
					}
				});	
			}
		}
		
		// [72953] 히스토리 레이어 전체 선택, 상품, 이벤트  dudfkd1223 2021-06-01
		function change_history(ch_type){
			var ajax_url = "../include/top_ajax_function.php?actype=GetHistoryInfo";
			$.ajax({
				type:'post',
				url:ajax_url,
				data : {
						"ch_type" : ch_type
				},
				dataType : "html",
				success:function(result){
					$("#tset_history").empty();
					$("#tset_history").append(result);
				}
			});	
		}
		
		// [72953] 쿠키 삭제 및 재정의 dudfkd1223 2021-06-03
		function delete_cookie(pno, del_type, state){
			if(state == '3'){
				var Del_Confirm = confirm("전체 내역을 삭제하시겠습니까?"); 
			}else {
				var Del_Confirm = true;
			}
			if(Del_Confirm == true){
				var ajax_url = "../include/top_ajax_function.php?actype=DeleteCookie";
				$.ajax({
					type:'post',
					url:ajax_url,
					data : {
							"pno" : pno,
							"del_type" : del_type
					},
					dataType : "json",
					success:function(result){
						location.reload();
					}
				});	
			}
		}
		
		// [72953] 관심상품 버튼 로그인 확인 dudfkd1223 2021-06-03
		function wish_list_chk(sess_type){
			if(sess_type == 'N'){
				var sess_Confirm = confirm("로그인 후 이용이 가능합니다."); 
			}else {
				location.href='../mypage/wish_list.htm';
			}
			if(sess_Confirm == true){
				location.href='../login/login.htm';
			}
		}
	
	
	