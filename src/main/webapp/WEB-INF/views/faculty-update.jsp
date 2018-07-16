<%@include file="/includes/statics-resources/tag-libs.jsp"%>


<div class="updateFaculty">


	<div class="modalContainer">

		<div class="modalDialog">

			<section class="modalHeader">
				<a href="#" id="closeModal">X</a>
			</section>

			<form:form id="formUpdateFaculty" modelAttribute="faculty">
				<form:hidden path="facultyId" id="facultyIdUpdate" />

				<section class="modalBody">

					<h2 id="tittleModal">Modificar Facultad</h2>
					<div id="dialogModal">

						<table>

							<tr>
								<td>
									<fieldset>
										<form:label path="name">Nombre</form:label>
										<form:input path="name" type="text" id="nameUpdate" />
										<label id="nameUpdateError" class="validation-error">
										</label>
									</fieldset>
								</td>
		
						</table>



					</div>

				</section>

				<section class="modalFooter">
					<input id="buttonUpdateFaculty" class="button edit-button"
						type="submit" value="Modificar Facultad" /> <input
						id="buttonCancel" class="button delete-button" type="submit"
						value="Cancelar" />
				</section>

			</form:form>

		</div>

	</div>



</div>