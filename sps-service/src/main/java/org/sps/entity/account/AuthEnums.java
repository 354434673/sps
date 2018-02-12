package org.sps.entity.account;

public interface AuthEnums  {
    enum IdentifyType{
        MAC("MAC") ,//网卡地址
        IMEI("IMEI"),//国际移动设备标识
        ID_CARD("ID_CARD"),//用户身份证号
        PHONE("PHONE"),//手机号
        EMAIL("EMAIL"),//邮箱
        USER_ID("USER_ID"),//用户Id
        AGREEMENT_NO("AGREEMENT_NO");//用户纸质订单协
        private String value;
        private IdentifyType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
    enum AuthStatus{
        BIND_SUCCESS("BIND_SUCCESS","绑卡成功"),
        TO_VALIDATE("TO_VALIDATE","待短验确认"),
        BIND_FAIL("BIND_FAIL","绑卡失败"),
        BIND_ERROR("BIND_ERROR","绑卡异常"),
        TIME_OUT("TIME_OUT","超时失败"),
        ACCEPT("ACCEPT","已接收"),
        WAIT_BIND("WAIT_BIND","待绑卡"),
        FAIL("FAIL","系统异常");
        private String key;
        private String value;
        private AuthStatus(String key, String value) {
            this.key = key;
            this.value = value;
        }
        public String getKey() {
            return key;
        }
        public static  final String getValue(String key) {
            AuthStatus authStatus = AuthStatus.valueOf(key);
            return authStatus.getValue();
        }
        public static  final AuthStatus get(String key) {
            AuthStatus authStatus = AuthStatus.valueOf(key);
            return authStatus;
        }
        public String getValue() {
            return value;
        }
        public static void main(String[] args) {
            System.out.println(AuthStatus.get(BIND_ERROR.key));
        }
    }
}
