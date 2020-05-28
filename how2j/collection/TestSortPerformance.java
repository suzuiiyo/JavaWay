package collection;

import java.util.List;

public class TestSortPerformance {
    public static void main(String[] args) {
        int[] arr = new int[400 * 1000];
        for(int i=0; i<arr.length; i++){
            arr[i] = (int)(Math.random()*100);
        }
        long t1 = System.currentTimeMillis();
        Node roots = new Node();
        for(int n : arr){
            roots.add(n);
        }
        List<Object> treeSortedArray = roots.values();
        long t2 = System.currentTimeMillis();
        System.out.printf("¶þ²æÊ÷ºÄÊ±:%d%n", t2 - t1);
        //System.out.println(treeSortedArray);
        
        System.out.println("************************");

        TestSortPerformance tsp = new TestSortPerformance();
        long t3 = System.currentTimeMillis();
        int[] arr2 = tsp.bubbleForeSort(arr);
        long t4 = System.currentTimeMillis();
        System.out.printf("Ç°ÏòÃ°ÅÝºÄÊ±:%d%n", t4 - t3);
        /*for(int f : arr2){
            System.out.print(f + " ");
        }*/

        System.out.println("************************");

        long t5 = System.currentTimeMillis();
        int[] arr3 = tsp.bubbleSort(arr);
        long t6 = System.currentTimeMillis();
        System.out.printf("Ã°ÅÝÅÅÐòºÄÊ±:%d%n", t6 - t5);
        /*for(int f : arr3){
            System.out.print(f + " ");
        }*/

        System.out.println("************************");

        long t7 = System.currentTimeMillis();
        int[] arr4 = tsp.chooseSort(arr);
        long t8 = System.currentTimeMillis();
        System.out.printf("Ñ¡ÔñÅÅÐòºÄÊ±:%d%n", t8- t7);
        /*for(int f : arr4){
            System.out.print(f + " ");
        }*/
    }

    public int[] bubbleForeSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){
                if(arr[j] < arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }

    public int[] bubbleSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    public int[] chooseSort(int[] arr){
        for(int i=0; i<arr.length; i++){
            int maxIndex = i;
            for(int j=i; j<arr.length; j++){
                if(arr[j] > arr[maxIndex]){
                    maxIndex = j;
                }
                int temp = arr[maxIndex];
                arr[maxIndex] = arr[j];
                arr[j] = temp;
            }
        }
        return arr;
    }
}