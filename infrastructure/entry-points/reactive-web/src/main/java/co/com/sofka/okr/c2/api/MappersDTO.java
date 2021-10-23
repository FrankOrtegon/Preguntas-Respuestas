package co.com.sofka.okr.c2.api;

import co.com.sofka.okr.c2.model.okrs.KRS;
import co.com.sofka.okr.c2.model.okrs.OKRS;
import co.com.sofka.okr.c2.model.usuarios.Usuarios;
import org.springframework.stereotype.Component;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

@Component
public class MappersDTO {

    private List<KRS> krs = new ArrayList<>();
    private List<OKRS> okrs = new ArrayList<>();

    public BiFunction<OKRS, List<KRS>, OKRSDTO> toDTO(){
        return (okr, kr)-> new OKRSDTO(
                okr.getId().getValue(),
                okr.getObjective().getValue(),
                okr.getTitle().getValue(),
                okr.getManagerId(),
                okr.getDescription().getValue(),
                okr.getAreaInCharge(),
                okr.getProgress(),
                kr
        );
    }

    public Function<OKRS, OKRSDTO> okrToDto(){
        return okr-> new OKRSDTO(
                okr.getId().getValue(),
                okr.getObjective().getValue(),
                okr.getTitle().getValue(),
                okr.getManagerId(),
                okr.getDescription().getValue(),
                okr.getAreaInCharge(),
                okr.getProgress(),
                krs
        );
    }

    public Function<Usuarios, ResponseUserDTO> userToDTO(){
        return users -> new ResponseUserDTO(
          users.getId().getValue(),
          users.getName().getValue(),
          okrs
        );
    }

}
