package com.example.demo.com.util;

import java.util.Random;
import java.util.Scanner;

public class Crud{
	//��������
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int[] x={45,78,25,6,2,1,34,57,46,45,47,4,31,100};
        x=sort(x);
        int index=count(x);
        do {
            String y=scanner.nextLine();
            if(y.isEmpty()){
                System.out.println("����");
                break;
            }
            int z=rank(Integer.parseInt(y),x,index);
            if(z<0){
                System.out.println("�����ڣ�");

            }else{
                System.out.println(z);
            }
        }while(true);
        scanner.close();
    }
    //��������,[)������
    public static int[] copy(int[] x,int start,int end) {
    	int[] m=new int[end-start];
    	for(int i=0;i<end-start;i++) {
  			m[i]=x[start++];
  		}
    	return m;
  	}
    //��ӡ����,[)������
    public static void print(int[] x,int start,int end) {
    	for(int i=start;i<end;i++) {
  			System.out.print(x[i]);
  		}
  	}
    //�����Сֵ
  	public static String max_min(int[] x) {
  		int max=x[0];
  		int min=x[0];
  		for(int i=0;i<x.length;i++) {
  			max=max<x[i]?x[i]:max;
  			min=min>x[i]?x[i]:min;
  		}
  		return Integer.valueOf(max).toString()+"&&"+Integer.valueOf(min).toString();
  	}
  	//��λ��
  	public static int median(int[] x) {
  		int[] m=copy(x,0,x.length);
  		sort(m);
  		if(x.length%2==1) {
  			return m[x.length/2];
  		}else {
  			return (m[x.length/2-1]+m[x.length/2])/2;
  		}
  	}
  	//���kС����
  	public static int smk(int[] x,int k) {
  		int[] m=sort(x);
  		return m[k-1];
  	}
  	//��ƽ����
  	public static int sos(int[] x) {
  		int sum=0;
  		for(int i=0;i<x.length;i++){
  			sum+=x[i]*x[i];
  		}
  		return sum;
  	}
  	//��ƽ��ֵ
  	public static double avg(int[] x){
  		double sum=0;
  		for(int i=0;i<x.length;i++){
  			sum+=x[i];
  		}
  		return sum/x.length;
  	}
  	//��ӡ������ƽ��ֵ�����İٷֱ�
  	public static void av(int[] x){
  		double av=avg(x);
  		double m=0;
  		for(int i=0;i<x.length;i++){
  			m=x[i]>av?++m:m;
  		}
  		System.out.printf("%.2f",m/x.length*100);
  	}
  	//��˳���ӡ��������������Ĺ���Ԫ��
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
  	//�����������
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
  	//�����û�
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
  //���ֲ���
    private static int rank(int y,int[] ds,int index ){
        for(int a=0,b=index;a<=b;){
            int c=a+(b-a)/2;
            if(y>ds[c]){
                a=c+1;
            }else if(y<ds[c]){
                b=c-1;
            }else{
            	//�����ǿ��ǵ����ds�д����ظ��ַ��������±���С���ַ�Ϊ׼
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
    //ȥ��
    public static int count(int[] x) {
    	if(x.length==0) {System.out.println("����");}
        int index=1;
        for(int i=1;i<x.length;i++) {
        	if(x[i]!=x[i-1]){
        		x[index++]=x[i];
        	}
        }
        return index;
    }
    //ð������
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
    //��������
    public static void cv(int[] x,int min0 ,int max0){
    	//���ҷ�Χ��������ѭ��������С
    	int min=min0,max=max0;
    	//ѭ������ʱĬ��ֵ�����ڶ�Ӧλ�ã�����ߵ������С�������ұߵ����Դ�����
    	while(max>min) {
    		//��Ĭ��ֵ���濪ʼ������ÿ��ѭ�����Ὣ����Ĭ��ֵ�������������һ�����������ŵ�Ĭ��ֵ�����
    		while(max>min){
    			if(x[max]<x[min]){
    				int n=x[min]; 
    				x[min]=x[max];
    				x[max]=n;
    				break;
    			}
    			max--;
    		}
    		//ÿ��ѭ�����ὫС��Ĭ��ֵ�����ŵ�Ĭ��ֵ���ұ�
    		while(min<max){
    			if(x[min]>x[max]){
    				int n=x[min]; 
    				x[min]=x[max];
    				x[max]=n;
    			}
    			min++;
    		}
    	}
    	//���Ĭ��ֵ�������ߵ�Ԫ�ظ�������1�͵ݹ��ظ�ѭ��
    	if((min-1)>min0) {
    		cv(x,min0,min-1);
    	}
    	if((max+1)<max0) {
    		cv(x,max+1,max0);
    	}
    }
    //�鲢����
    public static void merge_sort(int[] arr) {
        int len = arr.length;
        //�������飬�洢�������������
        int[] result = new int[len];
        // block=1:��ÿ����ĳ���Ϊ1ʱ
        for(int block = 1; block < len*2; block *= 2) {
            for(int start = 0; start <len; start += 2 * block) {
                int low = start;
                int mid = (start + block) < len ? (start + block) : len;
                int high = (start + 2 * block) < len ? (start + 2 * block) : len;
                //[)�ҿ����䣬����Ϊblock
                int start1 = low, end1 = mid;
                int start2 = mid, end2 = high;
                //���ζ��������ڵĿ���й鲢����
                while (start1 < end1 && start2 < end2) {
                	if(arr[start1]<arr[start2]) {
                		result[low++]=arr[start1++];
                	}else {
                		result[low++]=arr[start2++];
                	}
                }
                //�������һ����������
                while(start1 < end1) {
                	result[low++] = arr[start1++];
                }
                while(start2 < end2) {
                	result[low++] = arr[start2++];
                }
                
            }
            //��������������tem����š�ԭarr����
            int[] tem=arr;
            //arrָ��ԭresult����
            arr=result;
            //resultָ��ԭarr���󣬶��������ô��ݵģ�����arr��result��Ӧͬʱָ��ͬһ������
            result=tem;
        }    
    }
}
