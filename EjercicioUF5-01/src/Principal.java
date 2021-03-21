/*ESTA SERÁ LA CLASE PRINCIPAL, CON NUESTRO METODO MAIN, DESDE DONDE
 * HAREMOS LLAMAMIENTO A TODOS LOS METODOS DEFINIDOS EN LA CLASE FIESTA
 * PARA VARIAR VALORES O CONSULTARLOS.
 */
/*A CONTINUACION, IMPORTAMOS TODOS LOS PAQUETES NECESARIOS PARA NUESTRA
 * PROGRAMACION. 
 * HE REALIZADO UN PANEL CON MENU DESPLEGABLE PARA LA ELECCION DE CADA
 * ACCION A REALIZAR. PARA ELLO, HE UTILIZADO OBJETOS DEL PAQUETE JAVAX.SWING
 * A SU VEZ HE IMPORTADO TAMBIEN EL PAQUETE PARA LA EXCEPCION DE CUANDO 
 * EL USUARIO NO INTRODUZCA CORRECTAMENTE LA FECHA Y HORA PORQUE COMO 
 * UTILIZAMOS UN OBJETO LOCALDATETIME ESO PUEDE SER MUY FRECUENTE Y ASI,
 * AVISAMOS AL USUARIO DE QUE HA INTRODUCIDO MAL EL VALOR.
 * LOS PAQUETES ACTIONEVENT Y ACTIONLISTENER SON NECESARIOS PORQUE ESTOS EVENTOS
 * SERAN LOS QUE ACTIVARAN LOS BOTONES DE LOS MENUS DESPLEGABLES.
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Principal {
	/*
	 * EN LA CLASE PRINCIPAL, SOLO TENDREMOS NUESTRO METODO MAIN, CON EL MARCO
	 * QUE CONTIENE TODO EL CONJUNTO DE ACCIONES A LAS CLASES Y METODOS QUE
	 * DESCRIBIMOS ABAJO.
	 */
	public static void main(String[] args) {

		marco marco1 = new marco();
		marco1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco1.setVisible(true);

	}
}

/*
 * ESTA PRIMERA CLASE ES LA DEL MARCO, EN EL ESTABLECEMOS LAS MEDIDAS DE NUESTRO
 * CONTENEDOR DE LA INFORMACION, ASI COMO DATOS GENERALES, POSICION EN LA
 * PANTALLA, TITULO DE LA VENTANA,ETC
 */
class marco extends JFrame {
	public marco() {

		setBounds(450, 150, 400, 120);
		setTitle("DEFINIDOR DE FIESTAS");
		/*
		 * AQUI LE AÑADIMOS LA LAMINA QUE CONTIENE EL MENU DESPLEGABLE, PRIMERO
		 * INSTANCIAMOS NUESTRO OBJETO LAMINA QUE HEMOS CONSTRUIDO MAS ABAJO Y
		 * DESPUES LA AÑADIMOS AL MARCO. UNA LAMINA, VIENE SIENDO COMO UN LIBRO.
		 * EL MARCO LO PODRIAMOS DEFINIR COMO LA ESTANTERIA. NO SE SI ESTA
		 * ANALOGIA ES MUY CORRECTA, PERO YO LA VEO ASI.
		 */
		laminaSP lamina2 = new laminaSP();
		add(lamina2);

	}
}

class laminaSP extends JPanel {
	/*
	 * AQUI EN ESTA CLASE ES DONDE ESTA LO GORDO DE LA PROGRAMACION DEL
	 * EJERCICIO, ESTA CLASE ES NUESTRO LIBRO, Y EN ELLA, INTRODUCIREMOS TODOS
	 * LOS ALGORITMOS PARA EL CALCULO DE LOS OBJETIVOS DE LA ACTIVIDAD.
	 * 
	 * PRIMERO DEFINIMOS LOS OBJETOS QUE FORMAN NUESTRO MENU, EL JMENU ES EL
	 * BOTON QUE SE VE A PRIMERA VISTA CUANDO EJECUTAMOS EL PROGRAMA Y AL
	 * PULSARLO, ES CUANDO SE DESPLIEGAN LOS JMENUITEM
	 */
	private JMenu menu1;
	private JMenuItem Fiesta_Predeterminada;
	private JMenuItem Fiesta_Nueva;
	private JMenu menu3;
	private JMenuItem datos_todas;
	private JMenu menu2;
	private JMenuItem invitar;
	private JMenuItem cancelar;

