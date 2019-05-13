package collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class LinnearList implements java.util.List {
    private Object[] objects;
    private int count = 0;
    private int sizeIncrement = 10;

    public LinnearList() {
        objects = new Object[sizeIncrement];
        count = 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < count; ++i) {
            if (objects[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[count];
        for (int i = 0; i < count; ++i) {
            arr[i] = objects[i];
        }
        return arr;
    }

    @Override
    public Object[] toArray(Object[] a) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(Object o) {
        if (count == objects.length) {
            Object[] newArray = new Object[objects.length + sizeIncrement];
            for (int i = 0; i < count; ++i) {
                newArray[i] = objects[i];
            }
            newArray[count] = o;
            this.objects = newArray;
        } else {
            objects[count] = o;
        }

        count++;

        return true;
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object get(int index) {
        if (index < count && index >= 0) {
            return objects[index];
        } else {
            throw new ArrayIndexOutOfBoundsException("Index is out of array bounds.");
        }
    }

    @Override
    public Object set(int index, Object element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, Object element) {
        if (index < count) {
            if (count < objects.length) {
                for (int i = count; i > index; --i) {
                    objects[i] = objects[i - 1];
                }
                objects[index] = element;
                count++;
            } else {
                Object[] newArray = new Object[objects.length + sizeIncrement];
                for (int i = 0; i < index; ++i) {
                    newArray[i] = objects[i];
                }
                for (int i = index + 1; i < count + 1; ++i) {
                    newArray[i] = objects[i - 1];
                }
                newArray[index] = element;
                count++;
                this.objects = newArray;
            }
        } else {
            add(element);
        }
        return;

    }

    @Override
    public Object remove(int index) {
        if (index < count && index >= 0) {
            Object removingObject = objects[index];
            for (int i = index + 1; i < count; ++i) {
                objects[i - 1] = objects[i];
            }

            count--;

            return removingObject;
        } else {
            throw new ArrayIndexOutOfBoundsException("Index is out of array bounds.");
        }
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator listIterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ListIterator listIterator(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }
}