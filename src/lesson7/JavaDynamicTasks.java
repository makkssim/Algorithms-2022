package lesson7;

import kotlin.NotImplementedError;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class JavaDynamicTasks {
    /**
     * Наибольшая общая подпоследовательность.
     * Средняя
     *
     * Дано две строки, например "nematode knowledge" и "empty bottle".
     * Найти их самую длинную общую подпоследовательность -- в примере это "emt ole".
     * Подпоследовательность отличается от подстроки тем, что её символы не обязаны идти подряд
     * (но по-прежнему должны быть расположены в исходной строке в том же порядке).
     * Если общей подпоследовательности нет, вернуть пустую строку.
     * Если есть несколько самых длинных общих подпоследовательностей, вернуть любую из них.
     * При сравнении подстрок, регистр символов *имеет* значение.
     */
    //трудоемкость  O(first.length()*second.length())
    //ресурсоемкость  O(first.length()*second.length())
    public static String longestCommonSubSequence(String first, String second) {
        if (first.equals("") || second.equals("")) return "";
        int[][] table = new int[first.length() + 1][second.length() + 1];
        for (int i = first.length() - 1; 0 <= i; i--) {
            for (int j = second.length() - 1; 0 <= j; j--) {
                if (first.charAt(i) == second.charAt(j)) table[i][j] = table[i + 1][j + 1] + 1;
                else table[i][j] = Math.max(table[i][j + 1], table[i + 1][j]);
            }
        }
        int i = 0;
        int j = 0;
        StringBuilder builder = new StringBuilder();
        while (i < first.length() && j < second.length()) {
            if (first.charAt(i) == second.charAt(j)) {
                builder.append(first.charAt(i));
                i++;
                j++;
            }
            else if (table[i][j + 1] > table[i + 1][j]) j++;
            else i++;
        }
        return builder.toString();
    }

    /**
     * Наибольшая возрастающая подпоследовательность
     * Сложная
     *
     * Дан список целых чисел, например, [2 8 5 9 12 6].
     * Найти в нём самую длинную возрастающую подпоследовательность.
     * Элементы подпоследовательности не обязаны идти подряд,
     * но должны быть расположены в исходном списке в том же порядке.
     * Если самых длинных возрастающих подпоследовательностей несколько (как в примере),
     * то вернуть ту, в которой числа расположены раньше (приоритет имеют первые числа).
     * В примере ответами являются 2, 8, 9, 12 или 2, 5, 9, 12 -- выбираем первую из них.
     */
    //трудоемкость  O(N^2)
    //ресурсоемкость  O(N)
    public static List<Integer> longestIncreasingSubSequence(List<Integer> list) {
        if (list.isEmpty()) return new ArrayList<>();
        int[] maxLength = new int[list.size()];
        int[] prev = new int[list.size()];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            prev[i] = -1;
            maxLength[i] = 1;
            for (int j = 0; j < i; j++) {
                if (list.get(i) > list.get(j) && maxLength[i] - 1 < maxLength[j]) {
                    maxLength[i] = maxLength[j] + 1;
                    prev[i] = j;
                }
            }
        }
        int pos = 0;
        int len = 0;
        for (int i = 0; i < list.size(); i++) {
            if (maxLength[i] > len) {
                pos = i;
                len = maxLength[i];
            }
        }
        while (pos != -1) {
            result.add(0, list.get(pos));
            pos = prev[pos];
        }
        return result;
    }

    /**
     * Самый короткий маршрут на прямоугольном поле.
     * Средняя
     *
     * В файле с именем inputName задано прямоугольное поле:
     *
     * 0 2 3 2 4 1
     * 1 5 3 4 6 2
     * 2 6 2 5 1 3
     * 1 4 3 2 6 2
     * 4 2 3 1 5 0
     *
     * Можно совершать шаги длиной в одну клетку вправо, вниз или по диагонали вправо-вниз.
     * В каждой клетке записано некоторое натуральное число или нуль.
     * Необходимо попасть из верхней левой клетки в правую нижнюю.
     * Вес маршрута вычисляется как сумма чисел со всех посещенных клеток.
     * Необходимо найти маршрут с минимальным весом и вернуть этот минимальный вес.
     *
     * Здесь ответ 2 + 3 + 4 + 1 + 2 = 12
     */
    public static int shortestPathOnField(String inputName) {
        throw new NotImplementedError();
    }
}
