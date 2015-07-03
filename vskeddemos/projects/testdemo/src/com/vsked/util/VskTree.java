package com.vsked.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class VskTree {
	List<VskNode> nList=new ArrayList<VskNode>();
		
	//to see the dtree or mztree
	public static void main(String[] args) {
		File f=new File("c:/");
		System.out.println(f.getParent()+"||"+f.getParentFile());
		
		//if the parent path is null now path is the disk
		
	}
	
	public void addNode(VskNode inNode){
		nList.add(inNode);		
	}
	
	public List<VskNode> getNodeListByParentNode(int pn){
		List<VskNode> rList=new ArrayList<VskNode>();
		for(VskNode vn:nList)
			if(pn==vn.parentNodeId)
				rList.add(vn);
		return rList;
	}
	
	public List<VskNode> getNodeListByNodeId(int nid){
		List<VskNode> rList=new ArrayList<VskNode>();
		for(VskNode vn:nList)
			if(nid==vn.nodeId)
				rList.add(vn);
		return rList;
	}
	
	public VskNode getNodeByNodeId(int nid){
		VskNode rvn=null;
		for(VskNode vn:nList)
			if(nid==vn.nodeId){
				rvn=vn;
				break;
			}
		return rvn;
	}
	
	public List<VskNode> getNodeListByNodeName(String inNodeName){
		List<VskNode> rList=new ArrayList<VskNode>();
		for(VskNode vn:nList)
			if(inNodeName.equals(vn.nodeName))
				rList.add(vn);
		return rList;
	}
	
	public VskNode getNodeByNodeName(String inNodeName){
		VskNode rvn=null;
		for(VskNode vn:nList)
			if(inNodeName.equals(vn.nodeName)){
				rvn=vn;
				break;
			}
		return rvn;
	}
	
	public boolean deleteNodeById(int nid){
		for(VskNode vn:nList)
			if(nid==vn.nodeId){
				nList.remove(vn);
				return true;
			}
		return false;
	}
	
	public boolean deleteNodeByParentNodeId(int pid){
		boolean flag=false;
		for(VskNode vn:nList)
			if(pid==vn.parentNodeId){
				nList.remove(vn);
				flag=true;
			}
		return flag;
	}
	
	public boolean deleteNode(VskNode ivn){
		boolean flag=false;
		for(VskNode vn:nList)
			if(ivn.nodeId==vn.nodeId && ivn.parentNodeId==vn.parentNodeId && ivn.nodeName.equals(vn.nodeName)){
				nList.remove(vn);
				flag=true;
			}
		return flag;
	}
	
	public boolean isExistsNodeName(String inNodeName){
		for(VskNode vn:nList)
			if(inNodeName.equals(vn.nodeName))
				return true;
		return false;
	}
	
	public boolean isExistsNodeId(int inNodeId){
		for(VskNode vn:nList)
			if(inNodeId==vn.nodeId)
				return true;
		return false;		
	}
	
	//TODO delete the loop replace express
	
}
