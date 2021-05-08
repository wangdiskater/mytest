package mytest.jdk.enums;

import org.junit.jupiter.api.Test;

/**
 * @Description
 * @ClassName EnumEqual
 * @Author wangDi
 * @date 2021-05-07 09:54
 */
public class EnumEqualTest {

    /**
     * enum 的 比较测试
     * 1. 运行时的安全性
     * 2. 编译时的安全性
     */
    @Test
    void equalEnum1() {
        Life.LifeEnum lifeEnum = null;
        System.out.println(Life.LifeEnum.EAT.equals(lifeEnum));
        System.out.println(lifeEnum.equals(Life.LifeEnum.EAT));
        System.out.println(lifeEnum == Life.LifeEnum.EAT);

    }


    @Test
    void equalEnum2() {
        // error
//        if (LifeEnum2.LEARN == Life.LifeEnum.LEARN){
//
//        }
        if (LifeEnum2.LEARN.equals(Life.LifeEnum.LEARN)) {

        }
    }


    @Test
    void enumConsultation() {
        Consultation.ConsultState consultState = Consultation.ConsultState.UNPAID;
        printStatus(consultState);
        Consultation.ConsultState consultState1 = Consultation.ConsultState.PAID;
        printStatus(consultState1);
        Consultation.ConsultState consultState2 = Consultation.ConsultState.CREATED;
        printStatus(consultState2);
        Consultation.ConsultState consultState3 = Consultation.ConsultState.CONSULTING;
        printStatus(consultState3);

    }

    void printStatus(Consultation.ConsultState consultState){
        int consultIndex = consultState.getConsultIndex();
        System.out.println("当前订单状态下标："+ consultIndex + " 支付状态：" + consultState.isPaid() + " 订单创建状态 " + consultState.isCreated() + " 订单的咨询状态 " + consultState.isConsulting());
    }
}
