<%@include file="/includes/statics-resources/tag-libs.jsp"%>

<!--academicPeriod-create-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/academicPeriod/academicPeriod-create.js"></script>


<div class="createAcademicPeriod">

	<h2>PERIODOS ACADEMICOS</h2>

	<h3>Registrar Periodo Academico</h3>

	<form:form id="formCreateAcademicPeriod"
		modelAttribute="academicPeriod">

		<table>

			<tr>

				<td>
					<fieldset>
						<form:label path="name">Nombre</form:label>
						<form:input path="name" type="text" id="nameCreate" />
						<label id="nameCreateError" class="validation-error"> </label>
					</fieldset>
				</td>

			</tr>

			<tr>

				<td>
					<fieldset>
						<form:label path="initialDate">Fecha de Inicio</form:label>
						<form:input path="initialDate" type="date" id="initialDateCreate" />
						<label id="initialDateCreateError" class="validation-error">
						</label>
					</fieldset>
					
				</td>

			</tr>

			<tr>
				<td>
					<fieldset>
						<form:label path="endDate">Fecha de Fin</form:label>
						<form:input path="endDate" type="date" id="endDateCreate" />
						<label id="endDateCreateError" class="validation-error"> </label>
					</fieldset>
				</td>
			</tr>

		</table>

		<input id="buttonCreateAcademicPeriod" class="button add-button"
			type="submit" value="Registrar Periodo Academico" />

	</form:form>

</div>