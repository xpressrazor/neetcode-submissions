class DynamicArray {
    int[] arr;
    int counter;
    int capacity;

    public DynamicArray(int capacity) {
        arr = new int[capacity];
        counter = 0;
        this.capacity = capacity;
    }

    public int get(int i) {
        return arr[i];
    }

    public void set(int i, int n) {
        arr[i] = n;
    }

    public void pushback(int n) {
        if (counter >= capacity) {
            resize();
        }
        arr[counter++] = n;
    }

    public int popback() {
        int val = arr[--counter];

        /*
        if (counter < (capacity / 2)) {
            capacity = capacity / 2;

            int[] newArr = new int[capacity];
            for (int i = 0; i < counter; i++) {
                newArr[i] = arr[i];
            }
        }
        */

        return val;
    }

    private void resize() {
        capacity = capacity * 2;
        int[] newArr = new int[capacity];

        for (int i = 0; i < counter; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
    }

    public int getSize() {
        return counter;
    }

    public int getCapacity() {
        return capacity;
    }
}
