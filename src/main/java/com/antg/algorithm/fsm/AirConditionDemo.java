package com.antg.algorithm.fsm;
/**
* @author:Antg
* @create: 2023/8/2
* @Description: 有限状态机(finite state mechine,FSM)空调Demo
 * 空调有
 *  两个键(动作) 电源键和制冷键
 *  三个运行态(状态) 停止,吹风,制冷
 *
 *
 *
*/
public class AirConditionDemo {
    private int state=0;// 初始状态 0 :关闭 1:送风 2:制冷
    public int getState(){return state;}

    public void power(){
        if(state==0){
            state=1;
            System.out.println("开始吹风");
        } else if (state==1) {
            state=0;
            System.out.println("停止吹风");
        }else{
            state=0;
            System.out.println("停止吹风");
        }
    }

    public void cool(){
        if(state==0){
            System.out.println("电源未开启");
        }else if(state==1){
            state=2;
            System.out.println("开始制冷");
        }else{
            state=1;
            System.out.println("停止制冷");
        }
    }

    public static void main(String[] args) {
        AirConditionDemo airCondition = new AirConditionDemo();
        airCondition.power();
        airCondition.cool();
        airCondition.power();
        airCondition.cool();


    }
}
