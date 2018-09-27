<%@include file="/includes/statics-resources/tag-libs.jsp"%>


<div class="updateCourse">

	<div class="modalContainer">

		<div class="modalDialog">

			<section class="modalHeader">
				<a href="#" id="closeModal">X</a>
			</section>

			<form:form id="formUpdateCourse" modelAttribute="course">

				<form:hidden path="groupId" id="groupIdUpdate" />

				<section class="modalBody">
					<h2 id="tittleModal">Modificar Curso</h2>
					<div id="dialogModal">



						<table>

							<tr>

								<td>
									<fieldset>
										<form:label path="groupId">Identificador de Grupo</form:label>
										<form:input path="groupId" type="text" id="groupIdUpdate" disabled="true"/>
										<label id="groupIdUpdateError" class="validation-error">
										</label>
									</fieldset>
								</td>

								<td>
									<fieldset>
										<form:label path="subject">Asignatura</form:label>
										<form:input path="subject" type="text" id="subjectUpdate" />
										<label id="subjectUpdateError" class="validation-error">
										</label>
									</fieldset>
								</td>

							</tr>

							<tr>

								<td>
									<fieldset>
										<form:label path="teacher">Profesor</form:label>
										<form:input path="teacher" type="text" id="teacherUpdate" />
										<label id="teacherUpdateError" class="validation-error">
										</label>
									</fieldset>
								</td>

								<td>
									<fieldset>
										<form:label path="academicPeriod">Periodo Academico</form:label>
										<form:input path="academicPeriod" type="text"
											id="academicPeriodUpdate" />
										<label id="academicPeriodUpdateError" class="validation-error">
										</label>
									</fieldset>
								</td>


							</tr>


							<tr>

								<td>
									<fieldset>
										<form:label path="isVirtual">Es virtual</form:label>
										<form:select path="isVirtual" id="isVirtualUpdate">
											<option class="actualValue" hidden></option>
											<option value="1">Si</option>
											<option value="2">No</option>
										</form:select>
									</fieldset>
								</td>

							</tr>

						</table>

					</div>

				</section>

				<section class="modalFooter">
					<input id="buttonUpdateCourse" class="button edit-button"
						type="submit" value="Modificar Curso" /> <input id="buttonCancel"
						class="button delete-button" type="submit" value="Cancelar" />
				</section>

			</form:form>

		</div>

	</div>

</div>