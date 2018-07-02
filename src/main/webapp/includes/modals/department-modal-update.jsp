<%@include file="/includes/statics-resources/tag-libs.jsp"%>

<div class="modalContainer">

	<div class="modalDialog">

		<section class="modalHeader">
			<a href="#" id="closeModal">X</a>
		</section>

		<section class="modalBody">

			<h2 id="tittleModal">Modificar Departamento</h2>
			<div id="dialogModal">

				<form:form id="formCreateDepartment" modelAttribute="department">
				<form:hidden path="departmentId" id="departmentIdUpdate"/>
					<table>

						<tr>

							<td>
								<fieldset>
									<form:label path="name">Nombre</form:label>
									<form:input path="name" type="text" id="nameUpdate" />
									<label id="nameUpdateError" class="validation-error"> </label>
								</fieldset>
							</td>

						</tr>

					</table>

				</form:form>

			</div>

		</section>

		<section class="modalFooter">
			<input id="buttonUpdateDepartment" class="button edit-button"
				type="submit" value="Modificar Departamento" />
				<input id="buttonCancel" class="button delete-button" type="submit" value="Cancelar" />
		</section>

	</div>

</div>
