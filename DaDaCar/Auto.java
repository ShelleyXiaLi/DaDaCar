/*�������һ������̨�汾�Ĵ���⳵ϵͳ���Ժ���Կ������ɰ�׿������ҳ��
 *   1.չʾ���п��⳵��(�ݶ�Ϊ5̨)���б����£�
 *   2.ѡ���͡��⳵�������⳵ʱ�䣻
 *   3.չʾ�⳵�嵥���������ܽ����ػ����ͳ��ͣ����ؿ����ͳ��͡�
 *   
 *   ����                           ����              �ػ���         �ؿ���        �����   
 * 1 Truck         ���                 5       0      500
 * 2 HeavyTruck    ������             30      0      1000
 * 3 Bus           ����                 0       50     400
 * 4 Car           ����                 0       5      100
 * 5 Pickup        ̹;                 2       2      200
 * 
 * 2018.3.19
 * ˼·�� 1. ���Ƚ�� ����ȡ�������롱�����⣬ʹ��import java.util.Scanner����   
 *      2. ����Ϊһ�����࣬ӵ�м۸��������������   
 *       2.1 ���Σ�  
 *       2.2 �����ࣿ  ��Ϊû���ض��ķ��������Բ�ʹ���ó����࣬ʹ�ýӿ�ʵ��
 *       2.3 ���ؿ������ػ������ɽӿڣ�����ֻҪʵ������Ҫ�ĽӿھͿ����ˡ�
 *      3. չʾ�������������������飬�������鼴�ɣ��ֱ����
 *       3.1 ѡ���;��൱�ڸ����˾��������������ֱ����ȡԪ�������
 *       3.2 ����1����¼�ؿ���������2����¼�ػ�����
 *      4.��ҳ�棬��Ҫ��һ����ӭ���棬������⳵����ͼ�����û���⳵������˳���
 *      5.���ͣ��⳵�������⳵ʱ�䣬������Scanner���߻�ȡֵ����Ӧ�����
 *      
 *      6.���̣��򿪻�ӭҳ���Ƿ��⳵�� ��  �⳵�밴1  ��  �����б�    ��  ѡ����   ��  ѡ���⳵ʱ��   �� չʾ�⳵�嵥 
 *                           ��  �˳��밴0            ��  �˳��밴0
 */ 
package com.DaDaCar;
 
import java.util.Scanner;   //��ȡ��������
import java.util.ArrayList;

