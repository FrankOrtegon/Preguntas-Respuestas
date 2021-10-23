package co.com.sofka.okr.c2.usecase.usuario;

import co.com.sofka.okr.c2.model.okrs.OKRS;
import co.com.sofka.okr.c2.model.usuarios.Usuarios;
import co.com.sofka.okr.c2.model.usuarios.gateways.UsuariosRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RequiredArgsConstructor
public class UsuarioUseCase {

    private final UsuariosRepository usuariosRepository;

    public Flux<Usuarios> getAllUser(){
        return usuariosRepository.getAllUser();
    }

    public Mono<Usuarios> getUser(String id){return usuariosRepository.getOkrById(id);}
}
