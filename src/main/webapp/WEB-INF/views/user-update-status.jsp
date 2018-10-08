<%@include file="/includes/statics-resources/tag-libs.jsp"%>


<div class="updateUserStatus">

	<div class="modalContainer">

		<div class="modalDialog">

			<section class="modalHeader">
				<a href="#" id="closeModal">X</a>
			</section>

			<section class="modalBody">

				<h2 id="tittleModal">Modificar estado del usuario</h2>

				<p id="dialogModal">
					El estado del usuario es <strong> <span class="status"></span></strong>,
					�desea Cambiar su estado?
				</p>
				<form:form modelAttribute="user">

					<form:hidden path="userId" id="userIdUpdateStatus" />

				</form:form>
			</section>

			<section class="modalFooter">
				<input id="buttonUpdateStatusUser" class="button sent-button"
					type="submit" value="Modificar estado de usuario" /> <input
					id="buttonCancel" class="button delete-button" type="submit"
					value="Cancelar" />
			</section>

		</div>

	</div>


</div>