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
								<fieldset class="row">
									<form:label path="departmentId">Codigo</form:label>
									<form:input path="departmentId" type="text"
										id="departmentIdCreate" />
									<label id="departmentIdCreateError" class="validation-error">
									</label>
								</fieldset> <td>
				
				
							<td>
					<fieldset>
						<form:label path="name">Nombre</form:label>
						<form:input path="name" type="text" id="nameCreate" />
						<label id="nameCreateError" class="validation-error"> </label>
					</fieldset>
				</td>
				
			</tr>

		</table>

	</form:form>
 
 </div>
 
<!-- <p id="dialogModal" > El estado del profesor es activo, desea inactivarlo ? </p> --></se
							ction>

<section class="modalFooter">
<input id="buttonCreateDepartment" class="button add-button"
				type="submit" value="Registrar Departamento" />
 <input id="buttonCancel" class="button delete-button" type="submit" />
</section>

</div>

</div>
