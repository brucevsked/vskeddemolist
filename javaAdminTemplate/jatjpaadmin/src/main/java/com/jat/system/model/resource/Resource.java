package com.jat.system.model.resource;

import com.jat.repository.model.ResourcePO;

public class Resource {
    private ResourceId id;
    private ResourceName name;
    private ResourceUrl url;
    private ResourceIcon icon;
    private ResourceType type;
    private ResourceSequence sequence;

    private Resource parent;

    public Resource(ResourceName name, ResourceUrl url, ResourceIcon icon, ResourceType type, ResourceSequence sequence, Resource parent) {
        this.name = name;
        this.url = url;
        this.icon = icon;
        this.type = type;
        this.sequence = sequence;
        this.parent = parent;
    }

    public Resource(ResourceId id, ResourceName name, ResourceUrl url, ResourceIcon icon, ResourceType type, ResourceSequence sequence) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.icon = icon;
        this.type = type;
        this.sequence = sequence;
    }

    public Resource(ResourceId id, ResourceName name, ResourceUrl url, ResourceIcon icon, ResourceType type, ResourceSequence sequence, Resource parent) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.icon = icon;
        this.type = type;
        this.sequence = sequence;
        this.parent = parent;
    }

    public ResourceId getId() {
        return id;
    }

    public ResourceName getName() {
        return name;
    }

    public ResourceUrl getUrl() {
        return url;
    }

    public ResourceIcon getIcon() {
        return icon;
    }

    public ResourceType getType() {
        return type;
    }

    public ResourceSequence getSequence() {
        return sequence;
    }

    public Resource getParent() {
        return parent;
    }

    public static Resource poToBo(ResourcePO po){
        if(po==null){
            return null;
        }
        ResourceId id=new ResourceId(po.getId());
        ResourceName name=new ResourceName(po.getName());
        ResourceUrl url=new ResourceUrl(po.getUrl());
        ResourceIcon ico=new ResourceIcon(po.getIcon());
        ResourceType type=new ResourceType(po.getType());
        ResourceSequence sequence=new ResourceSequence(po.getSequence());
        if(po.getParentId()!=null){
            Resource parentResource=poToBo(po.getParent());
            return new Resource(id,name,url,ico,type,sequence,parentResource);
        }else{
            return new Resource(id,name,url,ico,type,sequence);
        }

    }

    public ResourcePO boToPo(Integer isDel){
        if(this.getParent()!=null){
            ResourcePO parentResource=this.getParent().boToPo(isDel);
            Integer resourceId=null;
            if(this.getId()!=null){
                resourceId=this.getId().getId();
            }
            Integer parentId=null;
            if(parentResource!=null){
                parentId=parentResource.getId();
            }
            return new ResourcePO(resourceId,this.getName().getName(),this.getUrl().getUrl(),this.getIcon().getIcon(),this.getType().getType(),this.getSequence().getSequence(),parentId, isDel);
        }else{
            Integer resourceId=null;
            if(this.getId()!=null){
                resourceId=this.getId().getId();
            }
            return new ResourcePO(resourceId,this.getName().getName(),this.getUrl().getUrl(),this.getIcon().getIcon(),this.getType().getType(),this.getSequence().getSequence(),isDel);
        }
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name=" + name +
                ", url=" + url +
                ", icon=" + icon +
                ", type=" + type +
                ", sequence=" + sequence +
                ", parent=" + parent +
                '}';
    }
}
