package Otro.service;
import Otro.repository.PacienteRepository;
import Otro.entity.Paciente;

import java.util.List;

public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService() {
        this.repository = new PacienteRepository();
    }

    public void crearPaciente(Paciente paciente) {
        repository.crear( paciente);
    }

    public Paciente obtenerPaciente(Long id) {
        return repository.leer(id);
    }

    public List<Paciente> obtenerTodosLosPacientes() {
        return repository.leerTodos();
    }

    public void actualizarPaciente(Paciente paciente) {
        repository.actualizar(paciente);
    }

    public void eliminarPaciente(Long id) {
        repository.eliminar(id);
    }

    public void cerrar() {
        repository.cerrar();
    }
}
