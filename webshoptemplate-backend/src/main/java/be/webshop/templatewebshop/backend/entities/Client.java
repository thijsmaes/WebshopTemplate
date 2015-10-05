package be.webshop.templatewebshop.backend.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by tmaes on 15/08/2015.
 */
@Entity
public class Client extends Person {
    private String id;

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
