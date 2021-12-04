<div class="modal fade" id="creaCorso" role="dialog">
	<div class="modal-dialog modal-md" role="document">
		<div class="modal-content">
			<form action="/<%=application.getServletContextName()%>/creaCorso"
				method="post">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						&times;</button>
					<h4 class="modal-title">Aggiungi corso</h4>
				</div>
				<div class="modal-body">

					<div class="form-group">
						<label for="nomecorso">Nome corso</label> <input type="text" id="nomecorso"
							name="nomecorso" class="form-control" value="">
					</div>
						<div class="form-group">
						<div class="input-group date" id="dp">
							<label for="datainizio">Data inizio</label> <span
								class="input-group-addon"> <i
								class="glyphicon glyphicon-calendar"></i>
							</span> <input type="text" id="datainizio" name="datainizio"
								class="form-control" value="">
						</div>
					</div>
						<div class="form-group">
						<div class="input-group date" id="dp">
							<label for="datafine">Data fine</label> <span
								class="input-group-addon"> <i
								class="glyphicon glyphicon-calendar"></i>
							</span> <input type="text" id="datafine" name="datafine"
								class="form-control" value="">
						</div>
					</div>
					<div class="form-group">
						<label for="prezzo">Costo</label> <input type="number" id="prezzo"
							name="prezzo" class="form-control" value="">
					</div>
					<div class="form-group">
						<label for="commento">Commento</label> <input type="text" id="commento"
							name="commento" class="form-control" value="">
					</div>
					<div class="form-group">
						<label for="aula">Aula</label> <input type="text" id="aula"
							name="aula" class="form-control" value="">
					</div>
					<div class="form-group">
						<label for="docente">Ricerca docente</label> <input type="text" id="docente"
							name="docente" class="form-control" placeholder="Inserisci cod docente...">
					</div>
				
				</div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-success btn-lg">
						Salva modifiche</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">
						Annulla</button>
				</div>
			</form>
		</div>
	</div>
</div>
