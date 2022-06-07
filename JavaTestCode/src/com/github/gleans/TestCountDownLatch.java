package store.zabbix.bran;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TestCountDownLatch {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);
        new KeyPass(2000L, "公司一", latch).start();
        new KeyPass(3000L, "公司二", latch).start();
        new KeyPass(5000L, "公司三", latch).start();
        latch.await(2, TimeUnit.SECONDS);
        System.out.println("~~~贾总PPT巡演~~~~");
        System.out.println("~~~~融资完成，撒花~~~~");
    }

    static class KeyPass extends Thread {

        private long times;

        private CountDownLatch countDownLatch;

        public KeyPass(long times, String name, CountDownLatch countDownLatch) {
            super(name);
            this.times = times;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(times);
                System.out.println("负责人：" + Thread.currentThread().getName()
                        + "开始工作，持续时间：" + this.times / 1000 + "秒");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
