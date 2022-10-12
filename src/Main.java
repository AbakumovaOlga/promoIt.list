import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        AbakumovaList<Car> abakumovaList = new AbakumovaList<>(3);

        abakumovaList.add(new Car(1990, "Ferrari 360 Spider", 310));
        abakumovaList.add(new Car(20012, "Lamborghini Gallardo", 290));
        abakumovaList.add(new Car(2010, "Bugatti Veyron", 350));
        abakumovaList.add(new Car(2010, "22222Bugatti Veyron", 350));


        ArrayList<Car> arrayList = new ArrayList<>(3);

        arrayList.add(new Car(1990, "Ferrari 360 Spider", 310));
        arrayList.add(new Car(20012, "Lamborghini Gallardo", 290));
        arrayList.add(new Car(2010, "Bugatti Veyron", 350));
        arrayList.add(new Car(2010, "22222Bugatti Veyron", 350));


        ListIterator abakumovaIterator= abakumovaList.listIterator();
        ListIterator arrayIterator=arrayList.listIterator();

        System.out.println("hasNext");
        System.out.println(abakumovaIterator.hasNext());
        System.out.println(arrayIterator.hasNext());
        System.out.println("next0");
        System.out.println(abakumovaIterator.next());
        System.out.println(arrayIterator.next());
        System.out.println("next1");
        System.out.println(abakumovaIterator.next());
        System.out.println(arrayIterator.next());
        System.out.println("next2");
        System.out.println(abakumovaIterator.next());
        System.out.println(arrayIterator.next());
        System.out.println("next3");
        System.out.println(abakumovaIterator.next());
        System.out.println(arrayIterator.next());
        System.out.println("hasNext2");
        System.out.println(abakumovaIterator.hasNext());
        System.out.println(arrayIterator.hasNext());
        System.out.println("hasPrevious");
        System.out.println(abakumovaIterator.hasPrevious());
        System.out.println(arrayIterator.hasPrevious());
        System.out.println("previousIndex");
        System.out.println(abakumovaIterator.previousIndex());
        System.out.println(arrayIterator.previousIndex());
        System.out.println("previous");
        System.out.println(abakumovaIterator.previous());
        System.out.println(arrayIterator.previous());
        System.out.println("nextIndex");
        System.out.println(abakumovaIterator.nextIndex());
        System.out.println(arrayIterator.nextIndex());


       // printList(abakumovaList);

    }

    public static void printList(List abakumovaList) {
        System.out.println("AbakumovaList ("+abakumovaList.size()+") = ");
        Iterator iterator = abakumovaList.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next()+", ");
        }
        System.out.println();
    }
}
