package com.vsked.facelets;

import  javax.faces.bean.ManagedBean;
import  javax.faces.bean.SessionScoped;

@ManagedBean(name="hello")
@SessionScoped
public  class  HelloWorld  implements  java.io.Serializable{
	private static final long serialVersionUID = 2195643876314974921L;
	private  String  name;
    public  String  getName()  {
        this.name  =  " vsked world is here yeah now u has see me";
        return  name;
    }
}
