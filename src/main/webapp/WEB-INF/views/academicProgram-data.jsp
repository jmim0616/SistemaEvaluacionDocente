<!--academicProgram-data-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/academicProgram/academicProgram-data.js"></script>
	
	<!--academicProgram-create-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/academicProgram/academicProgram-create.js"></script>
	
	<!--academicProgram-update-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/academicProgram/academicProgram-update.js"></script>
	
	
	
<div class="scroll academicProgramData">

	<h3>Resultado de Programas Academicos</h3>

	<table id="tableAcademicProgramData" class="table standard-table">

		<thead>

			<tr class="not">
			
				<th>Codigo</th>
				<th>Facultad</th>
				<th>Nombre</th>
				<th>Acciones</th>

			</tr>

		</thead>

	</table>

	<%@include file="/WEB-INF/views/academicProgram-create.jsp"%>
	<%@include file="/WEB-INF/views/academicProgram-update.jsp"%>

</div>