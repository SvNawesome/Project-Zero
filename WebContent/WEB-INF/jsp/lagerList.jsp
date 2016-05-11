<%@ include file="header.jsp"%>
<!-- Source : http://www.jqueryscript.net/table/Simple-jQuery-Plugin-For-Html-Table-Live-Search.html -->

<script type="text/javascript" src="${cp}/static/js/html-table-search.js"></script>
<script type="text/javascript" src="${cp}/static/js/livesearch.js"></script>

		<h2>Lager</h2>
		<table class="table table-hover search-table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Ort</th>
				<th>Kapazit�t</th>
				<th>Auslastung</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>

		</thead>
			<tbody>
			<c:forEach items="${Lager}" var="value">

				<tr>
					<td>${value.lagerID}</td>
					<td>${value.name}</td>
					<td>${value.ort}</td>
					<td>${value.kapazit�t}</td>
					<td>${value.auslastung}</td>
					<td><button class="table_button tooltip" data-tooltip="Hinzuf�gen"><a href="<c:url value='/register' />"><span class="fa fa-plus-square" aria-hidden="true"></span></a></button></td>
					<td><button class="table_button tooltip" data-tooltip="Bearbeiten"><a href="<c:url value='/home' />" ><span class="fa fa-pencil" aria-hidden="true"></span></a></button></td>
					<td><button class="table_button tooltip" data-tooltip="L�schen"><a href="<c:url value='/home' />" ><span class="fa fa-minus-circle" aria-hidden="true"></span></a></button></td>
				</tr>
			</tbody>
			</c:forEach>
		</table>
		<br /> <a href="<c:url value='/lagerNew' />">
			<button class="button">Lager hinzuf�gen</button>
		</a>
		
		<script type="text/javascript">				
			document.title = 'Lagerliste';
		</script>
<%@ include file="footer.jsp"%>