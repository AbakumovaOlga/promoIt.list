import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        AbakumovaList<Car> abakumovaList = new AbakumovaList<>(3);

        abakumovaList.add(new Car(1990, "Ferrari 360 Spider", 310));
        abakumovaList.add(new Car(20012, "Lamborghini Gallardo", 290));
        abakumovaList.add(new Car(2010, "Bugatti Veyron", 350));

      // Integer[] a=new Integer[2];
        Comparator maxSpeedCarComparator=new MaxSpeedCarComparator();
        abakumovaList.sort(maxSpeedCarComparator);
//        for (int i=0;i<res.length;i++){
//            System.out.println(res[i]);
//        }

        printList(abakumovaList);

    }

    public static void printList(List abakumovaList) {
        System.out.print("AbakumovaList ("+abakumovaList.size()+") = ");
        for (int i = 0; i < abakumovaList.size(); i++) {
            System.out.print(abakumovaList.get(i) + ", ");
        }
        System.out.println();
    }
}
