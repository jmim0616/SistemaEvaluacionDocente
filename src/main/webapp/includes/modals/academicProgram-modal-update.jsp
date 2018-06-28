<%@include file="/includes/statics-resources/tag-libs.jsp"%>

<div class="modalContainer">

	<div class="modalDialog">

		<section class="modalHeader">
			<a href="#" id="closeModal">X</a>
		</section>

				<section class="modalBody">

			<h2 id="tittleModal">Modificar Programa Academico</h2>
			<div id="dialogModal">

				<form:form id="formUpdateAcademicProgram" modelAttribute="academicProgram">

					<table>

						<tr>

							<td>
								<fieldset class="row">
									<form:label path="academicProgramId">Codigo </form:label>
									<form:input path="academicProgramId" type="text" id="academicProgramIdUpdate" />
									<label id="academicProgramIdUpdateError" class="validation-error">
									</label>
								</fieldset>

							</td>

							<td>
								<fieldset class="row">
									<form:label path="faculty">Codigo de la Facultad</form:label>
									<form:select path="faculty" id="facultyUpdate">
										<option value="-">Facultades</option>
									</form:select>
									<label id="facultyUpdateError" class="validation-error">
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
<input id="buttonUpdateAcademicProgram" class="button edit-button"
				type="submit" value="Modificar Programa Academico" />
 <input id="buttonCancel" class="button delete-button" type="submit" value="Cancelar"/>
</section>

</div>

</div>
