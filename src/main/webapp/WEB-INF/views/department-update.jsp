<%@include file="/includes/statics-resources/tag-libs.jsp"%>


<div class="updateDepartment">


	<div class="modalContainer">

		<div class="modalDialog">

			<section class="modalHeader">
				<a href="#" id="closeModal">X</a>
			</section>

			<form:form id="formCreateDepartment" modelAttribute="department">
				<form:hidden path="departmentId" id="departmentIdUpdate" />

				<section class="modalBody">

					<h2 id="tittleModal">Modificar Departamento</h2>
					<div id="dialogModal">

						<br> <label>Los campos marcados con asterisco (<a style="color: red;"><strong>*</strong></a>), son obligatorios
						</label>


						<table>

							<tr>

								<td>
									<fieldset>
										<form:label path="faculty">Facultad <a style="color: red;"><strong>*</strong></a>
										</form:label>
										<form:select path="faculty" id="facultyUpdate">
											<option class="actualValue" hidden></option>
											<c:forEach items="${faculties}" var="item">
												<option value="${item.facultyId}">${item.name}</option>
											</c:forEach>
										</form:select>
										<label id="facultyUpdateError" class="validation-error">
										</label>
									</fieldset>

								</td>

								<td>
									<fieldset>
										<form:label path="name">Nombre <a style="color: red;"><strong>*</strong></a>
										</form:label>
										<form:input path="name" type="text" id="nameUpdate" />
										<label id="nameUpdateError" class="validation-error">
										</label>
									</fieldset>
								</td>


							</tr>

						</table>



					</div>

				</section>

				<section class="modalFooter">
					<input id="buttonUpdateDepartment" class="button edit-button"
						type="submit" value="Modificar Departamento" /> <input
						id="buttonCancel" class="button delete-button" type="submit"
						value="Cancelar" />
				</section>

			</form:form>

		</div>

	</div>



</div>