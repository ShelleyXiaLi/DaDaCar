/*需求：完成一个控制台版本的达达租车系统，以后可以考虑做成安卓或者网页。
 *   1.展示所有可租车辆(暂定为5台)，列表如下；
 *   2.选择车型、租车数量、租车时间；
 *   3.展示租车清单，包含：总金额，总载货量和车型，总载客量和车型。
 *   
 *   车型                           名称              载货量         载客量        日租金   
 * 1 Truck         解放                 5       0      500
 * 2 HeavyTruck    红旋风             30      0      1000
 * 3 Bus           金龙                 0       50     400
 * 4 Car           天籁                 0       5      100
 * 5 Pickup        坦途                 2       2      200
 * 
 * 2018.3.19
 * 思路： 1. 首先解决 “获取键盘输入”的问题，使用import java.util.Scanner工具   
 *      2. 车作为一个父类，拥有价格和名字两个属性   
 *       2.1 传参？  
 *       2.2 抽象类？  因为没有特定的方法，所以不使用用抽象类，使用接口实现
 *       2.3 把载客量和载货量做成接口，子类只要实现所需要的接口就可以了。
 *      3. 展示车辆，把他们做成数组，遍历数组即可，分别输出
 *       3.1 选择车型就相当于给出了具体数组的索引，直接提取元素输出。
 *       3.2 数组1，记录载客量；数组2，记录载货量。
 *      4.打开页面，先要有一个欢迎界面，如果有租车需求就继续，没有租车需求就退出。
 *      5.车型，租车数量，租车时间，都是用Scanner工具获取值并相应输出。
 *      
 *      6.流程：打开欢迎页，是否租车？ →  租车请按1  →  车辆列表    →  选择车辆   →  选择租车时长   → 展示租车清单 
 *                           →  退出请按0            →  退出请按0
 */ 
package com.DaDaCar;
 
import java.util.Scanner;   //获取键盘输入
import java.util.ArrayList;

