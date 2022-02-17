import java.util.*;

public class Main {
    public static void main(String[] args) {
task3();
    }

    public static void task3() {
        Scanner scn = new Scanner(System.in);

        System.out.println("Enter n ");

//        int mainGridSize = 81;
//        int innerGridSize = 9;

        int smallSquare = scn.nextInt();


        List<List<Integer>> mainList = new ArrayList<List<Integer>>(smallSquare * smallSquare);

        List<Integer> innerList1 = new ArrayList<Integer>();
        ;

        innerList1.add(7);
        innerList1.add(8);
        innerList1.add(4);
        innerList1.add(1);
        innerList1.add(5);
        innerList1.add(9);
        innerList1.add(3);
        innerList1.add(2);
        innerList1.add(6);

        List<Integer> innerList2 = new ArrayList<Integer>();
        ;

        innerList2.add(5);
        innerList2.add(3);
        innerList2.add(9);
        innerList2.add(6);
        innerList2.add(7);
        innerList2.add(2);
        innerList2.add(8);
        innerList2.add(4);
        innerList2.add(1);

        List<Integer> innerList3 = new ArrayList<Integer>();
        ;

        innerList3.add(6);
        innerList3.add(1);
        innerList3.add(2);
        innerList3.add(4);
        innerList3.add(3);
        innerList3.add(8);
        innerList3.add(7);
        innerList3.add(5);
        innerList3.add(9);

        List<Integer> innerList4 = new ArrayList<Integer>();
        ;

        innerList4.add(9);
        innerList4.add(2);
        innerList4.add(8);
        innerList4.add(7);
        innerList4.add(1);
        innerList4.add(5);
        innerList4.add(4);
        innerList4.add(6);
        innerList4.add(3);

        List<Integer> innerList5 = new ArrayList<Integer>();
        ;

        innerList5.add(3);
        innerList5.add(5);
        innerList5.add(7);
        innerList5.add(8);
        innerList5.add(4);
        innerList5.add(6);
        innerList5.add(1);
        innerList5.add(9);
        innerList5.add(2);

        List<Integer> innerList6 = new ArrayList<Integer>();
        ;

        innerList6.add(4);
        innerList6.add(6);
        innerList6.add(1);
        innerList6.add(9);
        innerList6.add(2);
        innerList6.add(3);
        innerList6.add(5);
        innerList6.add(8);
        innerList6.add(7);

        List<Integer> innerList7 = new ArrayList<Integer>();
        ;

        innerList7.add(8);
        innerList7.add(7);
        innerList7.add(6);
        innerList7.add(3);
        innerList7.add(9);
        innerList7.add(4);
        innerList7.add(2);
        innerList7.add(1);
        innerList7.add(5);

        List<Integer> innerList8 = new ArrayList<Integer>();
        ;

        innerList8.add(2);
        innerList8.add(4);
        innerList8.add(3);
        innerList8.add(5);
        innerList8.add(6);
        innerList8.add(1);
        innerList8.add(9);
        innerList8.add(7);
        innerList8.add(8);

        List<Integer> innerList9 = new ArrayList<Integer>();
        ;

        innerList9.add(1);
        innerList9.add(9);
        innerList9.add(5);
        innerList9.add(2);
        innerList9.add(8);
        innerList9.add(7);
        innerList9.add(6);
        innerList9.add(3);
        innerList9.add(4);


        mainList.add(innerList1);
        mainList.add(innerList2);
        mainList.add(innerList3);
        mainList.add(innerList4);
        mainList.add(innerList5);
        mainList.add(innerList6);
        mainList.add(innerList7);
        mainList.add(innerList8);
        mainList.add(innerList9);

        iterateUsingIterator(mainList);

        if (isValidSudoku(mainList))
        {
            System.out.println("Valid");
        }
        else
        {
            System.out.println("Not Valid");
        }


    }


    public static void iterateUsingIterator(List<List<Integer>> mainList) {
        // Iterator for the 2D list

        Iterator listOfListsIterator
                = mainList.iterator();

        System.out.println("[");
        while (listOfListsIterator.hasNext()) {

            List<Integer> list = new ArrayList<Integer>();

            list = (List<Integer>) listOfListsIterator.next();

            Iterator eachListIterator
                    = list.iterator();

            System.out.print("  [");
            while (eachListIterator.hasNext()) {

                System.out.print(
                        "  "
                                + eachListIterator.next()
                                + ", ");
            }
            System.out.println("], ");
        }
        System.out.println("]");
    }

    public static boolean isInRange(List<List<Integer>> mainList) {

        // Масив дошки обходу [][]
        for (int i = 0; i < mainList.size(); i++) {
            for (int j = 0; j < mainList.get(i).size(); j++) {

                if (mainList.get(i).get(j) <= 0 ||
                        mainList.get(i).get(j) > 9) {
                    return false;
                }
            }
        }
        return true;

    }


    public static boolean isValidSudoku(List<List<Integer>> mainList) {

        // Перевіряємо, чи всі елементи дошки[][]
        // зберігає значення в діапазоні [1, 9]
        if (isInRange(mainList) == false) {
            return false;
        }

        // Зберігає унікальне значення
        // від 1 до N
        boolean[] unique = new boolean[mainList.size() + 1];

        // Пройти кожен рядок
        // заданий масив
        for (int i = 0; i < mainList.size(); i++) {

            // Ініціалізація унікального[]
            // масив до false
            Arrays.fill(unique, false);

            // Обхід кожного стовпця
            // поточного рядка
            for (int j = 0; j < mainList.get(i).size(); j++) {

                // Зберігає значення
                // дошки [i][j]
                int Z = mainList.get(i).get(j);

                // Перевірити, чи є поточний рядок
                // зберігає повторювані значення
                if (unique[Z]) {
                    return false;
                }
                unique[Z] = true;
            }
        }

        // Пройти кожен стовпець
        // заданий масив
        for (int i = 0; i < mainList.size(); i++) {

            // Ініціалізація унікального[]
            // масив до false
            Arrays.fill(unique, false);

            // Обхід кожного рядка
            // поточного стовпця
            for (int j = 0; j < mainList.get(i).size(); j++) {

                // Зберігає значення
                // дошки [j][i]
                int Z = mainList.get(i).get(j);

                // Перевірити, чи є поточний стовпець
                // зберігає повторювані значення
                if (unique[Z]) {
                    return false;
                }
                unique[Z] = true;
            }
        }

        // Пройти кожен блок
        // розмір 3 * 3 в масиві board[][]
        for (int i = 0; i < mainList.size() - 2; i += 3) {

            // j зберігає перший стовпець
            // кожен блок 3 * 3
            for (int j = 0; j < mainList.get(i).size() - 2; j += 3) {

                // Ініціалізація унікального[]
                // масив до false
                Arrays.fill(unique, false);

                // Блок переміщення струму
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {


// Зберігає номер рядка
                        // поточного блоку
                        int X = i + k;

                        // Зберігає номер стовпця
                        // поточного блоку
                        int Y = j + l;

                        // Зберігає значення
                        // дошки [X][Y]
                        int Z = mainList.get(X).get(Y);

                        // Перевірити, чи є поточний блок
                        // зберігає повторювані значення
                        if (unique[Z]) {
                            return false;
                        }
                        unique[Z] = true;
                    }
                }
            }
        }

        return true;


    }
}


