package leetcode.editor.cn;

/**
 * @author 11757
 * @date 2022/3/14
 **/
public class UTF8EncodingValidation {
    static final int MASK1 = 1 << 7;
    static final int MASK2 = (1 << 7) + (1 << 6);

    public boolean validUtf8(int[] data) {
        int n = data.length;
        for (int i = 0; i < n; ) {
            int num = data[i];
            int cnt = getBytes(num);
            if (cnt < 0 || cnt + i > n) {
                //字节异常或长度不足
                return false;
            }
            for (int j = 1; j < cnt; j++) {
                if (!isValid(data[i + j])) {
                    return false;
                }
            }
            i += cnt;
        }
        return true;
    }

    //判断10开头
    public boolean isValid(int num) {
        return (num & MASK2) == MASK1;
    }

    public int getBytes(int num) {
        // num & 1000000 ==0 说明 以0开头，只有1字节
        if ((num & MASK1) == 0) {
            return 1;
        }
        int n = 0;
        int mask = MASK1;
        //判断连续的字节数量
        while ((num & mask) != 0) {
            n++;
            if (n > 4) {
                return -1;
            }
            mask >>= 1;
        }
        return n >= 2 ? n : -1;
    }

    public static void main(String[] args) {
        UTF8EncodingValidation validation = new UTF8EncodingValidation();
        System.out.println(validation.validUtf8(new int[]{197, 130, 1}));
    }

}