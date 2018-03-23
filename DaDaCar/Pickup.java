package com.DaDaCar;

public class Pickup extends Auto {  //不同接口用逗号隔开
    Auto pickup =new Pickup();
    static String name ="坦途";
	static int price= 200;
	
	static int carryPeopleNum = 2;
	 static int carryGoodsNum = 2;
}
//因为java 中不能定义抽象静态方法static
//interface中所有的成员方法都是abstract的，当然也就不能定义静态方法static。
//所以不用接口实现了