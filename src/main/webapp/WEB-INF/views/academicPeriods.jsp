<%@include file="/includes/statics-resources/tag-libs.jsp"%>

<!--Menu -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/layout/menu/menu.js"></script>

<!--academicPeriods -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/academicPeriod/academicPeriods.js"></script>

<div class="menu">

	<ul class="menu-list">


		<li class="general-menu" ><a href="#"> Procesos Asociados <i class="icon-right"><ion-icon
						name="arrow-dropdown"></ion-icon></i></a>

			<ul>

				<li><a id="linkCreateAcademicPeriod" href="#"> Registrar </a></li>

				<li class="sub-menu"><a href="#"> Modificacion <i
						class="icon-right"><ion-icon name="arrow-dropdown"></ion-icon></i></a>

					<ul class="sub-menu-content">

						<form:form id="formSearchAcademicPeriod" modelAttribute="academicPeriod">

							<fieldset>
								<form:label path="name">Año del Periodo Academico</form:label>
								<form:input path="name" type="text" id="nameSearch" />
								<label id="nameSearchError" class="validation-error"> </label>
							</fieldset>

							<input id="buttonSearchAcademicPeriod" class="button sent-button"
								type="submit" value="Buscar Periodo Academico" />
								
						</form:form>

					</ul>
					
					</li>

		
	</ul>


</div>



<div class="content">

	<h2>PERIODOS ACADEMICOS</h2>


</div>

