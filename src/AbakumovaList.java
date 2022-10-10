import java.util.*;
import java.util.function.Consumer;

public class AbakumovaList<T>
        implements List<T> , AuthorHolder{

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
        for (int i=0; i<size;i++) {
            if (list[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    @Override
    public Object[] toArray() {
        Object[] result=new Object[size];
        for (int i=0; i<size; i++){
            result[i]=list[i];
        }
        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T1> T1[] toArray(T1[] a) {
        //TODO
        if(a.length>=size){
            for (int i=0; i<size;i++){
                a[i]=(T1) list[i];
            }
            if(a.length>size){
                a[size]=null;
            }
            return a;
        }
        else {
            Object[] result=  new Object[size];
            for (int i=0; i<size;i++){
                result[i]=(T1) list[i];
            }
            return (T1[]) result;
        }
    }

    @Override
    public boolean add(T t) {
        add(size, t);
        return true;
    }

    @Override
    public void add(int index, T element) {
        if (index > list.length - 1) {
            increaseLength();
        }
        for (int i=size; i>index; i--){
            list[i]=list[i-1];
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
            list[size - 1] = null;
            size--;
        } catch (Exception e) {
            //TODO Exception
            throw new RuntimeException(e);
        }
        return oldElement;
    }

    @Override
    public boolean containsAll(Collection<?> c) {

        for (var elementC : c
        ) {
            boolean containsElement = false;
            for (int i = 0; i < size; i++) {
                if (list[i].equals(elementC)) {
                    containsElement = true;
                }
            }
            if (!containsElement) return false;
        }
        return true;

    }

    @Override
    public boolean addAll(Collection<? extends T> c) {

        return addAll(size, c);
    }

    private void increaseLength() {

        Object[] list2 = new Object[list.length * 2 + 1];
        for (int i = 0; i < size; i++) {
            list2[i] = list[i];
        }
        list = list2;

    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        while(list.length-1<size+c.size()) increaseLength();
        for (int i=size+c.size(); i>=index+c.size(); i--){
            list[i]=list[i-c.size()];
        }
        for (var elementC : c
        ) {

            list[index] =elementC;
            size++;
            index++;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean result=false;
        for (var elementC: c
             ) {
            for(int i=0; i<size; i++){
                if(list[i].equals(elementC)){
                    remove(elementC);
                    result=true;
                }
            }
        }
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean result=false;
        AbakumovaList<T> removeList=new AbakumovaList<T>();
        for(int i=0; i<size; i++){
            if(!c.contains(list[i])){
                removeList.add((T) list[i]);
                result=true;
            }
        }
        removeAll(removeList);
        return result;

    }

    @Override
    public void sort(Comparator<? super T> c) {
        List.super.sort(c);
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            list[i] = null;
        }
        size = 0;
    }

    @Override
    public T get(int index) {
        //TODO exception
        return (T) list[index];
    }

    @Override
    public T set(int index, T element) {
        T oldElement= (T) list[index];
        list[index]=element;
        return oldElement;
    }


    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (list[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        //TODO
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        //TODO
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        if (fromIndex >= size || fromIndex < 0 || toIndex >= size || toIndex < 0) {
            try {
                //TODO Exception
                throw new Exception("fromIndex and toIndex should be  >=0 and <size");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        List<T> result = null;
        try {
            result = new AbakumovaList<>(toIndex - fromIndex);
            for (int i = fromIndex; i < toIndex; i++) {
                result.add((T) list[i]);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public String getAuthor() {
        return null;
    }


    private class Itr implements Iterator<T> {
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such
        int expectedModCount = size;

        // prevent creating a synthetic constructor
        Itr() {
        }

        public boolean hasNext() {
            return cursor != size;
        }

        @SuppressWarnings("unchecked")
        public T next() {
            checkForComodification();
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] elementData = AbakumovaList.this.list;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return (T) elementData[lastRet = i];
        }

        public void remove() {
            if (lastRet < 0)
                throw new IllegalStateException();
            checkForComodification();

            try {
                AbakumovaList.this.remove(lastRet);
                cursor = lastRet;
                lastRet = -1;
                expectedModCount = size;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public void forEachRemaining(Consumer<? super T> action) {
            Objects.requireNonNull(action);
            final int size = AbakumovaList.this.size;
            int i = cursor;
            if (i < size) {
                final Object[] es = list;
                if (i >= es.length)
                    throw new ConcurrentModificationException();
                for (; i < size && size == expectedModCount; i++)
                    action.accept(elementAt(es, i));
                // update once at end to reduce heap write traffic
                cursor = i;
                lastRet = i - 1;
                checkForComodification();
            }
        }

        final void checkForComodification() {
            if (size != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }

    @SuppressWarnings("unchecked")
    static <E> E elementAt(Object[] es, int index) {
        return (E) es[index];
    }

}
