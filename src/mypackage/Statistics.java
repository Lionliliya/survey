package mypackage;

import java.util.*;

/**
 * Created by lionliliya on 02.09.15.
 */
public class Statistics {
    public static Statistics analisys = new Statistics();

    public Statistics() {}

    public static Statistics getInstance() {
        return analisys;
    }

    private static List<String> name = new ArrayList<>();
    private static List<String> age = new ArrayList<>();
    private static List<String> gender = new ArrayList<>();
    private static List<String> expert = new ArrayList<>();
    private static Map<String, String> ageDependexpert = new HashMap<>();

    // соотношение опыта и возраста
    private static ArrayList<Integer> low_0 = new ArrayList<>();
    private static ArrayList<Integer> low_1_3 = new ArrayList<>();
    private static ArrayList<Integer> aver_3_5 = new ArrayList<>();
    private static ArrayList<Integer> high_5 = new ArrayList<>();


    public void addData(SurveyData answer) {
        name.add(answer.getName());
        age.add(answer.getAge());
        gender.add(answer.getGender());
        expert.add(answer.getExpert());
        ageDependexpert.put(answer.getExpert(), answer.getAge());
    }

    public int countElement() {
        return name.size();
    }

    public Map getInfo(List<String> data) {
        Set<String> uniquename = new HashSet<>(data);
        Map<String, Integer> result = new HashMap<>();

        for (String s : uniquename) {
            int n = Collections.frequency(data, s);
            result.put(s, n);
        }

        return result;
    }

    public Map<String, Integer> getNames() {
        return getInfo(name);
    }

    public Map<String, Integer> getAges() {
        return getInfo(age);
    }

    public Map<String, Integer> getGender() {
        return getInfo(gender);
    }

    public Map<String, Integer> getExpert() {
        return getInfo(expert);
    }

    public static int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }
    // метод для анализа соотношения возраста и опыта работы в сфере IT
    public Map<String, String> getDependence() {

        Map<String, String> depend = new HashMap<>();


        for (Map.Entry<String, String> s : ageDependexpert.entrySet()) {
            String value = s.getKey();
            if (value.equals("Нет опыта, или меньше года")) {
                low_0.add(Integer.valueOf(s.getValue()));
                int [] low_01 = convertIntegers(low_0);
                int max = low_01[0], min = low_01[0];

                for (int n = 0; n < low_01.length; n++) {

                    if (max <= low_01[n]) {
                        max = low_01[n];
                    }
                    if (min >= low_01[n]) {
                        min = low_01[n];
                    }
                }
                depend.put("Нет опыта, или меньше года", "возрастом от " + min + " лет до " + max + " лет");
            } else {
                if (value.equals("От 1 года до 3")) {
                    low_1_3.add(Integer.valueOf(s.getValue()));
                    int [] low_1_3_1=convertIntegers(low_1_3);
                    int max1 = low_1_3_1[0], min1 = low_1_3_1[0];
                    for (int n = 0; n < low_1_3_1.length; n++) {

                        if ( max1 <= low_1_3_1[n]) {
                            max1 = low_1_3_1[n];
                        }
                        if (min1 >= low_1_3_1[n]) {
                            min1 = low_1_3_1[n];
                        }
                    }
                    depend.put("Опыт от 1 года до 3", "возрастом от от " + min1 + " лет до " + max1 + " лет");
                } else {
                    if (value.equals("От 3 года до 5")) {
                        aver_3_5.add(Integer.valueOf(s.getValue()));
                        int [] aver_3_5_1 = convertIntegers(aver_3_5);
                        int max2 = aver_3_5_1[0], min2 = aver_3_5_1[0];
                        for (int n = 0; n < aver_3_5_1.length; n++) {

                            if (max2 <= aver_3_5_1[n]) {
                                max2 = aver_3_5_1[n];
                            }
                            if (aver_3_5_1[n] >= aver_3_5_1[n]) {
                                min2 = aver_3_5_1[n];
                            }
                        }
                        depend.put("Опыт 3 года до 5", "возрастом от от " + min2 + " лет до " + max2 + " лет");

                    } else {
                        if (value.equals("От 5 лет")) {
                            high_5.add(Integer.valueOf(s.getValue()));
                            int [] high_5_1 = convertIntegers(high_5);
                            int max3 = high_5_1[0], min3 = high_5_1[0];
                            for (int n = 0; n <high_5_1.length; n++) {

                                if (max3 <= high_5_1[n]) {
                                    max3 = high_5_1[n];
                                }
                                if (min3 >= high_5_1[n]) {
                                    min3 = high_5_1[n];
                                }
                            }
                            depend.put("Опыт 5 лет", "возрастом от от " + min3 + " лет до " + max3 + " лет");
                        }
                    }
                }
            }
        }

        return depend;
    }


}
