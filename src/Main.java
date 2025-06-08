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
        System.out.println("\nSilnia");
        System.out.println(silnia(5));
        System.out.println("\nFibonaci");
        System.out.println(fibonaci(20));
        System.out.println("\nNWD za pomoca alg.Euklidesa");
        System.out.println(nwd(42,56));
        System.out.println("\nNWW");
        System.out.println(nww(42,56));
        System.out.println("\nWyszukiwanie Liniowe");
        int czyZnaleziono = wyszukiwanieLiniowe(randList(), 10);
        if (czyZnaleziono == -1){
            System.out.println("Nie znaleziono liczby");
        }else{
            System.out.println("znaleziono liczbe na pozycji: " + czyZnaleziono);
        }

        int[] tab = {1,2,3,4,5,6,7,8};
        System.out.println("\nWyszukiwanie Binarne " + wyszukiwanieBinarne(tab, 7));
        System.out.println("\nCzy liczba jest pierwsza");
        System.out.println(czyPierwsza(96));

        System.out.println("\nOdwracanie tablicy");

        System.out.println(Arrays.toString(odwracanie(tab)));

        System.out.println("\nZliczanie Wystepowania danej liczby: 4. Liczba wystapien:"+ liczWystepowanie(randList(),4));
        System.out.println("\nZnajdowanie najmniejszej liczby: " + znajdzMin(randList()));
        System.out.println("\nznajdowanie najwiekszej liczby" + znajdzMax(randList()));
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

    //silnia
    static int silnia(int n){

        for (int i = n - 1; i > 1; i--) {
            n = n * i;
        }
        return n;
        /*int result = 1;
        for (int i = 1; i <= n; i++) {
            n = n * i;
        }
        return result;*/
    }

    //fibonaci
    static int fibonaci(int n){
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonaci(n - 1) + fibonaci(n - 2);
    }
    //nwd alg.Euklidesa
    static int nwd(int n, int k){
        while (k != 0){
            int c = n % k;
            n = k;
            k = c;
        }
        return n;
    }
    //nww
    static int nww(int n, int k){
        return (n * k)/nwd(n,k);
    }
    //Wyszukiwanie liniowe
    static int wyszukiwanieLiniowe(int[] tab, int szukanaLiczba){
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == szukanaLiczba){
                return i;
            }
        }
        return -1;
    }
    //Wyszukiwanie Binarne
    static int wyszukiwanieBinarne(int[] tab, int szukanaLiczba){
        //tablica musi byc posortowana!!
        int l = 0;
        int p = tab.length - 1;
        while (l <= p){
            int mid = l + (p - l)/2;
            if (szukanaLiczba == tab[mid]){
                return mid;
            } else if (szukanaLiczba > tab[mid]) {
                l = mid +1;
            } else if (szukanaLiczba < tab[mid]) {
                p = mid -1;
            }

        }
        return -1;
    }
    //Sprawdzanie czy liczba jest liczba pierwszą
    static boolean czyPierwsza(int a){
        if (a < 1){
            return false;
        }
        for (int i = 2; i < a; i++) {
            if (a % i == 0){
                return false;
            }
        }
        return true;
    }
    //Odwracanie tablicy
    static int[] odwracanie(int[] tab){
        for (int i = 0; i < tab.length/2; i++) {
            int temp = tab[tab.length-i-1];
            tab[tab.length-i-1] = tab[i];
            tab[i] = temp;
        }
        return tab;
    }
    //Zliczanie wystepowania danej liczby w tablicy
    static int liczWystepowanie(int[] tab, int x){
        int licznik = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] == x){
                licznik ++;
            }
        }
        return licznik;
    }

    //Znajdz Max
    static int znajdzMax(int[] tab){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < tab.length; i++) {
            if (max < tab[i]){
                max = tab[i];
            }
        }
        return max;
    }
    //Znajdz Min
    static int znajdzMin(int[] tab){
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < tab.length; i++) {
            if (min > tab[i]){
                min = tab[i];
            }
        }
        return min;
    }
}