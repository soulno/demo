<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp"%>
<div class="container">
	<h3>Board Update</h3>
	<br />
	<input type="hidden" name="num" id="num" value="${board.num}" />
		<div class="form-group">
			<label for="title">제목:</label> 
			<input type="text" class="form-control" id="title" name="title" value="${board.title}" >

		</div>
		<div class="form-group">
			<label for="writer">글쓴이:</label> 
			<input type="text" class="form-control" id="writer" name="writer" value="${board.writer}" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="content">내용:</label>
			<textarea id="content" name="content" id="content" class="form-control" >${board.content }</textarea>
		</div>

		<button type="button" id="btnModify" class="btn btn-primary  btn-sm">수정하기</button>
</div>
<script>
$("#btnModify").click(function(){
	data = {
	  "num" :  $("#num").val(),
	  "title" :  $("#title").val(),
	  "content" :  $("#content").val()
	}
	$.ajax({
		type : "put",
		url : "/update",
		contentType :"application/json;charset=utf-8",
		data : JSON.stringify(data),
		success : function(resp){
			if(resp=="success"){
				alert("수정완료")
				location.href="/list";
			}
		}//success
	})//ajax
	
})//btnModify

</script>
</body>
</html>




