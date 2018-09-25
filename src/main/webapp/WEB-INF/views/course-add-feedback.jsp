<%@include file="/includes/statics-resources/tag-libs.jsp"%>

<!--course-add-feedback-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/course/course-add-feedback.js"></script>

<div class="addFeedbackCourse">

	<h2>CURSOS</h2>

	<div class="modalContainer">

		<div class="modalDialog">

			<section class="modalHeader">
				<a href="#" id="closeModal">X</a>
			</section>

			<form:form id="formAddFeedbackCourse" modelAttribute="courseFeedback">
				<form:hidden path="course" id="courseAdd" />

				<section class="modalBody">

					<h2 id="tittleModal">Agregar Retroalimentacion al Curso</h2>
					<div id="dialogModal">

						<table>

							<tr>
								<td>
									<fieldset>
										<form:label path="feedBackType">Tipo de Retroalimentacion</form:label>
										<form:select path="feedBackType" id="feedBackTypeAdd">
								
										</form:select>
										<label id="feedBackTypeAddError" class="validation-error">
										</label>
									</fieldset>
								</td>
							<tr>
							<tr>
								<td>
									<fieldset>
										<form:label path="comment">Comentario</form:label>
										<form:textarea path="comment" id="commentAdd" />
										<label id="commentAddError" class="validation-error">
										</label>
									</fieldset>
								</td>
							<tr>
						</table>



					</div>

				</section>

				<section class="modalFooter">
					<input id="buttonAddFeedbackCourse" class="button add-button"
						type="submit" value="Agregar Retroalimentacion" /> <input
						id="buttonCancel" class="button delete-button" type="submit"
						value="Cancelar" />
				</section>

			</form:form>

		</div>

	</div>



</div>