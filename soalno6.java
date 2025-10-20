import java.util.Scanner;

public class soalno6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] data = {1, 2, 3, 4, 5, 6};

        System.out.print("Masukkan jumlah rotasi (k): ");
        int k = scanner.nextInt();
        k = k % data.length;

        reverseArray(data, 0, data.length - 1);         
        reverseArray(data, 0, k - 1);                
        reverseArray(data, k, data.length - 1);       

        System.out.println("Array setelah rotasi:");
        for (int angka : data) {
            System.out.print(angka + " ");
        }
    }

    public static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
