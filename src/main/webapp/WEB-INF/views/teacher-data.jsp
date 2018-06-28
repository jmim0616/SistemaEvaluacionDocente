<!--teacher-data-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/teacher/teacher-data.js"></script>
	
	
<div class="teacherData" style="display: none;">

	<h2>DOCENTES</h2>

	<h3>Resultado de Profesores</h3>

	<%@include file="/includes/toolbars/toolbar-teacher-update.jsp"%>

	<table id="tableTeacherData" class="table standard-table">

		<thead>

			<tr class="not">
			
				<th>Codigo</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Tipo Identificacion</th>
				<th>Titulo Profesional</th>
				<th>Titulo de Maestria</th>
				<th>Titulo de Doctorado</th>
				<th>Email Institucional</th>
				<th>Email Personal</th>
				<th>Telefono Fijo</th>
				<th>Telefono Celular</th>
				<th>Experiencia</th>
				<th>Estado</th>
			</tr>

		</thead>

		<tr>
			<td>12345</td>
			<td>Vlad</td>
			<td>Woz</td>
			<td>1CC</td>
			<td>Sistemas1</td>
			<td>Sistemas2</td>
			<td>Sistemas3</td>
			<td>VladWoz1@gmail.com</td>
			<td>VladWoz2@gmail.com</td>
			<td>1</td>
			<td>2</td>
			<td>100 años</td>
			<td>Activo</td>
		</tr>


		<tr>
			<td>energia</td>
			<td>Febrero</td>
			<td>$6000</td>
			<td>1</td>
			<td>2</td>
			<td>3</td>
			<td>4</td>
			<td>5</td>
		</tr>

		<tr>
			<td>Internet</td>
			<td>Junio</td>
			<td>$1000</td>
			<td>1</td>
			<td>2</td>
			<td>3</td>
			<td>4</td>
			<td>5</td>
		</tr>

		<tr>
			<td>Telefono</td>
			<td>Junio</td>
			<td>$500</td>
			<td>1</td>
			<td>2</td>
			<td>3</td>
			<td>4</td>
			<td>5</td>
		</tr>


	</table>


<%@include file="/includes/modals/teacher-modal-update-status.jsp"%>

</div>