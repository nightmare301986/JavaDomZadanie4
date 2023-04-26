/*Реализуйте очередь с помощью LinkedList со следующими методами:
enqueue() - помещает элемент в конец очереди,
dequeue() - возвращает первый элемент из очереди и удаляет его,
first() - возвращает первый элемент из очереди, не удаляя. */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Queue1 {
    public static void main(String[] args) {                                //Формирование и вывод очереди (на основе массива)
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(7, 15, 45, 30, 50, 16, 11));
        System.out.println("Очередь queue: ");
        System.out.println(queue);
        System.out.println();
        System.out.println("Введите число для добавления в очередь: ");
        Scanner sc = new Scanner(System.in);
        int qq = sc.nextInt();
        
        enqueue(queue, qq);
        System.out.println("Очередь после добавления нового элемента (метод enqueue): ");
        System.out.println(queue);
        System.out.println();
        System.out.println("Первый элемент очереди queue равен (метод dequeue): ");
        System.out.println(dequeue(queue));
        System.out.println("Очередь после удаления первого элемента (метод dequeue): ");
        System.out.println(queue);
        System.out.println();
        System.out.println("Первый элемент очереди queue равен (метод first): ");
        System.out.println(first(queue));
        System.out.println("Очередь queue (метод first): ");
        System.out.println(queue);
        sc.close();
    }

    public static void enqueue(Queue<Integer> queue, int qq) {             //Операция добавления элемента в очередь (в конец)
        Queue<Integer> queue1 = queue;
        queue1.add(qq);
    }

     public static int dequeue(Queue<Integer> queue) {                    //Операция нахождения 1-го элемента в очереди и его удаления
        Queue<Integer> queue1 = queue;             
        int firstElement = queue1.element(); 
        queue1.remove(firstElement);
        return firstElement;
    }
    public static int first(Queue<Integer> queue) {                       //Операция нахождения 1-го элемента в очереди
        Queue<Integer> queue1 = queue;
        int firstElement = queue1.element(); 
        return firstElement;
    }
}
