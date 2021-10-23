package co.com.sofka.okr.c2.usecase.okr;

import co.com.sofka.okr.c2.model.okrs.OKRS;
import co.com.sofka.okr.c2.model.okrs.gateways.OKRSRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RequiredArgsConstructor
public class OKRUseCase {

    private final OKRSRepository repository;

    public Mono<OKRS> execute(String id){
        return  repository.getOkrById(id);
    }

    public Flux<OKRS> getByIdUser(String id){
        return repository.getOkrByIdUser(id);
    }

    public Flux<OKRS> findCompleted(String id){return repository.findByCompleted(id);}

    public Flux<OKRS> findProgress(String id){return repository.findByProgress(id);}
}
