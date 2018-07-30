<%@include file="/includes/statics-resources/tag-libs.jsp"%>

<!--teacher-create-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/user/user-create.js"></script>


<div class="createTeacher scroll">

	<h2>USUARIOS</h2>

	<h3>Registrar usuario</h3>

	<form:form id="formCreateUser" modelAttribute="user" >

		<table>

			<tr>

				<td>

					<fieldset>
						<form:label path="mask">Nombre de usuario</form:label>
						<form:input path="mask"  type="text" id="maskCreate" />
						<label id="maskCreateError" class="validation-error"> </label>
					</fieldset>

				</td>
				
				<td>

					<fieldset>
						<form:label path="password">Contraseña</form:label>
						<form:input path="password" type="password" id="passwordCreate" />
						<label id="passwordCreateError" class="validation-error"> </label>
					</fieldset>

				</td>
				
			</tr>

			<tr>

				<td>

					<fieldset>
						<form:label path="name">Nombre</form:label>
						<form:input path="name" type="text" id="nameCreate" />
						<label id="nameCreateError" class="validation-error">
						</label>
					</fieldset>

				</td>
				
				<td>

					<fieldset>
						<form:label path="jobPosition">Cargo laboral</form:label>
						<form:select path="jobPosition"
							id="jobPositionCreate">
							<option value="1">Jefe de departamento</option>
							<option value="2">Coordinador de área</option>
						</form:select>
					</fieldset>
					
				</td>

			</tr>

			<tr>

				<td>
					<fieldset>
						<form:label path="institutionalMail">Correo electrónico institucional</form:label>
						<form:input path="institutionalMail" type="text"
							id="institutionalMailCreate" />
						<label id="institutionalMailCreateError" class="validation-error">
						</label>
					</fieldset>

				</td>
				
				<td>

					<fieldset>
						<form:label path="personalMail">Correo electrónico personal</form:label>
						<form:input path="personalMail" type="text"
							id="personalMailCreate" />
						<label id="personalMailCreateError" class="validation-error">
						</label>
					</fieldset>

				</td>

			</tr>

			<tr>
			
				<td><input id="buttonCreateUser" class="button add-button"
					type="submit" value="Registrar usuario" /></td>

			</tr>

		</table>

	</form:form>

</div>