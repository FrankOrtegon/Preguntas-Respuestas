package co.com.sofka.okr.c2.mongo.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
public class UsuariosEntity {

    @Id
    private String id;
    private String name;
    private String email;
    private String urlPhoto;
    private String phone;

    public UsuariosEntity() {
    }

    public UsuariosEntity(String id, String name, String email, String urlPhoto, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.urlPhoto = urlPhoto;
        this.phone = phone;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
