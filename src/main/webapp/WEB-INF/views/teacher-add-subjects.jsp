<%@include file="/includes/statics-resources/tag-libs.jsp"%>

<!--teacher-add-subjects-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/teacher/teacher-add-subjects.js"></script>
	
<!-- taify -->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/vendors/js/tagify/tagify.min.js"></script>

	 <link rel="stylesheet" type="text/css" 
	 href="${pageContext.request.contextPath}/resources/vendors/js/tagify/tagify.css" />

<div class="createTeacher scroll">


	<h2>DOCENTES</h2>

	<h3>Agregar Asignaturas al docente</h3>

	<form:form id="formAddSubjectTeacher" modelAttribute="teacher">

		<table class="table">
		
		<tr>
		<br>

				<td>
					<label> <strong> Documento de Identificacion </strong> </label>	
					<label id="teacherId" > <a> Documento de Identificacion </a>	  </label>	
				</td>
				
				<td>
					<label > <strong> Nombre </strong> </label>	
					<label id="name" >  </label>	
				</td>
				
				<td>
					<label > <strong> Apellido </strong> </label>	
					<label id="lastName" >  </label>	
				</td>

			</tr>
			
			<tr>

				<td>
					<label > <strong> Titulo de Profesional </strong> </label>	
					<label id="underDegree" >  </label>	
				</td>
				
				<td>
					<label > <strong> Titulo de Maestria </strong> </label>	
					<label id="masterDegree" >  </label>	
				</td>
				
				<td>
					<label > <strong> Titulo de Doctorado </strong> </label>	
					<label id="doctorDegree" >  </label>	
				</td>

			</tr>
				
			<tr>
				
				<td>
					<label > <strong> Experiencia </strong> </label>	
					<label id="experience" >  </label>	
				</td>

			</tr>

			<tr>

				<td>

					<fieldset>
						<label> Asignaturas </label>
						<textarea name="subjectAdd" id="subjectAdd" ></textarea>
						<label id="subjectAddError" class="validation-error">
						</label>
					</fieldset>

				</td>

			</tr>


			<tr>

				<td><input id="buttonAddSubjects" class="button add-button"
					type="submit" value="Agregar Asignatura" /></td>

			</tr>

		</table>

	</form:form>

</div>