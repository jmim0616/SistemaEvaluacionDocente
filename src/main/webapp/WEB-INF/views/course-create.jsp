<%@include file="/includes/statics-resources/tag-libs.jsp"%>


<div class="createCourse">

	<div class="modalContainer">

		<div class="modalDialog">

			<section class="modalHeader">
				<a href="#" id="closeModal">X</a>
			</section>

			<form:form id="formCreateCourse" modelAttribute="course">

				<section class="modalBody">
					<h2 id="tittleModal">Registrar Curso</h2>
					<div id="dialogModal">



						<table>

							<tr>

								<td>
									<fieldset>
										<form:label path="groupId">Identificador de Grupo</form:label>
										<form:input path="groupId" type="text" id="groupIdCreate" />
										<label id="groupIdCreateError" class="validation-error">
										</label>
									</fieldset>
								</td>

								<td>
									<fieldset>
										<form:label path="subject">Asignatura</form:label>
										<form:input path="subject" type="text" id="subjectCreate" />
										<label id="subjectCreateError" class="validation-error">
										</label>
									</fieldset>
								</td>

							</tr>

							<tr>

								<td>
									<fieldset>
										<form:label path="teacher">Profesor</form:label>
										<form:input path="teacher" type="text" id="teacherCreate" />
										<label id="teacherCreateError" class="validation-error">
										</label>
									</fieldset>
								</td>

								<td>
									<fieldset>
										<form:label path="academicPeriod">Periodo Academico</form:label>
										<form:input path="academicPeriod" type="text"
											id="academicPeriodCreate" />
										<label id="academicPeriodCreateError" class="validation-error">
										</label>
									</fieldset>
								</td>


							</tr>


							<tr>

								<td>
									<fieldset>
										<form:label path="isVirtual">Es virtual</form:label>
										<form:select path="isVirtual" id="isVirtualCreate">
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
					<input id="buttonCreateCourse" class="button add-button"
						type="submit" value="Registrar Curso" /> <input id="buttonCancel"
						class="button delete-button" type="submit" value="Cancelar" />
				</section>

			</form:form>

		</div>

	</div>

</div>