<%@include file="/includes/statics-resources/tag-libs.jsp"%>

<!--Menu -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/layout/menu/menu.js"></script>

<!--teacher -->
<!-- <script type="text/javascript" -->
<%-- 	src="${pageContext.request.contextPath}/resources/project/js/teacher/teacher.js"></script> --%>

<!--teachers --> 
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/teacher/teachers.js"></script>


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

				

				<li class="sub-menu"><a href="#"> Modificacion <i
						class="icon-right"><ion-icon name="arrow-dropdown"></ion-icon></i></a>

					<ul class="sub-menu-content">

						<form:form id="formSearchTeacher" modelAttribute="teacher">

							<fieldset>
								<form:label path="teacherId">Identificacion del Docente</form:label>
								<form:input path="teacherId" type="text" id="teacherIdSearch" />
								<label id="teacherIdSearchError" class="validation-error"> </label>
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

