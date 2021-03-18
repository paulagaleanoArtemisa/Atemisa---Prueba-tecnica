Operación Fuego de Estrella de Neutrones
![Con titulo](fotosPruebaTecnica/post_topsecret.PNG "titulo")
1. Descomprimir el proyecto fuegoestrella.zip
2. Abrir la consola y ubicarse en la ruta del proyecto
3. Ejecutar el comando mvn clean package, se creara un ejecutable dentro de la carpeta "target"
![Con titulo](fotosPruebaTecnica/generarJar.PNG "titulo")
4. En la consola ubicarse en nombreproyecto/target y ejecutar 
![Con titulo](fotosPruebaTecnica/targetJar.PNG "titulo")
5. Consumir servicios de Postman 
Pasamos la siguiente informacion para generar las pruebas.
● Kenobi: [-500, -200] 
● Skywalker: [100, -100] 
● Solo: [500, 100]

{ 
"satellites": [ 
    { 
      “name”: "kenobi", 
      “distance”: 100.0, 
      “message”: ["este", "", "", "mensaje", ""] 
    }, 
    { 
      “name”: "skywalker", 
      “distance”: 115.5 
      “message”: ["", "es", "", "", "secreto"] 
    }, 
    { 
      “name”: "solo", 
      “distance”: 142.7 
      “message”: ["este", "", "un", "", ""] 
    } 
  ] 
} 

Para el nivel 2 
Post : http://localhost:8080/topsecret
![Con titulo](fotosPruebaTecnica/post_topsecret.PNG "titulo")

Para el nivel 3 
Post : http://localhost:8080/topsecret_split/{satellite_nombre}
![Con titulo](fotosPruebaTecnica/post_topsecretnombre.PNG "titulo")

Get : http://localhost:8080/topsecret_split/{satellite_nombre}
![Con titulo](fotosPruebaTecnica/gettopsecretnombre.PNG "titulo")


En caso de que la información llegue incompleta retornara un mensaje de error
![Con titulo](fotosPruebaTecnica/errorGettopsecretnombre.PNG "titulo")





