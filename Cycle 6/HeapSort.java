import java.util.Scanner;

public class HeapSort {
    static void swap(int[] arr, int a, int b){
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
    
    static void heapify(int[] arr, int n, int i){
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int largest = i;

        if(leftChild < n && arr[leftChild] > arr[i])
            largest = leftChild;
        if(rightChild < n && arr[rightChild] > arr[largest])
            largest = rightChild;
        
        if(largest != i){
            swap(arr, largest, i);
            heapify(arr, n, largest);
        }
    }

    static void heapSort(int[] arr, int n){
        for(int i=n/2 - 1; i>=0; i--)
            heapify(arr, n, i);
        
        for(int i=n-1; i>=0; i--){
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    static int readArray(int[] arr){
        System.out.print("Enter size of array: ");
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        System.out.print("Enter elements: ");
        for(int i=0; i<n; i++)
            arr[i] = scanner.nextInt();    
        
        scanner.close();
        return n;
    }

    static void printArray(int[] arr, int n){
        System.out.println();
        for(int i=0; i<n; i++)
            System.out.printf("%d ", arr[i]);
        System.out.println();
    }

    static void heapSortHelper(){
        int arr[] = new int[100];
        int n = readArray(arr);
        heapSort(arr, n);
        printArray(arr, n);
    }

    public static void main(String[] args) {
        heapSortHelper();
    }
}
