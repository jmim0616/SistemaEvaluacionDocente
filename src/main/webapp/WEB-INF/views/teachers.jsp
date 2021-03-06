<!DOCTYPE html>
<html lang="en">

<%@include file="/includes/statics-resources/tag-libs.jsp"%>

<!--Menu -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/layout/menu/menu.js"></script>



<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/teacher/teachers.js"></script>
	


<body>

<div class="menu">

	<ul class="menu-list">


		<li class="general-menu" ><a href="#"> Procesos Asociados <i class="icon-right"><ion-icon
						name="arrow-dropdown"></ion-icon></i></a>

			<ul>

		<li class="sub-menu" > <a href="#" > Registro <i class="icon-right">
		<ion-icon name="arrow-dropdown"></ion-icon></i></a>
		
			<ul class="sub-menu-content">
			
				<li><a id="linkCreateTeacher" href="#"> Registrar Con Formulario </a></li>
				<li><a id="linkCreateExcelTeacher" href="#">Registrar con excel</a></li>
			</ul></li>

				

				<li class="sub-menu"><a href="#"> Modificación <i
						class="icon-right"><ion-icon name="arrow-dropdown"></ion-icon></i></a>

					<ul class="sub-menu-content">

						<form:form id="formSearchTeacher" modelAttribute="teacher">

							<fieldset>
								<form:label path="teacherId">Identificación del Docente</form:label>
								<form:input path="teacherId" type="text" id="teacherIdSearch" />
							</fieldset>
							
							<fieldset>
								<form:label path="name">Nombre del Docente</form:label>
								<form:input path="name" type="text" id="nameSearch" />
							</fieldset>

							<fieldset>
									<form:label path="subjectSearch">Nombre de la Asignatura</form:label>
									<form:input path="subjectSearch" type="text" id="subjectSearch" />
									</label>
							</fieldset>

							<input id="buttonSearchTeacher" class="button sent-button"
								type="submit" value="Buscar Docente" />
								
						</form:form>

					</ul>
					
					</li>
		
		
		
	</ul>


</div>

<div class="content">

	<h2>DOCENTES</h2>


</div>

</body>