public class Auto {   
    static String name;
    static int   price;
    static int carryPeopleNum;
    static int carryGoodsNum;
    @SuppressWarnings("resource")
	public static void main(String[] args) {
    	
    	System.out.println("��ӭ���ٴ���⳵��");
    	Scanner input1=new Scanner(System.in);
    	System.out.print("�⳵�밴1���˳��밴0��");   //println�����Ϣ��ỻ�У���print����
    	
    	int choice1 =input1.nextInt();
        if(choice1==1) {
        	System.out.println("��ѡ����Ҫ��ĳ����������밴0��");
           /*2018.3.19
            *��������ʵ�˻�ӭҳ�棬������Ӧ���복���б���Ϣ�����ʵ����
            * ˼·�����ȴ������࣬��������Ӧ���͵����࣬�ֱ�ʵ������������Ӧ��ֵ��
            *      ͬʱ���ؿ������ػ������ɽӿڣ���ͬ������ʵ�ֲ�ͬ�Ľӿڡ�
            *      �Ѳ�ͬ��ֵ�洢����Ӧ�������У�����name��price���ؿ������ػ�����ͨ�������������Ԫ�ػ�ȡ���ݡ�
            *��������Ӧ����һ����������ҳ�档 
            *
            *2018.3.20
            *��ϰһ����������ݺ��ٻ�����д
            *˼·��ר�Ŷ���һ����������AutoInf���������public�ģ�Ȼ���������е���
        	*  ��ε��������е�Ԫ�أ�   ʹ��   ������[����ֵ]��
        	*  �𣺱�������Ϊ��̬���飬ʹ�� ����+�������ķ�ʽ���ʣ�����  AutoInf.carrygoods[i] 
        	*/
        	
        	//˼������������������г��������븴���Ժܲ����ʹ�ñ����������������������˴���ĸ�����
        	//�ع˱��������֪ʶ��  while����  ����һ�����뼴����ʾ���г��������
        	int i=0;
        	System.out.println("�������\t"+"��������\t"+"�ػ���/��\t"+"�ؿ���/��\t"+"�����/Ԫ\t");
        	while (i < 5) {
        		System.out.println(
        				(i+1)+
        				"\t"+AutoInf.name[i]+
        				"\t"+AutoInf.carrygoods[i]+
        				"\t"+AutoInf.carrypeople[i]+
        				"\t"+AutoInf.price[i]);
                   i++;
        	       }
        	//�������ʹ��ת�����ʹ��ʽ����   ���ʵ�֣�\t �Ʊ��
        	
        	
        	//����˳����б���ٴλ�ȡ�������룬�Ի�ó�����ѡ����Ϣ��
        	
        	/*2018.3.20
            *˼������ôһ��ѡ��������أ�
        	*
            *����һ����̬����Ĺ��ܣ�ArrayList���û���������⳵��ֵ����������
            *ArrayList�ǿ��Զ�̬�ı��С�ġ�
            *����list
                                    �﷨��ʽ��
            ArrayList<int[]> list = new ArrayList<int[]>(); 
            ArrayList<Integer> list = new ArrayList<Integer>();//��һ�ֿ���
            *��ô��ʲôʱ��ʹ��Array�����飩��ʲôʱ��ʹ��ArrayList?
            *�𰸣������ǲ�֪�������ж��ٸ�����Ԫ�ص�ʱ�򣬾Ϳ�ʹ��ArrayList��
            *���֪�����ݼ����ж��ٸ�Ԫ�أ��������顣
        	
        	*ʹ��ArrayList�ô���
        	*ͬʱ���Եõ����鳤�ȣ�Ҳ����һ���⼸����
        	*������ѭ����Ȼ��������һ���ض��ķ������������룬�ü����������������֡�
        	*����Ҫ�涨һ���ض�ֵ���û��������ֵ��ʾ�������������0��
        	*�û��������ֵ��һ������������һ��������¼�������ֵ
        	*
        	*ΪʲôArrayList���ܷ�int���ͣ�
        	*Integer��int�İ�װ��(wrapper)���Ƕ���
             int�ǻ�����������
                                      �ھ�����ڴ������
                                      �����Ƿ��ڶ���ģ��������������Ƿ���ջ���
             JAVA�ļ���ֻ�ܷ���������
             https://zhidao.baidu.com/question/380197738.html
             http://blog.csdn.net/huanghanqian/article/details/73920439
        	*/
        	
        	ArrayList<Integer> list = new ArrayList<Integer>();
        	
        	Scanner input2=new Scanner(System.in);
        	int chooseCar1 =input2.nextInt();
        	int temCarNum = 0;   //�������temCarNum���ڴ����Ѿ�ѡ��ĳ�����
        	if(chooseCar1==0) {  
        		System.out.println("��ӭ�´ι��٣���ѡ�����׶��˳�");  
        		//����Ƿ���յ�0�����˳���Ϣ��������յ���ֱ�Ӳ�����ѭ��
        	}else{  
        		//ʹ��||�ж�Ϊture��ֱ�ӷ��أ�����ÿ�ζ��ж����Ρ�
        		while(chooseCar1<0 || chooseCar1>=6) {
            	System.out.println("�޶�Ӧ���ͣ����������룡");
            	Scanner input3=new Scanner(System.in);
        	    int reselectCar =input3.nextInt();
        	    chooseCar1= reselectCar;
        	   //�Ƚ���һ���жϣ��������1-5֮�ڣ�Ҫ���������룬��1-5֮�ں󣬼�������
        		}
        		
        	    while(chooseCar1>0 && chooseCar1<=5) {  
        		    list.add(chooseCar1);
        		    System.out.println("��ѡ����"+chooseCar1+"�ų�"+AutoInf.name[chooseCar1-1]+"��");
        		    System.out.println("����ѡ����������ţ�ѡ����ϰ�0�˳�");
        		
                 Scanner input4=new Scanner(System.in);
        	     int chooseCar2 =input4.nextInt();
        	     chooseCar1= chooseCar2;
        	     temCarNum++;
        	   if(temCarNum==5) {
       	    	  System.out.println("��ѡ�������Ѵ����ޣ�");
       	    	  break;    //�������һ�������������Ѿ�ѡ��ĳ�����������5ʱ������ѭ����ʹ��ѡ������������5
       	          }
        	     continue;
        	     } 
        		}
             /*2018.3.23
              * �����޸��˳���ѡ�񲿷����������ƣ��������������
              * ����һ�����������ظ�����������û�м���
              * �����������Ȼ��Ƚϣ�
               
               2018.3.22
               *�����������Ҫ���ڲ���ʶ���������Ѿ���ѡ���ˣ���ѡ��ĳ��Ƿ�Ӧ�ò����ټ���ѡ�� 
           	   *���ܿ���ʹ������������ų���
           	   *������ֻ���ų����ϴ�ѡ��ͱ���ѡ��ͬ�������
           	   *����ѡ���͵�����������䶼�������⡣��Ҫ��д��
           	   */	
        	int carNum = list.size();//��ȡ������
        	System.out.println("������ѡ����"+carNum+"������");
        	
        	
        	/*while(chooseCar1>0 && chooseCar1<6) {
        	
        	System.out.println("��ѡ����"+chooseCar1+"�ų���"+"");
        	    list.add(chooseCar1);   // ����Ԫ�ص�list������
        	    int carNum = list.size();//��ȡ������
          	    System.out.println("������ѡ����"+carNum+"������" );
        	}
        	System.out.println("����������");
        	*/
       	    //  list.add(chooseCar2);
        	
        	//System.out.println(list[]);
            
        	
        	/*2018.3.21
             * 
             * ����ʹ��ArrayList��̬���飬��Ϊ��̬���鲻�ܹ����ܻ�������int
        	 * �ı�˼·
        	 * http://blog.csdn.net/sum_tw/article/details/57158986
        	 * ˼·�����������������Сʱ�������ⴴ��һ������Ҫ�����飬����ǰ���Ǹ�����������м��ɡ�
        	 *����Ҫ�½�һ������Ϊ1�����飬����һ����������¼�������ֵ�ĸ�����
        	      ����������ճ�Ϊ��Ҫ������ĳ��ȡ�
        	      ���ߣ�ֱ��û�г�ʼ���飬ͨ����ȡ��������ݵĸ���ȷ����Ҫ�����鳤�ȣ�
        	      ��Ϊ�����Ҫ�û���������һ��Ԥ���⳵���������൱�ڶ�һ������
        	      ����ֱ��ͨ���û�����ĳ�����Ż�����鳤�ȡ�	
        	 *
        	 *
        	 * int carlist[]=new int[5];
        	Scanner input2 = new Scanner(System.in);
        	for(int m=0;m<5;m++)
        	{
        	carlist[m] = input2.nextInt();
        	}*/
        	//�������ֵ�����
            
        	/*Scanner input2=new Scanner(System.in);
        	int chooseCar1 =input2.nextInt();
        	
        	Scanner input3=new Scanner(System.in);
        	int chooseCar2 =input3.nextInt();
        	 * 
        	 * if(chooseCar1==1) {
            	System.out.println("��ѡ����"+Truck.name);
            	//�����е��������������ʵ�֣�
         	   //��Ӧ����  ������.������   ������  ������.������    
            	//���������������  �ľ�̬���� Truck.name
            }
            if(chooseCar2==2) {
            	System.out.println("��ѡ����"+HeavyTruck.name);
            }
        	*/
           //��������ݿ���ֱ���޸�Ϊ������͡��۸��ؿ������ػ���
       	   //Ҳ��Ҫ���һ���⳵�����ļ��̻�ȡ�ӿ�
              System.out.print("��ѡ���⳵ʱ��:");
                //2018.3.20
                //Ϊ�˴���Ľ�׳��
            	//����Ӧ�ü�һ��if�������ж��������ֵ�Ƿ����
            	//ʹ��if���Ļ����ж�һ�ξͲ���������������ˣ����Կ���ʹ��while���
            	
            	Scanner input4=new Scanner(System.in);
            	int days1 =input4.nextInt();
            	
            	while(days1<=0){
            		System.out.println("��������⳵ʱ����������������!");
            	    Scanner input5=new Scanner(System.in);
            	      int days2 =input5.nextInt();
            	      days1= days2;
            	      
            	      }   
            	System.out.println("��ѡ������"+days1+"��");
                //System.out.println("arraylist����Ϊ"+list.size());
            	
            	//��������while����������⳵ʱ�������ж�,Ϊʲô��ʹ��do...while��
            	//��Ϊdo..while����ִ��һ�κ��ٽ����жϣ�����û�������������ݲ��Ϲ淶���ͻ����
              
                
                int totalCarryGoods = 0;
              //����һ������totalCarryGoods����¼���еĳ������ػ���
                for ( int n = 0; n <list.size(); n++){
            	 //System.out.println("�����Ϊ"+list.get(n)+AutoInf.name[list.get(n)-1]);
            	 
                  //System.out.println("�����õĳ��ػ���Ϊ��"+AutoInf.carrygoods[list.get(n)-1]);
            		  //��һ����������������������ػ���
            		totalCarryGoods += AutoInf.carrygoods[list.get(n)-1];
            	}
            	System.out.println("����ѡ���������ػ���Ϊ��"+totalCarryGoods+"�֣�");
            	
            	  //ͬ���ķ���������һ������totalCarryPeople����¼���г������ػ���
            	int totalCarryPeople = 0;
            	for ( int n = 0; n <list.size(); n++){
          		  //System.out.println("�����Ϊ"+list.get(n)+AutoInf.name[list.get(n)-1]);
          	 
                  //System.out.println("�����õĳ��ػ���Ϊ��"+AutoInf.carrygoods[list.get(n)-1]);
          		  //��һ���������������ѡ���ĵ����ؿ���
          		totalCarryPeople += AutoInf.carrypeople[list.get(n)-1];
          	   }
          	   System.out.println("����ѡ���������ؿ���Ϊ��"+totalCarryPeople+"�ˣ�");
            	
          	   
          	   //ͬ����˼·������һ������totalMoney����¼���еĳ������ؿ���	  
          	    int eachDayMoney = 0;
         	  for ( int n = 0; n <list.size(); n++){
       		  //System.out.println("�����Ϊ"+list.get(n)+AutoInf.name[list.get(n)-1]);
       	       //2018.3.23
         	  //˼�������ȷ����Ӧ�ĳ�����������Ȼ��ȷ�����ǵļ۸�
              //����ܹ���ѡ�Ļ�������һ�������������ܸ�ѡ����ôֻ��Ҫ��ȡ������Ŷ�Ӧ�ļ۸���Ӽ��ɣ�
       		  //���Ի��߲����Ը�ѡ�����Ƕ����ռ������ؿ͡��ػ�����˼·�Ϳ��ԣ�����۸�����������ɵõ�
         		 eachDayMoney += AutoInf.price[list.get(n)-1];
       	   }
       	   System.out.println("����ѡ�����������Ϊ��"+eachDayMoney*days1+"Ԫ��");
            	
            	
            	//�����ȡArrayList����洢�����ݣ���Ϊ�����Ĵ��롣
            	//list.get(n)��ȡ���Ƕ�Ӧ�ĳ��ı�ţ�ֱ�Ӵ���Autoinf��Ӧ�������е�ȡԪ�ؼ��ɡ�
            	
            	
                //�������Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 5
            	//at com.DaDaCar.Auto.main(Auto.java:231)
            	//��˼�Ǵ�����ʾ����˼������Խ�磬
            	//�ٸ����ӣ��㽨�˸�����int [] a = new int[4],
            	//	����ĳ�����4���ֱ�Ϊa[0]��a[3]����a.length=4,
            	//���Ե���i<=a.length�ͻ�ȡ��4���ֵ����a[4]��Ȼ�����㽨�����鷶Χ֮�ڣ�������ʾ����Խ�硣
            	//���������-1����Ϊ�����n��ŵĳ�������ֻ��ȡ��n-1��������n-1��������Ϊn�ĳ���
            	
            	//System.out.println("��ѡ�����޵ĳ���Ϊ:"+AutoInf.name[(carlist[m]-1)]+"�����ػ�����"+AutoInf.carrygoods[(chooseCar1-1)]+"�֣����ؿ�����"+AutoInf.carrypeople[(chooseCar1-1)]+"�ˣ�");
           
        
               }else {
    	       System.out.println("��ӭ�´ι��٣��ڻ�ӭҳ�˳�");
    	  //��ѡ�񳵽׶�����0��ֱ�Ӳ�����ѭ��
       }
    }
}

/*2018.3.23
 * ��ǣ�
 * �����Ҷ�����ɵĵ�һ��С��Ŀ����Ŀ������Ľ���������еĴ���ʵ�֣�����֪ʶ�㡢���̽ṹ�����Լ�˼������ѯ���ϵ����ģ�
 * ��������Ŀ���ҷǳ����Ķ��Ҹе����㡣
 * ���⻹�кܶ࣬�����ٴ�ѡ����ʱ�޷��������������Ƿ���Ч����Ҫ����ӿڵ�˼�룬������Ϊ�ӿڲ��ܶ���Ϊstatic����
 * ʹ����һЩ������˵�Ƚ��µļ���������Scanner��ȡ�������룬���ж�̬����ArrayList��
 * ���뿴�������Ʒ�����Ѹ���ָ�㣬��Ʒ�ܼ򵥣�������䣬ϣ�����ߴͽ̣��ǳ���л��
 */
