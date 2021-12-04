<div class="modal fade" id="eliminaCorso" role="dialog">
	<div class="modal-dialog modal-md" role="document">
		<div class="modal-content">
			<form action="/<%=application.getServletContextName()%>/deleteCorso"
				method="post">
				<input type="hidden" id="idc" name="idc" value="">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						&times;</button>
					<h4 class="modal-title">Eliminazione  corso</h4>
				</div>
				<div class="modal-body">
				<p>Eliminado il corso elimini anche le prenotazioni dei corsisti!!!</p>
				
				
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-success btn-lg">
						Conferma</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">
						Annulla</button>
				</div>
			</form>
		</div>
	</div>
</div>