package com.vsked.demo11;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Table(name = "action1")
@Entity
@SQLDelete(sql = "update action1 set deleted=1 where id=?") //删除语句变为更新语句
@FilterDef(name = "deletedFilter", parameters = @ParamDef(name = "isDeleted", type = "Boolean"))//定义一个过滤器
@Filter(name = "deletedFilter", condition = "deleted = :isDeleted")//过滤器参数设置
public class ActionPO implements Serializable {

    @Transient//此字段不需要持久化到数据库
    private static final long serialVersionUID = -4568390758215072293L;

    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy = "action",orphanRemoval=true,cascade = CascadeType.ALL)
    private List<ActionParameterPO> actionParameters=new LinkedList<>();

    private Boolean deleted=false;

    public ActionPO() {
    }

    public void addParameterForQuery(ParameterPO parameterPO){
        ActionParameterPO acp=new ActionParameterPO(parameterPO);
        actionParameters.add(acp);
    }

    public void addParameter(ParameterPO parameterPO,Long actionParameterId){
        ActionParameterPO acp=new ActionParameterPO(actionParameterId,this,parameterPO);
        actionParameters.add(acp);
    }

    public void removeParameter(Long parameterId){
        Iterator<ActionParameterPO> acpIt=actionParameters.iterator();
        List<ActionParameterPO> actionParametersAdds=new LinkedList<>();
        while(acpIt.hasNext()){
            ActionParameterPO acp=acpIt.next();
            ParameterPO tmpParameter=acp.getParameter();
            if(tmpParameter.getId().longValue()==parameterId){
                tmpParameter.setDeleted(new Boolean(true));
                ActionParameterPO acpTemp=new ActionParameterPO(acp.getId(),this,tmpParameter);
                acpTemp.setDeleted(new Boolean(true));
                actionParametersAdds.add(acpTemp);
                acpIt.remove();
            }
        }

        for(ActionParameterPO ap:actionParametersAdds){
            actionParameters.add(ap);
        }
        actionParametersAdds.clear();
    }

    public void restoreParameter(Long parameterId){
        Iterator<ActionParameterPO> acpIt=actionParameters.iterator();
        List<ActionParameterPO> actionParametersAdds=new LinkedList<>();
        while(acpIt.hasNext()){
            ActionParameterPO acp=acpIt.next();
            ParameterPO tmpParameter=acp.getParameter();
            if(tmpParameter.getId().longValue()==parameterId){
                tmpParameter.setDeleted(new Boolean(false));
                ActionParameterPO acpTemp=new ActionParameterPO(acp.getId(),this,tmpParameter);
                acpTemp.setDeleted(new Boolean(false));
                actionParametersAdds.add(acpTemp);
                acpIt.remove();
            }
        }

        for(ActionParameterPO ap:actionParametersAdds){
            actionParameters.add(ap);
        }
        actionParametersAdds.clear();
    }

    public void removeAllParameter(){
        Iterator<ActionParameterPO> acpIt=actionParameters.iterator();
        List<ActionParameterPO> actionParametersAdds=new LinkedList<>();
        while(acpIt.hasNext()){
            ActionParameterPO acp=acpIt.next();
            ParameterPO tmpParameter=acp.getParameter();
            tmpParameter.setDeleted(new Boolean(true));
            ActionParameterPO acpTemp=new ActionParameterPO(acp.getId(),this,tmpParameter);
            acpTemp.setDeleted(new Boolean(true));
            actionParametersAdds.add(acpTemp);
            acpIt.remove();
        }

        for(ActionParameterPO ap:actionParametersAdds){
            actionParameters.add(ap);
        }
        actionParametersAdds.clear();
    }

    public void restoreAllParameter(){
        Iterator<ActionParameterPO> acpIt=actionParameters.iterator();
        List<ActionParameterPO> actionParametersAdds=new LinkedList<>();
        while(acpIt.hasNext()){
            ActionParameterPO acp=acpIt.next();
            ParameterPO tmpParameter=acp.getParameter();
            tmpParameter.setDeleted(new Boolean(false));
            ActionParameterPO acpTemp=new ActionParameterPO(acp.getId(),this,tmpParameter);
            acpTemp.setDeleted(new Boolean(false));
            actionParametersAdds.add(acpTemp);
            acpIt.remove();
        }

        for(ActionParameterPO ap:actionParametersAdds){
            actionParameters.add(ap);
        }
        actionParametersAdds.clear();
    }

    public ActionPO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public ActionPO(Long id, String name,List<ActionParameterPO> actionParameters) {
        this.id = id;
        this.name = name;
        this.actionParameters = actionParameters;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public List<ActionParameterPO> getActionParameters() {
        return actionParameters;
    }

    public void setActionParameters(List<ActionParameterPO> actionParameters) {
        this.actionParameters = actionParameters;
    }


    @Override
    public String toString() {
        return "ActionPO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", actionParameters=" + actionParameters +
                '}';
    }
}
