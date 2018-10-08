<!--teacher-data-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/teacher/teacher-data.js"></script>

<!--teacher-update-status-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/teacher/teacher-update-status.js"></script>

<!--courseFeedback-update-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/courseFeedback/courseFeedback-update.js"></script>

<div class="scroll data">

<div class="scroll teacherData">


	<h2>DOCENTES</h2>

	<h3>Resultado de Profesores</h3>

	<table id="tableTeacherData" class="table standard-table teacher">

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
				<th>Asignaturas</th>
				<th>Estado</th>
				<th>Acciones</th>
			</tr>

		</thead>



	</table>

	<%@include file="/WEB-INF/views/teacher-update-status.jsp"%>


</div>

<br>
<br>

<div class="scroll courseData">

	<h3>Resultado de los Cursos del Profesor</h3>

	<table id="tableCourseData" class="table standard-table">

		<thead>

			<tr class="not">

				<th>Codigo</th>
				<th>Periodo Academico</th>
				<th>Profesor</th>
				<th>Asignatura</th>
				<th>Identificador de Grupo</th>
				<th>Es virtual</th>

			</tr>

		</thead>

	</table>


</div>

<br>
<br>


<div class="scroll courseFeedbackData">

	<h3>Resultado de las Retroalimentaciones de los Cursos del Profesor</h3>

	<table id="tableCourseFeedbackData" class="table standard-table">

		<thead>

			<tr class="not">

				<th>Codigo de la Retroalimentacion</th>
				<th>Tipo de Retroalimentacion</th>
				<th>Comentario</th>
				<th>Usuario</th>
				<th>Fecha de Modificacion</th>
				<th>Puntuacion Promedio</th>
				<th>Acciones</th>
			</tr>

		</thead>

	</table>
	
		<%@include file="/WEB-INF/views/courseFeedback-update.jsp"%>


</div>

</div>




