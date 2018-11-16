<!--subject-data-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/subject/subject-data.js"></script>

<!--subject-update-status-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/subject/subject-update-status.js"></script>



<div class="scroll subjectData" >

		<h2>ASIGNATURAS</h2>

	<h3>Resultado de Asignaturas</h3>

	<table id="tableSubjectData" class="table standard-table">

			<thead>

			<tr class="not">
			
				<th>Código</th>
				<th>Área Disciplinaria</th>
				<th>Nombre</th>
				<th>Número de Créditos</th>
				<th>Programas Académicos</th>
				<th>Estado</th>
				<th>Acciones</th>
			</tr>

		</thead>

		
	</table>

	<%@include file="/WEB-INF/views/subject-update-status.jsp"%>

</div>