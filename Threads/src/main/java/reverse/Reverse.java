package reverse;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: Rajashekar
 * Date: 23/07/14
 * Time: 09:55
 * To change this template use File | Settings | File Templates.
 */
public class Reverse {

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3};//0,1,2
        String[] strings = {"one", "two", "three"};
        List<String> stringList = new ArrayList<String>();
        stringList.add("one");
        stringList.add("two");
        stringList.add("three");

        List<Integer> intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        System.out.println(reverseList(intList));

        Integer[] integers = new Integer[array.length];

        for (int j = 0; j < array.length; j++) {
            integers[j] = array[j];
        }
        System.out.println(reverseList(Arrays.asList(integers)));

        TreeMap<String, String> kvMap = new TreeMap<>();
        kvMap.put("1", "first");
        kvMap.put("2", "second");
        kvMap.put("3", "third");

       NavigableMap navigableMap =  kvMap.descendingMap();
        System.out.println(Arrays.toString(navigableMap.toString().toCharArray()));
//        int[] ints = reverseInt(array);
//        String[] strings1 = reverseStrings(strings);
//        System.out.println(Arrays.toString(ints));
//        System.out.println(Arrays.toString(strings1));

    }

    private static int[] reverseInt(int[] array) {
        int len = array.length - 1;
        int temp = 0;
        int k = 0;

        while (len > k) {
            temp = array[len];
            array[len] = array[k];
            array[k] = temp;
            len--;
            k++;
        }
        return array;
    }

    private static <T> T[] reverseStrings(final T[] strings) {
        int strLength = strings.length - 1;
        int start = 0;
        T tempObj = null;
        while (strLength > start) {
            tempObj = strings[strLength];
            strings[strLength] = strings[start];
            strings[start] = tempObj;

            strLength--;
            start++;
        }
        return strings;
    }

    private static <T> List<T> reverseList(List<T> list) {
        Collections.reverse(list);
        return list;
    }
}
