package co.com.sofka.okr.c2.mongo;

import co.com.sofka.okr.c2.mongo.entities.OKREntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import reactor.core.publisher.Flux;

public interface OKRsDBRepository extends ReactiveMongoRepository<OKREntity, String>, ReactiveQueryByExampleExecutor<OKREntity> {

    Flux<OKREntity> findAllByManagerId(String id);
    Flux<OKREntity> findByManagerIdAndProgressEquals(String managerId, Double progress);
    Flux<OKREntity> findByManagerIdAndProgressLessThan(String managerId, Double progress);
}
