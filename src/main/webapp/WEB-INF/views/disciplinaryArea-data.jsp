<!--disciplinaryArea-data-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/disciplinaryArea/disciplinaryArea-data.js"></script>
	
	<!--disciplinaryArea-create-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/disciplinaryArea/disciplinaryArea-create.js"></script>
	
	<!--disciplinaryArea-update-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/disciplinaryArea/disciplinaryArea-update.js"></script>

	
	
<div class="scroll disciplinaryAreaData">


	<h2>ÁREAS DISCIPLINARIAS</h2>

	<h3>Resultado de Areas Disciplinarias</h3>

	<table id="tableDisciplinaryAreaData" class="table standard-table">

		<thead>

			<tr class="not">
			
				<th>Código</th>
				<th>Departamento</th>
				<th>Nombre</th>
				<th>Acciones</th>

			</tr>

		</thead>

		
	</table>


	<%@include file="/WEB-INF/views/disciplinaryArea-create.jsp"%>
	<%@include file="/WEB-INF/views/disciplinaryArea-update.jsp"%>

</div>