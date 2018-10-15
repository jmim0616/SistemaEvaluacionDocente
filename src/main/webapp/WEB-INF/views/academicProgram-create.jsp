<%@include file="/includes/statics-resources/tag-libs.jsp"%>



<div class="createAcademicProgram">

<div class="modalContainer">

	<div class="modalDialog">

		<section class="modalHeader">
			<a href="#" id="closeModal">X</a>
		</section>

<form:form id="formCreateAcademicProgram" modelAttribute="academicProgram">

		<section class="modalBody">

			<h2 id="tittleModal">Registrar Programa Academico</h2>
			<div id="dialogModal">

					<br>
	<label>Los campos marcados con asterisco (<a style="color: red;"><strong>*</strong></a>), son obligatorios </label>

					<table>

						<tr>

							<td>
								<fieldset>
									<form:label path="faculty">Facultad <a style="color: red;"><strong>*</strong></a> </form:label>
									<form:select path="faculty" id="facultyCreate">
									<c:forEach items="${faculties}" var="item">
									<option value="${item.facultyId}">${item.name}</option>
									</c:forEach>
									</form:select>
									<label id="facultyCreateError" class="validation-error">
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

					</table>

			

			</div>

		</section>

		<section class="modalFooter">
			<input id="buttonCreateAcademicProgram" class="button add-button"
				type="submit" value="Registrar Programa Academico" /> <input
				id="buttonCancel" class="button delete-button" type="submit" value="Cancelar" />
		</section>
		
			</form:form>
		
	</div>

</div>


</div>