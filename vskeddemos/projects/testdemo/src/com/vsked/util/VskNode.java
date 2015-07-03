package com.vsked.util;

public class VskNode {
	public int nodeId;
	public int parentNodeId;
	public String nodeName;
	
	public VskNode(int inNodeId,int inParentNodeId,String inNodename){
		nodeId=inNodeId;
		parentNodeId=inParentNodeId;
		nodeName=inNodename;
	}

}
