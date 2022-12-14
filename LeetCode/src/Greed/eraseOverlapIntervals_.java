package Greed;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Dylan
 * @version 1.0
 * @date 2022/12/10 13:40
 * @description 给定一个区间的集合 intervals ，其中 intervals[i] = [starti, endi] 。
 * 返回 需要移除区间的最小数量，使剩余区间互不重叠 。
 *
 * 435. 无重叠区间
 **/
public class eraseOverlapIntervals_ {

    public int eraseOverlapIntervals(int[][] intervals) {
        //根据起点排序
        Arrays.sort(intervals,(a,b)->{
                return a[1]-b[1];
        });
        int count=1;
        int end=intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(end<=intervals[i][0]){
                end=intervals[i][1];
                count++;
            }
        }
        return intervals.length-count;

    }
}
