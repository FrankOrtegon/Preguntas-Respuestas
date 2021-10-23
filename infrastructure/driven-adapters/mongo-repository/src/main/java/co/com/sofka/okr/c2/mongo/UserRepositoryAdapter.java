package co.com.sofka.okr.c2.mongo;

import co.com.sofka.okr.c2.model.okrs.OKRS;
import co.com.sofka.okr.c2.model.usuarios.Usuarios;
import co.com.sofka.okr.c2.model.usuarios.gateways.UsuariosRepository;
import co.com.sofka.okr.c2.mongo.entities.UsuariosEntity;
import co.com.sofka.okr.c2.mongo.helper.AdapterOperations;
import co.com.sofka.okr.c2.mongo.helper.EntityMapper;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.function.Function;
@Repository
public class UserRepositoryAdapter extends AdapterOperations<UsuariosEntity,UsuariosEntity,String,UserDBRepository> implements UsuariosRepository {

    private EntityMapper mapper = new EntityMapper();

    public UserRepositoryAdapter(UserDBRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d-> mapper.map(d,UsuariosEntity.class));
    }

    @Override
    public Flux<Usuarios> getAllUser() {
        Flux<Usuarios> users = this.repository.findAll().map(mapper.fromUsuarioEntity());
        return users;
    }

    @Override
    public Mono<Usuarios> getOkrById(String id) {
        Mono<Usuarios> user = this.repository.findById(id).map(mapper.fromUsuarioEntity());
        return user;
    }


}
