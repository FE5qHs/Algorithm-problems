class MedianFinder {
    /** initialize your data structure here. */
    private int[] arr;
    
    public MedianFinder() {
        arr = new int[0];
    }
    
    public void addNum(int num) {
        int[] newArr = new int[arr.length + 1];
        if (0 == arr.length) {
            newArr[0] = num;
        } else {
            boolean isInsert = false;
            for (int i = 0, j = 0; i < arr.length; ++i, ++j) {
                if (arr[i] > num && !isInsert) {
                    newArr[j] = num;
                    ++j;
                    isInsert = true;
                }
                newArr[j] = arr[i];
            }
            if (arr[arr.length - 1] < num) {
                newArr[newArr.length - 1] = num;
            }
        }
        arr = newArr;
    }
    
    public double findMedian() {
        if (arr.length % 2 == 0) {
            return (double)(arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;
        } else {
            return arr[arr.length / 2];
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */