<%@include file="/includes/statics-resources/tag-libs.jsp"%>

<!--teacher-create-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/teacher/teacher-create.js"></script>


<div class="createTeacher">

    <div class="success">
     <a href="#" class="close">X</a>
	 <a class="icon"><ion-icon name="checkmark-circle-outline"></ion-icon></a> 
	<label class="message"></label>
    </div>



	<h2>DOCENTES</h2>

	<h3>Registrar Docente</h3>

	<form:form id="formCreateTeacher" modelAttribute="teacher">

		<table>

			<tr>

				<td>
					<fieldset class="row">
						<form:label path="teacherId">Codigo</form:label>
						<form:input path="teacherId" type="text" id="teacherIdCreate" />
						<label id="teacherIdCreateError" class="validation-error">
						</label>
					</fieldset>
				</td>

				<td>
					<fieldset>
						<form:label path="doctorDegree">Titulo de Doctorado</form:label>
						<form:input path="doctorDegree" type="text"
							id="doctorDegreeCreate" />
						<label id="doctorDegreeCreateError" class="validation-error">
						</label>
					</fieldset>

				</td>



			</tr>

			<tr>

				<td>

					<fieldset>
						<form:label path="name">Nombre</form:label>
						<form:input path="name" type="text" id="nameCreate" />
						<label id="nameCreateError" class="validation-error"> </label>
					</fieldset>

				</td>

				<td>
					<fieldset>
						<form:label path="institutionalMail">Correo Electronico Institucional</form:label>
						<form:input path="institutionalMail" type="text"
							id="institutionalMailCreate" />
						<label id="institutionalMailCreateError" class="validation-error">
						</label>
					</fieldset>

				</td>

			</tr>

			<tr>
				<td>

					<fieldset>
						<form:label path="lastName">Apellido</form:label>
						<form:input path="lastName" type="text" id="lastNameCreate" />
						<label id="lastNameCreateError" class="validation-error">
						</label>
					</fieldset>

				</td>


				<td>
					<fieldset>
						<form:label path="personalMail">Correo Electronico Personal</form:label>
						<form:input path="personalMail" type="text"
							id="personalMailCreate" />
						<label id="personalMailCreateError" class="validation-error">
						</label>
					</fieldset>
				</td>

			</tr>

			<tr>
				<td>

					<fieldset>
						<form:label path="identificationType">Tipo de identificacion</form:label>
						<form:select path="identificationType"
							id="identificationTypeCreate">
							<option value="1">Cedula de Ciudadania</option>
							<option value="2">Cedula de Extranjeria</option>
						</form:select>
					</fieldset>

				</td>

				<td>
					<fieldset>
						<form:label path="cellNumber">Telefono Celular</form:label>
						<form:input path="cellNumber" type="text" id="cellNumberCreate" />
						<label id="cellNumberCreateError" class="validation-error">
						</label>
					</fieldset>
				</td>

			</tr>

			<tr>
				<td>
					<fieldset>
						<form:label path="underDegree">Titulo de Profesional</form:label>
						<form:input path="underDegree" type="text" id="underDegreeCreate" />
						<label id="underDegreeCreateError" class="validation-error">
						</label>
					</fieldset>

				</td>

				<td>
					<fieldset>
						<form:label path="homeNumber">Telefono Fijo</form:label>
						<form:input path="homeNumber" type="text" id="homeNumberCreate" />
						<label id="homeNumberCreateError" class="validation-error">
						</label>
					</fieldset>
				</td>

			</tr>

			<tr>
				<td>

					<fieldset>
						<form:label path="masterDegree">Titulo de Maestria</form:label>
						<form:input path="masterDegree" type="text"
							id="masterDegreeCreate" />
						<label id="masterDegreeCreateError" class="validation-error">
						</label>
					</fieldset>
				</td>

				<td>
					<fieldset>
						<form:label path="experience">Experiencia</form:label>
						<form:textarea path="experience" id="experienceCreate" />
						<label id="experienceCreateError" class="validation-error">
						</label>
					</fieldset>
				</td>

			</tr>

			<tr>
				<td></td>

				<td><input id="buttonCreateTeacher" class="button add-button"
					type="submit" value="Registrar Docente" /></td>

			</tr>

		</table>

	</form:form>

</div>