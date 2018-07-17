<%@include file="/includes/statics-resources/tag-libs.jsp"%>

<!--teacher-create-excel-->
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/project/js/teacher/
teacher-create-excel.js"></script>  


	<h2>DOCENTES</h2>
					
	<form action="./Teachers/CreateExcel" method="POST"
		enctype="multipart/form-data">
		Seleccionar archivo	
		<br> 
		<input  type="file"  name="file" accept= ".xls, .xlsx" />

	<br> 
	<br>

	<input id="buttonCreateTeacherExcel" class="button add-button"
	type="submit" value="Procesar archivo" />
	
	</form>


