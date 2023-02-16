package student_management.entities;

public class Result {
    private int rId;
    private float percentage;
    private String grade;
    private int sId;

    public Result(){}

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getrId() {
        return rId;
    }

    public void setrId(int rId) {
        this.rId = rId;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    @Override
    public String toString() {
        return "Result{" +
                "percentage=" + percentage +
                ", grade='" + grade + '\'' +
                '}';
    }
}
