package business;

import com.google.common.base.Preconditions;

import beans.GradeBean;

public class Grade {

	private final GradeBean gradeBean;

    public Grade(GradeBean bean) {
        Preconditions.checkNotNull(bean, "GradeBean");
        gradeBean = bean;
    }

    public Grade() {
        this(new GradeBean());
    }
	
    public long getId() {
        return gradeBean.getId();
    }

    public void setId(long id) {
        gradeBean.setId(id);
    }

    public int getOriginality() {
        return gradeBean.getOriginality();
    }

    public void setOriginality(int originality) {
        gradeBean.setOriginality(originality);
    }

    public int getQuality() {
        return gradeBean.getQuality();
    }

    public void setQuality(int quality) {
        gradeBean.setQuality(quality);
    }

    public int getPresentation() {
        return gradeBean.getPresentation();
    }

    public void setPresentation(int presentation) {
        gradeBean.setPresentation(presentation);
    }

    public int getTaste() {
        return gradeBean.getTaste();
    }

    public void setTaste(int taste) {
        gradeBean.setTaste(taste);
    }

    public String getObservation() {
        return gradeBean.getObservation();
    }

    public void setObservation(String observation) {
        gradeBean.setObservation(observation);
    }
    
    public GradeBean getBean(){
    	return gradeBean;
    }
}
