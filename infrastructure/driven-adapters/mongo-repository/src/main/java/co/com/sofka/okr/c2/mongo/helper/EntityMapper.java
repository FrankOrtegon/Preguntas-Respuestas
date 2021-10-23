package co.com.sofka.okr.c2.mongo.helper;

import co.com.sofka.okr.c2.model.okrs.KRS;
import co.com.sofka.okr.c2.model.okrs.OKRS;
import co.com.sofka.okr.c2.model.usuarios.Usuarios;
import co.com.sofka.okr.c2.model.values.*;
import co.com.sofka.okr.c2.mongo.entities.KREntity;
import co.com.sofka.okr.c2.mongo.entities.OKREntity;
import co.com.sofka.okr.c2.mongo.entities.UsuariosEntity;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.function.Function;

@Component
public class EntityMapper {

    public Function<OKREntity, OKRS> fromOKREntity() {
        return newEntity -> new OKRS(
                new IdOKR(newEntity.getId()),
                new Objective(newEntity.getObjective()),
                new Title(newEntity.getTitle()),
                newEntity.getManagerId(),
                new Description(newEntity.getDescription()),
                newEntity.getAreaInCharge(),
                newEntity.getProgress(),
                new ArrayList<>()
        );
    }

    public Function<KREntity, KRS> fromKREntity() {
        return newEntity -> new KRS(
                newEntity.getId(),
                new IdOKR(newEntity.getIdOkr()),
                new Description(newEntity.getDescription()),
                newEntity.getManagerId(),
                newEntity.getStartDate(),
                newEntity.getEndDate(),
                newEntity.getLoadValue(),
                newEntity.getProgress()
        );
    }

   public Function<UsuariosEntity, Usuarios> fromUsuarioEntity(){
        return newUser -> new Usuarios(
                new IdUser(newUser.getId()),
                new Name(newUser.getName()),
                new Email(newUser.getEmail()),
                newUser.getUrlPhoto(),
                new Phone(newUser.getPhone())
        );
    }


}
