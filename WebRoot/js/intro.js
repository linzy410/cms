$(function(){
var ic = $("#u-intro > li").size();
var sw = 1;
$(".intro .n a").click(function() {
	sw = $(".n a").index(this);
	myShow(sw)
});
function myShow(i) {
	$(".intro .n a").eq(i).addClass("hover").siblings("a").removeClass("hover");
	$(".intro .a li").eq(i).stop(true, true).fadeIn(800).siblings("li").fadeOut(800);
	$(".intro .t h4").eq(i).stop(true, true).fadeIn(800).siblings("h4").fadeOut(800);
}
$(".intro").hover(function() {
	if (myTime) {
		clearInterval(myTime)
	}
},
function() {
	myTime = setInterval(function() {
		myShow(sw);
		sw++;
		if (sw == ic) {
			sw = 0
		}
	},
	3000)
});
var myTime = setInterval(function() {
	myShow(sw);
	sw++;
	if (sw == ic) {
		sw = 0
	}
},
3000);
});
