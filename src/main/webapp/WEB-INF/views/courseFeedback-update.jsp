<%@include file="/includes/statics-resources/tag-libs.jsp"%>


<div class="updateCourseFeedback">


	<div class="modalContainer">

		<div class="modalDialog">

			<section class="modalHeader">
				<a href="#" id="closeModal">X</a>
			</section>

			<form:form id="formUpdateCourseFeedback"
				modelAttribute="courseFeedback">

				<form:hidden path="courseFeedBackId" id="courseFeedBackIdUpdate" />

				<section class="modalBody">

					<h2 id="tittleModal">Modificar Retroalimentacion</h2>
					<div id="dialogModal">

						<br> <label>Los campos marcados con asterisco (<a
							style="color: red;"><strong>*</strong></a>), son obligatorios
						</label>


						<table>

							<tr>
								<td>
									<fieldset>
										<form:label path="feedBackType">Tipo de Retroalimentacion</form:label>
										<form:label path="feedBackType" id="feedBackTypeUpdate"></form:label>
									</fieldset>
								</td>
							</tr>
							<tr>
								<td>
									<fieldset>
										<form:label path="comment">Comentario <a style="color: red;"><strong>*</strong></a> </form:label>
										<form:textarea path="comment" id="commentUpdate" />
										<label id="commentUpdateError" class="validation-error">
										</label>
									</fieldset>
								</td>
							</tr>

						</table>



					</div>

				</section>

				<section class="modalFooter">
					<input id="buttonUpdateCourseFeedback" class="button edit-button"
						type="submit" value="Modificar Retroalimentacion del Curso" /> <input
						id="buttonCancel" class="button delete-button" type="submit"
						value="Cancelar" />
				</section>

			</form:form>

		</div>

	</div>



</div>