/*2018.3.20
 * �������ר�Ŵ���������
 * 1.����������飬�ֱ𴢴����֣��ؿ������ػ������۸�
 * 2.�����ȷ���ռ䣬�ٸ�ֵ��Ҳ�����ڷ���ռ��ͬʱ��ֵ������ֱ���ڷ����ͬʱ��ֵ��
 * 3.
 * 
 * 
 */

package com.DaDaCar;

public class AutoInf {
    static String [] name = new String[] {Truck.name,HeavyTruck.name,Bus.name,Car.name,Pickup.name};
    //����һ��name���飬���泵��������  
    //������룺Cannot define dimension expressions when an array initializer is provided
    //����ƶ�������ĳ��ȣ��Ͳ���ͬʱ��������ĳ���
    //������ֱ�ӵ�����������ݽ�����䣬�����Ļ��������ʵ�����нӿڣ���ô����ӿھͱ��û�������ˡ�
    
    
    
    
    //��������Ϊ��̬���飬ʹ�� ����+�������ķ�ʽ����
    
    static int  [] carrypeople =new int[] {Truck.carryPeopleNum,HeavyTruck.carryPeopleNum,Bus.carryPeopleNum,Car.carryPeopleNum,Pickup.carryPeopleNum };  
    //����һ��carrypeople���飬�����ؿ���
    //������룺Type mismatch: cannot convert from String to int
     //����һ��ʼ����˫���ţ�����ʶ��ΪString�ַ���������int�ͣ����Ա����ϴ������
    
    
    
     static int [] carrygoods =new int[] {Truck.carryGoodsNum,HeavyTruck.carryGoodsNum,Bus.carryGoodsNum,Car.carryGoodsNum,Pickup.carryGoodsNum};    
    //����һ��carrygoods���飬�����ػ���      
    

    static int  []  price   =new int[] {Truck.price,HeavyTruck.price,Bus.price,Car.price,Pickup.price};    
    //����һ��price���飬�������۸�  
}
