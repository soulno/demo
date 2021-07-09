<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp"%>
<div class="container">
	<h3>Board View</h3>
	<br />
	<div class="form-group">
			<label for="num">글번호:</label> 
			<input type="text" class="form-control" id="num" name="num" value="${board.num}" readonly="readonly">

		</div>
		<div class="form-group">
			<label for="title">제목:</label> 
			<input type="text" class="form-control" id="title" name="title" value="${board.title}" readonly="readonly">

		</div>
		<div class="form-group">
			<label for="writer">글쓴이:</label> 
			<input type="text" class="form-control" id="writer" name="writer" value="${board.writer}" readonly="readonly">
		</div>
		<div class="form-group">
			<label for="content">내용:</label>
			<textarea id="content" name="content" id="content" class="form-control" readonly="readonly">${board.content }</textarea>
		</div>

		<button type="button" id="btnUpdate" class="btn btn-primary  btn-sm">수정</button>
		<button type="button" id="btnDelete" class="btn btn-danger  btn-sm">삭제</button>
</div>
<br/><br/>
<div align="center">
<textarea rows="3" cols="50" id="msg"></textarea>
<input type="button" value="댓글쓰기" class="btn btn-secondary  btn-sm" id="btnComment">
</div>
<hr/>
<div id="replyResult"></div>


<script>
var init = function(){
	$.ajax({
		type:"get",
		url: "/reply/commentList",
		data: {"bnum" : $("#num").val()}
	})
	.done(function(resp){
		//alert(resp)
		var str ="";
		$.each(resp, function(key, val){
			str += val.userid+" "
			str += val.content+" "
			str += val.regdate+" "
			str +="<a href='javascript:fdel(" + val.cnum + ")'>삭제</a><br>"
		})
		$("#replyResult").html(str);
	})
	.fail(function(e){
		alret("실패")
	})
}

// 댓글쓰기
 $("#btnComment").click(function(){
	 if($("#msg").val()==""){
		 alert("댓글을 입력하세요!");
		 return;
	 }
	 data = {
		"bnum" : $("#num").val(),
		"content" : $("#msg").val()
	 }
	 $.ajax({
		 type:"post",
		 url : "/reply/commentInsert",
		 contentType:"application/json;charset=utf-8",
		 data: JSON.stringify(data)
		 
	 })
	 .done(function(){
		 alert("댓글 추가 성공")
		 init()
	 })
	 .fail(function(){
		 alert("댓글 추가 실패")
	 })
 })
 

$("#btnUpdate").click(function(){
	if(!confirm('정말 수정할까요?'))
		return false;
	location.href="/update/${board.num}"
})
$("#btnDelete").click(function(){
	if(!confirm('정말 삭제할까요?'))
		return false;
	
	$.ajax({
		type:"delete",
		url : "/delete/${board.num}",
		success:function(resp){
			if(resp=="success"){
				alert("삭제성공");
				location.href="/list";
			}//if
		}//success
	})//ajax
}) //btnDelete

/* 댓글 삭제  */
function fdel(cnum) {
	//alert(cnum)
	$.ajax({
		type:"DELETE",
		url: "/reply/delete/"+cnum
		
	})
	.done(function(resp){
		 alert(resp + "번 글 삭제 완료")
		 init()
	 })
	 .fail(function(e){
		 alert("댓글 삭제 실패")
	 })
	
} // fdel


init();
</script>
</body>
</html>




