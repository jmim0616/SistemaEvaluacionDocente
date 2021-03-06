<!--teacher-data-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/course/course-data.js"></script>

<!--course-update-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/course/course-update.js"></script>

<!--course-add-feedback-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/course/course-add-feedback.js"></script>

<!--course-delete-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/course/course-delete.js"></script>

<!--courseFeedback-update-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/courseFeedback/courseFeedback-update.js"></script>

<!--course-create -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/course/course-create.js"></script>

<div class="data">

<div class="scroll courseData">


	<h2>CURSOS</h2>

	<h3>Resultado de Cursos</h3>

	<table id="tableCourseData" class="table standard-table">

		<thead>

			<tr class="not">

				<th>Código</th>
				<th>Periodo Académico</th>
				<th>Profesor</th>
				<th>Asignatura</th>
				<th>Identificador de Grupo</th>
				<th>Es virtual</th>
				<th>Acciones</th>

			</tr>

		</thead>



	</table>

	
	<%@include file="/WEB-INF/views/course-update.jsp"%>
	<%@include file="/WEB-INF/views/course-add-feedback.jsp"%>
	<%@include file="/WEB-INF/views/course-delete.jsp"%>
	<%@include file="/WEB-INF/views/course-create.jsp"%>

</div>

<br>
<br>

<div class="scroll courseFeedbackData">

	<h3>Resultado de las Retroalimentaciones del Curso</h3>

	<table id="tableCourseFeedbackData" class="table standard-table">

		<thead>

			<tr class="not">

				<th>Código de la Retroalimentación</th>
				<th>Tipo de Retroalimentación</th>
				<th>Comentario</th>
				<th>Usuario</th>
				<th>Fecha de Modificación</th>
				<th>Puntuación Promedio</th>
				<th>Acciones</th>
			</tr>

		</thead>

	</table>
	
		<%@include file="/WEB-INF/views/courseFeedback-update.jsp"%>


</div>

</div>

