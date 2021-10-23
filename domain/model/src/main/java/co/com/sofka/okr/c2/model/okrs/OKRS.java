package co.com.sofka.okr.c2.model.okrs;
import co.com.sofka.okr.c2.model.values.Description;
import co.com.sofka.okr.c2.model.values.IdOKR;
import co.com.sofka.okr.c2.model.values.Objective;
import co.com.sofka.okr.c2.model.values.Title;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
public class OKRS {

    private IdOKR id;
    private Objective objective;
    private Title title;
    private String managerId;
    private Description description;
    private String areaInCharge;
    private Double progress;
    private List<KRS> krs;

    public OKRS(IdOKR id, Objective objective, Title title, String managerId, Description description, String areaInCharge, Double progress, List<KRS> krs) {
        this.id = id;
        this.objective = objective;
        this.title = title;
        this.managerId = managerId;
        this.description = description;
        this.areaInCharge = areaInCharge;
        this.progress = progress;
        this.krs = krs;
    }

    public void addKRS(KRS krs){
        this.krs.add(krs);
    }

    public IdOKR getId() {
        return id;
    }

    public void setId(IdOKR id) {
        this.id = id;
    }

    public Objective getObjective() {
        return objective;
    }

    public void setObjective(Objective objective) {
        this.objective = objective;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public String getAreaInCharge() {
        return areaInCharge;
    }

    public void setAreaInCharge(String areaInCharge) {
        this.areaInCharge = areaInCharge;
    }

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }

    public List<KRS> getKrs() {
        return krs;
    }

    public void setKrs(List<KRS> krs) {
        this.krs = krs;
    }
}
