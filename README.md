# Shadow - Persistence #

La finalidad de este repositorio es proporcionar un servicio de persistencia encapsulada para la gestión de los usuarios de la Asociación Grupo Universitario de Informática (GUI) de Valladolid.

### Alcance ###

El alcance de este servicio sólo llega hasta la proporción de una interfaz para realizar peticiones predefinidas sobre la base de datos.

### Uso ###

Aunque se puede emplear el código fuente para añadir su funcionalidad en una aplicación, es muy recomendable emplear los encapsulados JAR. De esta forma, se consigue una reducción considerable en la gestión y uso ya que puede ser tratada como una biblioteca externa que proporciona una funcionalidad especifica e independiente del resto de recursos.
También permite tener un mejor control sobre las versiones y reducir sus repercusiones sobre el resto de la lógica.

- Lo primero es importar el [fichero JAR](https://github.com/guiuva/shadow-persistence/releases/download/v1.0.0/gui_shadow_persistence-1.0.jar) al proyecto deseado.

- Una vez importado, el uso es muy sencillo.
```
IPersistenceFacade persistence = new PersistenceFacade();
UserDTO user = persistence.getUser("admin");
```

### Estado de la implementación ###

En la versión 1.0 solamente están implementados los métodos:

* `getUser` : especificando un identificador del usuario (login) proporciona un DTO con toda su información relacionada.
* `getTypes` : proporciona una lista con todos los posibles tipos de los campos adicionales que pueden ser asociados a un usuario en concreto.


### Información adicional ###

El proyecto fue iniciado por David Soler y actualmente es el diseñador y responsable del mantenimiento del repositorio.

El proyecto está licenciado como GPLv3 y su explotación ha sido cedida al Grupo Universitario de Informática.
