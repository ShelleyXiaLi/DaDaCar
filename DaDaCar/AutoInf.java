/*2018.3.20
 * 这个类是专门存放数组的类
 * 1.存放四种数组，分别储存名字，载客量，载货量，价格
 * 2.可以先分配空间，再赋值；也可以在分配空间的同时赋值，这里直接在分配的同时赋值。
 * 3.
 * 
 * 
 */

package com.DaDaCar;

public class AutoInf {
    static String [] name = new String[] {Truck.name,HeavyTruck.name,Bus.name,Car.name,Pickup.name};
    //定义一个name数组，保存车辆的名字  
    //错误代码：Cannot define dimension expressions when an array initializer is provided
    //如果制定了数组的长度，就不能同时设置数组的长度
    //或者我直接调用子类的数据进行填充，这样的话子类必须实现所有接口，那么引入接口就变得没有意义了。
    
    
    
    
    //必须声明为静态数组，使用 类名+数组名的方式访问
    
    static int  [] carrypeople =new int[] {Truck.carryPeopleNum,HeavyTruck.carryPeopleNum,Bus.carryPeopleNum,Car.carryPeopleNum,Pickup.carryPeopleNum };  
    //定义一个carrypeople数组，保存载客量
    //错误代码：Type mismatch: cannot convert from String to int
     //这里一开始用了双引号，数字识别为String字符串，不是int型，所以报以上错误代码
    
    
    
     static int [] carrygoods =new int[] {Truck.carryGoodsNum,HeavyTruck.carryGoodsNum,Bus.carryGoodsNum,Car.carryGoodsNum,Pickup.carryGoodsNum};    
    //定义一个carrygoods数组，保存载货量      
    

    static int  []  price   =new int[] {Truck.price,HeavyTruck.price,Bus.price,Car.price,Pickup.price};    
    //定义一个price数组，保存租金价格  
}
