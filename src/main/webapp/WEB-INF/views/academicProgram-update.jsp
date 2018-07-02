<%@include file="/includes/statics-resources/tag-libs.jsp"%>

<!--academicProgram-update-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/academicProgram/academicProgram-update.js"></script>


<div class="updateAcademicProgram">

    <div class="success">
     <a href="#" class="close">X</a>
	 <a class="icon"><ion-icon name="checkmark-circle-outline"></ion-icon></a> 
	<label class="message"></label>
    </div>

	<h2>PROGRAMAS ACADEMICOS</h2>

	<%@include file="/includes/modals/academicProgram-modal-update.jsp"%>
	

</div>