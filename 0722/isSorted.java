public class isSorted {
    
    public static boolean isSorted(int[] arr, int index) {
        // 如果檢查到最後一個元素，表示已排序完成
        if (index >= arr.length - 1) {
            return true;
        }

        // 如果當前比下一個大，表示不是升序
        if (arr[index] > arr[index + 1]) {
            return false;
        }

        // 繼續檢查下一組
        return isSorted(arr, index + 1);
    }

    public static void main(String[] args) {
        // 測試升序陣列
        int[] array1 = {1, 2, 3, 4, 5};
        System.out.println("Array1 is sorted? " + isSorted(array1, 0)); // true

        // 測試非升序陣列
        int[] array2 = {1, 3, 2, 4};
        System.out.println("Array2 is sorted? " + isSorted(array2, 0)); // false
    }
}
