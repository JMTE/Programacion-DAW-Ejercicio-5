/*ESTA VA A SER LA CLASE DONDE ESTABLECEREMOS LOS ATRIBUTOS 
 * Y DONDE DEFINIREMOS LOS METODOS SETTER Y GETTER DE NUESTRA CLASE
 * PARA DESPUES LLAMARLOS DESDE LA CLASE PRINCIPAL
 */

/*AQUI IMPORTAMOS LOS PAQUETES QUE NOS HACEN FALTA PARA ESTA CLASE
 * DEBIDO A QUE HEMOS DEFINIDO LA FECHA COMO UN OBJETO LOCALDATETIME
 * TENEMOS QUE IMPORTAR EL PAQUETE DE LA CLASE LOCALTIME Y EL PAQUETE 
 * PARA CAMBIAR EL FORMATO DE LA HORA
 */
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Fiesta {
	/*
	 * A CONTINUACION ENCAPSULAMOS LAS VARIABLES O ATRIBUTOS PARA QUE ESTAS NO
	 * SEAN MODIFICABLES DESDE OTRO PUNTO. DE ESTA MANERA SI QUEREMOS CAMBIAR
	 * ALGO, DEBEMOS PASAR POR LOS METODOS GETTER Y SETTER
	 */
	private String tipo;
	private LocalDateTime fechaHora; // DEFINIMOS FECHAHORA COMO UN OBJETO
										// LOCALDATETIME
	private String direccion;
	private int bebidas;
	private int bocadillos;
	private int invitados;
	private double precioFiesta;

	/*
	 * CREAMOS EL PRIMER CONSTRUCTOR DE FIESTA, EL CUAL SERÁ LLAMADO CUANDO LE
	 * PASEMOS LOS PARAMETROS QUE EN EL SE ENCUENTRAN
	 */
	public Fiesta(String tipo, LocalDateTime fechaHora, String direccion,
			int bebidas, int bocadillos) {
		/*
		 * COMO EN EL CONSTRUCTOR HEMOS DEFINIDO LAS VARIABLES IGUAL QUE LAS QUE
		 * HACEN REFERENCIA AL OBJETO ACTUAL, ESTAS ULTIMAS, SE DEFINEN CON UN
		 * THIS DELANTE PARA DIFERENCIARLAS. DECIMOS QUE ESTAS VARIABLES SERAN
		 * IGUALES A LAS QUE LE PASAMOS POR PARAMETROS
		 */
		this.tipo = tipo;
		this.fechaHora = fechaHora;
		this.direccion = direccion;
		this.bebidas = bebidas;
		this.bocadillos = bocadillos;

	}

	public Fiesta() {
		/*
		 * EL SEGUNDO CONSTRUCTOR QUE HACEMOS DE FIESTA, ES UN CONTRUCTOR CON
		 * UNAS VARIABLES QUE HEMOS INVENTADO.
		 */
		tipo = "disfraces";
		String str = "04/10/2021 11:30";
		/*
		 * PARA EL OBJETO LOCALDATETIME, PRIMERO HAY QUE DECIRLE COMO VAMOS A
		 * INTRODUCIR EL VALOR PARA FORMATEARLO AL VALOR QUE ACEPTA EL
		 * COMPILADOR. EN ESTE CASO, OBLIGAREMOS AL USUARIO A INTRODUCIRLO DE LA
		 * FORMA DD/MM/YYYY HH:MM
		 */
		DateTimeFormatter formatter = DateTimeFormatter
				.ofPattern("dd/MM/yyyy HH:mm");
		/*
		 * A CONTINUACION, HACEMOS UNA TRANSFORMACION DEL VALOR QUE LE
		 * INTRODUCIMOS MEDIANTE EL METODO PARSE
		 */
		fechaHora = LocalDateTime.parse(str, formatter);
		direccion = "C/Margaritas 60 Bajo";
		bebidas = 38;
		bocadillos = 54;

	}

	/*
	 * A CONTINUACION DEFINIMOS LOS METODOS SETTER Y GETTER  DE LOS  TODOS LOS ATRIBUTOS 
	 * POR SI NOs HICIERAN FALTA EN ALGUN MOMENTO EN EL PROGRAMA PRINCIPAL, EN NUESTRO
	 * EJEMPLO NO NOS HACEN FALTA PORQUE LOS PEDIREMOS TODOS JUNTOS INTEGRADOS
	 * EN UN STRING. LOS METODOS SETTER NOS ESTABLECEN UN VALOR NUEVO PARA EL ATRIBUTO
	 * Y LOS METODOS GETTER NOS DEVUELVEN ESE VALOR MEDIANTE EL LLAMAMIENTO A LA FUNCION
	 */
	public void cambiaTipo(String tipo){
		this.tipo=tipo;
	}
	public String dame_tipo() {
		return tipo;
	}
	public void  cambiaHora(LocalDateTime hora){
		this.fechaHora=hora;
	}

	public LocalDateTime dame_fechaHora() {
		return fechaHora;
	}
	public void cambiaDireccion(String direccion){
		this.direccion=direccion;
	}

	public String dame_direccion() {
		return direccion;

	}
	public void cambiaBebidas(int bebidas){
		this.bebidas=bebidas;
	}

	public int dame_bebidas() {
		return bebidas;
	}
	public void cambiaBocadillos(int bocadillos){
		this.bocadillos=bocadillos;
	}

	public int dame_bocadillos() {
		return bocadillos;

	}

	/*
	 * AQUI ESTA EL METODO GETTER QUE DEVUELVE UN STRING CON TODOS NUESTROS
	 * DATOS INTEGRADOS
	 */
	public String Consultar() {
		String frase = "#################   El tipo de fiesta es: " + tipo
				+ "\n#################   La fecha  y hora del evento es: "
				+ fechaHora
				+ "\n#################   La dirección de la celebración es: "
				+ direccion + "\n#################   El numero de bebidas es: "
				+ bebidas
				+ "\n#################   El numero de bocadillos es: "
				+ bocadillos
				+ "\n#################   El numero de invitados es: "
				+ invitados
				+ "\n#################   El precio de la fiesta es: "
				+ precioFiesta;
		return frase;
	}

	/*
	 * A CONTINUACION DEFINIMOS UN METODO SETTER PARA LA ACCION DE AÑADIR
	 * INVITADOS A LA FIESTA. EL METODO SETTER, ESTABLECE UNA OPERACION, Y NOS
	 * VARIA EL VALOR DE NUESTRO ATRIBUTO. EN ESTA OCASION, CADA VEZ QUE
	 * LLAMEMOS A NUESTRO METODO INVITAR, SE AÑADIRA UN INVITADO A NUESTRA
	 * VARIABLE.
	 */
	public void invitar() {

		this.invitados += 1;

	}

	/*
	 * EN EL SIGUIENTE CASO, ES UN METODO SETTER PARA CANCELAR UN INVITADO, CADA
	 * VEZ QUE LLAMEMOS A ESTE METODO, UN INVITADO SERA RESTADO DE NUESTRA
	 * VARIABLE. A MAYORES LE INTRODUCIMOS QUE LA CONDICION PARA QUE SE EJECUTE,
	 * ES QUE NUESTROS INVITADOS SEAN POSITIVOS, SINO, NO SE HARÁ LA RESTA.
	 */
	public void cancelarInvitacion() {
		if (this.invitados > 0) {

			this.invitados -= 1;
		}

	}

	/*
	 * EL SIGUIENTE METODO GETTER ES AL QUE LLAMAREMOS PARA INFORMARNOS DE
	 * CUANTOS INVITADOS TENEMOS EN NUESTRO OBJETO FIESTA
	 */
	public int dame_invitados() {
		return invitados;
	}

	/*
	 * CON EL SIGUIENTE METODO SETTER, CALCULAREMOS EL PRECIO DE LA FIESTA SEGUN
	 * LOS VALORES DADOS EN EL ENUNCIADO
	 */
	public void calcula_precioFiesta() {
		precioFiesta = (this.invitados * 5 + this.bebidas * 2 + this.bocadillos * 3);
	}

	/*
	 * Y CON EL SIGUIENTE METODO GETTER, DEVOLVEREMOS EL VALOR DEL PRECIO DE LA
	 * FIESTA DEL OBJETO FIESTA REQUERIDO.
	 */
	public double precioFiesta() {
		return precioFiesta;
	}
}