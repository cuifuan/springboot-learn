package store.zabbix.bran;

import jdk.nashorn.internal.objects.NativeJSON;
import jdk.nashorn.internal.parser.JSONParser;
import jdk.nashorn.internal.runtime.JSONFunctions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SumWage {
    public static void main(String[] args) {
        List<UserDemo> userDemoList = new ArrayList<UserDemo>() {{
            add(new UserDemo(20, "jason", BigDecimal.valueOf(1000000)));
            add(new UserDemo(22, "yasuo", BigDecimal.valueOf(2000000)));
            add(new UserDemo(22, "ekko", BigDecimal.valueOf(100)));
        }};
        Map<Integer, List<UserDemo>> UserDemoMapByAge = userDemoList.stream()
                .collect(Collectors.groupingBy(UserDemo::getAge));
        System.out.println(UserDemoMapByAge);
    }

    static class UserDemo {
        private int age;
        private String username;
        private BigDecimal wage;

        public UserDemo(int age, String username, BigDecimal wage) {
            this.age = age;
            this.username = username;
            this.wage = wage;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public BigDecimal getWage() {
            return wage;
        }

        public void setWage(BigDecimal wage) {
            this.wage = wage;
        }

        @Override
        public String toString() {
            return "UserDemo{" +
                    "age=" + age +
                    ", username='" + username + '\'' +
                    ", wage=" + wage +
                    '}';
        }
    }
}