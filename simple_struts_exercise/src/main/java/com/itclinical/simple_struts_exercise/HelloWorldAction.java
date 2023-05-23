package com.itclinical.simple_struts_exercise;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial")
public class HelloWorldAction extends ActionSupport {
private String name;
public String getName() {
return name;
}
public void setName(String name) {
this.name = name;
}

/* public String saveUsername1() throws Exception {
    if(isNamePropertyNullOrEmpty()) {
    addActionError("Please enter your name! from saveusername1");
    return ActionSupport.INPUT;
    }
    return ActionSupport.SUCCESS;
    }
*/
public String saveUsername() throws Exception {
if(isNamePropertyNullOrEmpty()) {

addActionError(getText("error.enter.message"));
//addActionError("Please enter your name!");
return ActionSupport.INPUT;
}
return ActionSupport.SUCCESS;
}

protected boolean isNamePropertyNullOrEmpty() {
return name == null || name.isEmpty();
}



}