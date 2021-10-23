package co.com.sofka.okr.c2.model.usuarios.gateways;

import co.com.sofka.okr.c2.model.okrs.OKRS;
import co.com.sofka.okr.c2.model.usuarios.Usuarios;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UsuariosRepository {

    Flux<Usuarios> getAllUser();
    Mono<Usuarios> getOkrById(String id);
}
