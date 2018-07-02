<!--disciplinaryArea-data-->
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/project/js/disciplinaryArea/disciplinaryArea-data.js"></script>
	
	
<div class="disciplinaryAreaData">

	<div class="error">
		<a href="#" class="close">X</a> <a class="icon"><ion-icon
				name="warning"></ion-icon></a> <label class="message"></label>
	</div>

	<h2>AREAS DISCIPLINARIAS</h2>

	<h3>Resultado de Areas Disciplinarias</h3>

	<%@include file="/includes/toolbars/toolbar-disciplinaryArea-update.jsp"%>

	<table id="tableDisciplinaryAreaData" class="table standard-table">

		<thead>

			<tr class="not">
			
				<th>Codigo</th>
				<th>Facultad</th>
				<th>Nombre</th>

			</tr>

		</thead>

		
	</table>



</div>