package dto;

import java.io.Serializable;

public class Votos implements Serializable {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;

    @Override
    public String toString() {
        return "Votos{"
                + "id=" + id
                + '}';
    }
}
