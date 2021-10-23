package co.com.sofka.okr.c2.model.okrs.gateways;

import co.com.sofka.okr.c2.model.okrs.KRS;
import co.com.sofka.okr.c2.model.okrs.OKRS;
import co.com.sofka.okr.c2.model.usuarios.Usuarios;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface OKRSRepository {

    Mono<OKRS> getOkrById(String id);
    Flux<OKRS> getOkrByIdUser(String id);
    Flux<OKRS> findByCompleted(String id);
    Flux<OKRS> findByProgress(String id);

}
