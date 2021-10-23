package co.com.sofka.okr.c2.mongo;

import co.com.sofka.okr.c2.model.okrs.OKRS;
import co.com.sofka.okr.c2.model.okrs.gateways.OKRSRepository;
import co.com.sofka.okr.c2.model.usuarios.Usuarios;
import co.com.sofka.okr.c2.mongo.entities.OKREntity;
import co.com.sofka.okr.c2.mongo.helper.AdapterOperations;
import co.com.sofka.okr.c2.mongo.helper.EntityMapper;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Repository
public class OKRsRepositoryAdapter extends AdapterOperations<OKREntity, OKREntity, String, OKRsDBRepository> implements OKRSRepository {

    private EntityMapper mapper = new EntityMapper();

    public OKRsRepositoryAdapter(OKRsDBRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, OKREntity.class));
    }

    @Override
    public Mono<OKRS> getOkrById(String id) {
        Mono<OKRS> obj = this.repository.findById(id).map(mapper.fromOKREntity());
        return obj;
    }

    @Override
    public Flux<OKRS> getOkrByIdUser(String id) {
        return this.repository.findAllByManagerId(id).map(mapper.fromOKREntity());
    }

    @Override
    public Flux<OKRS> findByCompleted(String id) {
        return this.repository.findByManagerIdAndProgressEquals(id,100.0).map(mapper.fromOKREntity());
    }

    @Override
    public Flux<OKRS> findByProgress(String id) {
        return this.repository.findByManagerIdAndProgressLessThan(id,100.0).map(mapper.fromOKREntity());
    }

}
