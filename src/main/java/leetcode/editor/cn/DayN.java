package leetcode.editor.cn;

/**
 * @author xiefa
 * 1154 第几天
 **/
public class DayN {

    public int dayOfYear(String date) {
        String[] dateS = date.split("-");
        int year = Integer.parseInt(dateS[0]);
        int month = Integer.parseInt(dateS[1]);
        int day = Integer.parseInt(dateS[2]);
        int ans = 0;
        int[] monthNum = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        for (int i = 1; i < month; i++) {
            ans += monthNum[i - 1];
        }
        if (year % 4 == 0 && month > 2) {
            ans++;
        }
        ans += day;
        return ans;
    }

    public static void main(String[] args) {
        DayN dayN = new DayN();
        System.out.println(dayN.dayOfYear("2004-03-01"));
    }
}
