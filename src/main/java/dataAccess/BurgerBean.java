package dataAccess;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "Burger")
@Table(name = "BUGER")
public class BurgerBean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull(message = "Reference obligatoire")
    @Column(name = "name")
    private String name;
    @NotNull(message = "Reference obligatoire")
    @Column(name = "description")
    private String description;
    @Column(name = "picture")
    private String picture;

    @OneToMany
    private List<IngredientBean> ingredients;

    @OneToMany
    private List<GradeBean> grades;

    public List<IngredientBean> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientBean> ingredients) {
        this.ingredients = ingredients;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

}
