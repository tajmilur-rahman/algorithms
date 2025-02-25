package QuickSort;

public class KthSmallestNumber {

    int partition(int[] arr, int l, int r) {
        int i = l, j = r;
        int pivot = arr[l];

        while(i < j) {
            while (i <= arr.length - 1 && arr[i] <= pivot) i++;
            while (arr[j] > pivot) j--;
            if (i < j) swap(arr, i, j);
        }
        swap(arr, l, j);

        return j;
    }

    void swap(int[] array, int i, int j) {
        int swapSpot = array[i];
        array[i] = array[j];
        array[j] = swapSpot;
    }

    public int KSmall(int[] numbers, int l, int r, int k) {
        int p = partition(numbers, l, numbers.length-1);
        if(p==k) return numbers[k];
        if(k<p) return KSmall(numbers, l, p-1, k);
        else return KSmall(numbers, p+1, r, k);
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{7,10,4,3,20,15};
        int k = 1;
        KthSmallestNumber kthSmallestNumber = new KthSmallestNumber();
        System.out.println(kthSmallestNumber.KSmall(numbers, 0, numbers.length-1, k));
    }
}
