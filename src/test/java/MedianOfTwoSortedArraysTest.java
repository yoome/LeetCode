import com.yoome.solutions.MedianOfTwoSortedArrays;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MedianOfTwoSortedArraysTest {

    @Test
    public void test() {
        int[] nums1 = {1, 2, 5, 6};
        int[] nums2 = {3, 4, 8};
        MedianOfTwoSortedArrays arrays = new MedianOfTwoSortedArrays();
        double res = arrays.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
        assertEquals(4.0, res, 0.1);
    }
}
