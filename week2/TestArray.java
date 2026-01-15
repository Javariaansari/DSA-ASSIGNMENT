class CustomArray {
    private int[] data;
    private int size;

    public CustomArray(int length) {
        data = new int[length];
    }
    public void insert(int value) {
        if (size == data.length) {
            System.out.println("Array is full: " + value);
            return;
        }
        data[size++] = value;
    }
    public void show() {
        for (int i = 0; i < size; i++)
            System.out.print(data[i] + " ");
        System.out.println();
    }
}
public class TestArray {
    public static void main(String[] args) {
        CustomArray marks = new CustomArray(4);

        marks.insert(5);
        marks.insert(15);
        marks.insert(25);
        marks.insert(35);
        marks.insert(45); // array full

        marks.show();
    }
}
