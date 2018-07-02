<!--faculty-data-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/faculty/faculty-data.js"></script>
	
	
<div class="facultyData">

	<div class="error">
		<a href="#" class="close">X</a> <a class="icon"><ion-icon
				name="warning"></ion-icon></a> <label class="message"></label>
	</div>

	<h2>FACULTADES</h2>

	<h3>Resultado de Facultades</h3>

	<%@include file="/includes/toolbars/toolbar-faculty-update.jsp"%>

	<table id="tableFacultyData" class="table standard-table">

		<thead>

			<tr class="not">
			
				<th>Codigo</th>
				<th>Departamento</th>
				<th>Nombre</th>

			</tr>

		</thead>

		
	</table>



</div>