package sort;

import edu.princeton.cs.algs4.StdRandom;

/**
 * @author 王俊杰
 * @date 2019/3/30 19:45
 */
public class QuickSort extends ProtoSort{

    /**划分**/
    private static int partition(Comparable[] a, int low, int high){
        //high+1是由于要使用--j，而在循环做iteration时--j的效率≥j--
        int i = low, j = high+1;
        while (true){
            //开始移动i，扫描直到发现大于a[low]的值
            while (less(a[++i], a[low])){
                //防止超过数组上限
                if (i > high) {
                    break;
                }
            }
            //开始移动j，扫描直到发现小于a[low]的值
            while (less(a[low], a[--j])){
                //防止超过数组下限
                if (j < low){
                    break;
                }
            }
            //若ij cross了，则结束partion
            if (i >= j){
                break;
            }
            //交换i，j，把大的放右边，小的放左边
            exchange(a, i, j);
        }
        //把a[low]放到partition左部分的最右边元素位置去，即j，此时a[low]左边≤a[low]， a[low]右边都≥a[low]
        exchange(a, j, low);
        return j;
    }

    /**内部接口**/
    private static void sort(Comparable[] a, int low, int high){
        if (low >= high){
            return;
        }
        int j = partition(a, low, high);
        sort(a, low, j-1);
        sort(a, j+1, high);
    }

    /**外部接口**/
    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a, 0, a.length -1);
    }

    /** test */
    public static void main(String[] arg){
        Integer[] a = {1, 4, 5, 2, 6, 11, 8, 123, 12, 14, 31, 3, 51, 77, 888, 91};
        sort(a);
        assert isSorted(a);
        show(a);
    }

}
