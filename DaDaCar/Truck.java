package com.DaDaCar;

public class Truck extends Auto {
    Auto truck =new Truck();
    static String name ="解放";
	static int price= 500;
	/*public int carryGoods(){
		 int num =5;
		 return num;
	 }
	 */
	 static int carryPeopleNum = 0;
	 static int carryGoodsNum = 5;
}	
	//因为java 中不能定义抽象静态方法static
	//interface中所有的成员方法都是abstract的，当然也就不能定义静态方法static。
	 //这里仅仅只实现了一个接口，如果想要在数组中直接调用子类元素填充，就必须把接口全部实现。
 
	

