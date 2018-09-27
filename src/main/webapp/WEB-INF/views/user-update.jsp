<%@include file="/includes/statics-resources/tag-libs.jsp"%>


<div class="updateUser" >

	<div class="modalContainer">

		<div class="modalDialog">

			<section class="modalHeader">
				<a href="#" id="closeModal">X</a>
			</section>

			<form:form id="formUpdateUser" modelAttribute="user">
				<form:hidden path="UserId" id="userIdUpdate" />

				<section class="modalBody">

					<h2 id="tittleModal">Modificar usuario</h2>
					<div id="dialogModal">

						<table>

							<tr>
								<td>
									<fieldset>
										<form:label path="mask">Nombre de usuario</form:label>
										<form:input path="mask" type="text" id="maskUpdate" />
										<label id="maskUpdateError" class="validation-error">
										</label>
									</fieldset>
								</td>

								<td>
									<fieldset>
										<form:label path="password">Contraseña</form:label>
										<form:input path="password" type="password" id="passwordUpdate" />
										<label id="passwordUpdateError" class="validation-error">
										</label>
									</fieldset>
								</td>
							</tr>
							<tr>
								<td>
									<fieldset>
										<form:label path="name">Nombre</form:label>
										<form:input path="name" type="text" id="nameUpdate" />
										<label id="nameUpdateError" class="validation-error">
										</label>
									</fieldset>
								</td>

								<td>
									<fieldset>
										<form:label path="institutionalMail">Correo electrónico institucional</form:label>
										<form:input path="institutionalMail" type="text"
											id="institutionalMailUpdate" />
										<label id="institutionalMailUpdateError"
											class="validation-error"> </label>
									</fieldset>
								</td>
							</tr>
							
							<tr>
								<td style= display:none; >

									<fieldset>
										<form:label path="status">Correo electrónico personal</form:label>
										<form:input path="status" type="text"
											id="status" />
										<label id="statuslUpdateError" class="validation-error">
										</label>
									</fieldset>

								</td>
								
								<td style= display:none;>

									<fieldset>
										<form:label path="userType">Correo electrónico personal</form:label>
										<form:input path="userType" type="text"
											id="userTypeUpdate" />
										<label id="userTypeUpdateError" class="validation-error">
										</label>
									</fieldset>

								</td>
								
								<td style= display:none;>

									<fieldset>
										<form:label path="jobPosition">Correo electrónico personal</form:label>
										<form:input path="jobPosition" type="text"
											id="jobPositionUpdate" />
										<label id="jobPositionUpdateError" class="validation-error">
										</label>
									</fieldset>

								</td>
								
								<td>

									<fieldset>
										<form:label path="personalMail">Correo electrónico personal</form:label>
										<form:input path="personalMail" type="text"
											id="personalMailUpdate" />
										<label id="personalMailUpdateError" class="validation-error">
										</label>
									</fieldset>

								</td>

							</tr>

						</table>



					</div>

				</section>

				<section class="modalFooter">
					<input id="buttonUpdateUser" class="button edit-button"
						type="submit" value="Modificar usuario" /> <input
						id="buttonCancel" class="button delete-button" type="submit"
						value="Cancelar" />
				</section>

			</form:form>

		</div>

	</div>

</div>