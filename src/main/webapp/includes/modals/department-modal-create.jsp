<%@include file="/includes/statics-resources/tag-libs.jsp"%>

<div class="modalContainer">

	<div class="modalDialog">

		<section class="modalHeader">
			<a href="#" id="closeModal">X</a>
		</section>

		<section class="modalBody">

			<h2 id="tittleModal">Registrar Departamento</h2>
			<div id="dialogModal">

				<form:form id="formCreateDepartment" modelAttribute="department">

					<table>

						<tr>

							<td>
								<fieldset>
									<form:label path="name">Nombre</form:label>
									<form:input path="name" type="text" id="nameCreate" />
									<label id="nameCreateError" class="validation-error"> </label>
								</fieldset>
							</td>

					</table>

				</form:form>

			</div>

		</section>

		<section class="modalFooter">
			<input id="buttonCreateDepartment" class="button add-button"
				type="submit" value="Registrar Departamento" /> 
				<input id="buttonCancel" class="button delete-button" type="submit" value="Cancelar" />
		</section>

	</div>

</div>
