<%@include file="/includes/statics-resources/tag-libs.jsp"%>



<div class="createDisciplinaryArea">

	<div class="modalContainer">

		<div class="modalDialog">

			<section class="modalHeader">
				<a href="#" id="closeModal">X</a>
			</section>

			<form:form id="formCreateDisciplinaryArea"
				modelAttribute="disciplinaryArea">

				<section class="modalBody">

					<h2 id="tittleModal">Registrar Área Disciplinar</h2>
					<div id="dialogModal">

						<br> <label>Los campos marcados con asterisco (<a
							style="color: red;"><strong>*</strong></a>), son obligatorios
						</label>

						<table>

							<tr>
								<td>
									<fieldset>
										<form:label path="department">Departamento <a
												style="color: red;"><strong>*</strong></a>
										</form:label>
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

							<tr>

								<td>
									<fieldset>
										<form:label path="name">Nombre <a
												style="color: red;"><strong>*</strong></a>
										</form:label>
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
					<input id="buttonCreateDisciplinaryArea" class="button add-button"
						type="submit" value="Registrar Área Disciplinar" /> <input
						id="buttonCancel" class="button delete-button" type="submit"
						value="Cancelar" />
				</section>

			</form:form>
		</div>

	</div>


</div>