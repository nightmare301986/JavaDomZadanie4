/* В калькулятор добавьте возможность отменить последнюю операцию.
Пример
1
+
2
ответ:
3
+
4
ответ:
7
+
2
ответ:
9
Отмена -> 7
Отмена -> 3
+
2
Ответ 5
 */

import java.util.LinkedList;
import java.util.Scanner;

public class Calculator3 {
    public static void main(String[] args) throws Exception {
        LinkedList<Double> list = new LinkedList<>();
        Scanner in = new Scanner(System.in);                    //Прилашение ко вводу и т.п.
        int count = 0;
        int i = 0;
        double num1 = 0;
        double num2 = 0;
        char oper=' ';
        boolean stop = false;
        String line = "";
        while (!stop) {
            
            System.out.print("Для остановки программы введите слово 'stop'; или 'cancel' - для отмены последней операции(если это возможно); или нажмите enter для продожения; или для повторного ввода (по ситуации):   ");
            line = in.nextLine();
            if (line.equals("cancel")) {                        //Отмена, остановка работы (проверка возможности отмены)
                while (line.equals("cancel")&& i>0) {
                    list.remove(list.size() - 1);
                    System.out.print("Имеющиеся значения в памяти: ");
                    System.out.println(list);
                    System.out.printf("Отмена предыдущей операции, результат вычислений равен %.1f %n \n",
                    list.get(i - 1));
                    if (i==1){ System.out.println("Осталось одно значение в памяти, следующая операция 'отмена/cancel' невозможна"); 
                    System.out.print("Имеющиеся значения в памяти: ");
                    System.out.println(list);
                    System.out.println("Для остановки программы введите слово 'stop' или нажмите enter для продолжения"); i--;}
                    else {
                    i--;
                    System.out.println("Еще отменить? Введите cancel для отмены операции или нажмите enter для продолжения");}
                    line = in.nextLine();
                }
            }
            if (line.equals("stop")) {                          //Расчет первой вводимой операции 
                stop = true;
            } else {
                count += 1;
                if (count == 1) {
                    System.out.print("Введите число 1: ");
                    num1 = in.nextDouble();
                    System.out.print("Введите операцию (+,-,*,/): ");
                    oper = in.next().charAt(0);
                    System.out.print("Введите число 2: ");
                    num2 = in.nextInt();
                    if (oper == '/' && num2 == 0) {
                        System.out.printf("Делить на 0 НЕЛЬЗЯ!");
                        System.exit(1);
                    }
                } else {                                                   //Расчет последующих операций
                    System.out.print("Введите операцию (+,-,*,/): ");
                    oper = in.next().charAt(0);
                    System.out.print("Введите число 2: ");
                    num2 = in.nextInt();
                    if (oper == '/' && num2 == 0) {
                        System.out.printf("Делить на 0 НЕЛЬЗЯ!");
                        System.exit(1);
                    }

                }

                double result;
                // Реализация алгоритма расчета в ависимости от введенного знака операции
                switch (oper) {
                    case '+':
                        if (count == 1) {                          //Расчет первой вводимой операции 
                            result = num1 + num2;
                            list.add(result);
                        } else {                                   //Расчет последующих операций
                            result = list.get(i) + num2;
                            i++;
                            list.add(result);
                        }
                        System.out.printf("Результат введенной операции равен %.1f %n \n", result);
                        break;
                    case '-':
                        if (count == 1) {
                            result = num1 - num2;
                            list.add(result);
                        } else {
                            result = list.get(i) - num2;
                            i++;
                            list.add(result);
                        }
                        System.out.printf("Результат введенной операции равен %.1f %n \n", result);
                        break;
                    case '*':
                        if (count == 1) {
                            result = num1 * num2;
                            list.add(result);
                        } else {
                            result = list.get(i) * num2;
                            i++;
                            list.add(result);
                        }
                        System.out.printf("Результат введенной операции равен %.1f %n \n", result);
                        break;
                    case '/':
                        if (count == 1) {
                            result = num1 / num2;
                            list.add(result);
                        } else {
                            result = list.get(i) / num2;
                            i++;
                            list.add(result);
                        }
                        System.out.printf("Результат введенной операции равен %.1f %n \n", result);
                        break;
                    default:
                        System.out.printf(
                                "Такой операции нет в калькуляторе. ");
                        break;
                }
                line = in.nextLine();

            }

        }
        in.close();
        System.out.print("Имеющиеся значения в памяти: ");                     //Вывод значений хранящихся в "памяти" калькулятора
        System.out.println(list);
        System.out.println();
        //Вывод итогового значения
        System.out.printf("Результат всех операций равен %.1f %n \n", list.get(list.size()-1));
        
    }
}
