<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>TOP MARQUES 上海奢侈品展:::博锐会展 BORRISON:::2013年10月25日-27日 上海展览中心</title>
		<link href="/css/style.css" rel="stylesheet" type="text/css"/>
		<link rel="shortcut icon" type="image/x-icon" href="/favicon.ico"/>
		<script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="/js/common.js"></script>
		<style type="text/css">
		</style>
		<script>
			$(function() {
				var href = window.location.href;
				$(".mainmenu a").each(function(){
					if (this.href==href){
						$(this).parent().addClass("current");
					}
				});
			});
		</script>
	</head>
	<body>
		<div class="box head">
			<h2><a href="cn/index.html">TOP MARQUES 上海奢侈品展:::博锐会展 BORRISON:::2013年10月25日-27日 上海展览中心</a></h2>
			<h3 class="cn">2013年10月25日-27日 上海展览中心</h3>
		</div>
		<div class="mainmenu" id="mo_menu">
			<ul>
				<s:iterator value="menus">
					<li id="li_menu_${id}">
					<a href="<s:if test='type==1'>/${nameEnSiteShow}-${id}</s:if><s:elseif test='type==2'>${url}</s:elseif><s:elseif test='type==3'>/news/${id}</s:elseif>">${name}</a>
					</li>
				</s:iterator>
			</ul>
		</div>
		<div class="main">
    		<div id="focus">
				<ul>
					<li><a href="#" target="_blank"><img src="/upload/2012529182600.jpg"/></a></li>
					<li><a href="#" target="_blank"><img src="/upload/20125291826260.jpg"/></a></li>
					<li><a href="#" target="_blank"><img src="/upload/20125291826410.jpg"/></a></li>
				</ul>
			</div>
		  <div class="center"> <a href="cn/news/" id="news">新闻</a> 
		    <div class="cn_Topnews"> 
		      
		<a href="cn/news/detail/Ducati/576.html" title="杜卡迪Ducati上海新展厅正式开幕"><h4>杜卡迪Ducati上海新展厅正式开幕<img src="images/systemimg/Iconew.gif" style="position:absolute;margin:5px 0 0 5px"></h4></a>
		
		<a href="cn/news/detail/Lamborghini/575.html" title="兰博基尼 Lamborghini 推出50周年限量版超跑 Veneno"><h4>兰博基尼 Lamborghini 推出50周年限量版超…</h4></a>
		
		<a href="cn/news/detail/JUVENIA/573.html" title="展商新品 - JUVENIA TOURBILLON 尊皇陀飞轮腕表"><h4>展商新品 - JUVENIA TOURBILLON 尊皇陀飞…<img src="images/systemimg/Icohot.gif" style="position:absolute;margin:5px 0 0 5px"></h4></a>
		
		<a href="cn/news/detail/Cadillac/570.html" title="国际巨星布拉德·皮特代言全新豪华轿车凯迪拉克XTS"><h4>国际巨星布拉德·皮特代言全新豪华轿车凯迪…</h4></a>
		
		<a href="cn/news/detail/MV-Agusta/569.html" title="意大利顶级摩托车MV Agusta亮相TOP MARQUES 2013！"><h4>意大利顶级摩托车MV Agusta亮相TOP MARQU…</h4></a>
		
		<a href="cn/news/detail/EXTRAVAGANZA/568.html" title="EXTRAVAGANZA Haitang Bay 2013 三亚海棠湾精致生活展"><h4>EXTRAVAGANZA Haitang Bay 2013 三亚海棠…</h4></a>
		
		<a href="cn/news/detail/TOP-MARQUES/566.html" title="TOP MARQUES业界焦点：中国消费者成为世界最大的奢侈品消费群体"><h4>TOP MARQUES业界焦点：中国消费者成为世界…</h4></a>
		
		    </div>
		    <div class="main_btn"> <a href="cn/gallery/Exhibitors&Booths/" id="gallery">图库</a> 
		      <a href="cn/videos/" id="videos">视频</a> </div>
		  </div>
			<div class="right">
				<div class="customers"> 
					<ul>
						<li style="display:block"><img src="images/pc_customers_logo1.gif"></li>
						<li><img src="images/pc_customers_logo2.gif"></li>
						<li><img src="images/pc_customers_logo3.gif"></li>
					</ul>
				</div>
			</div>
			<div class="clear"></div>
		</div>
		<div class="box foot clear">
			<strong>Celebrating the 16th Edition of Top Marques in China</strong>
			<p>Borrison / Luxuery Events Organiser</p>
		</div>
		<div style="height:30px"></div>
		<p>&nbsp;</p>
		<p align="center">沪ICP备07508629号-4<a href="http://www.sgs.gov.cn/lz/licenseLink.do?method=licenceView&entyId=20120417163158237" target="_blank"> <img src="images/icon4.gif" alt="上海工商亮照标识" width="25" height="25"></a></p>
	</body>
</html>
