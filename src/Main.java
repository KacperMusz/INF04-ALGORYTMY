import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        System.out.println("Sortowanie bąbelkowe:");
        System.out.println(Arrays.toString(sortBabelkowe(randList())));
        System.out.println(sortBabelkowe(randArr()));
        System.out.println("\nSortowanie przez wybor(Selection sort)");
        System.out.println(Arrays.toString(selectionSort(randList())));
        System.out.println(selectionSort(randArr()));
        System.out.println("\nSortowanie przez wstawianie (insertion sort)");
        System.out.println(Arrays.toString(insertionSort(randList())));
        System.out.println(insertionSort(randArr()));
    }
    //metoda Generowania losowych liczb w liscie
    static int[] randList(){
        int[] list = new int[20];
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            list[i] = (random.nextInt(99) +1);
        }
        return  list;
    }
    //Metoda Generowania losowych liczb w ArrayList
    static List<Integer> randArr(){
        Random random = new Random();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i, (random.nextInt(99) + 1));
        }
        return list;
    }
    //Sortowanie Bąbelkowe
    static int[] sortBabelkowe(int[] list){
        for(int i = 0; i < list.length; i++){
            for (int j = 0; j < list.length - i -1; j++) {
                if (list[j] > list[j+1]){
                    int temp = list[j];
                    list[j] = list[j+1];
                    list[j+1] = temp;
                }
            }
        }
        return list;
    }
    static List<Integer> sortBabelkowe(List<Integer> list){
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() -i - 1; j++) {
                if (list.get(j) > list.get(j+1)){
                    int temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
        return list;
    }

    //Sortowanie przez wybor (Selection sort)
    static int[] selectionSort(int[] list){
        int min;
        for (int i = 0; i < list.length; i++) {
            min= i;
            for (int j = i; j < list.length; j++){
                if (list[j] < list[min]){
                    min = j;
                }
            }
            int temp = list[i];
            list[i] = list[min];
            list[min] = temp;
        }
        return list;
    }
    static List<Integer> selectionSort(List<Integer> list){
        int min;
        for (int i = 0; i < list.size(); i++) {
            min = i;
            for (int j = i; j < list.size(); j++) {
                if (list.get(j) < list.get(min)){
                    min = j;
                }
            }
            int temp = list.get(i);
            list.set(i, list.get(min));
            list.set(min, temp);
        }
        return list;
    }
    //Sortowanie przez wstawianie(Insertion Sort)
    static int[] insertionSort(int[] list){
        for (int i = 0; i < list.length; i++){
            int key = list[i];
            int j = i -1;

            while (j >= 0 && list[j] > key){
                list[j + 1] = list[j];
                j = j-1;
            }
            list[j+1] = key;
        }

        return list;
    }
    static List<Integer> insertionSort(List<Integer> list){
        for (int i = 0; i < list.size(); i++) {
            int key = list.get(i);
            int j = i-1;
            while (j >=0 && list.get(j) > key){
                list.set(j+1, list.get(j));
                j = j -1;
            }
            list.set(j+1, key);
        }
        return list;
    }
}