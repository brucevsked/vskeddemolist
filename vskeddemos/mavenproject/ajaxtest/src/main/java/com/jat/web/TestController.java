package com.jat.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    private static final Logger log = LoggerFactory.getLogger(TestController.class);

    @GetMapping("/get1")
	public String get1(){
        log.trace("get1");
        return "{\"test\":\"no parameter get1\"}";
    }

    @GetMapping("/get2")
    public String get2(Long id,String name){
        log.trace("get2,id:[{}],name[{}]",id,name);
        return "id:["+id+"],name["+name+"]";
    }

    @GetMapping("/get3")
    public String get3(){
        log.trace("get3");
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "no parameter get3";
    }

    @GetMapping("/get4")
    public String get4(){
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.trace("get4");
        return "no parameter get4";
    }

    @GetMapping("/get5")
    public String get5(){
        log.trace("get5");
        return "no parameter get5";
    }

    @PostMapping("/post1")
    public String post1(){
        log.trace("post1");
        return "no parameter post1";
    }

    @PostMapping("/post2")
    public String post2(Long id,String name){
        log.trace("post2,id:[{}],name[{}]",id,name);
        return "id:["+id+"],name["+name+"]";
    }

    @PutMapping("/put1")
    public String put1(){
        log.trace("put1");
        return "no parameter put1";
    }

    @PutMapping("/put2")
    public String put2(Long id,String name){
        log.trace("put2,id:[{}],name[{}]",id,name);
        return "id:["+id+"],name["+name+"]";
    }

    @PatchMapping("/patch1")
    public String patch1(){
        log.trace("patch1");
        return "no parameter patch1";
    }

    @PatchMapping("/patch2")
    public String patch2(Long id,String name){
        log.trace("patch2,id:[{}],name[{}]",id,name);
        return "id:["+id+"],name["+name+"]";
    }

    @DeleteMapping("/delete1")
    public String delete1(){
        log.trace("delete1");
        return "no parameter delete1";
    }

    @DeleteMapping("/delete2")
    public String delete2(Long id,String name){
        log.trace("delete2,id:[{}],name[{}]",id,name);
        return "id:["+id+"],name["+name+"]";
    }

}
