package com.projects.problemStatement;

/**
 * 
 * @author aurovind.samal
 * Input: ar1[] = {-5, 3, 6, 12, 15}
        ar2[] = {-12, -10, -6, -3, 4, 10}
Output : The median is 3.
Explanation : The merged array is :
        ar3[] = {-12, -10, -6, -5 , -3,
                 3, 4, 6, 10, 12, 15},
       So the median of the merged array is 3

Input: ar1[] = {2, 3, 5, 8}
        ar2[] = {10, 12, 14, 16, 18, 20}
Output : The median is 11.
Explanation : The merged array is :
        ar3[] = {2, 3, 5, 8, 10, 12, 14, 16, 18, 20}
        if the number of the elements are even, 
        so there are two middle elements,
        take the average between the two :
        (10 + 12) / 2 = 11.
 *
 */
public class Median_of_two_sorted_arrays {
	
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
	    int total = nums1.length+nums2.length;
	    if(total%2==0){
	        return (getKth(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1, total/2) 
	              + getKth(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1, total/2-1))/2.0;
	    }else{
	        return getKth(nums1,0, nums1.length-1, nums2, 0, nums2.length-1, total/2);
	    }
	}
	
	//k is the index starting from 0
	private int getKth(int[] nums1, int i1, int j1, int[] nums2, int i2, int j2, int k){
	    if(j1<i1){
	        return nums2[i2+k];
	    }
	    if(j2<i2){
	        return nums1[i1+k];
	    }
	 
	    if(k==0){
	        return Math.min(nums1[i1], nums2[i2]);
	    }
	 
	    int len1 = j1 - i1 + 1;
	    int len2 = j2 - i2 + 1;
	 
	    int m1 = k*len1/(len1+len2);
	    int m2 = k - m1 - 1;
	 
	    m1 += i1;
	    m2 += i2;
	 
	    if(nums1[m1]<nums2[m2]){
	            k = k-(m1-i1+1);
	            j2 = m2;
	            i1 = m1+1;            
	    }else{
	            k = k-(m2-i2+1);
	            j1 = m1;
	            i2 = m2+1;
	    }
	    return getKth(nums1, i1, j1, nums2, i2, j2, k);
	}
	
	public static void main(String[] args) {
		Median_of_two_sorted_arrays ms = new Median_of_two_sorted_arrays();
		int arr1[] = {-5, 3, 6, 12, 15};
		int arr2[] = {-12, -10, -6, -3, 4, 10};
		double findMedianSortedArrays = ms.findMedianSortedArrays(arr1,arr2);
		System.out.println("The median is :"+findMedianSortedArrays);
		
		int ar1[] = {1, 12, 15, 26, 38};
        int ar2[] = {2, 13, 17, 30, 45};
        double findMedianUnSortedArrays = ms.findMedianSortedArrays(ar1,ar2);
		System.out.println("The median is :"+findMedianUnSortedArrays);
        
		
	}


}
