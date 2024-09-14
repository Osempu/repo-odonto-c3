package com.example.ClinicaOdontologicaC3.Service;


import com.example.ClinicaOdontologicaC3.Entity.Paciente;
import com.example.ClinicaOdontologicaC3.Repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository; // Clase repositorio para entidad paciente

    /**
     * 
     * @param paciente entidad paciente que se desea registrar
     * @return retorna la entidad paciente registrada
     */
    public Paciente registrarPaciente(Paciente paciente){
        return pacienteRepository.save(paciente);
    }
    /**
     * 
     * @param paciente entidad pacietne a actualizar
     */
    public void actualizarPaciente(Paciente paciente){
        pacienteRepository.save(paciente);
    }

    /**
     * 
     * @param id id del paciente para eliminarlo
     */
    public void eliminarPacientePorId(Long id){
        pacienteRepository.deleteById(id);
    }

    /**
     * 
     * @param id id del paciente para buscarlo
     * @return retorna el paciente encontrado
     */
    public Optional<Paciente> buscarPorId(Long id){
        return pacienteRepository.findById(id);
    }

    /**
     * 
     * @param email email del paciente para buscarlo
     * @return retorna al paciente encontrado
     */
    public Optional<Paciente> buscarPorEmail(String email){
        return pacienteRepository.buscarPorEmail(email);
    }

    /**
     * 
     * @return retorna el listado de todos los pacientes
     */
    public List<Paciente> listarTodos(){
        return pacienteRepository.findAll();
    }
}
