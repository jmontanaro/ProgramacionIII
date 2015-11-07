$(document).ready(function(){
	$("#btn").click(function(){
		var filtrarnombre = $("#nom").val();
		var filtrarapellido = $("#surname").val();
		var inicialnombre = $("#initialname").val();
		var calledireccion = $("#streetadress").val();
		var url = "http://localhost:8080/Agendatp3/agenda/ruben/contacto";
		var query = "?";
		if (filtrarnombre != ""){
			query += "nombre=" + filtrarnombre;
		}
		
		
		if (filtrarapellido != ""){
				if (query != "?"){
					query = query + "&";
				}
			query += "apellido=" + filtrarapellido;
		}		
		
		
		if (inicialnombre != ""){
				if (query != "?"){
					query = query + "&";
				}
			query += "inicialnombre=" + inicialnombre;
		}
		
		
		if (calledireccion != ""){
			if (query != "?"){
				query += "&";
			}
			query += "calledireccion=" + calledireccion;
		}
		
		
		if (query != "?") { 
			url = url + query;
		}
		
		$.get(url,

	        function(data,status){

				var text = "<fieldset>";
					text +="<legend><h1>Datos Filtrados</h1></legend>";
				var x;
					text +="<table border="+"'1'"+"class="+"'tabla'"+"style="+"'width:100%'>";
					text +="<tr><th>Apellido</td><th>Nombre</td><th>Direccion</td><th>Telefono</td></tr>";
				for (x in data) {
				    text +="<tr><td>"+data[x].apellido.toString() + "</td>";
				    text +="<td>"+data[x].nombre.toString() + "</td>";
				    text +="<td>"+data[x].direccion.toString() + "</td>";
				    text +="<td>"+data[x].telefono.toString() + "</td></tr>";
				}
					text+="</table>";
				    text+="</fieldset>";
				    document.getElementById("tabla").innerHTML = text;
				    document.getElementById("nom").value="";
				    document.getElementById("surname").value="";
				    document.getElementById("initialname").value="";
				    document.getElementById("streetadress").value="";
	        });
	    });
	});