
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class DynamicArrayImpl {

    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        dynamicArray.push(1);
        dynamicArray.push(2);
        dynamicArray.push(10, 10);
        dynamicArray.push(11);
        System.out.println(dynamicArray.toString());
    }

}

class DynamicArray {

    private int arr[];
    private int capacity;
    private int current;

    DynamicArray() {
        arr = new int[1];
        capacity = 1;
        current = 0;
    }

    @Override
    public String toString () {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }

    public void push(int data) {
        if (current == capacity) {
            int temp[] = new int[2 * capacity];

            for (int i=0; i < capacity; i++) {
                temp[i] = arr[i];
            }
            capacity*=2;
            arr = temp;
        }
        arr[current] = data;
        current++;
    }

    public void push(int index, int data) {
        if(index == capacity) {
            push(data);
        } else if (index < capacity) {
            arr[index] = data;
        } else {
            int temp[] = new int[index+1];
            for(int i=0; i<current; i++) {
                temp[i] = arr[i];
            }
            capacity = index+1;
            arr = temp;
            arr[index] = data;
            current = index+1;
        }
    }

    int get(int index) {
        if(index < current) {
            return arr[index];
        } else {
            return -1;
        }
    }

    void pop() {
        current--;
    }

    int length() {
        return current;
    }

    int getCapacity() {
        return capacity;
    }

    void print() {
        for(int i=0; i < current; i++) {
            System.out.println(arr[i]);
        }
    }

}
























