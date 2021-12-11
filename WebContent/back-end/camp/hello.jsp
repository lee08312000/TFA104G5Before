
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--  
   1.method 來決定他是POST還是GET
   2.ACTION 來對應web.xml 路徑使用到那個servlet
   3.name=欄位名稱可以自己取
   4.<p>${hello}</p>對應	req.setAttribute("hello");
 -->
<form method="post" ACTION="<%=request.getContextPath()%>/camp/hello.do">
	<input type="text" name="n123insert" value="新增"/>
	<input type="hidden" name="test" value="insert"/>
	<p>${n123}</p>
    <button type="submit" value="送出">新增</button>
</form>

<form method="post" ACTION="<%=request.getContextPath()%>/camp/hello.do">
	<input type="text" name="n123update" value="修改"/>
	<input type="hidden" name="test" value="update"/>
	<p>${n123}</p>
    <button type="submit" value="送出">修改</button>
</form>
<form method="post" ACTION="<%=request.getContextPath()%>/camp/hello.do">
	<input type="text" name="n123delete" value="刪除"/>
	<input type="hidden" name="test" value="delete"/>
	<p>${n123}</p>
    <button type="submit" value="送出">刪除</button>
</form>
<form method="post" ACTION="<%=request.getContextPath()%>/camp/hello.do">
	<input type="text" name="n123query" value="查詢"/>
	<input type="hidden" name="test" value="query"/>
	<p>${n123}</p>
    <button type="submit" value="送出">查詢</button>
</form>

</body>
</html>