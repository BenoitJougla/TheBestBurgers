package beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "User")
@Table(name = "USER")
public class UserBean implements Bean {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotNull(message = "Reference obligatoire")
    @Column(name = "name", unique = true)
    private String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private List<GradeBean> grades;

    public UserBean() {
        grades = new ArrayList<>();
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GradeBean> getGrades() {
        return grades;
    }

    public void setGrades(List<GradeBean> grades) {
        this.grades = grades;
    }

    public void addGrade(GradeBean grade) {
        grades.add(grade);
        grade.setUser(this);
    }

    public void removeGrade(GradeBean grade) {
        grades.remove(grade);
        grade.setUser(null);
    }

}
