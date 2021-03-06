<%@include file="/includes/statics-resources/tag-libs.jsp"%>


<div class="addFeedbackCourse">

	<div class="modalContainer">

		<div class="modalDialog">

			<section class="modalHeader">
				<a href="#" id="closeModal">X</a>
			</section>

			<form:form id="formAddFeedbackCourse" modelAttribute="courseFeedback">
				<form:hidden path="course" id="courseAdd" />
				<input type="text" style="display: none;" id="groupIdAdd">

				<section class="modalBody">

					<h2 id="tittleModal">Agregar Retroalimentacion al Curso</h2>
					<div id="dialogModal">
					
						<br>
						<label>Los campos marcados con asterisco (<a style="color: red;"><strong>*</strong></a>), son obligatorios </label>
					

						<table>

							<tr>
								<td>
									<fieldset>
										<form:label path="feedBackType">Tipo de Retroalimentación <a style="color: red;"><strong>*</strong></a> </form:label>
										<form:select path="feedBackType" id="feedBackTypeAdd">
								
										</form:select>
										<label id="feedBackTypeAddError" class="validation-error">
										</label>
									</fieldset>
								</td>
							</tr>
							<tr>
								<td>
									<fieldset>
										<form:label path="comment">Comentario <a style="color: red;"><strong>*</strong></a> </form:label>
										<form:textarea path="comment" id="commentAdd" />
										<label id="commentAddError" class="validation-error">
										</label>
									</fieldset>
								</td>
							</tr>
						
						</table>



					</div>

				</section>

				<section class="modalFooter">
					<input id="buttonAddFeedbackCourse" class="button add-button"
						type="submit" value="Agregar Retroalimentación" /> <input
						id="buttonCancel" class="button delete-button" type="submit"
						value="Cancelar" />
				</section>

			</form:form>

		</div>

	</div>



</div>