package business;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Preconditions;

import beans.BurgerBean;
import beans.IngredientBean;
import dataAccess.DAOManager;

public class Burger implements Comparable<Burger> {

    private final BurgerBean burgerBean;

    public Burger(BurgerBean bean) {
        Preconditions.checkNotNull(bean, "BurgerBean");
        burgerBean = bean;
    }

    public Burger() {
        this(new BurgerBean());
    }

    public void save() {
        DAOManager.getInstance().saveBurger(burgerBean);
    }

    public boolean exists() {
        return burgerBean.getId() > 0l;
    }

    public List<Ingredient> getIngredients() {
        final List<Ingredient> list = new ArrayList<>();

        burgerBean.getIngredients().forEach(bean -> {
            list.add(new Ingredient(bean));
        });

        return list;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        final List<IngredientBean> list = new ArrayList<>();

        ingredients.forEach(ingredient -> {
            list.add(ingredient.getBean());
        });

        burgerBean.setIngredients(list);
    }

    public long getId() {
        return burgerBean.getId();
    }

    public void setId(long id) {
        burgerBean.setId(id);
    }

    public String getName() {
        return burgerBean.getName();
    }

    public void setName(String name) {
        burgerBean.setName(name);
    }

    public String getDescription() {
        return burgerBean.getDescription();
    }

    public void setDescription(String description) {
        burgerBean.setDescription(description);
    }

    public String getPicture() {
        return burgerBean.getPicture();
    }

    public void setPicture(String picture) {
        burgerBean.setPicture(picture);
    }

    public void addIngredient(IngredientBean i) {
        final List<IngredientBean> ingredients = burgerBean.getIngredients();
        ingredients.add(i);
        burgerBean.setIngredients(ingredients);
    }

    public void addGrade(Grade g) {
        burgerBean.addGrade(g.getBean());
    }

    public void removeGrade(Grade g) {
        burgerBean.removeGrade(g.getBean());
    }

    public BurgerBean getBean() {
        return burgerBean;
    }

    public Restaurant getRestaurant() {
        return new Restaurant(burgerBean.getRestaurant());
    }

    public List<Grade> getGrades() {
        final List<Grade> grades = new ArrayList<>();

        burgerBean.getGrades().forEach(bean -> {
            grades.add(new Grade(bean));
        });

        return grades;
    }

	@Override
	public int compareTo(Burger o) {
		
		List<Grade> listGrade1 = this.getGrades();
		List<Grade> listGrade2 = o.getGrades();
		
		int total1 = 0;
		int total2 = 0;
		
		for(Grade g : listGrade1){
			total1 += g.getOriginality();
			total1 += g.getPresentation();
			total1 += g.getQuality();
			total1 += g.getTaste();
		}
		
		total1 /= listGrade1.size();
		
		for(Grade g : listGrade2){
			total2 += g.getOriginality();
			total2 += g.getPresentation();
			total2 += g.getQuality();
			total2 += g.getTaste();
		}
		
		total2 /= listGrade2.size();
		
		return total2 - total1;
	}

}
