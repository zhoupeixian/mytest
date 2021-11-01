package com.example.demo.com.util;

import java.util.Random;
import java.util.Scanner;

public class Crud{
	//测试用例
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] x={45,78,25,6,2,1,34,57,46,45,47,4,31,100};
        x=sort(x);
        int index=count(x);
        do {
            String y=scanner.nextLine();
            if(y.isEmpty()){
                System.out.println("结束");
                break;
            }
            int z=rank(Integer.parseInt(y),x,index);
            if(z<0){
                System.out.println("不存在！");

            }else{
                System.out.println(z);
            }
        }while(true);
        scanner.close();
    }
    //复制数组,[)开区间
    public static int[] copy(int[] x,int start,int end) {
    	int[] m=new int[end-start];
    	for(int i=0;i<end-start;i++) {
  			m[i]=x[start++];
  		}
    	return m;
  	}
    //打印数组,[)开区间
    public static void print(int[] x,int start,int end) {
    	for(int i=start;i<end;i++) {
  			System.out.print(x[i]);
  		}
  	}
    //最大最小值
  	public static String max_min(int[] x) {
  		int max=x[0];
  		int min=x[0];
  		for(int i=0;i<x.length;i++) {
  			max=max<x[i]?x[i]:max;
  			min=min>x[i]?x[i]:min;
  		}
  		return Integer.valueOf(max).toString()+"&&"+Integer.valueOf(min).toString();
  	}
  	//中位数
  	public static int median(int[] x) {
  		int[] m=copy(x,0,x.length);
  		sort(m);
  		if(x.length%2==1) {
  			return m[x.length/2];
  		}else {
  			return (m[x.length/2-1]+m[x.length/2])/2;
  		}
  	}
  	//求第k小的数
  	public static int smk(int[] x,int k) {
  		int[] m=sort(x);
  		return m[k-1];
  	}
  	//求平方和
  	public static int sos(int[] x) {
  		int sum=0;
  		for(int i=0;i<x.length;i++){
  			sum+=x[i]*x[i];
  		}
  		return sum;
  	}
  	//求平均值
  	public static double avg(int[] x){
  		double sum=0;
  		for(int i=0;i<x.length;i++){
  			sum+=x[i];
  		}
  		return sum/x.length;
  	}
  	//打印出大于平均值的数的百分比
  	public static void av(int[] x){
  		double av=avg(x);
  		double m=0;
  		for(int i=0;i<x.length;i++){
  			m=x[i]>av?++m:m;
  		}
  		System.out.printf("%.2f",m/x.length*100);
  	}
  	//按顺序打印出两个有序数组的公共元素
  	public static void equel(int[] a,int[] b){
  		int x=0,y=0;
		String string="";
		while(x<a.length && y<b.length){
			if(a[x]==b[y]){
				string=string+a[x]+b[y];
				if (x<a.length-1 && a[x]==a[x+1]) {
					x++;
					string=string+a[x];
				}
				if(y<b.length-1 && b[y]==b[y+1]){
					y++;
					string=string+b[y];
				}
				x++;
				y++;
			}else if(a[x]<b[y]){
				x++;
			}else{
				y++;
			}
		}
		System.out.print(string);
	}
  	//数组随机排列
  	public static int[] random_sort(int[] x){
  		Random random=new Random();
  		for(int i=0;i<x.length;i++){
  			int j=random.nextInt(x.length);
  			int tmp=x[i];
  			x[i]=x[j];
  			x[j]=tmp;
  		}
   		return x;
  	}
  	//数组置换
  	public static int[] mystery(int[] x){
  	int N = x.length;
  	if(N <= 1){ return x ;}
  	for(int i=0;i<N/2;i++){
  		int m=x[i];
  		x[i]=x[N-1-i];
  		x[N-1-i]=m;
  	}
  	return x;
  	}
  //二分查找
    private static int rank(int y,int[] ds,int index ){
        for(int a=0,b=index;a<=b;){
            int c=a+(b-a)/2;
            if(y>ds[c]){
                a=c+1;
            }else if(y<ds[c]){
                b=c-1;
            }else{
            	//这里是考虑到如果ds中存在重复字符，则以下标最小的字符为准
            	if(c>=1) {
            		while (ds[c] == ds[c-1]) {
            			c--;
            			if(c==0) {
            				break;
            			}
            		}
            	}
            	return c;
            }
        }
        return -1;
    }
    //去重
    public static int count(int[] x) {
    	if(x.length==0) {System.out.println("结束");}
        int index=1;
        for(int i=1;i<x.length;i++) {
        	if(x[i]!=x[i-1]){
        		x[index++]=x[i];
        	}
        }
        return index;
    }
    //冒泡排序
    public static int[] sort(int[] x){
    		for(int i=0;i<x.length-1;i++){
    			for(int j=0;j<x.length-1;j++){
    				if(x[j]>x[j+1]){
    					int n=x[j+1];
    					x[j+1]=x[j];
    					x[j]=n;
    				}
    			}
    		}
    	return x;
    }
    //快速排序
    public static void cv(int[] x,int min0 ,int max0){
    	//查找范围，将随着循环不断缩小
    	int min=min0,max=max0;
    	//循环结束时默认值将处于对应位置，且左边的数姐皆小于它，右边的数皆大于它
    	while(max>min) {
    		//从默认值对面开始遍历，每次循环都会将大于默认值（这里是数组第一个数）的数放到默认值的左边
    		while(max>min){
    			if(x[max]<x[min]){
    				int n=x[min]; 
    				x[min]=x[max];
    				x[max]=n;
    				break;
    			}
    			max--;
    		}
    		//每次循环都会将小于默认值的数放到默认值的右边
    		while(min<max){
    			if(x[min]>x[max]){
    				int n=x[min]; 
    				x[min]=x[max];
    				x[max]=n;
    			}
    			min++;
    		}
    	}
    	//如果默认值左右两边的元素个数大于1就递归重复循环
    	if((min-1)>min0) {
    		cv(x,min0,min-1);
    	}
    	if((max+1)<max0) {
    		cv(x,max+1,max0);
    	}
    }
    //归并排序
    public static void merge_sort(int[] arr) {
        int len = arr.length;
        //辅助数组，存储排序后的数组对象
        int[] result = new int[len];
        // block=1:当每个块的长度为1时
        for(int block = 1; block < len*2; block *= 2) {
            for(int start = 0; start <len; start += 2 * block) {
                int low = start;
                int mid = (start + block) < len ? (start + block) : len;
                int high = (start + 2 * block) < len ? (start + 2 * block) : len;
                //[)右开区间，长度为block
                int start1 = low, end1 = mid;
                int start2 = mid, end2 = high;
                //依次对两个相邻的块进行归并排序
                while (start1 < end1 && start2 < end2) {
                	if(arr[start1]<arr[start2]) {
                		result[low++]=arr[start1++];
                	}else {
                		result[low++]=arr[start2++];
                	}
                }
                //如果其中一个块先排完
                while(start1 < end1) {
                	result[low++] = arr[start1++];
                }
                while(start2 < end2) {
                	result[low++] = arr[start2++];
                }
                
            }
            //声明第三个数组tem“存放”原arr对象
            int[] tem=arr;
            //arr指向原result对象
            arr=result;
            //result指向原arr对象，对象是引用传递的，所以arr和result不应同时指向同一个对象
            result=tem;
        }    
    }
}
