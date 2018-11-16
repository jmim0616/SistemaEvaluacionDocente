<%@include file="/includes/statics-resources/tag-libs.jsp"%>

<!--academicPeriod-update-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/academicPeriod/academicPeriod-update.js"></script>


<div class="updateAcademicPeriod">

	<h2>PERIODOS ACADÉMICOS</h2>

	<h3>Modificar Periodo Académico</h3>
	
			<br>
	<label>Los campos marcados con asterisco (<a style="color: red;"><strong>*</strong></a>), son obligatorios </label>
	

	<form:form id="formUpdateAcademicPeriod"
		modelAttribute="academicPeriod">

		<form:hidden path="academicPeriodId" id="academicPeriodIdUpdate" />

		<table>

			<tr>

				<td>
					<fieldset>
						<form:label path="name">Nombre <a style="color: red;"><strong>*</strong></a> </form:label>
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
						<form:label path="initialDate">Fecha de Inicio <a style="color: red;"><strong>*</strong></a> </form:label>
							<input type="text" id="initialDateUpdate">
						<label id="initialDateUpdateError" class="validation-error">
						</label>
					</fieldset>
				</td>

			</tr>

			<tr>
				<td>
				
					<fieldset>
						<form:label path="endDate">Fecha de Fin <a style="color: red;"><strong>*</strong></a> </form:label>
							<input type="text" id="endDateUpdate">
						<label id="endDateUpdateError" class="validation-error"> </label>
					</fieldset>
				</td>
			</tr>

		</table>


		<input id="buttonUpdateAcademicPeriod" class="button edit-button"
			type="submit" value="Modificar Periodo Académico" />

	</form:form>

</div>