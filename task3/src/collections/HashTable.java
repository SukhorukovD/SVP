package collections;

import java.util.ArrayList;
import java.util.List;

public class HashTable {

    private List<Object>[] itemsWithSameHashCode;
    private int size;
    private int count;

    public HashTable() {
        size = 199;
        count = 0;
        itemsWithSameHashCode = new List[size];
        for (int i = 0; i < size; ++i) {
            itemsWithSameHashCode[i] = new ArrayList<Object>();
        }
    }

    public int Size() {
        return count;
    }

    public Object add(Object addingObject) {
        int requiredKey = addingObject.hashCode() % size;

        for (int i = 0; i < itemsWithSameHashCode[requiredKey].size(); ++i) {
            if (itemsWithSameHashCode[requiredKey].get(i).equals(addingObject)) {
                throw new IllegalArgumentException("Object Duplication");
            }
        }

        itemsWithSameHashCode[requiredKey].add(addingObject);
        count++;
        return addingObject;
    }

    public Object remove(Object objectToRemove) {

        int requiredKey = objectToRemove.hashCode() % size;

        for (int i = 0; i < itemsWithSameHashCode[requiredKey].size(); ++i) {
            if (itemsWithSameHashCode[requiredKey].equals(objectToRemove)) {
                itemsWithSameHashCode[requiredKey].remove(objectToRemove);
                return objectToRemove;
            }
        }
        count--;
        throw new IllegalArgumentException("No such object in structure");
    }

    public boolean contains(Object objectToFind) {
        int requiredKey = objectToFind.hashCode() % size;

        for (int i = 0; i < itemsWithSameHashCode[requiredKey].size(); ++i) {
            if (itemsWithSameHashCode[requiredKey].equals(objectToFind)) {
                return true;
            }
        }

        return false;
    }

    public Object get(Object object) {
        for (int i = 0; i < this.itemsWithSameHashCode.length; ++i) {
            for (int j = 0; j < this.itemsWithSameHashCode[i].size(); ++j) {
                if (itemsWithSameHashCode[i].get(j).equals(object)) {
                    return itemsWithSameHashCode[i].get(j);
                }
            }
        }
        throw new IllegalArgumentException("No such object in structure");
    }

    public List<Object> toList() {
        List<Object> items = new ArrayList<Object>();
        for (int i = 0; i < this.itemsWithSameHashCode.length; ++i) {
            for (int j = 0; j < this.itemsWithSameHashCode[i].size(); ++j) {
                items.add(this.itemsWithSameHashCode[i].get(j));
            }
        }
        return items;
    }

    @Override
    public String toString() {

        String str = "HashTabel: \n";

        for (int i = 0; i < itemsWithSameHashCode.length; ++i) {
            for (int j = 0; j < itemsWithSameHashCode[i].size(); ++j) {
                str += itemsWithSameHashCode[i].get(j).toString() + " ";
                str += "\n";
            }
        }
        return str;
    }
}