	public laminaSP() {
		/*
		 * ESTE SERA EL CONTRUCTOR DE NUESTRA CLASE LAMINASP, A CONTINUACION
		 * DEFINIMOS UN JMENUBAR QUE SERA DONDE ESTEN NUESTROS BOTONES
		 * DESPLEGABLES PODRIA HABERLO DEFINIDO EN EL MISMO SITIO QUE LOS
		 * ANTERIORES
		 */
		JMenuBar barra = new JMenuBar();
		/*
		 * Y A CONTINUACION, INSTANCIAMOS NUESTROS OBJETOS CREADOS CON EL NOMBRE
		 * QUE VAN A TENER IMPRESO. DE LA MISMA FORMA, HAY ALGUNOS QUE LOS
		 * DEJAMOS DESACTIVADOS Y QUE SE VEAN EN NUESTRO MARCO EN OTRO COLOR. NO
		 * TIENE SENTIDO POR EJEMPLO, TENER ACTIVADO EL BOTON INVITAR, CUANDO
		 * AUN NO TENEMOS NINGUNA FIESTA.
		 */
		menu1 = new JMenu("Nueva Fiesta");
		Fiesta_Predeterminada = new JMenuItem(
				"Fiesta con datos predeterminados");
		Fiesta_Nueva = new JMenuItem("Fiesta nueva (Hay que introducir datos)");
		menu3 = new JMenu("Datos Fiestas");
		datos_todas = new JMenuItem("Ver los datos de todas las fiestas");
		datos_todas.setEnabled(false);
		menu2 = new JMenu("Invitados");
		invitar = new JMenuItem("Añadir invitado");
		invitar.setEnabled(false);
		cancelar = new JMenuItem("Quitar invitado");
		cancelar.setEnabled(false);
		/*
		 * A CONTINUACION INSTANCIAMOS LA CLASE PRIVADA QUE CREAMOS DESPUES,
		 * REALMENTE, ESTAS ACCIONES SE HACEN DESPUES DE CREAR ESA CLASE DE LA
		 * QUE HABLO, ES LA CLASE QUE VA A DOTAR A NUESTROS BOTONES DE VIDA Y
		 * LES VA A ADJUDICAR LA ACCION QUE NOSOTROS LES PROGRAMEMOS.
		 */
		pulsar_boton2 accion = new pulsar_boton2();
		/*
		 * EL METODO ACTIONLISTENER LO QUE HACE ES PONER EL BOTON O OBJETO QUE
		 * NOSOTROS LE INDICAMOS A LA ESCUCHA, ES DECIR, ATENTO A QUE ALGUIEN
		 * REALICE UNA ACCION SOBRE EL. SIN EL LLAMAMIENTO A ESTE METODO,EL
		 * BOTON NO REALIZARIA NADA, ESTARIA COMO MUERTO. POR LO TANTO, PONEMOS
		 * TODOS NUESTROS BOTONES DESPLEGABLES A LA ESCUCHA.
		 */
		menu1.addActionListener(accion);
		Fiesta_Predeterminada.addActionListener(accion);
		Fiesta_Nueva.addActionListener(accion);
		datos_todas.addActionListener(accion);
		invitar.addActionListener(accion);
		cancelar.addActionListener(accion);
		/*
		 * A CONTINUACION, AÑADIMOS TODOS LOS ITEMS,OBJETOS, MENUS A LA LAMINA
		 * TODOS FORMAN UN CONJUNTO DENOMINADO BARRA.SON SUBCONJUNTOS EN UN
		 * GRUPO.
		 */
		menu1.add(Fiesta_Predeterminada);
		menu1.add(Fiesta_Nueva);
		menu3.add(datos_todas);
		menu2.add(invitar);
		menu2.add(cancelar);
		barra.add(menu1);
		barra.add(menu3);
		barra.add(menu2);
		add(barra);

	}

