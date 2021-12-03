<div class="modal fade" id="aggiungiCorista" role="dialog">
	<div class="modal-dialog modal-md" role="document">
		<div class="modal-content">
			<form action="/<%=application.getServletContextName() %>/InsertCorsista" method="POST">
			<input type="hidden" id="idc" name="idc" value="">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						&times;</button>
					<h4 class="modal-title">Dati corsista</h4>
				</div>
				<div class="modal-body">

					<div class="form-group">
						<label for="nome">Nome</label> <input type="text" id="nome"
							name="nome" class="form-control" value="">
					</div>
					<div class="form-group">
						<label for="cname">Cognome</label> <input type="text" id="cname"
							name="cname" class="form-control" value="">
					</div>
					<div class="form-group">
						<label for="prezzo">Precedenti formativi</label> <div id="prezzo" class="form-check">
  						<input class="form-check-input" type="radio" name="S" id="S">
 								 <label class="form-check-label" for="S">
    								<%="Si" %>
  								</label>
  							  <input class="form-check-input" type="radio" name="N" id="N" checked>
 						 <label class="form-check-label" for="N">
   								 <%="No" %>
  							</label>

						</div>
					</div>
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-success btn-lg">
						Aggiungi</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">
						Annulla</button>
				</div>
			</form>
		</div>
	</div>
</div>