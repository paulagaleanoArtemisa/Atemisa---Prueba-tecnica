Operación Fuego de Estrella de Neutrones
! [Con titulo] (fotosPruebaTecnica/post_topsecret. PNG "titulo") 
1. Descomprimir el proyecto fuegoestrella.zip
2. Abrir el consuelo y ubicarse en la ruta del proyecto 
3. Ejecutar el comando mvn paquete limpio, se creaa un ejecutable dentro de la carpeta "objetivo" 
! [Con titulo] (fotosPruebaTecnica/generarJar.PNG "titulo") 
4. En el consolador ubicarse en nombreproyecto/target y ejecutar 
! [Con titulo] (fotosPruebaTecnica/targetJar.PNG "titulo") 
5. Consumir servicios de Cartero 
Pasamos la siguiente información para generar las pruebas. 

● Kenobi: [-500, -200] 
● Skywalker: [100, -100] 
● Solo: [500, 100]

{ 
"satélites": [ 
    { 
 "nombre": "kenobi", 
 "distancia": 100.0, 
 "mensaje": ["este", "", "", "mensaje", ""] 
    }, 
    { 
 "nombre": "skywalker", 
 "distancia": 115,5 
 "mensaje": ["", "es", "", "", "secreto"] 
    }, 
    { 
 "nombre": "solo", 
 "distancia": 142,7 
 "mensaje": ["este", "", "un", "", ""] 
    } 
  ] 
} 

Para el nivel 2 
Post : http://localhost:8080/topsecret
! [Con titulo] (fotosPruebaTecnica/post_topsecret. PNG "titulo") 

Para el nivel 3 
Publicación : http://localhost:8080/topsecret_split/{satellite_nombre} 
! [Con titulo] (fotosPruebaTecnica/post_topsecretnombre. PNG "titulo") 

Obtener : http://localhost:8080/topsecret_split/{satellite_nombre} 
! [Con titulo] (fotosPruebaTecnica/gettopsecretnombre. PNG "titulo") 


En caso de que la información llegue incompleta retornara un mensaje de error
! [Con titulo] (fotosPruebaTecnica/errorGettopsecretnombre.PNG "titulo") 


