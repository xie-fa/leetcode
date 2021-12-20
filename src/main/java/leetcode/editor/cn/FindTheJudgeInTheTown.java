package leetcode.editor.cn;

/**
 * 997 找到小镇的法官
 * AUTHOR 11757
 * DATE 2021/12/19
 **/
public class FindTheJudgeInTheTown {

    public int findJudge(int n, int[][] trust) {
        int[] p = new int[n + 1];
        for (int i = 1; i <= trust.length; i++) {
            p[trust[i - 1][0]]--;
            p[trust[i - 1][1]]++;
        }
        for (int i = 1; i < p.length; i++) {
            if (p[i] == (n - 1)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FindTheJudgeInTheTown findTheJudgeInTheTown = new FindTheJudgeInTheTown();

        int[][] trust = new int[2][];
        int[] t1 = {1, 2};
        int[] t2 = {2, 3};
        trust[0] = t1;
        trust[1] = t2;

        System.out.println(findTheJudgeInTheTown.findJudge(3, trust));
    }
}
