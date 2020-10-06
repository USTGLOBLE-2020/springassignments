package com.Assignment1.Day1;

public class RmDupElements {

	public static int rmDupEle(int arrList[], int numOfElements) {
		/*
		 if the number of elements is 0 or 1,
		 then return the number of elements.
		 */
		if(numOfElements == 0 || numOfElements == 1) {
			return numOfElements;
		}
		
		/*
			Create a temporary integer array named "tempArrList" to assign the number of elements as "int[numberOfElements]"
		 */
		int[] tempArrList = new int[numOfElements];
		/*
		 j as supporting integer variable 
		 */
		int j = 0;
		/*
		 Iterate the loop by comparing the first and second elements are equal or not!
		 If they are not equal, assign the first element in temporary array list of supporting integer variable
		 */
		for(int i = 0 ; i < numOfElements-1 ; i++) {
			
			if(arrList[i] != arrList[i+1]) {
				tempArrList[j++] = arrList[i];
			}
		}
		tempArrList[j++] = arrList[numOfElements-1];

		for(int i = 0; i<j;i++) {
			arrList[i] = tempArrList[i];
		}
		return j;
	}
	
	public static void main(String[] args) {
		int arrElements[] = {
				12, 25, 25, 13, 13, 40, 50, 50
		};
		int length = arrElements.length;
		length = rmDupEle(arrElements, length);
		
		for(int i = 0; i < length; i++) {
			System.out.println(arrElements[i]+" ");
		}
		
	}
}