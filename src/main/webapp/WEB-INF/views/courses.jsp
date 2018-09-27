<!DOCTYPE html>
<html lang="en">

<%@include file="/includes/statics-resources/tag-libs.jsp"%>

<!--Menu -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/layout/menu/menu.js"></script>
	
		<!--courses-->
	<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/course/courses.js"></script>
	
		<!--course-create-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/course/course-create.js"></script>


<body>

	<div class="menu">

		<ul class="menu-list">


			<li class="general-menu"><a href="#"> Procesos Asociados <i
					class="icon-right"><ion-icon name="arrow-dropdown"></ion-icon></i></a>

				<ul>

					<li class="sub-menu"><a href="#"> Registro <i
							class="icon-right"> <ion-icon name="arrow-dropdown"></ion-icon></i></a>

						<ul class="sub-menu-content">

							<li><a id="linkCreateCourse" href="#"> Registrar Con
									Formulario </a></li>
							<li><a id="linkCreateExcelCourse" href="#">Registrar con
									excel</a></li>
						</ul></li>



					<li class="sub-menu"><a href="#"> Modificacion <i
							class="icon-right"><ion-icon name="arrow-dropdown"></ion-icon></i></a>

						<ul class="sub-menu-content">

							<form:form id="formSearchCourse" modelAttribute="course">

								<fieldset>
									<form:label path="groupId">Identificador del Curso</form:label>
									<form:input path="groupId" type="text" id="groupIdSearch" />
									<label id="groupIdSearchError" class="validation-error">
									</label>
								</fieldset>

								<fieldset>
									<form:label path="teacher">Identificacion del Docente</form:label>
									<form:input path="teacher" type="text" id="teacherSearch" />
									<label id="teacherSearchError" class="validation-error">
									</label>
								</fieldset>

								<fieldset>
									<form:label path="subject">Nombre de la Asignatura</form:label>
									<form:input path="subject" type="text" id="subjectSearch" />
									<label id="subjectSearchError" class="validation-error">
									</label>
								</fieldset>

								<fieldset>
									<form:label path="academicPeriod">Nombre del Periodo Academico</form:label>
									<form:input path="academicPeriod" type="text"
										id="academicPeriodSearch" />
									<label id="academicPeriodSearchError" class="validation-error">
									</label>
								</fieldset>



								<input id="buttonSearchCourse" class="button sent-button"
									type="submit" value="Buscar Curso" />

							</form:form>

						</ul></li>



				</ul>
	</div>

	<div class="content">

		<h2>CURSOS</h2>


		<%@include file="/WEB-INF/views/course-create.jsp"%>

	</div>

</body>