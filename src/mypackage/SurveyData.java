package mypackage;

/**
 * Created by lionliliya on 02.09.15.
 */
public class SurveyData {
    private String name;
    private String age;
    private String gender;
    private String expert;

    public SurveyData(String name, String age, String gender, String expert) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.expert = expert;
    }

    public SurveyData() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getExpert() {
        return expert;
    }

    public void setExpert(String expert) {
        this.expert = expert;
    }
}
