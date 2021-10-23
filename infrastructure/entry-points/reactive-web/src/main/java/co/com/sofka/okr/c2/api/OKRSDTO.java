package co.com.sofka.okr.c2.api;

import co.com.sofka.okr.c2.model.okrs.KRS;

import java.util.List;

public class OKRSDTO {

    private String id;
    private String objective;
    private String title;
    private String managerId;
    private String description;
    private String areaInCharge;
    private Double progress = 100.0;
    private List<KRS> krs;

    public OKRSDTO(String id, String objective, String title, String managerId, String description, String areaInCharge, Double progress, List<KRS> krs) {
        this.id = id;
        this.objective = objective;
        this.title = title;
        this.managerId = managerId;
        this.description = description;
        this.areaInCharge = areaInCharge;
        this.progress = progress;
        this.krs = krs;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getObjective() {
        return objective;
    }

    public void setObjective(String objective) {
        this.objective = objective;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
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
