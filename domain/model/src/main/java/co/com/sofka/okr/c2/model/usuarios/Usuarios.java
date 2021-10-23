package co.com.sofka.okr.c2.model.usuarios;
import co.com.sofka.okr.c2.model.values.Email;
import co.com.sofka.okr.c2.model.values.IdUser;
import co.com.sofka.okr.c2.model.values.Name;
import co.com.sofka.okr.c2.model.values.Phone;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Usuarios {
    private IdUser id;
    private Name name;
    private Email email;
    private String urlPhoto;
    private Phone phone;

    public Usuarios() {
    }

    public Usuarios(IdUser id, Name name, Email email, String urlPhoto, Phone phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.urlPhoto = urlPhoto;
        this.phone = phone;
    }

    public IdUser getId() {
        return id;
    }

    public void setId(IdUser id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public String getUrlPhoto() {
        return urlPhoto;
    }

    public void setUrlPhoto(String urlPhoto) {
        this.urlPhoto = urlPhoto;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }
}
