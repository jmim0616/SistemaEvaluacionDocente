<%@include file="/includes/statics-resources/tag-libs.jsp"%>


<div class="updateDisciplinaryArea">


	<div class="modalContainer">

		<div class="modalDialog">

			<section class="modalHeader">
				<a href="#" id="closeModal">X</a>
			</section>

			<form:form id="formUpdateDisciplinaryArea"
				modelAttribute="disciplinaryArea">
				<form:hidden path="disciplinaryAreaId" id="disciplinaryAreaIdUpdate" />

				<section class="modalBody">

					<h2 id="tittleModal">Modificar Área Disciplinar</h2>
					<div id="dialogModal">

						<br> <label>Los campos marcados con asterisco (<a style="color: red;"><strong>*</strong></a>), son obligatorios
						</label>

						<table>

							<tr>

								<td>
									<fieldset>
										<form:label path="department">Departamento <a style="color: red;"><strong>*</strong></a> </form:label>
										<form:select path="department" id="departmentUpdate">
											<option class="actualValue" hidden></option>
											<c:forEach items="${departments}" var="item">
												<option value="${item.departmentId}">${item.name}</option>
											</c:forEach>
										</form:select>
										<label id="departmentUpdateError" class="validation-error">
										</label>
									</fieldset>

								</td>

							</tr>

							<tr>

								<td>
									<fieldset>
										<form:label path="name">Nombre <a style="color: red;"><strong>*</strong></a> </form:label>
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
					<input id="buttonUpdateDisciplinaryArea" class="button edit-button"
						type="submit" value="Modificar Área Disciplinar" /> <input
						id="buttonCancel" class="button delete-button" type="submit"
						value="Cancelar" />
				</section>

			</form:form>

		</div>

	</div>



</div>