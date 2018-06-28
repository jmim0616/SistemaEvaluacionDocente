<%@include file="/includes/statics-resources/tag-libs.jsp"%>

<div class="modalContainer">

	<div class="modalDialog">

		<section class="modalHeader">
			<a href="#" id="closeModal">X</a>
		</section>

		<section class="modalBody">

			<h2 id="tittleModal">Modificar Facultad</h2>
			<div id="dialogModal">

				<form:form id="formUpdateFaculty" modelAttribute="faculty">

					<table>

						<tr>

							<td>
								<fieldset class="row">
									<form:label path="facultyId">Codigo </form:label>
									<form:input path="facultyId" type="text" id="facultyIdUpdate" />
									<label id="facultyIdUpdateError" class="validation-error">
									</label>
								</fieldset>

							</td>

							<td>
								<fieldset class="row">
									<form:label path="department">Codigo del Departamento</form:label>
									<form:select path="department" id="departmentUpdate">
										<option value="-">Departamentos</option>
									</form:select>
									<label id="departmentUpdateError" class="validation-error">
									</label>
								</fieldset>

							</td>

						</tr>

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
<input id="buttonUpdateFaculty" class="button edit-button"
				type="submit" value="Modificar Facultad" />
 <input id="buttonCancel" class="button delete-button" type="submit" />
</section>

</div>

</div>
