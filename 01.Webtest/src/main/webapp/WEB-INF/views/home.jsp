<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>

<link rel="icon" href="<c:url value = 'images/logo.png'/>"
	type="image/x-icon">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css" />
</head>
<body style="background: #FFF">
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-6">
				<div class="p-5" style="background: #fff; border-radius: 10px;">
					<div class="text-center">
						<h1 class="h4 text-gray-900 mb-4">로그인</h1>
					</div>
					<form class="user" action="login" method="post" id="loginForm">
						<div class="form-group">
							<input type="text" class="form-control form-control-user" autocomplete="off"
								id="user_id" aria-describedby="emailHelp" name="user_id"
								placeholder="아이디를 입력해주세요.">
						</div>
						<div class="form-group">
							<input type="password" class="form-control form-control-user" autocomplete="off"
								name="user_password" id="user_password" placeholder="비밀번호를 입력해주세요.">
						</div>
						   <button type="submit" class="btn btn-user btn-block form-control" style="background : #F7DE6D;">
							Login</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
	<script>
	$('#member_pw').on('keypress', function(e){ 
	    if(e.keyCode == '13'){ 
	        $('#loginForm').submit(); 
	    }
	}); 
	
 	$('#loginForm').submit(function(event) {
 		 event.preventDefault(); // 폼의 기본 동작(페이지 리로딩) 막기
 	    
 	    $.ajax({
 	        url: "login",
 	        data: { user_id: $("#user_id").val(), user_password: $("#user_password").val() },
 	        type: 'post',
 	    }).done(function (result) {
 	    	alert(result);
 	        if (result === 1) {
 	            location = "main";
 	        } else {
 	            alert('없는 계정이거나 비밀번호가 틀렸습니다.')
 	        }
 	    });
	});

	</script>

</body>
</html>