package beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "Grade")
@Table(name = "GRADE")
public class GradeBean implements Bean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Reference obligatoire")
    @Column(name = "originality")
    private int originality;

    @NotNull(message = "Reference obligatoire")
    @Column(name = "quality")
    private int quality;

    @NotNull(message = "Reference obligatoire")
    @Column(name = "presentation")
    private int presentation;

    @NotNull(message = "Reference obligatoire")
    @Column(name = "taste")
    private int taste;

    @NotNull(message = "Reference obligatoire")
    @Column(name = "observation")
    private String observation;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private UserBean user;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private BurgerBean burger;

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public int getOriginality() {
        return originality;
    }

    public void setOriginality(int originality) {
        this.originality = originality;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public int getPresentation() {
        return presentation;
    }

    public void setPresentation(int presentation) {
        this.presentation = presentation;
    }

    public int getTaste() {
        return taste;
    }

    public void setTaste(int taste) {
        this.taste = taste;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public BurgerBean getBurger() {
        return burger;
    }

    public void setBurger(BurgerBean burger) {
        this.burger = burger;
    }

}
