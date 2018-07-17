package leetcode.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 集合求交集
 */
public class CollectionsIntersection {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(10);
        list1.add(18);
        list1.add(8);
        list1.add(3);


        List<Integer> list2 = new ArrayList();
        list2.add(8);
        list2.add(3);
        list2.add(7);
        list2.add(23);

        List<Integer> sections = new ArrayList<>();
        List<Integer> largeList;
        List<Integer> target;
        if (list1.size() > list2.size()) {
            target = list2;
            largeList = list1;
        } else {
            target = list1;
            largeList = list2;
        }

        int size = target.size();
        for (int i = 0 ; i < size; i ++) {
            if (largeList.contains(target.get(i))) {
                sections.add(target.get(i));
            }
        }

        for (int i : sections) {
            System.out.print(i + " ");
        }

    }
}
