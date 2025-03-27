package com.jat.util;

import com.jat.admin.api.model.MenuView;
import com.jat.model.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.LinkedList;
import java.util.List;

public class MenuTool {

    private static final Logger log = LoggerFactory.getLogger(MenuTool.class);
    public static List<MenuView> resourceToMenu(List<Resource> resources){
        List<MenuView> topMenus=getChildrenData(null,resources);
        return topMenus;
    }

    public static List<MenuView> getTopMenu(List<Resource> resources){
        List<MenuView> menus=new LinkedList<>();

        for(Resource resource:resources){
            if(resource.getParentId()==null){
                menus.add(new MenuView(resource.getId(),resource.getIcon(),resource.getUrl(),resource.getName()));
            }
        }
        return menus;
    }

    public static List<MenuView> getChildrenData(Integer parentId,List<Resource> resources){
        List<MenuView> menus=new LinkedList<>();
        String url="";
        for(Resource resource:resources){
            if(resource.getParentId()==parentId){
                List<MenuView> childRenData=getChildrenData(resource.getId(),resources);
                MenuView mv=new MenuView(resource.getId(),resource.getIcon(),resource.getUrl(),resource.getName(),childRenData);
                if(mv.getSubs().size()==0){
                    mv.setSubs(null);
                }
                menus.add(mv);
            }
        }
        return menus;
    }

    public static boolean isExistChild(Integer parentId,List<Resource> resources){
        for(Resource resource:resources){
            if(parentId==resource.getParentId()){
                return true;
            }
        }
        return false;
    }


}
