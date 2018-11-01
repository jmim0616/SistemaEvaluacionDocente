<!--faculty-data-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/faculty/faculty-data.js"></script>
	<div class="scroll facultyData">

<!--faculty-create-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/faculty/faculty-create.js"></script>
	
	<!--faculty-update-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/faculty/faculty-update.js"></script>

	<h2>FACULTADES</h2>

	<h3>Resultado de Facultades</h3>

	<table id="tableFacultyData" class="table standard-table">

		<thead>

			<tr class="not">
			
				<th>Código</th>
				<th>Nombre</th>
				<th>Acciones</th>

			</tr>

		</thead>

		
	</table>

	<%@include file="/WEB-INF/views/faculty-create.jsp"%>
	<%@include file="/WEB-INF/views/faculty-update.jsp"%>

</div>