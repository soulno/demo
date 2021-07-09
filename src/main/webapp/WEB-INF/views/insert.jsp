<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp"%>
<div class="container">
	<h1>Board insert</h1>
	<br />
	<form action="insert" method="post">
		<div class="form-group">
			<label for="title">제목:</label> <input type="text" class="form-control" id="title" name="title" placeholder="Enter title">

		</div>
		<div class="form-group">
			<label for="writer">글쓴이:</label> <input type="text" class="form-control" id="writer" placeholder="Enter writer" name="writer">
		</div>
		<div class="form-group">
			<label for="content">내용:</label>
			<textarea id="content" name="content" id="content" class="form-control"></textarea>
		</div>

		<button type="submit" class="btn btn-primary">글쓰기</button>
	</form>
</div>
</body>
</html>