public class Auto {   
    static String name;
    static int   price;
    static int carryPeopleNum;
    static int carryGoodsNum;
    @SuppressWarnings("resource")
	public static void main(String[] args) {
    	
    	System.out.println("欢迎光临达达租车！");
    	Scanner input1=new Scanner(System.in);
    	System.out.print("租车请按1，退出请按0：");   //println输出信息后会换行，而print不会
    	
    	int choice1 =input1.nextInt();
        if(choice1==1) {
        	System.out.println("请选择您要租的车辆，结束请按0！");
           /*2018.3.19
            *这里是现实了欢迎页面，接下来应引入车辆列表信息，如何实现呢
            * 思路：首先创建父类，并创建相应车型的子类，分别实例化，并且相应赋值。
            *      同时把载客量和载货量做成接口，不同的子类实现不同的接口。
            *      把不同的值存储到相应的数组中，比如name，price，载客量，载货量，通过访问数组调用元素获取数据。
            *所以这里应该是一个数组的输出页面。 
            *
            *2018.3.20
            *复习一下数组的内容后再回来编写
            *思路：专门定义一个数组存放类AutoInf，这个类是public的，然后在主类中调用
        	*  如何调用数组中的元素？   使用   数组名[索引值]；
        	*  答：必须声明为静态数组，使用 类名+数组名的方式访问，比如  AutoInf.carrygoods[i] 
        	*/
        	
        	//思考：如果这里把五个都列出来，代码复用性很差，考虑使用遍历数组来输出，这样提高了代码的复用性
        	//回顾遍历数组的知识点  while遍历  这样一条代码即可显示所有车的情况。
        	int i=0;
        	System.out.println("车辆序号\t"+"车辆名称\t"+"载货量/吨\t"+"载客量/人\t"+"日租金/元\t");
        	while (i < 5) {
        		System.out.println(
        				(i+1)+
        				"\t"+AutoInf.name[i]+
        				"\t"+AutoInf.carrygoods[i]+
        				"\t"+AutoInf.carrypeople[i]+
        				"\t"+AutoInf.price[i]);
                   i++;
        	       }
        	//这里可以使用转义符来使格式整洁   如何实现？\t 制表符
        	
        	
        	//输出了车辆列表后，再次获取键盘输入，以获得车辆的选择信息。
        	
        	/*2018.3.20
            *思考：怎么一次选择多辆车呢？
        	*
            *引入一个动态数组的功能，ArrayList把用户输入具体租车的值填充进数组中
            *ArrayList是可以动态改变大小的。
            *数组list
                                    语法格式：
            ArrayList<int[]> list = new ArrayList<int[]>(); 
            ArrayList<Integer> list = new ArrayList<Integer>();//这一种可用
            *那么，什么时候使用Array（数组），什么时候使用ArrayList?
            *答案：当我们不知道到底有多少个数据元素的时候，就可使用ArrayList；
            *如果知道数据集合有多少个元素，就用数组。
        	
        	*使用ArrayList好处：
        	*同时可以得到数组长度，也就是一共租几辆车
        	*可以用循环，然后以输入一个特定的符号来结束输入，用集合来存放输入的数字。
        	*还需要规定一个特定值，用户输入这个值表示输入结束，比如0号
        	*用户输入的数值是一个变量，定义一个变量记录输入的数值
        	*
        	*为什么ArrayList不能放int类型？
        	*Integer是int的包装类(wrapper)，是对象
             int是基本数据类型
                                      在具体的内存分配上
                                      对象是放在堆里的，基本数据类型是放在栈里的
             JAVA的集合只能放引用类型
             https://zhidao.baidu.com/question/380197738.html
             http://blog.csdn.net/huanghanqian/article/details/73920439
        	*/
        	
        	ArrayList<Integer> list = new ArrayList<Integer>();
        	
        	Scanner input2=new Scanner(System.in);
        	int chooseCar1 =input2.nextInt();
        	int temCarNum = 0;   //这个变量temCarNum用于储存已经选择的车辆数
        	if(chooseCar1==0) {  
        		System.out.println("欢迎下次光临！在选择车辆阶段退出");  
        		//检测是否接收到0，即退出信息，如果接收到，直接不进入循环
        	}else{  
        		//使用||判断为ture后直接返回，不用每次都判断两次。
        		while(chooseCar1<0 || chooseCar1>=6) {
            	System.out.println("无对应车型，请重新输入！");
            	Scanner input3=new Scanner(System.in);
        	    int reselectCar =input3.nextInt();
        	    chooseCar1= reselectCar;
        	   //先进行一次判断，如果不在1-5之内，要求重新输入，在1-5之内后，继续往下
        		}
        		
        	    while(chooseCar1>0 && chooseCar1<=5) {  
        		    list.add(chooseCar1);
        		    System.out.println("您选择了"+chooseCar1+"号车"+AutoInf.name[chooseCar1-1]+"！");
        		    System.out.println("继续选择请输入序号，选择完毕按0退出");
        		
                 Scanner input4=new Scanner(System.in);
        	     int chooseCar2 =input4.nextInt();
        	     chooseCar1= chooseCar2;
        	     temCarNum++;
        	   if(temCarNum==5) {
       	    	  System.out.println("可选择车辆数已达上限！");
       	    	  break;    //这里加了一个限制条件，已经选择的车辆数量大于5时，跳出循环，使可选车辆数不大于5
       	          }
        	     continue;
        	     } 
        		}
             /*2018.3.23
              * 重新修改了车辆选择部分流程语句控制，添加了限制条件
              * 还有一个车辆不可重复的限制条件没有加入
              * 考虑数组遍历然后比较？
               
               2018.3.22
               *这里的问题主要在于不能识别哪辆车已经被选择了，被选择的车是否应该不能再继续选择？ 
           	   *可能可以使用数组遍历来排除？
           	   *这样做只能排除上上次选择和本次选择不同的情况。
           	   *可能选择车型的整个流程语句都存在问题。需要重写。
           	   */	
        	int carNum = list.size();//获取链表长度
        	System.out.println("您共计选择了"+carNum+"辆车！");
        	
        	
        	/*while(chooseCar1>0 && chooseCar1<6) {
        	
        	System.out.println("您选择了"+chooseCar1+"号车！"+"");
        	    list.add(chooseCar1);   // 增加元素到list对象中
        	    int carNum = list.size();//获取链表长度
          	    System.out.println("您共计选择了"+carNum+"辆车！" );
        	}
        	System.out.println("请重新输入");
        	*/
       	    //  list.add(chooseCar2);
        	
        	//System.out.println(list[]);
            
        	
        	/*2018.3.21
             * 
             * 放弃使用ArrayList动态数组，因为动态数组不能够接受基本类型int
        	 * 改变思路
        	 * http://blog.csdn.net/sum_tw/article/details/57158986
        	 * 思路：当你想增加数组大小时，就另外创建一个你想要的数组，把以前的那个数组放入其中即可。
        	 *首先要新建一个长度为1的数组，创建一个变量来记录输入的数值的个数，
        	      这个变量最终成为需要的数组的长度。
        	      或者，直接没有初始数组，通过获取输入的数据的个数确定需要的数组长度，
        	      因为如果需要用户首先输入一次预计租车的数量，相当于多一道程序，
        	      考虑直接通过用户输入的车辆序号获得数组长度。	
        	 *
        	 *
        	 * int carlist[]=new int[5];
        	Scanner input2 = new Scanner(System.in);
        	for(int m=0;m<5;m++)
        	{
        	carlist[m] = input2.nextInt();
        	}*/
        	//输入数字到数组
            
        	/*Scanner input2=new Scanner(System.in);
        	int chooseCar1 =input2.nextInt();
        	
        	Scanner input3=new Scanner(System.in);
        	int chooseCar2 =input3.nextInt();
        	 * 
        	 * if(chooseCar1==1) {
            	System.out.println("您选择了"+Truck.name);
            	//父类中调用子类属性如何实现？
         	   //答：应该是  子类名.属性名   而不是  属性名.子类名    
            	//这里调用了子类中  的静态变量 Truck.name
            }
            if(chooseCar2==2) {
            	System.out.println("您选择了"+HeavyTruck.name);
            }
        	*/
           //输出的内容可以直接修改为输出车型、价格、载客量和载货量
       	   //也需要添加一个租车天数的键盘获取接口
              System.out.print("请选择租车时长:");
                //2018.3.20
                //为了代码的健壮性
            	//这里应该加一个if语句进行判断输入的数值是否合理
            	//使用if语句的话，判断一次就不会继续往下运行了，所以可以使用while语句
            	
            	Scanner input4=new Scanner(System.in);
            	int days1 =input4.nextInt();
            	
            	while(days1<=0){
            		System.out.println("您输入的租车时长有误，请重新输入!");
            	    Scanner input5=new Scanner(System.in);
            	      int days2 =input5.nextInt();
            	      days1= days2;
            	      
            	      }   
            	System.out.println("您选择租用"+days1+"天");
                //System.out.println("arraylist长度为"+list.size());
            	
            	//以上利用while语句对输入的租车时长进行判断,为什么不使用do...while呢
            	//因为do..while语句会执行一次后再进行判断，如果用户初次输入的数据不合规范，就会出错。
              
                
                int totalCarryGoods = 0;
              //定义一个变量totalCarryGoods来记录所有的车的总载货量
                for ( int n = 0; n <list.size(); n++){
            	 //System.out.println("车序号为"+list.get(n)+AutoInf.name[list.get(n)-1]);
            	 
                  //System.out.println("您租用的车载货量为："+AutoInf.carrygoods[list.get(n)-1]);
            		  //这一条代码用于输出单辆车的载货量
            		totalCarryGoods += AutoInf.carrygoods[list.get(n)-1];
            	}
            	System.out.println("您所选汽车的总载货量为："+totalCarryGoods+"吨！");
            	
            	  //同样的方法，定义一个变量totalCarryPeople来记录所有车的总载货量
            	int totalCarryPeople = 0;
            	for ( int n = 0; n <list.size(); n++){
          		  //System.out.println("车序号为"+list.get(n)+AutoInf.name[list.get(n)-1]);
          	 
                  //System.out.println("您租用的车载货量为："+AutoInf.carrygoods[list.get(n)-1]);
          		  //这一条代码用于输出所选车的单独载客量
          		totalCarryPeople += AutoInf.carrypeople[list.get(n)-1];
          	   }
          	   System.out.println("您所选汽车的总载客量为："+totalCarryPeople+"人！");
            	
          	   
          	   //同样的思路，定义一个变量totalMoney来记录所有的扯得总载客量	  
          	    int eachDayMoney = 0;
         	  for ( int n = 0; n <list.size(); n++){
       		  //System.out.println("车序号为"+list.get(n)+AutoInf.name[list.get(n)-1]);
       	       //2018.3.23
         	  //思考，如何确定对应的车辆的数量，然后确定他们的价格？
              //如果能够复选的话，这是一种情况，如果不能复选，那么只需要调取车辆编号对应的价格相加即可，
       		  //可以或者不可以复选，我们都按照计算总载客、载货量的思路就可以，单天价格乘以天数即可得到
         		 eachDayMoney += AutoInf.price[list.get(n)-1];
       	   }
       	   System.out.println("您所选汽车的总租金为："+eachDayMoney*days1+"元！");
            	
            	
            	//这里调取ArrayList里面存储的数据，即为车辆的代码。
            	//list.get(n)获取的是对应的车的编号，直接带入Autoinf对应的数组中调取元素即可。
            	
            	
                //错误代码Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 5
            	//at com.DaDaCar.Auto.main(Auto.java:231)
            	//意思是错误提示的意思是数组越界，
            	//举个例子，你建了个数组int [] a = new int[4],
            	//	数组的长度是4，分别为a[0]到a[3]，而a.length=4,
            	//所以当你i<=a.length就会取到4这个值，而a[4]显然不在你建的数组范围之内，所以提示数组越界。
            	//解决方法是-1，因为最多有n编号的车，但是只能取到n-1，数组中n-1即代表编号为n的车。
            	
            	//System.out.println("您选择租赁的车辆为:"+AutoInf.name[(carlist[m]-1)]+"，总载货量；"+AutoInf.carrygoods[(chooseCar1-1)]+"吨，总载客量："+AutoInf.carrypeople[(chooseCar1-1)]+"人！");
           
        
               }else {
    	       System.out.println("欢迎下次光临！在欢迎页退出");
    	  //在选择车阶段输入0，直接不进入循环
       }
    }
}

/*2018.3.23
 * 后记：
 * 这是我独立完成的第一个小项目，题目来自于慕课网，所有的代码实现，包括知识点、流程结构都是自己思考、查询资料得来的，
 * 完成这个项目让我非常开心而且感到满足。
 * 问题还有很多，比如再次选择车辆时无法检测输入的数据是否有效；想要引入接口的思想，但是因为接口不能定义为static作罢
 * 使用了一些对我来说比较新的技术，比如Scanner获取键盘输入，还有动态数组ArrayList等
 * 恳请看到这份作品的朋友给予指点，作品很简单，雏鸟初啼，希望不吝赐教，非常感谢！
 */
