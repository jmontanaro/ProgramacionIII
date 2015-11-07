$(document).ready(function(){
	$("#btn").click(function(){
		var nombre = $("#name").val();
		var apellido = $("#ape").val();
		var direccion = $("#dire").val();
		var telefono = $("#tel").val();
		$.post("http://localhost:8080/Agendatp3/agenda/ruben/contacto",
				 {
	          Nombre: nombre,
	          Apellido: apellido, 
	          Telefono: telefono, 
	          Direccion: direccion
	        },
	        function(data,status){
				var text = "<fieldset>";
					text +="<legend><h1>Datos Ingresados</h1></legend>"; 
					text +="<table border="+"'1'"+"class="+"'tabla'"+"style="+"'width:100%'>";
					text +="<tr><th>Apellido</td><th>Nombre</td><th>Direccion</td><th>Telefono</td></tr>";
					text +="<tr><td>"+data.apellido+" </td>";
					text +="<td>"+data.nombre+" </td>";
					text +="<td>"+data.direccion+" </td>";
					text +="<td>"+data.telefono+" </td></tr>";					
					text +="</table>";
					text +="</fieldset>";
				
				    document.getElementById("resultado").innerHTML = text;
				    document.getElementById("ape").value="";
				    document.getElementById("name").value="";
				    document.getElementById("dire").value="";
				    document.getElementById("tel").value="";
	        });
	    });
	});