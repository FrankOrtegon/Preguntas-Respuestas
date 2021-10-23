package co.com.sofka.okr.c2.model.okrs;

import co.com.sofka.okr.c2.model.values.Description;
import co.com.sofka.okr.c2.model.values.IdOKR;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class KRS {

    private String id;
    private IdOKR idOkr;
    private Description description;
    private String managerId;
    private String startDate;
    private String endDate;
    private Double loadValue;
    private Double progress;

    public KRS(String id, IdOKR idOkr, Description description, String managerId, String startDate, String endDate, Double loadValue, Double progress) {
        this.id = id;
        this.idOkr = idOkr;
        this.description = description;
        this.managerId = managerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.loadValue = loadValue;
        this.progress = progress;
    }

    public KRS() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public IdOKR getIdOkr() {
        return idOkr;
    }

    public void setIdOkr(IdOKR idOkr) {
        this.idOkr = idOkr;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Double getLoadValue() {
        return loadValue;
    }

    public void setLoadValue(Double loadValue) {
        this.loadValue = loadValue;
    }

    public Double getProgress() {
        return progress;
    }

    public void setProgress(Double progress) {
        this.progress = progress;
    }
}
