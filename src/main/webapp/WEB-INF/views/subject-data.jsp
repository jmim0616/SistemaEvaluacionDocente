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
			
				<th>C�digo</th>
				<th>�rea Disciplinaria</th>
				<th>Nombre</th>
				<th>N�mero de Cr�ditos</th>
				<th>Programas Acad�micos</th>
				<th>Estado</th>
				<th>Acciones</th>
			</tr>

		</thead>

		
	</table>

	<%@include file="/WEB-INF/views/subject-update-status.jsp"%>

</div>