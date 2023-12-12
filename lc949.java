public class lc949 {
    int max_time = -1;
    public String largestTimeFromDigits(int[] arr) {
        this.max_time = -1;
        helper(arr, 0);
        if (this.max_time == -1) return "";
        else {
            return String.format("%02d:%02d", max_time / 60, max_time % 60);
        }
    }

    private void helper(int[] arr, int start) {
        if (start == arr.length) {
            this.build_time(arr);
            return;
        }
        for (int i = start; i < arr.length; i++) {
            this.swap(arr, start, i);
            this.helper(arr, start + 1);
            this.swap(arr, start, i);
        }
    }

    private void swap(int[] arr, int start, int i) {
        int temp = arr[start];
        arr[start] = arr[i];
        arr[i] = temp;
    }

    private void build_time(int[] arr) {
        int hour = arr[0] * 10 + arr[1];
        int minute = arr[2] * 10 + arr[3];
        if (hour < 24 && minute < 60) {
            this.max_time = Math.max(this.max_time, hour * 60 + minute);
        }
    }
}
