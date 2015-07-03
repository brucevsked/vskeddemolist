package com.vsked.test;

import java.util.Random;

public class BubbleSort {
	
	public static void main(String[] args) {
		int[] arr=initArray();
		outPutArray(arr);
		sort(arr);
		outPutArray(arr);

	}
	
	public static int[]  initArray(){
		int[] tmpAr=new int[10];
		Random r=new Random();
		for(int i=0;i<10;i++){
			tmpAr[i]=r.nextInt(100);
		}
		return tmpAr;
		
	}
    
	public static void outPutArray(int arr[]){
		for(int i=0;i<arr.length;i++)
			System.out.println(i+":"+arr[i]);
	}
	
	public static void sort(int arr[]){
		for(int i=0;i<arr.length-1;i++){
			for(int j=0;j<arr.length-i-1;j++){
				if(arr[j]>arr[j+1]){
					swap(arr,j,j+1);
				}
			}
		}
	}
	
	public static void swap(int arr[],int i,int j){
		int tmp=arr[i];
		arr[i]=arr[j];
		arr[j]=tmp;
	}
}
