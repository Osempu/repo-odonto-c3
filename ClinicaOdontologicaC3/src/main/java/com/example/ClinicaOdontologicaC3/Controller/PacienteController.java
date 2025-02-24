package com.example.ClinicaOdontologicaC3.Controller;

import com.example.ClinicaOdontologicaC3.Entity.Paciente;
import com.example.ClinicaOdontologicaC3.Exception.CustomBadRequestException;
import com.example.ClinicaOdontologicaC3.Exception.ResourceNotFoundException;
import com.example.ClinicaOdontologicaC3.Service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;


  @PostMapping
    public ResponseEntity<Paciente> guardarPaciente(@RequestBody Paciente paciente) throws CustomBadRequestException {
      try {
          Paciente response = pacienteService.registrarPaciente(paciente);
          return ResponseEntity.ok(response);
      }catch(Exception e) {
          throw new CustomBadRequestException("Datos Invalidos");
      }
  }
  
  @PutMapping
   public ResponseEntity<String> actualizarPaciente(@RequestBody Paciente paciente) throws ResourceNotFoundException {
      Optional<Paciente> pacienteBuscado= pacienteService.buscarPorId(paciente.getId());
      if(pacienteBuscado.isPresent()){
          pacienteService.actualizarPaciente(paciente);
          return ResponseEntity.ok("paciente actualizado con exito");
      }else{
          throw new ResourceNotFoundException("Paciente no encontrado");
      }
  }

  @GetMapping("/buscar/{id}")
    public ResponseEntity<Optional<Paciente>> buscarPorId(@PathVariable Long id){
      return ResponseEntity.ok(pacienteService.buscarPorId(id));
  }

  @GetMapping("/buscar/email/{email}")
    public ResponseEntity<Optional<Paciente>> buscarPorEmail(@PathVariable String email) throws ResourceNotFoundException{
      Optional<Paciente> pacienteBuscado= pacienteService.buscarPorEmail(email);
      if(pacienteBuscado.isPresent()){
          return ResponseEntity.ok(pacienteBuscado);
      }else{
          throw new ResourceNotFoundException("paciente no encontrado por email");
      }
  }

  @GetMapping
    public ResponseEntity<List<Paciente>> listarTodos(){
      return ResponseEntity.ok(pacienteService.listarTodos());
  }

  @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Long id) throws ResourceNotFoundException{
      Optional<Paciente> pacienteBuscado=pacienteService.buscarPorId(id);
      if(pacienteBuscado.isPresent()){
          pacienteService.eliminarPacientePorId(id);
          return ResponseEntity.ok("paciente eliminado con exito");
      }else{
          throw new ResourceNotFoundException("paciente no encontrado");
      }

  }
}
