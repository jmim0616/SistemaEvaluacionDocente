<%@include file="/includes/statics-resources/tag-libs.jsp"%>

<div class="modalContainer">

	<div class="modalDialog">

		<section class="modalHeader">
			<a href="#" id="closeModal">X</a>
		</section>

		<section class="modalBody">

			<h2 id="tittleModal">Modificar Area Disciplinaria</h2>
			<div id="dialogModal">

				<form:form id="formUpdateDisciplinaryArea"
					modelAttribute="disciplinaryArea">

					<table>

						<tr>

							<td>
								<fieldset class="row">
									<form:label path="disciplinaryAreaId">Codigo </form:label>
									<form:input path="disciplinaryAreaId" type="text"
										id="disciplinaryAreaIdUpdate" />
									<label id="disciplinaryAreaIdUpdateError"
										class="validation-error"> </label>
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
			<input id="buttonUpdateDisciplinaryArea" class="button edit-button"
				type="submit" value="Modificar Area Disciplinaria" /> <input
				id="buttonCancel" class="button delete-button" type="submit"
				value="Cancelar" />
		</section>

	</div>

</div>
