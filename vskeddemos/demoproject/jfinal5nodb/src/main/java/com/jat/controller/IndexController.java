package com.jat.controller;

import com.jfinal.core.Controller;
import com.jfinal.core.Path;


@Path("/")
public class IndexController extends Controller {
    String version="this is index server05";

    public void index(){
        renderHtml(version);
    }

    public void ver(){
        renderHtml(version);
    }
}
