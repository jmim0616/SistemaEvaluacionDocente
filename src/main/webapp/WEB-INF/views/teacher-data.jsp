<!--teacher-data-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/teacher/teacher-data.js"></script>
	
	
<div class="teacherData" >

    <div class="error">
    <a href="#" class="close">X</a>
	 <a class="icon" ><ion-icon name="warning"></ion-icon></a>
	<label class="message"></label>
    </div>

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

		

	</table>




</div>