<%@include file="/includes/statics-resources/tag-libs.jsp"%>

<!--teacher-update-status-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/teacher/teacher-update-status.js"></script>

<div class="updateTeacherStatus">

		<h2>DOCENTES</h2>

	<div class="modalContainer">

		<div class="modalDialog">

			<section class="modalHeader">
				<a href="#" id="closeModal">X</a>
			</section>

			<section class="modalBody">

				<h2 id="tittleModal">Modificar Estado de Docente</h2>

				<p id="dialogModal">
					El estado del docente es <strong> <span class="status"></span></strong>,
					desea Cambiar su estado ?
				</p>
				<form:form modelAttribute="teacher">

					<form:hidden path="teacherId" id="teacherIdUpdateStatus" />

				</form:form>
			</section>

			<section class="modalFooter">
				<input id="buttonUpdateStatusTeacher" class="button sent-button"
					type="submit" value="Modificar Estado de Docente" /> <input
					id="buttonCancel" class="button delete-button" type="submit"
					value="Cancelar" />
			</section>

		</div>

	</div>


</div>