	/*
	 * Y ESTA ES LA CLASE PRIVADA DE LA QUE HABLABA ANTES, SERA LA CLASE DONDE
	 * PROGRAMAREMOS NUESTROS EVENTOS Y SUS METODOS CORRESPONDIENTES. CADA BOTON
	 * QUE EJECUTEMOS, LLAMARA AL METODO QUE LE CORRESPONDA.
	 */
	private class pulsar_boton2 implements ActionListener {
		/*
		 * DEFINO UNA VARIABLE CLICK, ESTA VARIABLE, SERA EL INDICATIVO DE QUE
		 * SE HA HECHO CLICK EN UNA FIESTA Y LA HA VALIDADO COMO CORRECTA
		 */

		int click;
		/*
		 * AQUI DEFINO UN ARRAY DE OBJETOS FIESTA, PORQUE VOY A IR ALMACENANDO
		 * TODOS MIS OBJETOS FIESTA EN UN ARRAY, DE ESTA MANERA TENDRE TODA LA
		 * INFORMACION DE ELLOS ORDENADA. LE DOY UNA DIMENSION CLICK+100 PARA
		 * QUE SEA INFINITA.
		 */
		Fiesta[] array = new Fiesta[click + 100];

		public void actionPerformed(ActionEvent e) {
			/*
			 * AQUI INTRODUZCO LOS TRY CATCH CORRESPONDIENTES, PARA LAS
			 * EXCEPCIONES EN LAS QUE PODEMOS INCURRIR AL INTRODUCIR PARAMETROS.
			 */
			try {
				try {
					try {
						if (e.getSource() == Fiesta_Predeterminada) {
							/*
							 * E.GETSOURCE SIGNIFICA QUE SI EL BOTON PULSADO ES
							 * EL DE FIESTA_PREDETERMINADA, ENTONCES VAMOS A
							 * CREAR UN OBJETO FIESTA NUEVO CON EL CONSTRUCTOR
							 * VACIO Y LOS VALORES PREDETERMINADOS QUE TENEMOS
							 * EN NUESTRA CLASE FIESTA. A SU VEZ LO GUARDAMOS EN
							 * EL ARRAY EN LA POSICION CLICK. POR EJEMPLO, AL
							 * PRIMER CLICK EN NUEVO FIESTA, FIESTA
							 * PREDETERMINADA, EL VALOR DE CLICK ES CERO AUN,
							 * PUES GUARDA ESTE NUEVO OBJETO FIESTA EN LA
							 * POSICION CERO. COMO DESPUES YA LE SUMAMOS UNA
							 * UNIDAD A CLICK PUES SIGUE ALMACENANDO EN EL LUGAR
							 * CORRESPONDIENTE.
							 */
							array[click] = new Fiesta();
							click++;// SUMAMOS EL CONTADOR DE CLICK
							// A SU VEZ TAMBIEN HABILITAMOS EL BOTON INVITAR
							// PORQUE YA TENEMOS FIESTAS
							invitar.setEnabled(true);
							// LO MISMO CON EL BOTON DATOS FIESTAS
							datos_todas.setEnabled(true);
						}
						if (e.getSource() == Fiesta_Nueva) {
							/*
							 * SI EL BOTON PULSADO ES FIESTA_NUEVA, ESTAMOS
							 * DICIENDO QUE QUEREMOS LLAMAR AL CONSTRUCTOR AL
							 * CUAL HAY QUE PASARLE LOS PARAMETROS DEL TIPO
							 * EXIGIDO EN LA CLASE FIESTA PARA ELLO DEFINIMOS
							 * LAS VARIABLES REQUERIDAS Y LAS PEDIMOS MEDIANTE
							 * JOPTIONPANE. PODRIAMOS PEDIRLAS POR CONSOLA, PERO
							 * DE ESTA FORMA ME PARECE MAS CLARA Y ELEGANTE.
							 */
							String tipo;
							DateTimeFormatter formatter = DateTimeFormatter
									.ofPattern("dd/MM/yyyy HH:mm");

							String direccion;
							int bebidas;
							int bocadillos;

							tipo = JOptionPane
									.showInputDialog("¿Que tipo de fiesta se celebra?\n(Cumpleaños,Bautizo,Boda,etc)");

							LocalDateTime fechaHora = LocalDateTime
									.parse(JOptionPane
											.showInputDialog("¿Que dia y a que hora es la fiesta?"
													+ "\nIntroducir los datos en formato dd/MM/yyyy HH:mm"),
											formatter);

							direccion = JOptionPane
									.showInputDialog("¿Cuál es la direccion de la fiesta?");
							/*
							 * EN BOCADILLOS Y BEBIDAS NOS PROTEGEMOS DE LOS
							 * NUMEROS NEGATIVOS MEDIANTE BUCLES DO-WHILE
							 */
							boolean positivo = false;
							do {
								bebidas = Integer
										.parseInt(JOptionPane
												.showInputDialog("¿Cuantas bebidas son necesarias?"));
								if (bebidas >= 0) {
									positivo = true;

								} else {
									JOptionPane
											.showMessageDialog(null,
													"No existen numero de bebidas negativa");
								}
							} while (!positivo);
							positivo = false;
							do {
								bocadillos = Integer
										.parseInt(JOptionPane
												.showInputDialog("¿Cuantos bocadillos son ?"));
								if (bocadillos >= 0) {
									positivo = true;
								} else {
									JOptionPane
											.showMessageDialog(null,
													"No existen numero de bocadillos negativo");
								}
							} while (!positivo);
							/*
							 * EN ESTE MOMENTO, YA TENEMOS TODOS NUESTROS
							 * PARAMETROS CARGADOS CON VALORES. DE ESTA FORMA A
							 * CONTINUACION,ALMACENAMOS NUESTRO NUEVO OBJETO
							 * FIESTA EN EL ARRAY DONDE ALMACENAMOS NUESTRAS
							 * FIESTAS HACIENDO LLAMAMIENTO AL METODO QUE LLEVA
							 * EN SU INTERIOR LOS PARAMETROS QUE HEMOS DEFINIDO
							 */
							array[click] = new Fiesta(tipo, fechaHora,
									direccion, bebidas, bocadillos);
							// Y AHORA AUMENTAMOS NUESTRO CLICK.
							click++;
							// Y TAMBIEN HABILITAMOS NUESTROS BOTONES INVITAR Y
							// VER DATOS
							invitar.setEnabled(true);

							datos_todas.setEnabled(true);
						}
						/*
						 * A CONTINUACION HACEMOS RECOPILACION DE TODAS LAS
						 * EXCEPCIONES QUE PODEMOS TENER AL INTRODUCIR LOS DATOS
						 * Y LAS CAPTURAMOS DE TAL MANERA QUE SI SE PRODUCEN,
						 * INFORMARAN AL USUARIO MEDIANTE UN MENSAJE Y CON LAS
						 * INSTRUCCIONES LE FACILITAREMOS SEGUIR ADELANTE SIN
						 * QUE EL PROGRAMA SE CAIGA.
						 */
					} catch (DateTimeParseException error) {
						JOptionPane
								.showMessageDialog(
										null,
										"El formato de dia y hora introducido es erroneo.\nVuelve a empezar con los datos de una nueva fiesta");
					}// ESTA CAPTURA ERROR AL ESCRIBIR LA FECHA
					catch (NumberFormatException error) {
						JOptionPane
								.showMessageDialog(
										null,
										"No introduzcas letras en donde tienen que ir numeros.\nVuelve a empezar con los datos de una nueva fiesta");
					}// ESTA CAPTURA ERROR AL INTRODUCIR LETRAS EN VEZ DE
						// NUMEROS
					catch (NullPointerException error) {
						JOptionPane
								.showMessageDialog(null,
										"Has decidido no meter los datos y salir del programa.\n HASTA LA PRÓXIMA!");
					}// ESTA CAPTURA ERROR POR SALIR SIN INTRODUCIR DATOS

					if (e.getSource() == datos_todas) {
						/*
						 * SI PULSAMOS EL BOTON DEFINIDO COMO DATOS_TODAS, LA
						 * ACCION QUE QUEREMOS HACER ES SABER LOS DATOS DE TODAS
						 * LAS FIESTAS QUE TENEMOS GUARDADAS EN NUESTRO ARRAY.
						 * PARA ELLO, RECORREREMOS NUESTRO ARRAY,( TENEMOS QUE
						 * SER CONSCIENTES DE QUE LA POSICION DEL ARRAY EMPIEZA
						 * EN CERO, POR ELLO, HAY QUE RESTAR AL CLICK UNA
						 * POSICION.) RECORREMOS NUESTRO ARRAY Y PARA CADA
						 * OBJETO FIESTA, HACEMOS LLAMAMIENTO AL METODO SETTER
						 * CALCULA_PRECIOFIESTA, PARA QUE CALCULE EL PRECIO DE
						 * CADA OBJETO FIESTA Y DESPUES PODAMOS LLAMAR AL METODO
						 * GETTER CREADO Y NOS DE ESE VALOR O DIRECTAMENTE
						 * LLAMAR AL METODO GETTER CONSULTAR QUE YA NOS FACILITA
						 * TODOS LOS DATOS QUE LE HABIAMOS DEFINIDO EN UN STRING
						 * EN NUESTRA CLASE FIESTA.
						 */

						System.out
								.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
						for (int i = 0; i <= click - 1; i++) {
							System.out
									.println("\n################# ------ DATOS FIESTA :"
											+ (i + 1));
							array[i].calcula_precioFiesta();
							System.out.println((array[i].Consultar()));

						}
					}
					if (e.getSource() == invitar) {
						/*
						 * SI EL BOTON PULSADO ES INVITAR, LO QUE QUEREMOS ES
						 * AÑADIR UN INVITADO A NUESTRO OBJETO FIESTA, TENDREMOS
						 * QUE SABER A QUE OBJETO VAMOS A AÑADIR ESE INVITADO,
						 * PARA ELLO HEMOS NOMBRADO A LAS FIESTAS
						 * CORRELATIVAMENTE SEGUN LAS IBAMOS INTRODUCIENDO Y DE
						 * ESTA MANERA LE DIREMOS AL USUARIO QUE ES DE ESA FORMA
						 * COMO DEBE DE HACER LLAMAMIENTO AL OBJETO FIESTA QUE
						 * DESEE PARA AÑADIR USUARIO.
						 */

						boolean salir = false;
						while (!salir) {
							/*
							 * CON ESTE BUCLE WHILE, FORZAMOS AL USUARIO A
							 * INTRODUCIR UN NUMERO DE FIESTA CORRECTO. SI
							 * INTRODUCE UN NUMERO DE FIESTA INCORRECTO, NO SALE
							 * DEL BUCLE Y LE DICE QUE EL NUMERO DE FIESTA
							 * INTRODUCIDO ES INCORRECTO.
							 */
							int numero_fiesta = Integer
									.parseInt(JOptionPane
											.showInputDialog("INTRODUCE EL NUMERO DE FIESTA\nAHORA MISMO HAY "
													+ click + " FIESTA/S"));
							if (numero_fiesta > click || numero_fiesta <= 0) {
								JOptionPane.showMessageDialog(null,
										"La fiesta numero " + numero_fiesta
												+ " no existe");
							} else {
								/*
								 * SI INTRODUCE UN NUMERO DE FIESTA CORRECTO, EL
								 * OBJETO GUARDADO EN LA POSICION QUE HEMOS
								 * PEDIDO LLAMA AL METODO SETTER INVITAR Y DE
								 * ESTA MANERA SUMA UN INVITADO.
								 */
								array[numero_fiesta - 1].invitar();
								/*
								 * A CONTINUACION, MOSTRAMOS UN MENSAJE EN DONDE
								 * UTILIZAMOS EL METODO GETTER DAME_INVITADOS E
								 * INFORMAMOS DEL NUMERO TOTAL DE INVITADOS DE
								 * ESE OBJETO FIESTA GUARDADO EN LA POSICION DEL
								 * ARRAY QUE HEMOS FACILITADO
								 */
								JOptionPane
										.showMessageDialog(
												null,
												"HAS INVITADO A UN USUARIO A LA FIESTA "
														+ numero_fiesta
														+ "\n En esta fiesta hay ahora:  "
														+ array[numero_fiesta - 1]
																.dame_invitados()
														+ " Invitados");
								salir = true;
								/*
								 * SALIMOS DEL BUCLE Y HABILITAMOS EL BOTON DE
								 * PODER CANCELAR INVITADO
								 */
								cancelar.setEnabled(true);
							}
						}

					}
					/*
					 * AQUI CAPTURAMOS LA EXCEPCION DE INTRODUCIR UN STRING EN
					 * DONDE TIENE QUE IR UN NUMERO
					 */
				} catch (NumberFormatException error) {
					JOptionPane
							.showMessageDialog(null,
									"No has introducido un valor correcto en numero de fiesta");
				}

				if (e.getSource() == cancelar) {
					/*
					 * Y POR ULTIMO LA ACCION DE PULSAR EL BOTON CANCELAR. SI
					 * PULSAMOS ESTE BOTON, TENEMOS QUE RESTAR UN INVITADO AL
					 * OBJETO FIESTA QUE NOSOTROS LE INTROZCAMOS MEDIANTE EL
					 * MISMO METODO QUE PARA INVITAR. AQUI TENEMOS QUE TENER
					 * CUIDADO DE QUE
					 */

					boolean salir2 = false;

					while (!salir2) {
						/*
						 * EL BUCLE WHILE LO HACEMOS IGUAL QUE EN EL CASO DE
						 * INVITAR. POR SI INTRODUCIMOS UN NUMERO DE FIESTA QUE
						 * NO EXISTE.
						 */
						int numero_fiesta = Integer
								.parseInt(JOptionPane
										.showInputDialog("INTRODUCE EL NUMERO DE FIESTA\nAHORA MISMO HAY "
												+ click + " FIESTA/S"));
						if (numero_fiesta > click || numero_fiesta <= 0) {

							JOptionPane.showMessageDialog(null,
									"La fiesta numero " + numero_fiesta
											+ " no existe");
						} else if (array[numero_fiesta - 1].dame_invitados() == 0) {
							/*
							 * EN ESTE CASO, QUEREMOS DECIR QUE SI LA FIESTA HA
							 * SUMADO INVITADOS Y DESPUES HA RESTADO HASTA
							 * VOLVER A ESTAR EN CERO, AL QUERER RESTAR MAS,
							 * DECIR QUE LA FIESTA YA TIENE CERO INVITADOS
							 */
							JOptionPane.showMessageDialog(null,
									"Esta fiesta ya tiene cero invitados");
						} else {
							/*
							 * SI SE CUMPLEN LAS CONDICIONES ANTES MENCIONADAS,
							 * CON EL OBJETO ARRAY GUARDADO EN LA POSICION QUE
							 * HEMOS PEDIDO, HACEMOS LLAMAMIENTO AL METODO
							 * SETTER CANCELARINVITACION CON EL CUAL RESTAMOS UN
							 * USUARIO AL OBJETO FIESTA DESEADO
							 */
							array[numero_fiesta - 1].cancelarInvitacion();
							/*
							 * A CONTINUACION, VOLVEMOS A SACAR UN MENSAJE CON
							 * LOS DATOS DE INVITADOS ACTUALIZADO MEDIANTE EL
							 * LLAMAMIENTO AL METODO GETTER PARA EL OBJETO
							 * FIESTA DESEADO
							 */
							JOptionPane.showMessageDialog(
									null,
									"HAS CANCELADO LA INVITACION A UN USUARIO DE LA FIESTA "
											+ numero_fiesta
											+ "\n En esta fiesta hay ahora:  "
											+ array[numero_fiesta - 1]
													.dame_invitados()
											+ " Invitados");
							salir2 = true;

						}
					}

				}
			} catch (NumberFormatException error) {/*
													 * AQUI CAPTURAMOS LA
													 * EXCEPCION DE INTRODUCIR
													 * UN STRING EN EL VALOR DE
													 * FIESTA
													 */
				JOptionPane
						.showMessageDialog(null,
								"No has introducido un valor correcto en numero de fiesta");
			}

		}

	}

}
