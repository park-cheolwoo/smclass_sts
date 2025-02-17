<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<title> JARDIN SHOP </title>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="description" content="JARDIN SHOP" />
<meta name="keywords" content="JARDIN SHOP" />
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scaleable=no" />
<link rel="stylesheet" type="text/css" href="../css/reset.css?v=Y" />
<link rel="stylesheet" type="text/css" href="../css/layout.css?v=Y" />
<link rel="stylesheet" type="text/css" href="../css/content.css?v=Y" />
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/top_navi.js"></script>
<script type="text/javascript" src="../js/left_navi.js"></script>
<script type="text/javascript" src="../js/main.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
<script type="text/javascript" src="../js/jquery.easing.1.3.js"></script>
<script type="text/javascript" src="../js/idangerous.swiper-2.1.min.js"></script>
<script type="text/javascript" src="../js/jquery.anchor.js"></script>
<!--[if lt IE 9]>
<script type="text/javascript" src="../js/html5.js"></script>
<script type="text/javascript" src="../js/respond.min.js"></script>
<![endif]-->
<script type="text/javascript">
$(document).ready(function() {
	


});
</script>
</head>
<body>



<!--ìµì¤ë ì´ì´íì-->
<div id="ieUser" style="display:none">
	<div class="iewrap">	
		<p class="img"><img src="../images/ico/ico_alert.gif" alt="ìë¦¼" /></p>
		<p class="txt">IEë²ì ì´ ë®ì ííì´ì§ ì´ì©ì ë¶í¸í¨ì´ ìì¼ë¯ë¡ <strong>IE9ì´ìì´ë ë¤ë¥¸ ë¸ë¼ì°ì </strong>ë¥¼ ì´ì©í´ ì£¼ì¸ì. </p>
		<ul>
			<li><a href="http://windows.microsoft.com/ko-kr/internet-explorer/download-ie" target="_blank"><img src="../images/ico/ico_ie.gif" alt="IE ìµì ë¸ë¼ì°ì  ë¤ì´" ></a></li>
			<li><a href="https://www.google.com/intl/ko/chrome/browser" target="_blank"><img src="../images/ico/ico_chrome.gif" alt="IE ìµì ë¸ë¼ì°ì  ë¤ì´" ></a></li>
			<li><a href="http://www.mozilla.org/ko/firefox/new" target="_blank"><img src="../images/ico/ico_mozila.gif" alt="MOZILA ìµì ë¸ë¼ì°ì  ë¤ì´" ></a></li>
			<li><a href="http://www.apple.com/safari" target="_blank"><img src="../images/ico/ico_safari.gif" alt="SAFARI ìµì ë¸ë¼ì°ì  ë¤ì´" ></a></li>
			<li><a href="http://www.opera.com/ko/o/ie-simple" target="_blank"><img src="../images/ico/ico_opera.gif" alt="OPERA ìµì ë¸ë¼ì°ì  ë¤ì´" ></a></li>		
		</ul>
		<p class="btn" onclick="msiehide();"><img src="../images/ico/ico_close.gif" alt="ë«ê¸°" /></p>
	</div>
</div>
<!--//ìµì¤ë ì´ì´íì-->
<!--IE 6,7,8 ì¬ì©ììê² ë¸ë¼ì°ì  ìë°ì´í° ì¤ëª Div ê´ë ¨ ì¤í¬ë¦½í¸-->
 <script type="text/javascript">

     var settimediv = 200000; //ì§ììê°(1000= 1ì´)
     var msietimer;

     $(document).ready(function () {
         msiecheck();
     });

     var msiecheck = function () {
         var browser = navigator.userAgent.toLowerCase();
         if (browser.indexOf('msie 6') != -1 ||
                browser.indexOf('msie 7') != -1 ||
				 browser.indexOf('msie 8') != -1) {
             msieshow();			 
         }
         else {
             msiehide();
         }
     }

     var msieshow = function () {
        $("#ieUser").show();
        msietimer = setTimeout("msiehide()", settimediv);
     }

     var msiehide = function () {
		$("#ieUser").hide();
        clearTimeout(msietimer);
     }
</script>

