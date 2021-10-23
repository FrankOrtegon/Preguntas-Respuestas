package co.com.sofka.okr.c2.api;


import co.com.sofka.okr.c2.model.okrs.OKRS;
import co.com.sofka.okr.c2.usecase.okr.KRUseCase;
import co.com.sofka.okr.c2.usecase.okr.OKRUseCase;
import co.com.sofka.okr.c2.usecase.usuario.UsuarioUseCase;
import lombok.RequiredArgsConstructor;
import lombok.val;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
@RequiredArgsConstructor
public class Handler {
    private final OKRUseCase useCase;
    private final KRUseCase useCase2;
    private final UsuarioUseCase usuarioUseCase;
    private final MappersDTO mappersDTO;

    public Mono<OKRSDTO> listenGETUseCase(String id) {
        Mono<OKRSDTO> kr = useCase.execute(id).map(mappersDTO.okrToDto());
        Flux<OKRSDTO> responce = useCase2.execute(id).buffer().flatMap(it -> kr.flatMap(it1 -> {
            it1.setKrs(it);
            val kr2 = it1;
            return Mono.just(kr2);
        }));
        return responce.next();
    }


    public Mono<ResponseUserDTO> findUserAllOkr(String id){
        Mono<ResponseUserDTO> user = usuarioUseCase.getUser(id).map(mappersDTO.userToDTO());
        Flux<ResponseUserDTO> response = useCase.getByIdUser(id).buffer()
                .flatMap(it -> user.flatMap(okr -> {
                     okr.setOkrs(it);
                    val okr2 = okr;
                    return Mono.just(okr2);
                }));
        return response.next();
    }

    public Flux<ResponseUserDTO> getAllOkrByIdUser(){
        Flux<ResponseUserDTO> users = usuarioUseCase.getAllUser().map(mappersDTO.userToDTO())
                .flatMap(us ->
                    findUserAllOkr(us.getId())
                );
        return users;
    }

    public Flux<OKRSDTO> findByCompleted(String id){
        Flux<OKRSDTO> okrsFlux = useCase.findCompleted(id).map(mappersDTO.okrToDto());
        return okrsFlux;
    }

    public Flux<OKRSDTO> findByProgress(String id){
        Flux<OKRSDTO> okrs = useCase.findProgress(id).map(mappersDTO.okrToDto());
        return okrs;
    }

}

