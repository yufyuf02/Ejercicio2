/*
Autora: Yu-Fong
Fecha: 22 de agosto, 2025
Descripción: Gestionador de salones de un centro de eventos.
*/

import java.util.Scanner;
public class Main {
    
    public static void main(String [] args) {
        Scanner teclado = new Scanner(System.in);

// Salones
        System.out.print(
            "\nGestión de salones en **Centro de Eventos**\n\n" +
            "¿Cuántos salones pequeños hay disponibles?: ");
        int numPeque = teclado.nextInt();
        System.out.print("¿Cuántos medianos hay disponibles?: ");
        int numMed = teclado.nextInt();
        System.out.print("¿Cuántos grandes hay disponibles?: ");
        int numGran = teclado.nextInt();
        int totalSalones = numPeque + numMed + numGran;

        // Verifica que hayan al menos 4 salones
        if (totalSalones <= 3){
            System.out.print("\n" +
            "Deben haber al menos 4 salones disponibles.\n" +
            "Por favor intentar de nuevo.\n");
            return;

// Reservaciones
        } else {
            System.out.print("\nIniciar una reservación en **Centro de Eventos**\n\n");
            System.out.print("¿Cuál es el nombre del encargado?: ");
            teclado.nextLine();              // >:(
            String encargado = teclado.nextLine();
            System.out.print("¿Cuál es el nombre del evento?: ");
            String nombreEvento = teclado.nextLine();

            int tipoEvento = 1;
            System.out.print("Las opciones actuales son...\n" +
            "   (1) Cumpleaños\n   (2) Reunión\n   (3) 15 años\n" +
            "   (4) Conferencia\n   (5) Gala\n   (6) Boda\n" +
            "¿Qué tipo de evento es?: ");
            tipoEvento = teclado.nextInt();

            while (tipoEvento >= 7 || tipoEvento == 0){
                System.out.print("Por favor ingresar una opción válida.\n" +
                "   (1) Cumpleaños\n   (2) Reunión\n   (3) 15 años\n" +
                "   (4) Conferencia\n   (5) Gala\n   (6) Boda\n" +
                "¿Qué tipo de evento es?: ");
                tipoEvento = teclado.nextInt();
            }

            System.out.print("¿En qué fecha será el evento?: ");
            teclado.nextLine();              // >:(
            String fecha = teclado.nextLine();
            System.out.print("¿A qué hora inicia el evento (0-24 horas)?: ");
            int horaInicio = teclado.nextInt();
            System.out.print("¿A qué hora inicia termina el evento (0-24 horas)?: ");
            int horaFinal = teclado.nextInt();

            while ((horaInicio > horaFinal) || ((horaInicio >= 25)||(horaFinal >= 25))){
                System.out.print("\n" + 
                "Por favor ingresar una hora válida y que NO abarque el siguiente día.\n");
                System.out.print("¿A qué hora inicia el evento (0-24 horas)?: ");
                horaInicio = teclado.nextInt();
                System.out.print("¿A qué hora inicia termina el evento (0-24 horas)?: ");
                horaFinal = teclado.nextInt();
            }

            String asignacion = "Sin asignar";
            Reservacion reservacion1 = new Reservacion(encargado, nombreEvento, tipoEvento, fecha, horaInicio, horaFinal, asignacion);

// Asignaciones
            
            tipoEvento = reservacion1.getTipoEvento();

            int continuar = 0; 
            if (tipoEvento == (1)|| tipoEvento == (2)){
                if (numPeque == (0) && numMed == (0)){
                    System.out.print("\nNo hay salones disponibles para su evento, la reservación se pondrá en la lista de espera.\n");
                    reservacion1.setAsignacion("Lista de espera");
                    System.out.println(reservacion1.getAsignacion()); // Para verificar que esté en la lista de espera
                    return;
                } else {
                    System.out.print("\nPara la reservación '" + reservacion1.getNombreEvento() + "', " +
                    "las opciones de salón disponibles son...");
                    System.out.print("\n" + numPeque + " salon(es) pequeño(s) y " + numMed + " salon(es) mediano(s).\n" +
                    // Info de los salones pequeños y medianos.
                    "Los salones pequeños tiene una capacidad máxima de 10 personas y costo de Q100 por hora.\n" +
                    "Los salones medianos tiene una capacidad máxima de 40 personas y costo de Q300 por hora.\n" +
                    "¿Desea realizar la reservación?" +
                    "\n   (1) Sí (2) No\n");
    
                    continuar = teclado.nextInt();
                    if (continuar == 1){ // Si seleccionan que quieren realizar la reservación
                        System.out.print("¿Cuál salón desea?" +
                        "\n   (1) Pequeño (2) Mediano\n");
                        continuar = teclado.nextInt();
    
                        if (continuar == 1){ // Si seleccionan que quieren un salón pequeño
                            if (numPeque <= 0){
                                System.out.print("\nNo contamos con la cantidad de salones disponibles.\n" +
                                "Su reservación será ingresada a la lista de espera. Gracias.");
                                reservacion1.setAsignacion("Lista de espera");
                                System.out.println(reservacion1.getAsignacion()); // Para verificar que esté en la lista de espera
                                return;
                            } else {
                                System.out.print("¿Cuenta con servicio de catering?" +
                                "\n   (1) Sí (2) No\n");
                                continuar = teclado.nextInt();
                                System.out.print("¿Ya realizó el depósito?"+
                                "\n   (1) Sí (2) No\n");
                                continuar = teclado.nextInt();
                                if (continuar == 1){
                                    System.out.print("\nGracias por su colaboración. Se ha reservado su espacio.");
//                                    System.out.println(numPeque); // Para verificar que baje el número de salones
                                    numPeque = numPeque - 1;
                                    reservacion1.setAsignacion("Asignado a salón pequeño");
//                                    System.out.println(numPeque); // Para verificar que baje el número de salones
//                                    System.out.println(reservacion1.getAsignacion()); // Para verificar que se haya asignado
                                } else {
                                    System.out.println("Debe realizar el depósito para reservar. Gracias.");
                                    return;
                                }
                            }
                        } else {
                            if (numMed <= 0){
                                System.out.print("\nNo contamos con la cantidad de salones disponibles.\n" +
                                "Su reservación será ingresada a la lista de espera. Gracias.\n");
                                reservacion1.setAsignacion("Lista de espera");
//                                System.out.println(reservacion1.getAsignacion()); // Para verificar que esté en la lista de espera
                                return;
                            } else {
                                System.out.print("¿Cuenta con servicio de catering?" +
                                "\n   (1) Sí (2) No\n");
                                continuar = teclado.nextInt();
                                System.out.print("¿Ya realizó el depósito?"+
                                "\n   (1) Sí (2) No\n");
                                continuar = teclado.nextInt();
                                if (continuar == 1){
                                    System.out.print("\nSe ha reservado su espacio. Gracias por su colaboración. :)\n");
//                                    System.out.println(numMed); // Para verificar que baje el número de salones
                                    numMed = numMed - 1;
                                    reservacion1.setAsignacion("Asignado a salón mediano");
//                                    System.out.println(numMed); // Para verificar que baje el número de salones
//                                    System.out.println(reservacion1.getAsignacion()); // Para verificar que se haya asignado
                                } else {
                                    System.out.println("Debe realizar el depósito para reservar. Gracias.");
                                    return;
                                }
                            }
                        }
                    } else { // Si seleccionan que no quieren realizar la reservación.
                        System.out.print("\nGracias.\n");
                        return;
                    }
                    
                }
            } else {

                // Para salones grandes
                if (numGran == (0)) {
                    System.out.print("\nNo contamos con la cantidad de salones disponibles.\n" +
                    "Su reservación será ingresada a la lista de espera. Gracias.\n");
                    reservacion1.setAsignacion("Lista de espera");
//                    System.out.println(reservacion1.getAsignacion()); // Para verificar que esté en la lista de espera
                    return;
                } else {
                    System.out.print("\nPara la reservación '" + reservacion1.getNombreEvento() + "', " +
                    "las opciones de salón disponibles son...");
                    System.out.print("\n" + numGran + " salon(es) grande(s).\n" +
                    "Los salones grandes tiene una capacidad máxima de 100 personas y costo de Q500 por hora.\n" +
                    "¿Desea realizar la reservación?" +
                    "\n   (1) Sí (2) No\n");
                    continuar = teclado.nextInt();
                    if (continuar == 1){ // Si seleccionan que quieren realizar la reservación
                        if (numGran <= 0){
                            System.out.print("No contamos con la cantidad de salones disponibles." +
                            "Su reservación será ingresada a la lista de espera. Gracias.");
                            reservacion1.setAsignacion("Lista de espera");
//                            System.out.println(reservacion1.getAsignacion()); // Para verificar que esté en la lista de espera
                            return;
                        } else {
                            System.out.print("¿Cuenta con servicio de catering?" +
                            "\n   (1) Sí (2) No\n");
                            continuar = teclado.nextInt();
                            System.out.print("¿Ya realizó el depósito?"+
                            "\n   (1) Sí (2) No\n");
                            continuar = teclado.nextInt();
                            if (continuar == 1){
                                System.out.print("\nSe ha reservado su espacio. Gracias por su colaboración. :)\n");
//                                System.out.println(numGran); // Para verificar que baje el número de salones
                                numGran = numGran - 1;
                                reservacion1.setAsignacion("Asignado a salón grande");
//                                System.out.println(numGran + "\n" + // Para verificar que baje el número de salones
//                                reservacion1.getAsignacion());      // y verificar que se haya asignado.
                            } else {
                                System.out.println("Debe realizar el depósito para reservar. Gracias.");
                                return;
                            }
                        }
                    } else { // Si seleccionan que no quieren realizar la reservación.
                        System.out.print("\nGracias.\n");
                        return;
                    }
                }
            }
        }
    }
}