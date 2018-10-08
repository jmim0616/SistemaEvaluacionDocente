<!--faculty-data-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/user/user-data.js"></script>
	<div class="scroll facultyData">

<!--user-create-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/user/user-create.js"></script>
	
	<!--user-update-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/user/user-update.js"></script>
	
	<!--user-update-status-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/user/user-update-status.js"></script>

	
	<h2>USUARIOS</h2>

	<h3>Resultados</h3>

	<table id="tableUserData" class="table standard-table">

		<thead>

			<tr class="not">
			
				<th>Código</th>
				<th>Nombre de usuario</th>
				<th>Nombre</th>
				<th>Cargo laboral</th>
				<th>Correo electrónico institucional</th>
				<th>Correo electrónico personal</th>
				<th>Estado</th>
				<th>Acciones</th>
				<th style="display:none;">Password</th>
				<th style="display:none;">userType</th>
				<th style="display:none;">jobPosition</th>

			</tr>

		</thead>
		
	</table>
	
	<%@include file="/WEB-INF/views/user-update.jsp"%>
	<%@include file="/WEB-INF/views/user-update-status.jsp"%>

</div>