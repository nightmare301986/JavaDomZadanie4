//Пусть дан LinkedList с несколькими элементами. Реализуйте метод(не void), который вернет “перевернутый” список.
import java.util.Arrays;
import java.util.LinkedList;

public class LinkedL {
    public static void main(String[] args) {                                //Формирование и вывод массива (массивов)
        LinkedList<Object> list = new LinkedList<>(Arrays.asList(0, "aaa", 1, "a", 2, "ey"));
        System.out.println("Исходный массив");
        System.out.println(list);
        System.out.println();
        System.out.println("'Перевернутый' массив");
        System.out.println(ReverseL(list));
    }

    public static LinkedList<Object> ReverseL(LinkedList<Object> list) {    //Операция "переворачивания" массива
        LinkedList<Object> list_r = new LinkedList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            list_r.add(list.get(i));
        }
        return list_r;

    }

}
