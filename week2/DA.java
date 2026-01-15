class DynamicArray {
    private int[] data;
    private int size;

    public DynamicArray(int length) {
        data = new int[length];
    }

    // Insert value (dynamic resize)
    public void insert(int value) {
        if (size == data.length) {
            int[] newData = new int[size * 2];
            for (int i = 0; i < size; i++)
                newData[i] = data[i];
            data = newData;
            System.out.println("Array resize : " + data.length);
        }
        data[size++] = value;
    }

    // Remove value at given index
    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Invalid index!");
            return;
        }

        for (int i = index; i < size - 1; i++)
            data[i] = data[i + 1];

        size--;
    }

    // Find index of value
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value)
                return i;
        }
        return -1;
    }

    // Print array elements
    public void print() {
        for (int i = 0; i < size; i++)
            System.out.print(data[i] + " ");
        System.out.println();
    }
}

public class DA {
    public static void main(String[] args) {
        DynamicArray arr = new DynamicArray(2);

        arr.insert(10);
        arr.insert(20);
        arr.insert(30); // resize hoga
        arr.insert(40);

        arr.print(); // 10 20 30 40


        arr.removeAt(1); // 20 remove
        System.out.printf("index is resize");
        arr.print(); // 10 30 40
        System.out.printf("Remove at index: ");
        System.out.println(arr.indexOf(30)); // output: 1
    }
}
