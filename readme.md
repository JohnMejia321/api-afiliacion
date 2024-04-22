# Microservicio de solicitud de afiliación

Este microservicio es responsable de llevar a el proceso para realizar la afiliación de un nuevo empleado. Utiliza un modelo con campos específicos que son gestionados por el microservicio, mientras que otros campos son proporcionados por el usuario a través de un formulario.

## Modelo de Afiliación

El modelo de empleador contiene los siguientes campos:

 ```json
{
  "fechaSolicitud": "2024-04-10T08:00:00Z",
  "fechaGeneracion": "2024-04-10T08:00:00Z",
  "tipoInscripcion": "Trabajador nacional",
  "tipoDocumento": "Cédula",
  "cedula": "123456789",
  "pasaporte": "AB123456",
  "certificadoNacimiento": "Certificado 123",
  "ssNo": "SS123456789",
  "primerNombre": "Juan",
  "segundoNombre": "Pablo",
  "apellidoPaterno": "García",
  "apellidoMaterno": "Pérez",
  "apellidoCasada": "no aplica",
  "sexo": "Masculino",
  "salarioBasico": "semanal",
  "estadoCivil": "casado",
  "direccionResidencia": "Calle 123",
  "lugarNacimientoPais": "Colombia",
  "lugarNacimientoProvincia": "Cundinamarca",
  "lugarNacimientoDistrito": "Bogotá",
  "fechaNacimiento": "1990-01-01",
  "nombrePadreCompletoPrimerNombre": "Pedro",
  "nombrePadreCompletoSegundoNombre": "Antonio",
  "nombrePadreCompletoApellidoPaterno": "García",
  "nombrePadreCompletoApellidoMaterno": "Sánchez",
  "nombreMadreCompletoPrimerNombre": "María",
  "nombreMadreCompletoSegundoNombre": "Luisa",
  "nombreMadreCompletoApellidoPaterno": "Pérez",
  "nombreMadreCompletoApellidoMaterno": "Rodríguez",
  "nombreMadreCompletoApellidoCasada": "Pérez",
  "nombreConyugueCompletoPrimerNombre": "Laura",
  "nombreConyugueCompletoSegundoNombre": "María",
  "nombreConyugueCompletoApellidoPaterno": "González",
  "nombreConyugueCompletoApellidoMaterno": "Martínez",
  "fechaNacimientoConyugueDia": "1995-02-15",
  "fechaUnion": "2023-01-01",
  "nombreEmpleador": "Empresa XYZ",
  "numeroEmpleador": "12345",
  "direccionEmpresa": "Av. Principal 123",
  "telefonoEmpresa": "123456789",
  "fechaIngresoTrabajo": "2020-01-01",
  "cargoDesempena": "Analista",
  "funcionarioVerificadorPrimerNombre": "Carlos",
  "funcionarioVerificadorSegundoNombre": "Daniel",
  "funcionarioVerificadorApellidoPaterno": "Gutiérrez",
  "funcionarioVerificadorApellidoMaterno": "Hernández",
  "fechaVerificacion": "2024-04-10",
  "estadoAfiliacion": "Activo",
  "numeroAfiliado": "A123456"
}
 ```
 El ID de cada afiliacion se genera desde el backend consumiendo otro microservicio para llevar una trazabilidad con los demas microservicios, al enviar los datos desde el cliente frontend y los documentos pdf se crea por cada afiliación un bucket en minio storage este bucket es nombrado automaticamente por el backend con el primer nombre y apellido paterno de cada empleado inscrito ademas del ID generado por el ms.
Para el envio de los datos desde un formulario frontend se envia dos objetos un objeto con los campos json y otro con una lista de pdfs segun se necesite, el backend esta en la capacidad de recibir cuaquier cantidad de documentos pdfs  y ya desde el frontend se define segun el tipo de inscripcion cuantos pdfs se enviaran.

## Proceso de Inscripción

El microservicio permite la afiliacion de un empleador a través de un único endpoint:

- **Endpoint**: `POST http://localhost:9094/afiliaciones/guardar`

El usuario debe proporcionar los datos requeridos a través de un formulario. Además, de los pdf segun el tipo de inscripcion

## Configuración y Despliegue

El microservicio se levanta en el puerto `http://localhost:9094`. Se proporcionan archivos Dockerfile y deployment.yaml en el repositorio para desplegar  en un cluster de Minikube o Kind para realizar pruebas.

Para realizar pruebas se documenta el microservicio con la herramienta swagger y queda habilitado un endpoint para ello el cual es http://localhost:9094/swagger-ui/index.html

Para despligues en cluster de minikube o kind se debe exponer el servicio del ms usando el comando minikube tunnel o en kind usando el comando  kubectl port-forward service/solicitud-afiliacion-service 8081:8081, de esta forma queda expuesto para la maquina host y poder consumir sus servicios desde un cliente frontend.



En el repositorio se agregan todos los archivos yaml necesarios para desplegar, ademas de  jenkinsfile.


