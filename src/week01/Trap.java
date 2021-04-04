package week01;

/**
 * leecode 42
 */
public class Trap {

    /**采用动态规划的方法来进行求解
     * 这里需要注意的是：最终的结果不是直接动态规划一步到位，而是动态规划计算每一列的最左墙高度和右边墙最高高度
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int sum=0;

        //maxLeft[i]:表示第i列左边最高的墙
        int[] maxLeft= new int[height.length];
        //maxRight[i]:表示第I列右边最高的墙
        int[] maxRight= new int[height.length];
        for(int i=1;i<height.length-1;i++)
        {
            maxLeft[i] = Math.max(maxLeft[i-1],height[i-1]);
        }

        for(int i=height.length-2;i>=0;i--)
        {
            maxRight[i] = Math.max(maxRight[i+1],height[i+1]);
        }

        //计算每列可以存储的水，这里有个情形分析，一定是要左侧的最高墙<=右侧的最高墙
        for(int i=1;i<height.length-1;i++)
        {
            int min=Math.min(maxLeft[i],maxRight[i]);
            if(min>height[i])
            {
                sum+=(min-height[i]  );
            }
        }

        return sum;

    }
}
