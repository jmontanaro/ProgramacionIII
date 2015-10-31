$(document).ready(function(){
	
	<!--Agregamos propiedad al Post para el envio-->
	
	$("#button").click(function(){
		
		var nom = $("#nombre").val();
		var ape = $("#apellido").val();
		var tel = $("#telefono").val();
		var dir = $("#direccion").val();
		
		$.post("http://localhost:8080/Agenda/agenda/nicolas/contacto",
		{
			nombre: nom,
			apellido: ape, 
          	telefono: tel, 
          	direccion: dir
		},
        function(data){
			$("#resultadoid").text(data.id);
            $("#resultadonombre").text(data.nombre);
            $("#resultadoapellido").text(data.apellido);
            $("#resultadotelefono").text(data.telefono);
            $("#resultadodireccion").text(data.direccion);
            
        });
	});
	
	<!--Agregamos propiedad al GET para la busqueda-->
	
	$("#search").click(function(){
		
		var srchnom = $("#srchnombre").val();
		var srchape = $("#srchapellido").val();
		var srchini = $("#srchinicialnombre").val();
		var srchdir = $("#srchcalledireccion").val();
		
		$.get("http://localhost:8080/Agenda/agenda/nicolas/contacto",
		{
			nombre: srchnom,
			apellido: srchape, 
			inicial: srchini, 
			direccion: srchdir
		},
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
	
	$("#script").text("1")
});