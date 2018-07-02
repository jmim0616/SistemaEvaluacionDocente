<!--department-data-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/department/department-data.js"></script>


<div class="departmentData">

	<div class="error">
		<a href="#" class="close">X</a> <a class="icon"><ion-icon
				name="warning"></ion-icon></a> <label class="message"></label>
	</div>

	<h2>DEPARTAMENTOS</h2>

	<h3>Resultado de Departamentos</h3>

	<%@include file="/includes/toolbars/toolbar-department-update.jsp"%>

	<table id="tableDepartmentData" class="table standard-table">

		<thead>

			<tr class="not">

				<th>Codigo</th>
				<th>Nombre</th>

			</tr>

		</thead>


	</table>



</div>