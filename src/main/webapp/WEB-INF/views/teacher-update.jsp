<%@include file="/includes/statics-resources/tag-libs.jsp"%>

<!--teacher-update-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/teacher/teacher-update.js"></script>


<div class="updateTeacher scroll">

	<h2>DOCENTES</h2>

	<h3>Modificar Docente</h3>
	
	<br>
	<label>Los campos marcados con asterisco (<a style="color: red;"><strong>*</strong></a>), son obligatorios </label>
	

	<form:form id="formUpdateTeacher" modelAttribute="teacher">

	<table>

			<tr>

				<td>
					<fieldset class="row">
						<form:label path="teacherId"> Documento de Identificaci�n </form:label>
						<form:input path="teacherId" type="text" id="teacherIdUpdate" disabled="true" />
						<label id="teacherIdUpdateError" class="validation-error"></label>
					</fieldset>
				</td>

				<td>

					<fieldset>
						<form:label path="identificationType">Tipo de identificaci�n <a style="color: red;"><strong>*</strong></a> </form:label>
						<form:select path="identificationType"
							id="identificationTypeUpdate">
							<option class="actualValue" hidden></option>
							<option value="1">C�dula de Ciudadan�a</option>
							<option value="2">C�dula de Extranjer�a</option>
						</form:select>
						<label id="identificationTypeUpdateError" class="validation-error" style="color: white;"></label>
					</fieldset>

				</td>



			</tr>

			<tr>

				<td>

					<fieldset>
						<form:label path="name">Nombre <a style="color: red;"><strong>*</strong></a> </form:label>
						<form:input path="name" type="text" id="nameUpdate" />
						<label id="nameUpdateError" class="validation-error"> </label>
					</fieldset>

				</td>

				<td>

					<fieldset>
						<form:label path="lastName">Apellido <a style="color: red;"><strong>*</strong></a> </form:label>
						<form:input path="lastName" type="text" id="lastNameUpdate" />
						<label id="lastNameUpdateError" class="validation-error"></label>
					</fieldset>

				</td>

			</tr>

			<tr>
				<td>

					<fieldset>
						<form:label path="underDegree">T�tulo de Profesional <a style="color: red;"><strong>*</strong></a> </form:label>
						<form:input path="underDegree" type="text" id="underDegreeUpdate" />
						<label id="underDegreeUpdateError" class="validation-error"></label>
					</fieldset>


				</td>


				<td>

					<fieldset>
						<form:label path="masterDegree">T�tulo de Maestr�a</form:label>
						<form:input path="masterDegree" type="text"
							id="masterDegreeUpdate" />
						<label id="masterDegreeUpdateError" class="validation-error" style="color: white;"></label>
					</fieldset>

				</td>

			</tr>

			<tr>
				<td>


					<fieldset>
						<form:label path="doctorDegree">T�tulo de Doctorado</form:label>
						<form:input path="doctorDegree" type="text"
							id="doctorDegreeUpdate" />
						<label id="doctorDegreeUpdateError" class="validation-error"></label>
					</fieldset>

				</td>

				<td>

					<fieldset>
						<form:label path="institutionalMail">Correo Electr�nico Institucional</form:label>
						<form:input path="institutionalMail" type="text"
							id="institutionalMailUpdate" />
						<label id="institutionalMailUpdateError" class="validation-error"></label>
					</fieldset>

				</td>

			</tr>

			<tr>
				<td>

					<fieldset>
						<form:label path="personalMail">Correo Electr�nico Personal</form:label>
						<form:input path="personalMail" type="text"
							id="personalMailUpdate" />
						<label id="personalMailUpdateError" class="validation-error"></label>
					</fieldset>

				</td>

				<td>

					<fieldset>
						<form:label path="cellNumber">Tel�fono Celular</form:label>
						<form:input path="cellNumber" type="text" id="cellNumberUpdate" />
						<label id="cellNumberUpdateError" class="validation-error"></label>
					</fieldset>


				</td>

			</tr>

			<tr>
				<td>
					<fieldset>
						<form:label path="homeNumber">Tel�fono Fijo</form:label>
						<form:input path="homeNumber" type="text" id="homeNumberUpdate" />
						<label id="homeNumberUpdateError" class="validation-error"></label>
					</fieldset>

				</td>

				<td>
					<fieldset>
						<form:label path="experience">Experiencia</form:label>
						<form:textarea path="experience" id="experienceUpdate" />
						<label id="experienceUpdateError" class="validation-error"></label>
					</fieldset>
				</td>

			</tr>

			<tr>
				<td></td>

				<td><input id="buttonUpdateTeacher" class="button edit-button"
					type="submit" value="Modificar Docente" /></td>

			</tr>

		</table>

	</form:form>

</div>