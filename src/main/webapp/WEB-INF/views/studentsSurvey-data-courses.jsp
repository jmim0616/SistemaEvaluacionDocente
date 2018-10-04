
<!DOCTYPE html>
<html lang="en">

<head>

<%@include file="/includes/statics-resources/index-srcs.jsp"%>
<%@include file="/includes/statics-resources/tag-libs.jsp"%>

<title>Encuestas Web de Estudiantes</title>


<!-- studentsSurvey-data-courses -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/studentsSurvey/studentsSurvey-data-courses.js"></script>


</head>


<body>

	<div class="data">

		<div class="scroll studentsSurveyCoursesData">


			<h2>Encuestas Web de Estudiantes</h2>
			
			
			<form:form id="formSearchStudentsSurveyCourses" modelAttribute="course">

				<form:hidden path="groupId" id="groupIdSearch" />
				<form:hidden path="teacher" id="teacherSearch" />
				<form:hidden path="subject" id="subjectSearch" />
				<form:hidden path="academicPeriod" id="academicPeriodSearch" />

			</form:form>

			<table id="tableStudentsSurveyCoursesData" class="table standard-table">

				<thead>

					<tr class="not">

						<th>Periodo Academico</th>
						<th>Departamento</th>
						<th>Asignatura</th>
						<th>Identificador de Grupo</th>
						<th>Profesor</th>
						<th>Preguntas de la Encuesta</th>
	

					</tr>

				</thead>



			</table>

		</div>
	</div>




</body>



</html>


