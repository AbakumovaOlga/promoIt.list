import java.util.*;

public class AbakumovaList<T>
        implements List<T> {

    private Object[] list;
    private int size = 0;

    public AbakumovaList(int initialCapacity) throws Exception {
        try {
            list = new Object[initialCapacity];
        } catch (Exception e) {
            throw new Exception("the size must be greater than 0");
        }
    }

    public AbakumovaList() {
        list = new Object[]{};
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object o) {
        for (Object element : list
        ) {
            if (element.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        //TODO
        return null;
    }

    @Override
    public Object[] toArray() {
        //TODO
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        //TODO
        return null;
    }

    @Override
    public boolean add(T t) {
        add(size, t);
        return true;
    }

    @Override
    public void add(int index, T element) {
        if (index > list.length - 1) {
            Object[] list2 = new Object[list.length * 2 + 1];
            for (int i = 0; i < size; i++) {
                list2[i] = list[i];
            }
            list = list2;
        }
        list[index] = element;
        size++;
    }

    @Override
    public boolean remove(Object o) {
        remove(indexOf(o));
        return true;
    }

    @Override
    public T remove(int index) {
        T oldElement = (T) list[index];
        try {
            for (int i = index; i < size - 1; i++) {
                list[i] = list[i + 1];
            }
            list[size-1]=null;
            size--;
        } catch (Exception e) {
            //TODO Exception
            throw new RuntimeException(e);
        }
        return oldElement;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        for(int i=0; i<size; i++){
            list[i]=null;
        }
        size=0;
    }

    @Override
    public T get(int index) {
        //TODO exception
        return (T) list[index];
    }

    @Override
    public T set(int index, T element) {
        return null;
    }


    @Override
    public int indexOf(Object o) {
        for(int i=0; i<size; i++){
            if(list[i].equals(o)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
