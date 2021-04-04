package week01;

public class MergeArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m - 1;
        int q = n - 1;
        int p2 = m + n - 1;
        while (p >= 0 && q >= 0) {
            nums1[p2--]=nums1[p]>nums2[q]?nums1[p--]:nums2[q--];
        }

        if(q>=0)
        {
            System.arraycopy(nums2,0,nums1,0,q+1);
        }
    }
}
