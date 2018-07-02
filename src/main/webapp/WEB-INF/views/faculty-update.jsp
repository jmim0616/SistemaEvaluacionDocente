<%@include file="/includes/statics-resources/tag-libs.jsp"%>

<!--faculty-update-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/faculty/faculty-update.js"></script>


<div class="updateFaculty">

    <div class="success">
     <a href="#" class="close">X</a>
	 <a class="icon"><ion-icon name="checkmark-circle-outline"></ion-icon></a> 
	<label class="message"></label>
    </div>

	<h2>FACULTADES</h2>

	<%@include file="/includes/modals/faculty-modal-update.jsp"%>
	

</div>