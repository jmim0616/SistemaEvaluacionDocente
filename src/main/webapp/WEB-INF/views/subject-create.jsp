<%@include file="/includes/statics-resources/tag-libs.jsp"%>

<!--subject-create-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/subject/subject-create.js"></script>
	
<!-- taify -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/vendors/js/tagify/tagify.min.js"></script>

	 <link rel="stylesheet" type="text/css" 
	 href="${pageContext.request.contextPath}/resources/vendors/js/tagify/tagify.css" />

<div class="createTeacher scroll">


	<h2>ASIGNATURAS</h2>

	<h3>Registrar Asignatura</h3>
	
		<br>
	<label>Los campos marcados con asterisco (<a style="color: red;"><strong>*</strong></a>), son obligatorios </label>
	

	<form:form id="formCreateSubject" modelAttribute="subject">

		<table>
		
		 <tr>

				<td>

					<fieldset>
						<form:label path="subjectId">Código de la Asignatura<a style="color: red;"><strong>*</strong></a> </form:label>
						<form:input path="subjectId" type="text" id="subjectIdCreate" />
						<label id="subjectIdCreateError" class="validation-error"> </label>
					</fieldset>

				</td>


			</tr>

			<tr>

				<td>
					<fieldset>
						<form:label path="disciplinaryArea">Área Disciplinaria <a style="color: red;"><strong>*</strong></a> </form:label>
						<form:select path="disciplinaryArea" id="disciplinaryAreaCreate">
							<c:forEach items="${disciplinaryAreas}" var="item">
								<option value="${item.disciplinaryAreaId}">${item.name}</option>
							</c:forEach>
						</form:select>
						<label id="disciplinaryAreaCreateError" class="validation-error">
						</label>
					</fieldset>

				</td>

			</tr>

			<tr>

				<td>

					<fieldset>
						<form:label path="name">Nombre <a style="color: red;"><strong>*</strong></a> </form:label>
						<form:input path="name" type="text" id="nameCreate" />
						<label id="nameCreateError" class="validation-error"> </label>
					</fieldset>

				</td>


			</tr>

			<tr>

				<td>

					<fieldset>
						<form:label path="numberOfCredits">Número de Créditos <a style="color: red;"><strong>*</strong></a> </form:label>
						<form:select path="numberOfCredits" id="numberOfCreditsCreate">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option>
							<option value="10">10</option>
						</form:select>
					</fieldset>

				</td>


			</tr>

			<tr>

				<td>

					<fieldset>
						<label>Agregar Programas Académicos </label>
						<textarea name="academicProgramCreate" id="academicProgramCreate" ></textarea>
						<label id="academicProgramCreateError" class="validation-error">
						</label>
					</fieldset>

				</td>


			</tr>


			<tr>

				<td><input id="buttonCreateSubject" class="button add-button"
					type="submit" value="Registrar Asignatura" /></td>

			</tr>

		</table>

	</form:form>

</div>