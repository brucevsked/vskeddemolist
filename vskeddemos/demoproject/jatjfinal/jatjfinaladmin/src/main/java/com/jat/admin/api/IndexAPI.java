package com.jat.admin.api;

import com.jat.util.Response;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;

@Path("/")
public class IndexAPI extends Controller {

    private final String version="1.0.0";

    public void index(){
        renderJson(new Response(0,"成功,welcome to jat jfinal admin,version is:"+version)+"");
    }

    public void ver(){
        renderHtml(version);
    }

}
