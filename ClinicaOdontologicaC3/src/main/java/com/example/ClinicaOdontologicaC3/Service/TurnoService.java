package com.example.ClinicaOdontologicaC3.Service;

import com.example.ClinicaOdontologicaC3.Dto.TurnoDTO;
import com.example.ClinicaOdontologicaC3.Entity.Turno;
import com.example.ClinicaOdontologicaC3.Repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TurnoService {

    @Autowired
    private TurnoRepository turnoRepository; //Clase Repositorio para entidad Turno

    /**
     * 
     * @param turno entidad turno que se desea registrar
     * @return retorna turno dto
     */
    public TurnoDTO registrarTurno(Turno turno){
         Turno turnoGuardado= turnoRepository.save(turno);
         return turnoATurnoDto(turnoGuardado);
    }

    /**
     * Esta funcino retorna el listado de todos los turnos
     * @return Dto de listado de turnos
     */
    public List<TurnoDTO> listarTodos(){
        List<Turno> listaTurno= turnoRepository.findAll();
        List<TurnoDTO> listaDTO= new ArrayList<>();
        for (Turno turno : listaTurno) {
            listaDTO.add(turnoATurnoDto(turno));

        }
        return listaDTO ;
    }

    // Mapeador de turno a turno Dto
    private TurnoDTO turnoATurnoDto(Turno turno){
        TurnoDTO dto= new TurnoDTO();
        dto.setId(turno.getId());
        dto.setFecha(turno.getFecha());
        dto.setOdontologoId(turno.getOdontologo().getId());
        dto.setPacienteId(turno.getPaciente().getId());
        return dto;
    }

    /**
     * 
     * @param turno turno que se desea actualizar
     */
    public void actualizarTurno(Turno turno) { turnoRepository.save(turno); }

    /**
     * 
     * @param id id por la que se buscara el turno para eliminarlo posteriormente
     */
    public void eliminarTurnoPorId(Long id) { turnoRepository.deleteById(id); }
}
