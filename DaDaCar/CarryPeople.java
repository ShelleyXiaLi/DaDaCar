package com.DaDaCar;

public interface CarryPeople {
    public int carryPeople();
    //这里要设置返回值类型为int
}
     //因为java 中不能定义抽象静态方法static
	 //interface中所有的成员方法都是abstract的，当然也就不能定义静态方法static。
	 //所以放弃引入接口的思想。


	