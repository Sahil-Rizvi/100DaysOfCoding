package practice;

import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {


    public static void sortList(){
        List<String> l = Arrays.asList("infoedge", "naukri", "jeevansaathi");
        System.out.println(l);

        l.sort(Collections.reverseOrder(Comparator.comparingLong(String::length)));
        System.out.println(l);

        String str = "abbc";

        Arrays.stream(str.split(",")).forEach(System.out::println);

//        BigDecimal a = new BigDecimal("0.00000");
//        BigDecimal b = new BigDecimal(0000000);
//        System.out.println(a.compareTo(b)==0);
//        System.out.println(a.equals(b));
//        Set<String>inputPhrases = new HashSet<>();
//        inputPhrases.addAll(l);
//
//        System.out.println(l);
    }
    public static void main(String ...args){
//        System.out.println(SortOrder.MAP);
//        System.out.println(SearchFlag.BY_LABEL);
        //sortList();
        Pattern p =Pattern.compile("^ *not\\b");
        Matcher m = p.matcher("  not1".toLowerCase(Locale.ROOT));
        System.out.println(m.find());
    }
}

enum SortOrder {
    ASC("asc"),
    DESC("desc");

    public static final HashMap<String, SortOrder> MAP = new HashMap<String, SortOrder>();

    private String value;

    private SortOrder(String value) {
        this.value = value;
    }


    public static SortOrder getByName(String name) {
        return MAP.get(name);
    }

    static {
        for (SortOrder field : SortOrder.values()) {
            MAP.put(field.value, field);
        }
    }
}

enum SearchFlag {

    SIM_CV("simcv"), ORDERED_SEARCH("orderedSearch"), CS("cs"),
    BASIC("basic"), FULL_CV("fullcv"),
    ADV("adv"), HH("hh"), EZ("ez"),
    IT("it"), BOTH("both"), SAME("same"), SIMILAR("similar"),
    ROLE("role"), CVID("cvid"),
    HIRING_FOR("hiring_for");

    public final String label;

    public static final Map<String, SearchFlag> BY_LABEL = new HashMap<>();

    static {
        for(SearchFlag sf: values()){
            BY_LABEL.put(sf.label, sf);
        }
    }

    SearchFlag(String value) {
        this.label = value;
    }

//    @Override
//    public String toString() {
//        return this.value;
//    }

    public static SearchFlag valueOfLabel(String label){
        if(!BY_LABEL.containsKey(label)){
            return null;
            //throw new IllegalArgumentException("No SearchFlag enum for label: "+label);
        }
        return BY_LABEL.get(label);
    }

}
