package Otro;

import Otro.entity.Paciente;
import Otro.service.PacienteService;

import java.util.List;
import java.util.Scanner;

public class App {
    private static final PacienteService pacienteService = new PacienteService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- CRUD de Pacientes ---");
            System.out.println("1. Crear paciente");
            System.out.println("2. Leer paciente");
            System.out.println("3. Actualizar paciente");
            System.out.println("4. Eliminar paciente");
            System.out.println("5. Listar todos los pacientes");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1 -> crearPaciente();
                case 2 -> leerPaciente();
                case 3 -> actualizarPaciente();
                case 4 -> eliminarPaciente();
                case 5 -> listarPacientes();
                case 6 -> salir = true;
                default -> System.out.println("Opción no válida");
            }
        }
        pacienteService.cerrar();
        scanner.close();
    }

    private static void crearPaciente() {
        System.out.print("Nombre del paciente: ");
        String nombre = scanner.nextLine();
        System.out.print("consultorio del paciente: ");
        int consultorio = scanner.nextInt();

        Paciente paciente = new Paciente();
        paciente.setNombre(nombre);
        paciente.setConsultorio(consultorio);


        pacienteService.crearPaciente(paciente);
        System.out.println("Paciente creado con éxito");
    }

    private static void leerPaciente() {
        System.out.print("ID del paciente: ");
        Long id = scanner.nextLong();
        Paciente paciente = pacienteService.obtenerPaciente(id);
        if (paciente != null) {

        } else {
            System.out.println("Paciente no encontrado");
        }
    }

    private static void actualizarPaciente() {
        System.out.print("ID del producto a actualizar: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consumir el salto de línea

        Paciente paciente = pacienteService.obtenerPaciente(id);
        if (paciente != null) {
            System.out.print("Nuevo nombre (deje en blanco para mantener el actual): ");
            String nombre = scanner.nextLine();
            if (!nombre.isEmpty()) {
                paciente.setNombre(nombre);
            }

            System.out.print("Nuevo consultorio (0 para mantener el actual): ");
            int consultorio = scanner.nextInt();
            if (consultorio != 0 ) {
                paciente.setConsultorio(consultorio);
            }
            pacienteService.actualizarPaciente(paciente);
            System.out.println("Paciente actualizado con éxito");
        } else {
            System.out.println("Paciente no encontrado");
        }
    }

    private static void eliminarPaciente() {
        System.out.print("ID del paciente a eliminar: ");
        Long id = scanner.nextLong();
        pacienteService.eliminarPaciente(id);
        System.out.println("Paciente eliminado con éxito");
    }

    private static void listarPacientes() {
        List<Paciente> pacientes= pacienteService.obtenerTodosLosPacientes();
        if (pacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados");
        } else {
            for (Paciente paciente : pacientes) {
                System.out.println(paciente);
            }
        }
    }
}