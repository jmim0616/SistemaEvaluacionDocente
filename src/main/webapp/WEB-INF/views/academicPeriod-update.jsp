<%@include file="/includes/statics-resources/tag-libs.jsp"%>

<!--academicPeriod-update-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/academicPeriod/academicPeriod-update.js"></script>


<div class="updateAcademicPeriod">

	<h2>PERIODOS ACADEMICOS</h2>

	<h3>Modificar Periodo Academico</h3>

	<form:form id="formUpdateAcademicPeriod"
		modelAttribute="academicPeriod">

		<form:hidden path="academicPeriodId" id="academicPeriodIdUpdate" />

		<table>

			<tr>

				<td>
					<fieldset>
						<form:label path="name">Nombre</form:label>
						<form:input path="name" type="text" id="nameUpdate1" disabled="true" />
						-
						<form:select path="name"
							id="nameUpdate2">
							<option class="actualValue" hidden></option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
						</form:select>	
						<label id="nameUpdateError" class="validation-error"> </label>
					</fieldset>
				</td>

			</tr>

			<tr>

				<td>
					<fieldset>
						<form:label path="initialDate">Fecha de Inicio</form:label>
<%-- 						<form:input path="initialDate" type="date" id="initialDateCreate" /> --%>
							<input type="text" id="initialDateUpdate">
						<label id="initialDateUpdateError" class="validation-error">
						</label>
					</fieldset>
				</td>

			</tr>

			<tr>
				<td>
				
					<fieldset>
						<form:label path="endDate">Fecha de Fin</form:label>
<%-- 						<form:input path="endDate" type="date" id="endDateCreate" /> --%>
							<input type="text" id="endDateUpdate">
						<label id="endDateUpdateError" class="validation-error"> </label>
					</fieldset>
				</td>
			</tr>

		</table>


		<input id="buttonUpdateAcademicPeriod" class="button edit-button"
			type="submit" value="Modificar Periodo Academico" />

	</form:form>

</div>