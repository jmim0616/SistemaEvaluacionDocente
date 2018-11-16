<!--department-data-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/department/department-data.js"></script>

<!--department-create-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/department/department-create.js"></script>
	
<!--department-update-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/department/department-update.js"></script>

<div class="scroll departmentData">


	<h2>DEPARTAMENTOS</h2>

	<h3>Resultado de Departamentos</h3>

	<table id="tableDepartmentData" class="table standard-table">

		<thead>

			<tr class="not">

				<th>Código</th>
				<th>Facultad</th>
				<th>Nombre</th>
				<th>Acciones</th>

			</tr>

		</thead>


	</table>


	<%@include file="/WEB-INF/views/department-create.jsp"%>
	<%@include file="/WEB-INF/views/department-update.jsp"%>


</div>