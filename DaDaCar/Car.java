package com.DaDaCar;

public class Car extends Auto {
    Auto car =new Car();
    static String name ="天籁";   //将变量定义为静态变量，可以在全类中使用。这样就可以在父类中调用了。
	static int price= 100;
	static int carryPeopleNum = 5;
	static int carryGoodsNum = 0;
     
}
//因为java 中不能定义抽象静态方法static
//interface中所有的成员方法都是abstract的，当然也就不能定义静态方法static。