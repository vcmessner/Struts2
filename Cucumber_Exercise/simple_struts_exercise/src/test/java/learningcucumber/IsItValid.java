package learningcucumber;



class IsItValid {
    public static final String REGEX_ALPHA = "[a-zA-Z]+";
    public static final String REGEX_NUM ="[0-9]+";


    static String isNameValid(String name) {
        return name.matches(REGEX_ALPHA) ? "True" : "False";
    }

    static String isAgeValid(String age) {
        //return a.equals("") ? "False" : "True";
        return age.matches(REGEX_NUM) ? "True" : "False";
    }
}