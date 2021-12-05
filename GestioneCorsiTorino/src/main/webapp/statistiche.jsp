<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.gestionecorsi.torino.model.Corso"%>
<%@page import="com.gestionecorsi.torino.model.Corsista"%>
<%@page import="java.util.List"%>
<%@page import="com.gestionecorsi.torino.model.CorsoCorsista"%>
<%@page import="com.gestionecorsi.torino.bc.AdminFacade"%>
<%@page import="com.gestionecorsi.torino.model.Docente"%>
<%
	String admin = (String) session.getAttribute("admin");
	if (admin != null) {
%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/statistiche_style.css">
<%@ include file="CDN.html" %>
<%@ include file="neve.html" %>
<meta charset="ISO-8859-1">
<title>Report</title>
</head>
<body>
<jsp:include page="nav.jsp"/>
	<%
		AdminFacade aF = AdminFacade.getInstance();
		String mostCorsi = aF.getDocenteMostCorsi();
		Docente docente = aF.getDocenteByString(mostCorsi);
		int nCorsisti = aF.getNCorsisti();
	%>
	
<div class='frame'>
<canvas id='tree'></canvas>

<script>
(function() {
	  var SwirlNode, Tree, TreeSwirl, height, swirls, width,
	    __bind = function(fn, me){ return function(){ return fn.apply(me, arguments); }; };

	  width = 600;
	  height = 450;

	  swirls = [
	    {
	      color: 'gold',
	      nodes: 300,
	      speed: -1,
	      radius: 3
	    }, {
	      color: 'green',
	      nodes: 200,
	      speed: 1,
	      radius: 1.5
	    }, {
	      color: 'blue',
	      nodes: 80,
	      speed: -3,
	      radius: 6
	    }, {
	      color: 'green',
	      nodes: 250,
	      speed: 3,
	      radius: 3
	    }
	  ];

	  Tree = (function() {
	    function Tree(w, h, swirls) {
	      this.run = __bind(this.run, this);
	      var i;
	      this.width = w;
	      this.height = h;
	      this.canvas = document.getElementById('tree');
	      this.context = this.canvas.getContext('2d');
	      this.canvas.width = w;
	      this.canvas.height = h;
	      this.swirls = (function() {
	        var _i, _ref, _results;
	        _results = [];
	        for (i = _i = 0, _ref = swirls.length; 0 <= _ref ? _i < _ref : _i > _ref; i = 0 <= _ref ? ++_i : --_i) {
	          _results.push(new TreeSwirl(this, swirls[i], i / swirls.length));
	        }
	        return _results;
	      }).call(this);
	      this.run();
	    }

	    Tree.prototype.run = function(t) {
	      if (t == null) {
	        t = 0;
	      }
	      window.requestAnimationFrame(this.run);
	      return this.draw(t);
	    };

	    Tree.prototype.draw = function(t) {
	      var s, _i, _j, _len, _len1, _ref, _ref1, _results;
	      this.context.clearRect(0, 0, this.width, this.height);
	      _ref = this.swirls;
	      for (_i = 0, _len = _ref.length; _i < _len; _i++) {
	        s = _ref[_i];
	        s.drawBack(t);
	      }
	      _ref1 = this.swirls;
	      _results = [];
	      for (_j = 0, _len1 = _ref1.length; _j < _len1; _j++) {
	        s = _ref1[_j];
	        _results.push(s.drawFront(t));
	      }
	      return _results;
	    };

	    return Tree;

	  })();

	  TreeSwirl = (function() {
	    function TreeSwirl(tree, s, offset) {
	      var i;
	      this.tree = tree;
	      this.offset = offset;
	      this.color = s.color;
	      this.speed = s.speed;
	      this.radius = s.radius;
	      this.nodes = (function() {
	        var _i, _ref, _results;
	        _results = [];
	        for (i = _i = 0, _ref = s.nodes; 0 <= _ref ? _i < _ref : _i > _ref; i = 0 <= _ref ? ++_i : --_i) {
	          _results.push(new SwirlNode(this, i / s.nodes));
	        }
	        return _results;
	      }).call(this);
	    }

	    TreeSwirl.prototype.drawBack = function(t) {
	      var n, _i, _len, _ref, _results;
	      _ref = this.nodes;
	      _results = [];
	      for (_i = 0, _len = _ref.length; _i < _len; _i++) {
	        n = _ref[_i];
	        if (n.inBack(t)) {
	          _results.push(n.draw(t));
	        }
	      }
	      return _results;
	    };

	    TreeSwirl.prototype.drawFront = function(t) {
	      var n, _i, _len, _ref, _results;
	      _ref = this.nodes;
	      _results = [];
	      for (_i = 0, _len = _ref.length; _i < _len; _i++) {
	        n = _ref[_i];
	        if (n.inFront(t)) {
	          _results.push(n.draw(t));
	        }
	      }
	      return _results;
	    };

	    return TreeSwirl;

	  })();

	  SwirlNode = (function() {
	    function SwirlNode(swirl, offset) {
	      this.swirl = swirl;
	      this.offset = offset;
	    }

	    SwirlNode.prototype.yPos = function() {
	      var d, od;
	      d = this.t / 800 * this.swirl.speed;
	      od = d + this.offset * this.swirl.tree.height;
	      return (this.swirl.tree.height - od % this.swirl.tree.height) % this.swirl.tree.height;
	    };

	    SwirlNode.prototype.xDeg = function() {
	      return this.yPos() * 5 + 100 * this.swirl.offset;
	    };

	    SwirlNode.prototype.xRad = function() {
	      return this.xDeg() * Math.PI / 60;
	    };

	    SwirlNode.prototype.xPos = function() {
	      return Math.sin(this.xRad()) * this.swirl.tree.width * this.yPos() / this.swirl.tree.height / 3 + this.swirl.tree.width / 2;
	    };

	    SwirlNode.prototype.shade = function() {
	      return (Math.cos(this.xRad()) + 1) / 2;
	    };

	    SwirlNode.prototype.inBack = function(t) {
	      this.t = t;
	      return Math.cos(this.xRad()) > 0;
	    };

	    SwirlNode.prototype.inFront = function(t) {
	      this.t = t;
	      return !this.inBack(t);
	    };

	    SwirlNode.prototype.draw = function(t) {
	      this.t = t - 600;
	      this.drawNode(this.swirl.radius * 0.6, this.shade() + 0.9);
	      this.t = t - 180;
	      this.drawNode(this.swirl.radius * 0.8, this.shade() + 0.4);
	      this.t = t;
	      return this.drawNode(this.swirl.radius, this.shade());
	    };

	    SwirlNode.prototype.drawNode = function(size, shade) {
	      var c;
	      c = this.swirl.tree.context;
	      c.beginPath();
	      c.arc(this.xPos(), this.yPos(), size, 0, 2 * Math.PI);
	      c.fillStyle = this.swirl.color;
	      c.fill();
	      c.fillStyle = "rgba(0,0,0," + shade + ")";
	      return c.fill();
	    };

	    return SwirlNode;

	  })();

	  new Tree(width, height, swirls);

	}).call(this);
</script>

</div>

<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true" style="margin-top: 9%;">
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingOne">
      <h4 class="panel-title">
        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          I. Numero corsisti totali
        </a>
      </h4>
    </div>
    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
      <div class="panel-body">
        <%= nCorsisti %>
      </div>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingTwo">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
          II. Nome del corso più frequentato
        </a>
      </h4>
    </div>
    <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
      	<div class="panel-body">
      <%=AdminFacade.getInstance().getPopularCorso() %>
   		</div>
    </div>
  </div>
  <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingThree">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
          III. Data di inizio ultimo corso
        </a>
      </h4>
    </div>
    <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
      <div class="panel-body">
      	<%Corso a = AdminFacade.getInstance().getDataLastCorso(); %>
      		<div class="table-responsive">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Cod Corso</th>
						<th>Nome Corso</th>
						<th>Data Inizio</th>
						<th>Data Fine</th>
						<th>Costo</th>
						<th>Commenti</th>
						<th>Aula</th>
						<th>Cod Docente</th>
						

					</tr>
				</thead>
				<tbody>
				
					<tr>
					<td><%=a.getIdCorso() %></td>
					<td><%=a.getNomeCorso() %></td>
					<td><%=new SimpleDateFormat("dd/MM/yyyy").format(a.getDataInizio()) %></td>
					<td><%=new SimpleDateFormat("dd/MM/yyyy").format(a.getDataFine()) %></td>
					<td><%=String.format("%.2f",a.getCostoCorso()) %></td>
					<td><%=a.getCommenti() %></td>
					<td><%=a.getAulaCorso() %></td>
					<td><%=a.getCodDocente() %></td>
                    </tr>
				

				</tbody>

			</table>

		</div>
      	
      </div>
    </div>
  </div>
   <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingFour">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFour" aria-expanded="false" aria-controls="collapseFour">
          IV. Durata media dei corsi
        </a>
      </h4>
    </div>
    <div id="collapseFour" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFour">
      	<div class="panel-body">
      <%= (int) AdminFacade.getInstance().getAvgLength() %>
   		</div>
    </div>
  </div>
   <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingFive">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseFive" aria-expanded="false" aria-controls="collapseFive">
          V. Numero di commenti presenti
        </a>
      </h4>
    </div>
    <div id="collapseFive" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingFive">
      	<div class="panel-body">
      <%=AdminFacade.getInstance().getCountCommenti(-1) %>
   		</div>
    </div>
  </div>
   <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingSix">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseSix" aria-expanded="false" aria-controls="collapseSix">
          VI. Elenco corsisti
        </a>
      </h4>
    </div>
    <div id="collapseSix" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingsSix">
      	<div class="panel-body">
			<div class="table-responsive">
				<table class="table table-hover">
					<thead>
					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Cognome</th>
						<th>Corsi</th>
					</tr>
					</thead>
					<tbody>
						<%
							List<Corsista> corsisti = AdminFacade.getInstance().getCorsisti();
						
							for(Corsista c : corsisti) {
																
						%>
						<tr>
							<td><%= c.getCodCorsista()%></td>
							<td><%= c.getNomeCorsista() %></td>
							<td><%= c.getCognomeCorsista() %></td>
							<td><button type="button" class="btn btn-info" 
								data-toggle="modal" data-target="#gestisciArticoloModal_<%=c.getCodCorsista()%>">Riepilogo
								</button></td>
							<td><jsp:include page="corsiCorsistaModal.jsp">
									<jsp:param value="<%=c.getCodCorsista()%>" name="id" />
								</jsp:include></td>
						</tr>
						<% 
							}
						%>
					</tbody>
				</table>
			</div>
   		</div>
    </div>
  </div>
   <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingSeven">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseSeven" aria-expanded="false" aria-controls="collapseSeven">
          VII. Docente che può tenere più corsi
        </a>
      </h4>
    </div>
    <div id="collapseSeven" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingSeven">
      	<div class="panel-body">
      		<%= docente.getNomeDocente() + " " + docente.getCognomeDocente()%>
   		</div>
    </div>
  </div>
   <div class="panel panel-default">
    <div class="panel-heading" role="tab" id="headingEight">
      <h4 class="panel-title">
        <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseEight" aria-expanded="false" aria-controls="collapseEight">
          VIII. Corsi con posti disponibili
        </a>
      </h4>
    </div>
    <div id="collapseEight" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingEight">
      	<div class="panel-body">
      <%for(String s : AdminFacade.getInstance().getAvailableCorso()){ %><!-- Conviene fare una lista di corsi e stamparlo a tabella -->
  		<%=s %> 	
  		<br>	
   		<%} %>
   		</div>
    </div>
  </div>
</div>

</body>
</html>
<%
	} else {
		response.sendRedirect("accessonegato.jsp");
	}
%>