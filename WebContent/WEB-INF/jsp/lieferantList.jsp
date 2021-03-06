<%@ include file="header.jsp"%>
<!-- Source : http://www.jqueryscript.net/table/Simple-jQuery-Plugin-For-Html-Table-Live-Search.html -->


		<h2>Lieferanten</h2>
		
		<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
		<script type="text/javascript" src="${cp}/static/js/html-table-search.js"></script>
		<script type="text/javascript">
			$(document).ready(function(){
				$('table.search-table').tableSearch({
					searchText:'Search Table',
					searchPlaceHolder:'Input Value'
				});
			});
		</script>
		
		
		<table class="table table-hover search-table">
		<thead>
			<tr>
				<th>ID</th>
				<th>Addresse</th>
				<th>Ansprechpartner</th>
				<th>Artikelstämme</th>
				<th>Wareneingang</th>
				<th>Warenausgang</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
			<c:forEach items="${Lieferant}" var="value">
			<tbody>
				<tr>
					<td>${value.lieferantenId}</td>
					<td>${value.adresse}</td>
					<td>${value.ansprechpartner}</td>
					<td>${value.artikelstaemme}</td>
					<td>${value.wareneingang}</td>
					<td>${value.warenausgang}</td>
					<td><button class="table_button tooltip" data-tooltip="Bearbeiten"><a href="<c:url value='/home' />" ><span class="fa fa-pencil" aria-hidden="true"></span></a></button></td>
					<td><form method="POST" action="lieferantenDel"><input type="hidden" id="lieferantenId" name="lieferantenId" value="${value.lieferantenId}"/><button class="table_button tooltip" data-tooltip="Löschen" type="submit"><span class="fa fa-minus-circle" aria-hidden="true"></span></button></form></td>

				</tr>
			</tbody>
			</c:forEach>
		</table>
		<br /> <a href="<c:url value='/lieferantNew' />">
			<button class="button">Lieferant hinzufügen</button>
		</a>
		
		<script type="text/javascript">				
			document.title = 'Lieferantenliste';
		</script>
<%@ include file="footer.jsp"%>