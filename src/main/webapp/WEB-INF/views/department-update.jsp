<%@include file="/includes/statics-resources/tag-libs.jsp"%>

<!--department-update-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/department/department-update.js"></script>


<div class="updateDepartment">

    <div class="success">
     <a href="#" class="close">X</a>
	 <a class="icon"><ion-icon name="checkmark-circle-outline"></ion-icon></a> 
	<label class="message"></label>
    </div>

	<h2>DEPARTAMENTOS</h2>

	<%@include file="/includes/modals/department-modal-update.jsp"%>
	

</div>