<%@include file="/includes/statics-resources/tag-libs.jsp"%>


<div class="createFaculty">

	<div class="modalContainer">

		<div class="modalDialog">

			<section class="modalHeader">
				<a href="#" id="closeModal">X</a>
			</section>
			
			<form:form id="formCreateFaculty" modelAttribute="faculty">
			
				<section class="modalBody">
					<h2 id="tittleModal">Registrar Facultad</h2>
					<div id="dialogModal">



						<table>

							<tr>

								<td>
									<fieldset>
										<form:label path="name">Nombre</form:label>
										<form:input path="name" type="text" id="nameCreate" />
										<label id="nameCreateError" class="validation-error">
										</label>
									</fieldset>
								</td>

							</tr>
						</table>

					</div>

				</section>

				<section class="modalFooter">
					<input id="buttonCreateFaculty" class="button add-button"
						type="submit" value="Registrar Facultad" /> <input
						id="buttonCancel" class="button delete-button" type="submit"
						value="Cancelar" />
				</section>

			</form:form>

		</div>

	</div>

</div>