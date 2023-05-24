package com.itclinical.simple_struts_exercise;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial")
public class HelloWorldAction extends ActionSupport {
    private String name;
    private String age;

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

    private boolean saveAge() throws Exception {
        if(isAgePropertyInvalid()) {
            addActionError("Please enter a valid Age!");
            return false;
        }
        return true;
        }

    private boolean saveUsername() throws Exception {
    if(isNamePropertyInvalid()) {
        addActionError(getText("error.enter.message"));
        //addActionError("Please enter your name!");
        return false;        
    }
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