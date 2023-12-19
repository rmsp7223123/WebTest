<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<link href="<c:url value='/css/styles.css?${now }'/>" rel="stylesheet" />
<link href="<c:url value='/css/common.css?${now }'/>" rel="stylesheet" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/js/all.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script src="<c:url value='/js/common.js?${now }'/>"></script>
<title>Insert title here</title>

<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="css/sb-admin-2.min.css" rel="stylesheet">

<!-- Custom styles for this page -->
<link href="vendor/datatables/dataTables.bootstrap4.min.css"
	rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
	<h3 class="my-4" style="text-align: center;">글작성</h3>
	<form method="post" enctype="multipart/form-data" action="insert">
		<table class="tb-row">
			<colgroup>
				<col width="180px">
				<col>
			</colgroup>
			<tr>
				<th>제목</th>
				<td><input type="text" name="board_title"
					class="check-empty form-control" title="제목"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="board_content" class="check-empty form-control"
						title="내용"></textarea></td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<div>
						<label> <input type="file" name="file"
							class="form-control" id="file-multiple" multiple> <i
							role="button" class="fs-3 fa-solid fa-file-circle-plus"></i>
						</label>
					</div> <!-- 마우스 드래그 드랍으로 파일첨부 처리되게 -->
					<div class="form-control mt-2 py-2 file-drag">
						<div class="text-center py-3">첨부할 파일을 마우스로 끌어 오세요</div>
					</div>
				</td>
			</tr>
		</table>
		<input type="hidden" name="board_writer" value="${loginInfo.userid}">
	</form>

	<div class="btn-toolbar gap-2 my-3 justify-content-center">
		<button class="btn btn-primary px-4" id="btn-save">저장</button>
		<button class="btn btn-outline-primary px-4" onclick="history.go(-1)">취소</button>
		<!-- 	<button class="btn btn-outline-primary" onclick="location='list'">취소</button> -->
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="<c:url value='/js/scripts.js'/>"></script>
	<script>
		$('#btn-save').click(function() {
			$('form').submit()
		})
	</script>
</body>
</html>