package co.com.sofka.okr.c2.api;

import co.com.sofka.okr.c2.model.okrs.OKRS;
import co.com.sofka.okr.c2.model.values.Name;
import reactor.core.publisher.Flux;

import java.util.List;


public class ResponseUserDTO {

    private String id;
    private String name;
    private List<OKRSDTO> okrs;

    public ResponseUserDTO(String id, String name, List<OKRSDTO> okrs) {
        this.id = id;
        this.name = name;
        this.okrs = okrs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<OKRSDTO> getOkrs() {
        return okrs;
    }

    public void setOkrs(List<OKRS> okrs) {
        this.okrs = okrs;
    }
}