<div id="allwrap">
<div id="wrap">

	<div id="header">
		
		<div id="snbBox">
			<h1><img src="../images/txt/logo.gif" alt="JARDIN SHOP" /></h1>
			<div id="quickmenu">
				<div id="mnaviOpen"><img src="../images/btn/btn_mnavi.gif" width="33" height="31" alt="ë©ë´ì´ê¸°" /></div>
				<div id="mnaviClose"><img src="../images/btn/btn_mnavi_close.gif" width="44" height="43" alt="ë©ë´ë«ê¸°" /></div>
				<ul>
					<li><a href="#">EVENT</a></li>
					<li><a href="#">CUSTOMER</a></li>
					<li><a href="#">COMMUNITY</a></li>
				</ul>
			</div>
			<div id="snb">
				<ul>
					<li><a href="#">LOGIN</a></li>
					<li><a href="#">JOIN</a></li>
					<li><a href="#">MY PAGE</a></li>
					<li><a href="#">CART</a></li>
				</ul>

				<div id="search">
					<input type="text" class="searchType" />
					<input type="image" src="../images/btn/btn_main_search.gif" width="23" height="20" alt="ê²ìíê¸°" />
				</div>
			</div>
		</div>
	</div>


	<!-- GNB -->
	<div id="gnb">
		
		<div id="top">
			<ul>
				<li class="brand t1"><a href="#" id="topNavi1">JARDINâs BRAND</a>
					<ul id="topSubm1">
						<li><a href="#">í´ëì¤</a></li>
						<li><a href="#">íì¤íì¼ ì¹´íëª¨ë¦¬</a></li>
						<li><a href="#">ëë¦½ì»¤í¼ë°±</a></li>
						<li><a href="#">ì¹´íë¦¬ì¼ ì»¤í¼</a></li>
						<li><a href="#">ì¤ë¦¬ì§ëì»¤í¼ë°±</a></li>
						<li><a href="#">ì¹´íë¦¬ì¼ ìë£</a></li>
						<li><a href="#">ë§ì¼ëì»¤í¼ë°±</a></li>
						<li><a href="#">ìí°ì»¤í¼</a></li>
						<li><a href="#">ì¹´íí¬ë</a></li>
						<li><a href="#">ëª¨íëíí°</a></li>
						<li><a href="#">íì´í¬ìì ì¹´íëª¨ë¦¬</a></li>
						<li><a href="#">í¬íì </a></li>
					</ul>
				</li>
				<li class="t2"><a href="#" id="topNavi2">ìë</a>
					<ul id="topSubm2">
						<li><a href="#">í´ëì¤</a></li>
						<li><a href="#">ë¡ì¤í°ë¦¬ìµ</a></li>
						<li><a href="#">ì»¤í¼íì</a></li>
						<li><a href="#">ì°ì§ë³ ìë</a></li>
					</ul>
				</li>
				<li class="t1"><a href="#" id="topNavi3">ìëì»¤í¼ë°±</a>
					<ul id="topSubm3">
						<li><a href="#">ëë¦½ì»¤í¼ ë¡ì¤í¸</a></li>
						<li><a href="#">ì¤ë¦¬ì§ëì»¤í¼ë°±</a></li>
						<li><a href="#">ë§ì¼ëì»¤í¼ë°±</a></li>
					</ul>
				</li>
				<li class="t2"><a href="#" id="topNavi4">ì¸ì¤í´í¸</a>
					<ul id="topSubm4">
						<li><a href="#">ê¹íëª¨ë¦¬</a></li>
						<li><a href="#">íì¤íì¼ì¹´íëª¨ë¦¬</a></li>
						<li><a href="#">í¬íì </a></li>
					</ul>
				</li>
				<li class="t1"><a href="#" id="topNavi5">ìë£</a>
					<ul id="topSubm5">
						<li><a href="#">ê¹íë¦¬ì¼</a></li>
						<li><a href="#">ìí°ì»¤í¼</a></li>
						<li><a href="#">ëª¨íë</a></li>
					</ul>
				</li>
				<li class="t2"><a href="#" id="topNavi6">ì»¤í¼ì©í</a>
					<ul id="topSubm6">
						<li><a href="#">ì¢ì´ì»µ</a></li>
						<li><a href="#">ì»¤í¼íí°</a></li>
						<li><a href="#">ë¨¸ì  ë±</a></li>
					</ul>
				</li>
				<li class="t1"><a href="#" id="topNavi7">ì ë¬¼ì¸í¸</a></li>
				<li class="t2"><a href="#" id="topNavi8">ëëêµ¬ë§¤</a></li>
			</ul>
		</div>

		<script type="text/javascript">initTopMenu();</script>
	</div>
	<!-- //GNB -->

	<!-- container -->
	<div id="container">

		<div id="location">
			<ol>
				<li><a href="#">HOME</a></li>
				<li><a href="#">MEMBERSHIP</a></li>
				<li class="last">íìê°ì</li>
			</ol>
		</div>
		
		<div id="outbox">		
			<div id="left">
				<div id="title2">MEMBERSHIP<span>ë©¤ë²ì½</span></div>
				<ul>	
					<li><a href="#" id="leftNavi1">ë¡ê·¸ì¸</a></li>
					<li><a href="#" id="leftNavi2">íìê°ì</a></li>
					<li><a href="#" id="leftNavi3">ìì´ë/<span>ë¹ë°ë²í¸ ì°¾ê¸°</span></a></li>
					<li><a href="#" id="leftNavi4">íìì½ê´</a></li>
					<li><a href="#" id="leftNavi5">ê°ì¸ì ë³´<span>ì·¨ê¸ë°©ì¹¨</span></a></li>
					<li class="last"><a href="#" id="leftNavi6">ì´ë©ì¼ë¬´ë¨<span>ìì§ê±°ë¶</span></a></li>
				</ul>			
			</div><script type="text/javascript">initSubmenu(2,0);</script>


			<!-- contents -->
			<div id="contents">
				<div id="member">
					<h2><strong>íìê°ì</strong><span>íìì¼ë¡ ê°ìíìë©´ ë³´ë¤ ë ë¤ìí ííì ëë¦¬ì¤ ì ììµëë¤.</span></h2>
					
					<!-- STEP -->
					<div class="stepWrap">
						<div class="step stepon">
							<p class="web">STEP 01</p>
							<p class="txt">ì¤ëªíì¸</p>
							<p class="ck"><img src="../images/bg/bg_step.png" alt="íì¬ìì¹" /></p>
						</div>

						<div class="step">
							<p class="web">STEP 02</p>
							<p class="txt">ì½ê´ ëì</p>
						</div>

						<div class="step">
							<p class="web">STEP 03</p>
							<p class="txt"><span>íìì ë³´</span> <span>ìë ¥</span></p>
						</div>

						<div class="step">
							<p class="web">STEP 04</p>
							<p class="txt"><span>íìê°ì</span> <span>ìë£</span></p>
						</div>
					</div>
					<!-- //STEP -->
						

					<div class="alertBox">
						<ul>
							<li>íìëì ì¤ëªíì¸ ë° ê°ì ì¬ë¶ë¥¼ íì¸íë ì ì°¨ìëë¤.</li>
							<li>íìëì ê°ì¸ ì ë³´ ë³´í¸ë¥¼ ìí´ ì¤ëªíì¸ì ì¤ìíê³  ììµëë¤.</li>
						</ul>
					</div>


					
					<div class="btnAreaCenter">
						<a href="#" class="gbtn">ì´ë©ì¼ì¸ì¦</a></li>
					</div>
					

					<div class="checkDivTab">
						<table summary="ë¶ë¥, êµ¬ë§¤ì¬ë¶, íê°, ì ëª©, ìì¸ ë´ì© ìì¼ë¡ ìííì ìì± íì¤ì ììµëë¤." class="checkTable" border="1" cellspacing="0">
							<caption>ìíí ìì±</caption>
							<colgroup>
							<col width="19%" class="tw30" />
							<col width="*" />
							</colgroup>
							<tbody>
								<tr>
									<th scope="row"><span>ì¸ì¦ì½ë</span></th>
									<td>
										<input type="text" class="wlong" readonly/>
									</td>
								</tr>							
							</tbody>
						</table>
					</div>
					
					<!-- Btn Area -->
					<div class="btnArea">
						<div class="bCenter">
							<ul>																
								<li><a href="#" class="nbtnbig">ì´ë©ì¼ ì½ë ë°ì¡</a></li>
								<li><a href="#" class="sbtnMini">ë¤ìì¼ë¡</a></li>
							</ul>
						</div>
					</div>
					<!-- //Btn Area -->

				</div>
			</div>
			<!-- //contents -->
			

		</div>
	</div>
	<!-- //container -->




	<div id="footerWrap">
		<div id="footer">
			<div id="fnb">
				<ul>
					<li class="left"><a href="#">ê°ì¸ì ë³´ì·¨ê¸ë°©ì¹¨</a></li>
					<li><a href="#">ì´ì©ì½ê´</a></li>
					<li class="left"><a href="#">ì´ë©ì¼ë¬´ë¨ìì§ê±°ë¶</a></li>
					<li><a href="#">ê³ ê°ì¼í°</a></li>
					<li class="left brand"><a href="#">ìë ë¸ëë ì¬ì´í¸</a></li>
				</ul>
			</div>
			
			<div id="finfo">
				<div id="flogo"><img src="../images/txt/flogo.gif" alt="JARDIN THE COFFEE CREATOR, SINCE 1984" /></div>
				<address>
					<ul>
						<li>ãìë</li>
						<li>ëíì ì¤ìë¸</li>
						<li class="tnone">ì£¼ì ìì¸ì ê°ë¨êµ¬ ë¼íë 4-21ë²ì§ ì ë¹ë©</li>
						<li class="webnone">ìë¹ììë´ì¤ 02)546-3881</li>
						<li>ì¬ììë±ë¡ë²í¸ 211-81-24727</li>
						<li class="tnone">íµì íë§¤ì ê³  ì  ê°ë¨ â 1160í¸</li>
						<li class="copy">COPYRIGHT Â© 2014 JARDIN <span>ALL RIGHTS RESERVED.</span></li>
					</ul>
				</address>

				<div id="inicis"><img src="../images/ico/ico_inicis.png" alt="ì´ëìì¤ ê²°ì ìì¤í" /></div>
			</div>
		</div>
	</div>



</div>
</div>
</body>
</html>