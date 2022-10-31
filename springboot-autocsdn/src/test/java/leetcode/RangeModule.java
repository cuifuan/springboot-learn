package leetcode;

public class RangeModule {
    public RangeModule() {

    }

    public void addRange(int left, int right) {

    }

    public boolean queryRange(int left, int right) {
        return true;
    }

    public void removeRange(int left, int right) {

    }

    public static void main(String[] args) {
        RangeModule rangeModule = new RangeModule();
        rangeModule.addRange(10, 20);
        rangeModule.removeRange(14, 16);
        System.out.println(rangeModule.queryRange(10, 14)); // return True,(Every number in [10, 14) is being tracked)
        System.out.println(rangeModule.queryRange(13, 15)); // return False,(Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
        System.out.println(rangeModule.queryRange(16, 17)); // return True, (The number 16 in [16, 17) is still being tracked, despite the remove operation)
    }


}
