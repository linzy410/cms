<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
		<title>TOP MARQUES 上海奢侈品展:::博锐会展 BORRISON:::2013年10月25日-27日 上海展览中心</title>
		<Meta name="Keywords" Content="奢侈品展"/>
		<Meta name="description" content="TOP MARQUES"/>
		<link href="/css/style.css" rel="stylesheet" type="text/css"/>
		<link rel="shortcut icon" type="image/x-icon" href="/favicon.ico"/>
		<script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="/js/common.js"></script>
		<script>
		$(function() {
			var sWidth = $("#focus").width(); //获取焦点图的宽度（显示面积）
			var len = $("#focus ul li").length; //获取焦点图个数
			var index = 0;
			var picTimer;
			
			//以下代码添加数字按钮和按钮后的半透明条，还有上一页、下一页两个按钮
			var btn = "<div class='btnBg'></div><div class='btn'>";
			for(var i=0; i < len; i++) {
				btn += "<span></span>";
			}
			btn += "</div><div class='preNext pre'></div><div class='preNext next'></div>";
			$("#focus").append(btn);
			$("#focus .btnBg").css("opacity",0.5);

			//为小按钮添加鼠标滑入事件，以显示相应的内容
			$("#focus .btn span").css("opacity",0.4).mouseover(function() {
				index = $("#focus .btn span").index(this);
				showPics(index);
			}).eq(0).trigger("mouseover");

			//上一页、下一页按钮透明度处理
			$("#focus .preNext").css("opacity",0.2).hover(function() {
				$(this).stop(true,false).animate({"opacity":"0.5"},300);
			},function() {
				$(this).stop(true,false).animate({"opacity":"0.2"},300);
			});

			//上一页按钮
			$("#focus .pre").click(function() {
				index -= 1;
				if(index == -1) {index = len - 1;}
				showPics(index);
			});

			//下一页按钮
			$("#focus .next").click(function() {
				index += 1;
				if(index == len) {index = 0;}
				showPics(index);
			});

			//本例为左右滚动，即所有li元素都是在同一排向左浮动，所以这里需要计算出外围ul元素的宽度
			$("#focus ul").css("width",sWidth * (len));
			
			//鼠标滑上焦点图时停止自动播放，滑出时开始自动播放
			$("#focus").hover(function() {
				clearInterval(picTimer);
			},function() {
				picTimer = setInterval(function() {
					showPics(index);
					index++;
					if(index == len) {index = 0;}
				},4000); //此4000代表自动播放的间隔，单位：毫秒
			}).trigger("mouseleave");
			
			//显示图片函数，根据接收的index值显示相应的内容
			function showPics(index) { //普通切换
				var nowLeft = -index*sWidth; //根据index值计算ul元素的left值
				$("#focus ul").stop(true,false).animate({"left":nowLeft},300); //通过animate()调整ul元素滚动到计算出的position
				//$("#focus .btn span").removeClass("on").eq(index).addClass("on"); //为当前的按钮切换到选中的效果
				$("#focus .btn span").stop(true,false).animate({"opacity":"0.4"},350).eq(index).stop(true,false).animate({"opacity":"1"},300); //为当前的按钮切换到选中的效果
			}
		});
		</script>
	</head>
	<body>
		<div class="box head">
			<h2><a href="cn/index.html">TOP MARQUES 上海奢侈品展:::博锐会展 BORRISON:::2013年10月25日-27日 上海展览中心</a></h2>
			<h3 class="cn">2013年10月25日-27日 上海展览中心</h3>
		</div>
		<div class="box menubar">
			<div class="menu_cn">
				<a href="cn/" id="menu0">首页</a>
				<a href="cn/1/Dates&Facts/" id="menu1">展会概况</a>
				<a href="cn/2/Exhibitor/" id="menu2">展商类别</a>
				<a href="cn/3/Visitor/" id="menu3">观众来源</a>
				<a href="cn/news/" id="menu16">新闻资讯</a>
				<a href="cn/5/Partiners/" id="menu5">合作伙伴</a>
				<a href="cn/6/Services/" id="menu6">展会服务</a>
				<a href="cn/7/Review/" id="menu7">往届回顾</a>
				<a href="cn/8/Contact/" id="menu8">联系博税</a>
		
			</div>
			<div class="lan">
				<a href="cn" id="cn">中文</a>
				<a href="en" id="en">English</a>
			</div>
		</div>
		<script>$('#menu0').addClass('hover')</script>
		<div class="main">
    		<div id="focus">
				<ul>
					<li><a href="http://www.jsfoot.com/" target="_blank"><img src="/upload/2012529182600.jpg"></a></li>
					<li><a href="http://www.jsfoot.com/" target="_blank"><img src="/upload/20125291826260.jpg"></a></li>
					<li><a href="http://www.jsfoot.com/" target="_blank"><img src="/upload/20125291826410.jpg"></a></li>
				</ul>
			</div>
<!--			<div class="intro">-->
<!--			-->
<!--			<ul class="a">-->
<!--				<li style="display: block"><img src="attached/20125291825440.jpg" alt="TOP MARQUES Shanghai image1" title="TOP MARQUES Shanghai image1"></li>-->
<!--				<li><img src="attached/2012529182600.jpg" title="TOP MARQUES Shanghai image2"></li>-->
<!--				<li><img src="attached/20125291826140.jpg" title="TOP MARQUES Shanghai image3"></li>-->
<!--				<li><img src="attached/20125291826260.jpg" title="TOP MARQUES Shanghai image4"></li>-->
<!--				<li><img src="attached/20125291826410.jpg" title="TOP MARQUES Shanghai image5"></li>-->
<!--				<li><img src="attached/20125291826550.jpg" title="TOP MARQUES Shanghai image6"></li>-->
<!--				<li><img src="attached/20125291827100.jpg" title="TOP MARQUES Shanghai image7"></li>-->
<!--				<li><img src="attached/20125291827290.jpg" title="TOP MARQUES Shanghai image8"></li>-->
<!--			</ul>-->
<!--			<div class="t">-->
<!--			<h4 style="display: block">TOP MARQUES Shanghai image1</h4>-->
<!--			<h4>TOP MARQUES Shanghai image2</h4>-->
<!--			<h4>TOP MARQUES Shanghai image3</h4>-->
<!--			<h4>TOP MARQUES Shanghai image4</h4>-->
<!--			<h4>TOP MARQUES Shanghai image5</h4>-->
<!--			<h4>TOP MARQUES Shanghai image6</h4>-->
<!--			<h4>TOP MARQUES Shanghai image7</h4>-->
<!--			<h4>TOP MARQUES Shanghai image8</h4>-->
<!--			</div>-->
<!--			<div class="n"><a class="hover">1</a><a>2</a><a>3</a><a>4</a><a>5</a><a>6</a><a>7</a><a>8</a></div>-->
<!--			<div class="bar"></div>-->
<!--		</div>-->
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
		<script type="text/javascript">
		$(function(){
		var sw = 1;
		function myShow(i) {
			$(".customers li").eq(i).stop(true, true).fadeIn(800).siblings("li").fadeOut(800);
		}
		$(".customers").hover(function() {
			if (myTime) {
				clearInterval(myTime)
			}
		},
		function() {
			myTime = setInterval(function() {
				myShow(sw);
				sw++;
				if (sw ==3) {
					sw=0
				}
			},
			3000)
		});
		var myTime = setInterval(function() {
			myShow(sw);
			sw++;
			if (sw ==3){
				sw=0
			}
		},
		3000);
		});
		</script>
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
