<%@ include file="header.jsp"%>
<script type="text/javascript" src="${cp}/static/js/html-table-search.js"></script>
<script type="text/javascript" src="${cp}/static/js/livesearch.js"></script>

		<h2>Lager</h2>
		<table class="table table-hover search-table">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Ort</th>
				<th>Kapazit�t</th>
				<th>Auslastung</th>
				<th>Bestandsartikel</th>
				<th>Mitarbeiter</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${Mitarbeiter}" var="value">
				<tr>
					<td>${value.LagerId}</td>
					<td>${value.name}</td>
					<td>${value.Ort}</td>
					<td>${value.Kapazit�t}</td>
					<td>${value.Auslastung}</td>
					<td>${value.Bestandsartikel}</td>
					<td>${value.Mitarbeiter}</td>
					<td><a href="<c:url value='/register' />" class="tooltip" data-tooltip="Add"><span class="fa fa-plus-square" aria-hidden="true"></span></a></td>
					<td><a href="<c:url value='/home' />" class="tooltip" data-tooltip="Edit"><span class="fa fa-pencil" aria-hidden="true"></span></a></td>
					<td><a href="<c:url value='/home' />" class="tooltip" data-tooltip="Delete"><span class="fa fa-minus-circle" aria-hidden="true"></span></a></td>
				</tr>
			</c:forEach>
		</table>
		<br /> <a href="<c:url value='/lagerNew' />">
			<button class="button">Lager hinzuf�gen</button>
		</a>
		
		<script type="text/javascript">				
			document.title = 'Lagerliste';
		</script>
<%@ include file="footer.jsp"%>