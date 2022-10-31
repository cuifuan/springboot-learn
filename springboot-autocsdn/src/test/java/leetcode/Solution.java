package leetcode;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
//        int[] ary = new int[]{2, 5, 5, 11};
//        int[] res = twoSum(ary, 10);
//        System.out.println(Arrays.toString(res));
//        System.out.println("==================");
//        // 初始化链表
//        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
//        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
//        addTwoNumbers(l1, l2);
        System.out.println(lengthOfLongestSubstring("babawpac"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] last = new int[128];
        int n = s.length();
        int start = 0;
        int res = 0;
        for (int i = 0; i < n; i++) {
            // 获取字符的
            int index = s.charAt(i);
            start = Math.max(start, last[index]);
            res = Math.max(res, i - start + 1);
            last[index] = i + 1;
        }
        return res;


        // 记录字符上一次出现的位置
//        int[] last = new int[128];
//
//        int n = s.length();
//
//        int res = 0;
//        int start = 0; // 窗口开始位置
//        for (int i = 0; i < n; i++) {
//            int index = s.charAt(i);
//            start = Math.max(start, last[index]);
//            res = Math.max(res, i - start + 1);
//            last[index] = i + 1;
//        }
//
//        return res;
    }

    /**
     * 两数相加
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cusur = root;
        int tempNum = 0;
        while (l1 != null || l2 != null || tempNum != 0) {
            int sumA = l1 != null ? l1.val : 0;
            int sumB = l2 != null ? l2.val : 0;
            int sum = sumA + sumB + tempNum;
            tempNum = sum / 10;

            ListNode nextNode = new ListNode(sum % 10);
            cusur.next = nextNode;
            cusur = nextNode;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }


//        ListNode root = new ListNode(0);
//        ListNode cursor = root;
//        int carry = 0;
//        while(l1 != null || l2 != null || carry != 0) {
//            int l1Val = l1 != null ? l1.val : 0;
//            int l2Val = l2 != null ? l2.val : 0;
//            int sumVal = l1Val + l2Val + carry;
//            carry = sumVal / 10;
//
//            ListNode sumNode = new ListNode(sumVal % 10);
//            cursor.next = sumNode;
//            cursor = sumNode;
//
//            if(l1 != null) l1 = l1.next;
//            if(l2 != null) l2 = l2.next;
//        }
//
//        return root.next;
//        List<Long> aList = new ArrayList<>();
//        List<Long> bList = new ArrayList<>();
//        ListNode curNode = l1;
//        while (curNode != null) {
//            aList.add(Long.valueOf(curNode.val));
//            curNode = curNode.next;
//        }
//        StringBuilder aNum = new StringBuilder("");
//        for (int i = aList.size() - 1; i >= 0; i--) {
//            aNum.append(aList.get(i));
//        }
//        Long aNumParse = Long.parseLong(String.valueOf(aNum));
//
//        ListNode curNode2 = l2;
//        while (curNode2 != null) {
//            bList.add(Long.valueOf(curNode2.val));
//            curNode2 = curNode2.next;
//        }
//        StringBuilder bNum = new StringBuilder();
//        for (int k = bList.size() - 1; k >= 0; k--) {
//            bNum.append(bList.get(k));
//        }
//        Long bNumParse = Long.parseLong(String.valueOf(bNum));
//        Long cNum = aNumParse + bNumParse;
//        String cNumStr = String.valueOf(cNum);
//
//        List<String> resListTemp = Arrays.asList(cNumStr.split(""));
//        List<Long> resList = resListTemp.stream()
//                .map(Long::valueOf)
//                .collect(Collectors.toList());
//
//        Collections.reverse(resList);
//        ListNode resNode = new ListNode(resList.get(0).intValue());
//        ListNode other = resNode;
//        for (int i = 1; i < resList.size(); i++) { //头结点已经定义，从1开始
//            ListNode temp = new ListNode(resList.get(i).intValue());
//            other.next = temp;
//            other = other.next;
//        }
        return null;
    }

    /**
     * 第一题 两数之和
     */
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        // 建立k-v ，一一对应的哈希表
        HashMap<Integer, Integer> hash = new HashMap<>(8);
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(target - nums[i])) {
                return new int[]{hash.get(target - nums[i]), i};
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(nums[i], i);
        }
//        boolean flag = false;
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length; j++) {
//                if (i != j) {
//                    if ((target - (nums[i] + nums[j])) == 0) {
//                        res[0] = i;
//                        res[1] = j;
//                        flag = true;
//                    }
//                }
//            }
//            if (flag) {
//                break;
//            }
//        }
        return res;
    }


}
