package com.itclinical.simple_struts_exercise;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial")
public class HelloWorldAction extends ActionSupport {
    private String name;
    private String age;
    public static final int LEGAL_AGE = 18;

    public HelloWorldAction(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public HelloWorldAction() {
        
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

    public boolean saveAge() throws Exception {
        if(isAgePropertyInvalid()) {
            addActionError("Please enter a valid Age!");
            return false;
        }
        int myage = Integer.parseInt(age);
        if(myage<LEGAL_AGE){
            addActionError("Minors are not allowed!");
            return false;
        }
        return true;
        
        }

    public boolean saveUsername() throws Exception {
        System.out.println("entrei1");
        if(isNamePropertyInvalid()) {
            addActionError("Invalid Name!");
            System.out.println("entrei2");
            return false;        
        }
        System.out.println("entrei3");
        return true;
        
        }

    public String SaveOnSubmit() throws Exception{
        if(saveAge() && saveUsername()){
            return ActionSupport.SUCCESS;
        }
        return ActionSupport.INPUT;
        
    }

    protected boolean isNamePropertyInvalid() {
        return name == null || name.isEmpty() || !isalpha(name);
    }

    protected boolean isAgePropertyInvalid() {
        return age == null || age.isEmpty() || !is_positive_num(age);
    }

    protected boolean isalpha(String s){
        return s.matches("[a-zA-Z]+");
    }

    protected boolean is_positive_num(String s){
        return s.matches("[0-9]+");
    }




}