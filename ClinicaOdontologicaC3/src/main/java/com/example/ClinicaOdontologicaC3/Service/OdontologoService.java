package com.example.ClinicaOdontologicaC3.Service;

import com.example.ClinicaOdontologicaC3.Entity.Odontologo;
import com.example.ClinicaOdontologicaC3.Repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {
    @Autowired
    private OdontologoRepository odontologoRepository; //Clase repositorio para entidad odontologo

    /**
     * 
     * @param odontologo Entidad odontologo a registrar
     * @return retorna la entidad odontologo registrada
     */
    public Odontologo registrarOdontologo(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }

    /**
     * 
     * @param id id del odontogolo para buscarlo
     * @return entidad odontologo encontrada
     */
    public Optional<Odontologo> buscarPorId(Long id){
        return odontologoRepository.findById(id);
    }

    /**
     * 
     * @return listado de todos los odontologos
     */
    public List<Odontologo> listarTodos() { return odontologoRepository.findAll(); }

    /**
     * 
     * @param id id del odontologo para buscarlo
     */
    public void eliminarOdontologoPorId(Long id) { odontologoRepository.deleteById(id);}
}
