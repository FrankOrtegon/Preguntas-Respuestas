package co.com.sofka.okr.c2.mongo.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "krs")
public class KREntity {

    @Id
    private String id;
    private String idOkr;
    private String description;
    private String managerId;
    private String startDate;
    private String endDate;
    private Double loadValue;
    private Double progress;

    public KREntity(String id, String idOkr, String description, String managerId, String startDate, String endDate, Double loadValue, Double progress) {
        this.id = id;
        this.idOkr = idOkr;
        this.description = description;
        this.managerId = managerId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.loadValue = loadValue;
        this.progress = progress;
    }

    public KREntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdOkr() {
        return idOkr;
    }

    public void setIdOkr(String idOkr) {
        this.idOkr = idOkr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
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
