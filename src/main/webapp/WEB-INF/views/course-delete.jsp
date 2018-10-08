<%@include file="/includes/statics-resources/tag-libs.jsp"%>


<div class="deleteCourse">

	<div class="modalContainer">

		<div class="modalDialog">

			<section class="modalHeader">
				<a href="#" id="closeModal">X</a>
			</section>

			<section class="modalBody">

				<h2 id="tittleModal">Eliminar Curso</h2>

				<p id="dialogModal">
					Esta seguro que desea eliminar el curso ?
				</p>
				<form:form modelAttribute="course">

					<form:hidden path="groupId" id="groupIdDelete" />

				</form:form>
			</section>

			<section class="modalFooter">
				<input id="buttonDeleteCourse" class="button sent-button"
					type="submit" value="Eliminar Curso" /> <input
					id="buttonCancel" class="button delete-button" type="submit"
					value="Cancelar" />
			</section>

		</div>

	</div>


</div>