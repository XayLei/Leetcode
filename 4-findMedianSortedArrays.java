public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         if (nums1 == null || nums2 == null) {
              return 0;
          }
          
          int len = nums1.length + nums2.length;
         
          double ret = 0;
          // 偶数个元素
         if (len % 2 == 0) {
             ret = (findKth(nums1, nums2, 0, 0, len / 2) + findKth(nums1, nums2, 0, 0, len / 2 + 1)) / (double)2.0;
         } else {
             // 奇数个元素
             ret = findKth(nums1, nums2, 0, 0, len / 2 + 1);            
         }
         
         return ret;
     }
     
     // Find the Kth large number.
     public int findKth(int A[], int B[], int indexA, int indexB, int k) {
         int lenA = A.length;
         int lenB = B.length;
         
         if (indexA >= lenA) {
             return B[indexB + k - 1];
         } else if (indexB >= lenB) {
             return A[indexA + k - 1];
         }
         
         // Base Case, pay attention. 在这里必须要退出。因为k = 1的时候，不可能再分了。
         if (k == 1) {
             return Math.min(A[indexA], B[indexB]);
         }
         
         // -1是因为索引本身是从0开始的。而前k大元素含有k个元素。
         int mid = k / 2 - 1;
         
         // 注意，越界条件是 >= lenA. 怎么老是犯这个错误。。
         int keyA = indexA + mid >= lenA ? Integer.MAX_VALUE: A[indexA + mid];
         int keyB = indexB + mid >= lenB ? Integer.MAX_VALUE: B[indexB + mid];
         
         // 因为丢弃了k / 2个元素
         int kNew = k - k / 2;
         
         if (keyA < keyB) {
             return findKth(A, B, indexA + k / 2, indexB, kNew);
         } else {
             return findKth(A, B, indexA, indexB + k / 2, kNew);
         }
    }
}
