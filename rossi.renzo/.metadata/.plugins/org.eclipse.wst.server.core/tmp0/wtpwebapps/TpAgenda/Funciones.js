$(document).ready(function(){
  
	$("#btn").click(function(){
		var nombre = $("#Nombre").val();
		var apellido = $("#Apellido").val();
		var direccion = $("#Direccion").val();
		var telefono = $("#Tel").val();
		
		$.post("http://localhost:8080/TpAgenda/renzo/contactos",
        {
          Nombre: nombre,
          Apellido: apellido, 
          Tel: telefono, 
          Direccion: direccion
        },
        function(data,status){
            // alert("Data: " + data.nombre + "\nStatus: " + status);
            $("#nombre").text(data.nombre);
            $("#apellido").text(data.apellido);
            $("#direccion").text(data.direccion);
            $("#telefono").text(data.telefono);
        });
    });	
	
	
	// GET de busqueda
	
	$("#search").click(function(){
		
		var busquedaNombre = $("#busconombre").val();
		var busquedaApellido = $("#buscoapellido").val();
		var busquedaInicial = $("#buscoinicialnombre").val();
		var busquedaDireccion = $("#buscodireccion").val();
		
		var url = "http://localhost:8080/TpAgenda/renzo/contactos/";
				
		var query = "?";
		
		if (busquedaNombre != ""){
			query += "nombre=" + busquedaNombre;
		}
		
		
		if (busquedaApellido != ""){
				if (query != "?"){
					query = query + "&";
				}
			query += "apellido=" + busquedaApellido;
		}		
		
		
		if (busquedaInicial != ""){
				if (query != "?"){
					query = query + "&";
				}
			query += "inicial=" + busquedaInicial;
		}
		
		
		if (busquedaDireccion != ""){
			if (query != "?"){
				query += "&";
			}
			query += "direccion=" + busquedaDireccion;
		}
		
		
		if (query != "?")
			url = url + query;
		
		// alert ("Query: " + query);
		// alert("URL: " + url);
		
		$.get(url,
		
        function(data){
			var text = "<table>";
			var x;
			for (x in data) {
			    text += "<tr>";
			    text +="   <td>"+data[x].id + "</td>";
			    text +="   <td>"+data[x].nombre + "</td>";
			    text +="   <td>"+data[x].apellido + "</td>";
			    text +="   <td>"+data[x].telefono + "</td>";
			    text +="   <td>"+data[x].direccion + "</td>";
			    text +="</tr>";
			}
			text+="</table>";
			document.getElementById("tabla").innerHTML = text;
			                 
        });
	});
});