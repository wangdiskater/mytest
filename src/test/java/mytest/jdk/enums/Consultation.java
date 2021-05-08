package mytest.jdk.enums;

/**
 * @Description 学习使用枚举方法，以订单状态举例
 * 一开始都是未支付 -> 支付 -》创建 -》
 * 慢慢都变成true
 *
 * @ClassName Consultation
 * @Author wangDi
 * @date 2021-05-07 10:15
 */
public class Consultation {
    public enum ConsultState {
        UNPAID(0){
        },
        PAID(1){
            @Override
            public boolean isPaid() {
                return Boolean.TRUE;
            }
        },
        CREATED(2){
            @Override
            public boolean isPaid() {
                return Boolean.TRUE;
            }
            @Override
            public boolean isCreated() {
                return Boolean.TRUE;
            }
        },
        CONSULTING(3) {
            @Override
            public boolean isPaid() {
                return Boolean.TRUE;
            }
            @Override
            public boolean isCreated() {
                return Boolean.TRUE;
            }
            @Override
            public boolean isConsulting() {
                return Boolean.TRUE;
            }
        },
        ;
        private int consultIndex;
        public int getConsultIndex() {
            return consultIndex;
        }

        ConsultState(int consultIndex) {
            this.consultIndex = consultIndex;
        }
        public boolean isPaid(){
            return Boolean.FALSE;
        }
        public boolean isCreated(){
            return Boolean.FALSE;
        }
        public boolean isConsulting(){
            return Boolean.FALSE;
        }
    }
}
