<%@include file="/includes/statics-resources/tag-libs.jsp"%>

<!--teacher-create-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/teacher/teacher-create.js"></script>


<div class="createTeacher scroll">


	<h2>DOCENTES</h2>

	<h3>Registrar Docente</h3>
	
	<br>
	<label>Los campos marcados con asterisco (<a style="color: red;"><strong>*</strong></a>), son obligatorios </label>

	<form:form id="formCreateTeacher" modelAttribute="teacher" >

		<table>

			<tr>

				<td>
					<fieldset class="row">
						<form:label path="teacherId">Documento de Identificaci�n <a style="color: red;"><strong>*</strong></a> </form:label>
						<form:input path="teacherId" type="text" id="teacherIdCreate" />
						<label id="teacherIdCreateError" class="validation-error-form"></label>
					</fieldset>
				</td>

				<td>

					<fieldset>
						<form:label path="identificationType">Tipo de identificaci�n <a style="color: red;"><strong>*</strong></a> </form:label>
						<form:select path="identificationType"
							id="identificationTypeCreate">
							<option value="1">C�dula de Ciudadan�a</option>
							<option value="2">C�dula de Extranjer�a</option>
						</form:select>
						<label id="identificationTypeCreateError" class="validation-error-form" style="color: white;"></label>
					</fieldset>

				</td>



			</tr>

			<tr>

				<td>
					
					<fieldset>
						<form:label path="name">Nombre <a style="color: red;"><strong>*</strong></a> </form:label>
						<form:input path="name" type="text" id="nameCreate" />
						<label id="nameCreateError" class="validation-error-form"></label>
					</fieldset>

				</td>

				<td>

					<fieldset>
						<form:label path="lastName">Apellido <a style="color: red;"><strong>*</strong></a> </form:label>
						<form:input path="lastName" type="text" id="lastNameCreate" />
						<label id="lastNameCreateError" class="validation-error-form"></label>
					</fieldset>

				</td>

			</tr>

			<tr>
				<td>

					<fieldset>
						<form:label path="underDegree">T�tulo de Profesional <a style="color: red;"><strong>*</strong></a> </form:label>
						<form:input path="underDegree" type="text" id="underDegreeCreate" />
						<label id="underDegreeCreateError" class="validation-error-form"></label>
					</fieldset>


				</td>


				<td>

					<fieldset>
						<form:label path="masterDegree">T�tulo de Maestr�a</form:label>
						<form:input path="masterDegree" type="text"
							id="masterDegreeCreate" />
						<label id="masterDegreeCreateError" class="validation-error-form" style="color: white;"></label>
					</fieldset>

				</td>

			</tr>

			<tr>
				<td>


					<fieldset>
						<form:label path="doctorDegree">T�tulo de Doctorado</form:label>
						<form:input path="doctorDegree" type="text"
							id="doctorDegreeCreate" />
						<label id="doctorDegreeCreateError" class="validation-error-form"></label>
					</fieldset>

				</td>

				<td>

					<fieldset>
						<form:label path="institutionalMail">Correo Electr�nico Institucional</form:label>
						<form:input path="institutionalMail" type="text"
							id="institutionalMailCreate" />
						<label id="institutionalMailCreateError" class="validation-error-form"></label>
					</fieldset>

				</td>

			</tr>

			<tr>
				<td>

					<fieldset>
						<form:label path="personalMail">Correo Electr�nico Personal</form:label>
						<form:input path="personalMail" type="text"
							id="personalMailCreate" />
						<label id="personalMailCreateError" class="validation-error-form"></label>
					</fieldset>

				</td>

				<td>

					<fieldset>
						<form:label path="cellNumber">Tel�fono Celular</form:label>
						<form:input path="cellNumber" type="text" id="cellNumberCreate" />
						<label id="cellNumberCreateError" class="validation-error-form"></label>
					</fieldset>


				</td>

			</tr>

			<tr>
				<td>
					<fieldset>
						<form:label path="homeNumber">Tel�fono Fijo</form:label>
						<form:input path="homeNumber" type="text" id="homeNumberCreate" />
						<label id="homeNumberCreateError" class="validation-error-form"></label>
					</fieldset>

				</td>

				<td>
					<fieldset>
						<form:label path="experience">Experiencia</form:label>
						<form:textarea path="experience" id="experienceCreate" />
						<label id="experienceCreateError" class="validation-error-form"></1>
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