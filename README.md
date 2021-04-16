# Motor de Busqueda

## Requiere
- MySQL
https://dev.mysql.com/downloads/installer/

## Configuracion
Crear en la raiz del directorio un archivo .env:

```
USUARIO_DB=nombreUsuario
PASSWORD_DB=password
DB=database
DOCUMENTOS=ubicacionDocumentos
STOPWORDS=ubicacionDeLasStopWords
ARCHIVO=ubicacionArchivo (solo si se esta cargando un solo archivo)
```

donde:
- nombreUsuario: nombre del usuario de la base de datos (generalmente root).
- password: contraseña de la base de datos.
- database: nombre de la base de datos creada en MySQL.