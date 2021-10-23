package co.com.sofka.okr.c2.mongo;

import co.com.sofka.okr.c2.model.okrs.KRS;
import co.com.sofka.okr.c2.model.okrs.gateways.KRSRepository;
import co.com.sofka.okr.c2.mongo.entities.KREntity;
import co.com.sofka.okr.c2.mongo.helper.AdapterOperations;
import co.com.sofka.okr.c2.mongo.helper.EntityMapper;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public class KRsRepositoryAdapter extends AdapterOperations<KREntity, KREntity, String, KRsDBRepository> implements KRSRepository {

    private EntityMapper mapper = new EntityMapper();

    public KRsRepositoryAdapter(KRsDBRepository repository, ObjectMapper mapper) {
        super(repository, mapper, b ->  mapper.map(b, KREntity.class));
    }

    @Override
    public Flux<KRS> listKr(String id) {
        return this.repository.findAllByIdOkr(id).map(mapper.fromKREntity());
    }
}
