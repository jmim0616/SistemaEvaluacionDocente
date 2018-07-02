<!--academicProgram-data-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/academicProgram/academicProgram-data.js"></script>
	
	
<div class="academicProgramData">

	<div class="error">
		<a href="#" class="close">X</a> <a class="icon"><ion-icon
				name="warning"></ion-icon></a> <label class="message"></label>
	</div>

	<h2>PROGRAMAS ACADEMICOS</h2>

	<h3>Resultado de Programas Academicos</h3>

	<%@include file="/includes/toolbars/toolbar-academicProgram-update.jsp"%>

	<table id="tableAcademicProgramData" class="table standard-table">

		<thead>

			<tr class="not">
			
				<th>Codigo</th>
				<th>Facultad</th>
				<th>Nombre</th>

			</tr>

		</thead>

	</table>



</div>