<%@include file="/includes/statics-resources/tag-libs.jsp"%>

<div class="modalContainer">

	<div class="modalDialog">

		<section class="modalHeader">
			<a href="#" id="closeModal">X</a>
		</section>
		
		<section class="modalBody">
			<h2 id="tittleModal">Registrar Facultad</h2>
			<div id="dialogModal">

				<form:form id="formCreateFaculty" modelAttribute="faculty">

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
									<form:label path="department">Departamento</form:label>
									<form:select path="department" id="departmentCreate">
									<c:forEach items="${departments}" var="item">
									<option value="${item.departmentId}">${item.name}</option>
									</c:forEach>
									</form:select>
									<label id="departmentCreateError" class="validation-error">
									</label>
								</fieldset>

							</td>
</tr>
					</table>

				</form:form>

			</div>

		</section>

		<section class="modalFooter">
			<input id="buttonCreateFaculty" class="button add-button"
				type="submit" value="Registrar Facultad" /> <input
				id="buttonCancel" class="button delete-button" type="submit" value="Cancelar" />
		</section>
	</div>

</div>
