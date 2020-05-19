package DS.Learnbay.week1;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsetUsingRecursion(int[] arr) {
        List<List<Integer>> subsetList  = new ArrayList<>();
        generateSubsets(0, arr, new ArrayList<>(), subsetList);
        return subsetList;
    }

    public void generateSubsets(int index, int[] arr, List<Integer> current, List<List<Integer>> subsets) {
        subsets.add(new ArrayList<>(current));
        for(int i = index; i< arr.length; i ++) {
            current.add(arr[i]);
            generateSubsets(i + 1, arr, current, subsets);
            current.remove(current.size() - 1);
        }
    }


    public List<List<Integer>> subsetUsingIteration(int[] arr) {
        List<List<Integer>> subsetList  = new ArrayList<>();
        subsetList.add(new ArrayList<>());
        for (int i = 0; i < arr.length; i++) {
            List<Integer> firstList = new ArrayList<>();
            firstList.add(arr[i]);

            int size = subsetList.size();
            for(int j = 0; j < size; j++) {
                List<Integer> list = subsetList.get(j);
                if(!list.isEmpty()) {
                    List<Integer> newList = new ArrayList<>(list);
                    newList.add(arr[i]);
                    subsetList.add(newList);
                }
            }
            subsetList.add(firstList);

        }
        return subsetList;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3};
        Subsets subsets = new Subsets();
        for(List<Integer> list : subsets.subsetUsingRecursion(arr)) {
            System.out.println(list);
        }

    }
}
