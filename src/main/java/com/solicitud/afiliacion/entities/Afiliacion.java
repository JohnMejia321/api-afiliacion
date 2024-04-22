package com.solicitud.afiliacion.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.CassandraType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("afiliacion")
public class Afiliacion {

    @Id
    @PrimaryKeyColumn(name = "id", ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("Id")
    private String id;

    @Column("fecha_solicitud")
    @CassandraType(type = CassandraType.Name.TIMESTAMP)
    @JsonProperty("RequestDate")
    private Date fechaSolicitud;

    @Column("fecha_generacion")
    @CassandraType(type = CassandraType.Name.TIMESTAMP)
    @JsonProperty("GenerationDate")
    private Date fechaGeneracion;

    @Column("tipo_inscripcion")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("RegistrationType")
    private String tipoInscripcion;

    @Column("tipo_documento")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("DocumentType")
    private String tipoDocumento;

    @Column("cedula")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("IDCard")
    private String cedula;

    @Column("pasaporte")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("Passport")
    private String pasaporte;

    @Column("certificado_nacimiento")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("BirthCertificate")
    private String certificadoNacimiento;

    @Column("ss_no")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("SocialSecurityNo")
    private String ssNo;

    @Column("primer_nombre")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("FirstName")
    private String primerNombre;

    @Column("segundo_nombre")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("SecondName")
    private String segundoNombre;

    @Column("apellido_paterno")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("FirstLastName")
    private String apellidoPaterno;

    @Column("apellido_materno")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("SecondLastName")
    private String apellidoMaterno;

    @Column("apellido_casada")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("MarriedLastName")
    private String apellidoCasada;

    @Column("sexo")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("Gender")
    private String sexo;

    @Column("salario_basico")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("BasicSalary")
    private String salarioBasico;

    @Column("estado_civil")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("MaritalStatus")
    private String estadoCivil;

    @Column("direccion_residencia")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("ResidenceAddress")
    private String direccionResidencia;

    @Column("lugar_nacimiento_pais")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("BirthCountry")
    private String lugarNacimientoPais;

    @Column("lugar_nacimiento_provincia")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("BirthProvince")
    private String lugarNacimientoProvincia;

    @Column("lugar_nacimiento_distrito")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("BirthDistrict")
    private String lugarNacimientoDistrito;

    @Column("fecha_nacimiento")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("BirthDate")
    private String fechaNacimiento;

    @Column("nombre_padre_completo_primer_nombre")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("FatherFullNameFirstName")
    private String nombrePadreCompletoPrimerNombre;

    @Column("nombre_padre_completo_segundo_nombre")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("FatherFullNameSecondName")
    private String nombrePadreCompletoSegundoNombre;

    @Column("nombre_padre_apellido_paterno")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("FatherFullNameLastName")
    private String nombrePadreCompletoApellidoPaterno;

    @Column("nombre_padre_completo_apellido_materno")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("FatherFullNameSecondLastName")
    private String nombrePadreCompletoApellidoMaterno;

    @Column("nombre_madre_completo_primer_nombre")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("MotherFullNameFirstName")
    private String nombreMadreCompletoPrimerNombre;

    @Column("nombre_madre_completo_segundo_nombre")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("MotherFullNameSecondName")
    private String nombreMadreCompletoSegundoNombre;

    @Column("nombre_madre_completo_apellido_paterno")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("MotherFullNameLastName")
    private String nombreMadreCompletoApellidoPaterno;

    @Column("nombre_madre_completo_apellido_materno")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("MotherFullNameSecondLastName")
    private String nombreMadreCompletoApellidoMaterno;

    @Column("nombre_madre_completo_apellido_casada")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("MotherFullNameMarriedLastName")
    private String nombreMadreCompletoApellidoCasada;

    @Column("nombre_conyugue_completo_primer_nombre")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("SpouseFullNameFirstName")
    private String nombreConyugueCompletoPrimerNombre;

    @Column("nombre_conyugue_completo_segundo_nombre")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("SpouseFullNameSecondName")
    private String nombreConyugueCompletoSegundoNombre;

    @Column("nombre_conyugue_completo_apellido_paterno")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("SpouseFullNameLastName")
    private String nombreConyugueCompletoApellidoPaterno;

    @Column("nombre_conyugue_completo_apellido_materno")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("SpouseFullNameSecondLastName")
    private String nombreConyugueCompletoApellidoMaterno;

    @Column("fecha_nacimiento_conyugue")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("SpouseBirthDate")
    private String fechaNacimientoConyugueDia;

    @Column("fecha_union")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("UnionDate")
    private String fechaUnion;

    @Column("nombre_empleador")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("EmployerName")
    private String nombreEmpleador;

    @Column("numero_empleador")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("EmployerNumber")
    private String numeroEmpleador;

    @Column("direccion_empresa")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("EmployerAddress")
    private String direccionEmpresa;

    @Column("telefono_empresa")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("EmployerPhone")
    private String telefonoEmpresa;

    @Column("fecha_ingreso_trabajo")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("EmploymentStartDate")
    private String fechaIngresoTrabajo;

    @Column("cargo_desempena")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("PositionHeld")
    private String cargoDesempena;

    @Column("funcionario_verificador_primer_nombre")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("VerifierFirstName")
    private String funcionarioVerificadorPrimerNombre;

    @Column("funcionario_verificador_segundo_nombre")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("VerifierSecondName")
    private String funcionarioVerificadorSegundoNombre;

    @Column("funcionario_verificador_apellido_paterno")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("VerifierLastName")
    private String funcionarioVerificadorApellidoPaterno;

    @Column("funcionario_verificador_apellido_materno")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("VerifierSecondLastName")
    private String funcionarioVerificadorApellidoMaterno;

    @Column("fecha_verificacion")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("VerificationDate")
    private String fechaVerificacion;

    @Column("estado_afiliacion")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("AffiliationStatus")
    private String estadoAfiliacion;

    @Column("numero_afiliado")
    @CassandraType(type = CassandraType.Name.TEXT)
    @JsonProperty("AffiliationNumber")
    private String numeroAfiliado;
}
