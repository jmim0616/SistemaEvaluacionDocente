<%@include file="/includes/statics-resources/tag-libs.jsp"%>

<!--Menu -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/layout/menu/menu.js"></script>

<!--subjects -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/subject/subjects.js"></script>


<div class="menu">

	<ul class="menu-list">


		<li class="general-menu" ><a href="#"> Procesos Asociados <i class="icon-right"><ion-icon
						name="arrow-dropdown"></ion-icon></i></a>

			<ul>

		<li class="sub-menu" > <a href="#" > Registro <i class="icon-right">
		<ion-icon name="arrow-dropdown"></ion-icon></i></a>
		
			<ul class="sub-menu-content">
			
				<li><a id="linkCreateSubject" href="#"> Registrar Con Formulario </a></li>
				<li><a id="linkCreateExcelSubject" href="#"> Registrar Mediante Excel</a></li>
				
			</ul></li>

				
				<li class="sub-menu"><a href="#"> Modificacion <i
						class="icon-right"><ion-icon name="arrow-dropdown"></ion-icon></i></a>

					<ul class="sub-menu-content">

						<form:form id="formSearchSubject" modelAttribute="subject">

							<fieldset>
								<form:label path="name">Identificacion de la Asignatura</form:label>
								<form:input path="name" type="text" id="nameSearch" />
								<label id="nameSearchError" class="validation-error"> </label>
							</fieldset>

							<input id="buttonSearchSubject" class="button sent-button"
								type="submit" value="Buscar Asignatura" />
								
						</form:form>

					</ul>
					
					</li>

		
	</ul>


</div>



<div class="content">

	<h2>ASIGNATURAS</h2>


</div>

