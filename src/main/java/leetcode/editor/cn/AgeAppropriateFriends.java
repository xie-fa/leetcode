package leetcode.editor.cn;

import java.util.Arrays;

/**
 * AUTHOR 11757
 * DATE 2021/12/27
 * 825 适龄的朋友
 **/
public class AgeAppropriateFriends {

    /**
     * 排序加双指针
     *
     * @param ages
     * @return
     */
    public int numFriendRequests(int[] ages) {
        int n = ages.length;
        Arrays.sort(ages);
        int left = 0, right = 0, ans = 0;
        for (int age : ages) {
            if (age < 15) {
                continue;
            }
            while (ages[left] <= 0.5 * age + 7) {
                ++left;
            }
            while (right + 1 < n && ages[right + 1] <= age) {
                ++right;
            }
            ans += right - left;
        }
        return ans;
    }

    /**
     * 计数排序+前缀和
     *
     * @param ages
     * @return
     */
    public int numFriendRequests1(int[] ages) {
        int[] cnt = new int[121];
        for (int age : ages) {
            ++cnt[age];
        }
        int[] pre = new int[121];
        for (int i = 1; i <= 120; ++i) {
            pre[i] = pre[i - 1] + cnt[i];
        }
        int ans = 0;
        for (int i = 15; i <= 120; ++i) {
            if (cnt[i] > 0) {
                int bound = (int) (i * 0.5 + 8);
                ans += cnt[i] * (pre[i] - pre[bound - 1] - 1);
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        AgeAppropriateFriends ageAppropriateFriends = new AgeAppropriateFriends();
        System.out.println(ageAppropriateFriends.numFriendRequests(new int[]{20, 30, 100, 110, 120}));
        ;
    }

}
