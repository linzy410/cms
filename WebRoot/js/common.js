//flash用js调用
function F_viewSwf(width, height, wmode,ffwmode, url){
	document.write("<object classid='clsid:d27cdb6e-ae6d-11cf-96b8-444553540000' ");
	document.write("		codebase='http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0' ");
	document.write("		width='"+width+"' height='"+height+"' align='middle'>");
	document.write("	<param name='allowScriptAccess' value='always' /> ");
	document.write("	<param name='movie'	value='"+url+"' /> ");
	document.write("	<param name='quality' value='high' /> ");
	document.write("	<param name='menu' value='false'> ");
	document.write("	<param name='wmode'	value='"+wmode+"'> ");
	document.write("	<embed src='"+url+"' quality='high' wmode='"+ffwmode+"' menu='false' width='"+width+"' height='"+height+"' align='middle' ");
	document.write("		allowScriptAccess='sameDomain' type='application/x-shockwave-flash' ");
	document.write("		pluginspage='http://www.macromedia.com/go/getflashplayer' />");
	document.write("</object>");
}
//代码结束
//实例:  <script>F_viewSwf('170','15','transparent','transparent','images/index.swf')</script->//

//平滑滚动 锚点链接
function intval(v)
{    
v = parseInt(v);    
return isNaN(v) ? 0 : v;
} 
// 获取元素信息
function getPos(e)
{    
var l = 0;    
var t  = 0;    
var w = intval(e.style.width);    
var h = intval(e.style.height);    
var wb = e.offsetWidth;    
var hb = e.offsetHeight;    
while (e.offsetParent)
{       
l += e.offsetLeft + (e.currentStyle?intval(e.currentStyle.borderLeftWidth):0);        
t += e.offsetTop  + (e.currentStyle?intval(e.currentStyle.borderTopWidth):0);        
e = e.offsetParent;    
}    
l += e.offsetLeft + (e.currentStyle?intval(e.currentStyle.borderLeftWidth):0);    
t  += e.offsetTop  + (e.currentStyle?intval(e.currentStyle.borderTopWidth):0);    
return {x:l, y:t, w:w, h:h, wb:wb, hb:hb}; } 
// 获取滚动条信息
function getScroll() 
{    
var t, l, w, h;         
if (document.documentElement && document.documentElement.scrollTop)
{        
t = document.documentElement.scrollTop;        
l = document.documentElement.scrollLeft;        
w = document.documentElement.scrollWidth;       
h = document.documentElement.scrollHeight;    
}
else if (document.body)
{        
t = document.body.scrollTop;        
l = document.body.scrollLeft;        
w = document.body.scrollWidth;        
h = document.body.scrollHeight;    
}    
return { t: t, l: l, w: w, h: h };
} 
// 锚点(Anchor)间平滑跳转
function scroller(el, duration)
{
if(typeof el != 'object')
{
el = document.getElementById(el);
}
if(!el) return;
var z = this;
z.el = el;
z.p = getPos(el);
z.s = getScroll();
z.clear = function()
{
window.clearInterval(z.timer);z.timer=null
};
z.t=(new Date).getTime();
z.step = function()
{
var t = (new Date).getTime();    
var p = (t - z.t) / duration;    
if (t >= duration + z.t)
{
z.clear();
window.setTimeout(function(){z.scroll(z.p.y, z.p.x)},13);}
else {
st = ((-Math.cos(p*Math.PI)/2) + 0.5) * (z.p.y-z.s.t) + z.s.t;    
sl = ((-Math.cos(p*Math.PI)/2) + 0.5) * (z.p.x-z.s.l) + z.s.l;
z.scroll(st, sl);
}
};
z.scroll = function (t, l){window.scrollTo(l, t)};
z.timer = window.setInterval(function(){z.step();},13);
}