import java.util.Scanner;

public class BinarySearch {
    static int binarySearch(int arr[], int x, int l, int r){
        if(l > r)
            return -1;
        int mid = (l + r) / 2;
        if(x < arr[mid])
            return binarySearch(arr, x, l, mid - 1);
        if(x > arr[mid])
            return binarySearch(arr, x, mid + 1, r);
        return mid;
    }

    static int readArray(int[] arr, Scanner scanner){
        System.out.print("Enter size of array: ");
        
        int n = scanner.nextInt();
        System.out.print("Enter elements: ");
        for(int i=0; i<n; i++)
            arr[i] = scanner.nextInt();    
        
        return n;
    }

    static void binarySearchHelper(Scanner scanner){
        int[] arr = new int[100];
        int n = readArray(arr, scanner);
       
        
        System.out.print("Enter element to be searched: ");
        int x = scanner.nextInt();
        int search = binarySearch(arr, x, 0, n-1);
        
        if(search == -1)
            System.out.println("\nElement not found");
        else
            System.out.printf("\nElement found at %dth index\n", search);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        binarySearchHelper(scanner);
        scanner.close();
    }
}
