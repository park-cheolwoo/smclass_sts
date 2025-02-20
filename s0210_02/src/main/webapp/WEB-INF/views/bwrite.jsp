<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>글쓰기</title>
  <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:400,500,700,900&display=swap&subset=korean" rel="stylesheet">
  <link rel="stylesheet" href="/css/style.css">
  <link rel="stylesheet" href="/css/write.css">
  <script src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
  <link href="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/summernote@0.9.0/dist/summernote-lite.min.js"></script>
  <script>
  	const wbtn = () => {
  		if($(".id").val().length < 1){
  			alert("아이디를 입력하셔야 저장이 가능합니다.");
  			$(".id").focus();
  			return false;
  		}
  		alert("게시글을 저장합니다.");
  		writeFrm.submit();
  	}
  	
  	function readUrl(input){
 	   if(input.files && input.files[0]){
 		   var reader = new FileReader();
 		   reader.onload = function(e){
 			   document.getElementById("preview").src = e.target.result;
 		   };
 		   reader.readAsDataURL(input.files[0]);
 	   	}else{
 	   		document.getElementById("preview").src = "";
 	   }
    }
  	
  	$(function(){
  		$("#summernote").summernote({  		 	
  		  	placeholder: '최대 2048자까지 쓸 수 있습니다', //placeholder 설정
  		  	tabsize : 1,
 			height: 300,                // 에디터 높이
  		  	minHeight: 400,          // 에디터 최소 높이
  		  	maxHeight: 700,         // 에디터 최대 높이
  		  	focus: true,                 // 에디터 로딩후 포커스를 맞출지 여부
  		  	lang: "ko-KR",         // 한글 설정
			toolbar: [
			    // [groupName, [list of button]]
			    ['fontname', ['fontname']],
			    ['fontsize', ['fontsize']],
			    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
			    ['color', ['forecolor','color']],
			    ['table', ['table']],
			    ['para', ['ul', 'ol', 'paragraph']],
			    ['height', ['height']],
			    ['insert',['picture','link','video']],
			    ['view', ['fullscreen', 'help']]
			  ],
			fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
			fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
  		});
  	})
   </script>
</head>
<body>
<section>
    <h1>관리자 글쓰기</h1>
    <hr>

    <form action="/board/bwrite" name="writeFrm" method="post" enctype="multipart/form-data">
      <table>
        <colgroup>
          <col width="15%">
          <col width="85%">
        </colgroup>
        <tr>
          <th>작성자</th>
          <td>
            <input type="text" name="id" class="id">
          </td>
        </tr>
        <tr>
          <th>제목</th>
          <td>
            <input type="text" name="btitle">
          </td>
        </tr>
        <tr>
          <th>내용</th>
          <td>
            <textarea id="summernote" name="bcontent" cols="50" rows="10"></textarea>
          </td>
        </tr>
        <tr>
          <th>이미지 표시</th>
          <td>
            <input type="file" name="files" id="file" onchange="readUrl(this)">
          </td>
        </tr>

        <tr>
          <th>이미지 보기</th>
          <td>
            <img id="preview" style="width:100px" />
          </td>
        </tr>
      </table>
      <hr>
      <div class="button-wrapper">
        <button type="button" class="write" onclick="wbtn()">작성완료</button>
        <button type="button" class="cancel" onclick="javascript:location.href='/'">취소</button>
      </div>
    </form>

  </section>

</body>
</html>