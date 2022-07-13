package leetcode.editor.cn;

/**
 * 统计按位或能得到最大值的子集数目
 *
 * @author 11757
 * @date 2022/3/15
 **/
public class OrMaximumNumberOfSubsets {

    int maxOr = -1;
    int ans = 0;

    public int countMaxOrSubsets(int[] nums) {
        dfs1(nums, 0, 0);
        return ans;
    }

    private void dfs(int[] nums, int last, int index) {
        if (index >= nums.length) {
            return;
        }
        int or = last | nums[index];
        //
        if (maxOr < or) {
            ans = 1;
            maxOr = or;
        } else if (maxOr == or) {
            ans++;
        }
        dfs(nums, last, index + 1);
        dfs(nums, or, index + 1);
    }

    public void dfs1(int[] nums,int index,int value){
        if(index == nums.length){
            if (maxOr < value) {
                ans = 1;
                maxOr = value;
            } else if (maxOr == value) {
                ans++;
            }
            return;
        }
        dfs1(nums,index+1,value);
        dfs1(nums,index+1,value|nums[index]);
    }

    public static void main(String[] args) {
        OrMaximumNumberOfSubsets orMaximumNumberOfSubsets = new OrMaximumNumberOfSubsets();
        System.out.println(orMaximumNumberOfSubsets.countMaxOrSubsets(new int[]{3,2,1,5}));
    }

}
