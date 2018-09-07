<%@include file="/includes/statics-resources/tag-libs.jsp"%>

<!DOCTYPE html>
<html lang="en">

<head>

<%@include file="/includes/statics-resources/index-srcs.jsp"%>

<!--Menu -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/layout/menu/menu.js"></script>

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/teacher/teacher-create-excel.js"></script>

    <title>INDEX</title>

</head>

	<div class="clearfix">
    <div class="success">
     <a href="#" class="close">X</a>
	 <a class="icon"><ion-icon name="checkmark-circle-outline"></ion-icon></a> 
	<label class="message"></label>
    </div>
    <div class="error">
    <a href="#" class="close">X</a>
	 <a class="icon" ><ion-icon name="warning"></ion-icon></a>
	<label class="message"></label>
    </div>
</div>

<body>
	
	<form:form id="Fileuploader" 
		enctype="multipart/form-data">
		Seleccionar archivo
		<br>	
		<input id="excelfile" type="file"  name="file" accept= ".xls, .xlsx" />

	<br> 
	<br>

	<input id="buttonCreateTeacherExcel" class="button add-button"
	type="submit" value="Procesar archivo" />
	
	</form:form>
	

	

</body>

</html>







