<%@include file="/includes/statics-resources/tag-libs.jsp"%>


<div class="updateSubjectStatus">


	<div class="modalContainer">

		<div class="modalDialog">

			<section class="modalHeader">
				<a href="#" id="closeModal">X</a>
			</section>

			<section class="modalBody">

				<h2 id="tittleModal">Modificar Estado de la Asignatura</h2>

				<p id="dialogModal">
					El estado de la asignatura es <strong> <span class="status"></span></strong>,
					desea Cambiar su estado ?
				</p>
				<form:form modelAttribute="subject">

					<form:hidden path="subjectId" id="subjectIdUpdateStatus" />

				</form:form>
			</section>

			<section class="modalFooter">
				<input id="buttonUpdateStatusSubject" class="button sent-button"
					type="submit" value="Modificar Estado de Asignatura" /> <input
					id="buttonCancel" class="button delete-button" type="submit"
					value="Cancelar" />
			</section>

		</div>

	</div>


</div>