package com.DaDaCar;

public class HeavyTruck extends Auto{
    Auto heavyTruck =new HeavyTruck();
    static String name ="红旋风";
	static int price= 1000;
	//思考：既然我已经在AutoInf类里面把数据录入了数组，那么我就不需要在这里定义
	//或者，我在AutoInf类中调用该数据也可以。
	static int carryPeopleNum = 0;
	 static int carryGoodsNum = 30;
	 //2018.3.21
	 //这里需要在数组中调用该返回值，一般是用一个变量去接受这个返回值，然后在AutoInf中调用该变量
	 /*用与方法返回值相同或相似类型的变量来接收方法的返回值
                     例如：假设有一方法 public int getNumber(){
                     return 100;
                     }
                    那么我们可以这样获取：int result = getNumber();
                    接下来就可以使用result这个变量了！
	  * 
	  * 
	  */
}
