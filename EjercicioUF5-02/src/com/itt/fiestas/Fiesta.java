/*ESTA VA A SER LA CLASE DONDE ESTABLECEREMOS LOS ATRIBUTOS 
 * Y DONDE DEFINIREMOS LOS METODOS SETTER Y GETTER DE NUESTRA CLASE
 * PARA DESPUES LLAMARLOS DESDE LA CLASE PRINCIPAL
 */

/*VOY SOLO A COMENTAR, LAS DIFERENCIAS ENTRE UN PROYECTO Y OTRO YA QUE 
 * PARA LA MAYORIA LOS COMENTARIOS DE LAS EXPLICACIONES SON LOS MISMOS.
 * 
 */
package com.itt.fiestas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Fiesta {
	private String tipo;
	private LocalDateTime fechaHora;
	private String direccion;
	private int bebidas;
	private int bocadillos;
	private int invitados;
	private double precioFiesta;
	public static int contador;/*
	 * DECLARAMOS UN CONTADOR ESTATICO PARA CONTAR EL NUMERO
	 * DE FIESTAS QUE VAMOS INTRODUCIENDO. AL SER ESTATICA,
	 * SE PUEDE ACCEDER DENTRO DE LA CLASE SIN TENER QUE
	 * PASAR POR EL OBJETO. ES DECIR, ES UNA VARIABLE QUE
	 * PERTENECE A LA CLASE Y NO AL OBJETO
	 */
	public Fiesta(String tipo, LocalDateTime fechaHora, String direccion,
			int bebidas, int bocadillos) {
		this.tipo = tipo;
		this.fechaHora = fechaHora;
		this.direccion = direccion;
		this.bebidas = bebidas;
		this.bocadillos = bocadillos;
		contador++;
	}

	public Fiesta() {
		tipo = "disfraces";
		String str = "04/10/2021 11:30";
		DateTimeFormatter formatter = DateTimeFormatter
				.ofPattern("dd/MM/yyyy HH:mm");
		fechaHora = LocalDateTime.parse(str, formatter);
		direccion = "C/Margaritas 60 Bajo";
		bebidas = 38;
		bocadillos = 54;
		contador++;
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
	public int dame_numero_fiestas(){
		return contador;
	}


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
	 * EN ESTE SEGUNDO PROYECTO, QUEREMOS SOBRECARGAR EL METODO INVITAR. PARA
	 * ELLO, TENDREMOS UN PRIMER METODO SETTER EN EL CUAL TENEMOS QUE PASARLE UN
	 * PARAMETRO ENTERO CON EL NUMERO DE INVITADOS. SI DESDE LA CLASE PRINCIPAL
	 * LLAMAN AL METODO INVITAR CON UN PARAMETRO ENTERO, SERA ESTE METODO EL
	 * UTILIZADO. EN LA OPERACION, ESTE VALOR LO SUMARÁ A NUESTRA VARIABLE
	 * INVITADOS.
	 */
	public void invitar(int inv) {

		this.invitados = this.invitados + inv;

	}

	/*
	 * DEJAREMOS EL METODO INVITAR SIN PARAMETRO PARA CUANDO SOLO QUIERAN AÑADIR
	 * UN INVITADO DESDE LA CLASE PRINCIPAL.SI DESDE ALLI HACEN LLAMAMIENTO AL
	 * METODO INVITAR VACIO, ESTE SERA EL METODO UTILIZADO.
	 */
	public void invitar() {

		this.invitados += 1;

	}

	public void cancelarInvitacion() {
		if (this.invitados > 0) {

			this.invitados -= 1;
		}

	}

	public int dame_invitados() {
		return invitados;
	}

	public void calcula_precioFiesta() {
		precioFiesta = (this.invitados * 5 + this.bebidas * 2 + this.bocadillos * 3);
	}

	public double precioFiesta() {
		return precioFiesta;
	}
}