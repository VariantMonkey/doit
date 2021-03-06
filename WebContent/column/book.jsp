<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Content-Language" content="zh-CN" />   
	<meta name="keywords" content="前端, 产品, 设计, javascript, jquery, css, html, czlqibu, doit, java, j2ee, 扁平化, 代码, 笔记, web前端, web起步, 从这里起步" />
	<meta name="description" content="do IT是一个优秀的web前端网站" />
	
	<!-- 响应式声明开始 -->
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
	<!-- 响应式声明结束 -->
	
	<link rel= "shortcut icon" href="/doit/common/images/icon.png" />
	
	<title>do IT | 专注于web前端开发</title>
	
	<link rel="stylesheet" type="text/css" href="/doit/plugins/bootstrap-ui/css/bootstrap.min.css" />
	<link rel="stylesheet" type="text/css" href="/doit/plugins/semantic-ui/packaged/css/semantic.min.css" />
	<link rel="stylesheet" type="text/css" href="/doit/plugins/scrollup-master/css/themes/image.css" />
	<link rel="stylesheet" href="/doit/common/css/common.css" type="text/css" />	
	<link rel="stylesheet" href="/doit/plugins/search/css/zySearch.css" type="text/css" />
	<link rel="stylesheet" href="/doit/css/book.css" type="text/css" />
	<link rel="stylesheet" href="/doit/plugins/Wookmark-jQuery-master/css/reset.css" type="text/css" />
    <link rel="stylesheet" href="/doit/plugins/Wookmark-jQuery-master/css/main.css" type="text/css" />
    <link rel="stylesheet" href="/doit/plugins/Wookmark-jQuery-master/example-filter/css/style.css" type="text/css" />
</head>
<body>
	<div class="container bs-docs-container">
	
		<!-- 版头 -->
		<div class="row pageTitle">
			<span class="logo">
				<a rel="home" title="Just do IT" href="/doit/home/0/home">
					<b class="bclass">Just do IT</b>
				</a>
				<i>专注于web前端开发，专注于用户体验</i> 
			</span>
			<span id="zySearch" class="zySearch">
				<b class="search-img"></b>
				<input id="searchInput" class="search-input" type="text" placeholder="搜索小贱鸡？">
				<button class="search-btn btn">搜索</button>
			</span>
		</div>
		
		<!-- 菜单栏 -->
		<div class="row" style="margin-top:10px;">
			<header class="navbar navbar-inverse bs-docs-nav" role="banner">
				<div class="container">
					<div class="navbar-header">
						<span class="navTips">网站导航</span>
						<button class="navbar-toggle" data-target=".bs-navbar-collapse" data-toggle="collapse" type="button">
							<span class="sr-only">Toggle navigation</span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
							<span class="icon-bar"></span>
						</button>
					</div>
					<nav class="collapse navbar-collapse bs-navbar-collapse" role="navigation">
						<ul class="nav navbar-nav">
							<li><a href="/doit/home/0/home">首页</a></li>
							<li><a href="/doit/front/0/front">前端</a></li>
				      		<li><a href="/doit/java/0/java">JAVA</a></li>
				      		<li><a href="/doit/mobile/0/mobile">移动端</a></li>
				      		<li><a href="/doit/note/${noteFirstSortID}/0/note">笔记</a></li>
				      		<li><a href="/doit/works/0/works">个人作品</a></li>
				      		<li><a href="/doit/book/3/0/book" style="color:#FF8322;padding:0 23px;">读书乐趣</a></li>
				      		<li><a href="/doit/me">关于我</a></li>
						</ul>
					</nav>
				</div>
			</header>
		</div>
		<div class="row searchKeywordTipsDiv">
        	<!-- 顶部分类 -->
			<div style="text-overflow: ellipsis;overflow: hidden;white-space: nowrap;">
				<ol id="filters">
					${sortHtml}
			    </ol>
			</div>
    	</div>
    	<div class="row">
			<div class="col-md-12" role="main">
			    <br/>
			    <div id="main" role="main">
					<ul id="tiles">
				    	${bookHtml}
				    </ul>
			    </div>
			</div>
		</div>
	</div>
	
	<footer class="bs-footer" role="contentinfo">
		<br/><br/><br/><br/>
		<div class="row">
			<div class="col-md-8 record" role="main">
				<span>
					technology stays true here ©2015 
					<a href="http://www.52doit.com">
						www.52doit.com 
					</a>
					<a style="color:#000;" href="http://www.miitbeian.gov.cn/" target="_blank">
						鲁ICP备15007960号-2
					</a>
				</span>
			</div>
			<div class="col-md-4">
			</div>
		</div>
	</footer>
	
	<script type="text/javascript" src="/doit/common/js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="/doit/plugins/bootstrap-ui/js/bootstrap.min.js"></script> 
	<script type="text/javascript" src="/doit/plugins/scrollup-master/src/jquery.scrollUp.js"></script>
	<script type="text/javascript" src="/doit/plugins/Wookmark-jQuery-master/libs/jquery.imagesloaded.js"></script>
	<script type="text/javascript" src="/doit/plugins/Wookmark-jQuery-master/jquery.wookmark.js"></script>
	<script type="text/javascript" src="/doit/plugins/search/js/zySearch-doit.js"></script>
	<script type="text/javascript" src="/doit/js/book.js"></script>
			
	<!-- 百度分享 -->
	<script>window._bd_share_config={"common":{"bdSnsKey":{},"bdText":"","bdMini":"2","bdMiniList":false,"bdPic":"","bdStyle":"0","bdSize":"16"},"slide":{"type":"slide","bdImg":"8","bdPos":"right","bdTop":"135.5"}};with(document)0[(getElementsByTagName('head')[0]||body).appendChild(createElement('script')).src='http://bdimg.share.baidu.com/static/api/js/share.js?v=89860593.js?cdnversion='+~(-new Date()/36e5)];</script>

</body>
</html>