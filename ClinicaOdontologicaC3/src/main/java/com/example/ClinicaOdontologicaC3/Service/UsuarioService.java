package com.example.ClinicaOdontologicaC3.Service;

import com.example.ClinicaOdontologicaC3.Entity.Usuario;
import com.example.ClinicaOdontologicaC3.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    private UsuarioRepository usuarioRepository; //clase repositorio para entidad usuario

    /**
     * Funcion para cargar el usuario por nombre de usuario
     * Si encuentra al usuario lo devuelve
     * Devuelve UsernameNotFound Exception en caso de no encontrarlo
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> usuarioBuscado= usuarioRepository.buscarPorEmail(username);
        if(usuarioBuscado.isPresent()){
            return usuarioBuscado.get();
        }else{
            throw new UsernameNotFoundException("Usuario inexistente: "+username);
        }

    }
}
