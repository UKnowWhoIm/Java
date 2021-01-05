import java.util.Scanner;

public class QuickSort {
    static int partition(String arr[], int low, int high) { 
        String pivot = arr[high];  
        int i = (low-1); 
        for (int j=low; j<high; j++){ 
            if (arr[j].compareTo(pivot) < 0){ 
                i++; 
                String temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 

        String temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
    
    static void sort(String arr[], int low, int high){ 
        if (low < high) 
        { 
            int pi = partition(arr, low, high); 
            sort(arr, low, pi-1); 
            sort(arr, pi+1, high); 
        } 
    } 

    static void printArray(String arr[], int n) 
    { 
        System.out.println();
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" ");
    } 

    static int readArray(String arr[]){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size: ");
        int n = scanner.nextInt();
        System.out.print("Enter elements: ");
        for(int i=0; i<n; i++)
            arr[i] = scanner.next();
        
        scanner.close();
        return n;
    }

    static void quickSortHelper(){
        String arr[] = new String[100];
        int n = readArray(arr);
        sort(arr, 0, n-1);
        printArray(arr, n);
    }

    public static void main(String[] args) {
       quickSortHelper();
    }
  
}
