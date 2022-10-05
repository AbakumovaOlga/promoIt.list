import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        AbakumovaList<Integer> abakumovaList = new AbakumovaList<>(3);

        abakumovaList.add(90);
        abakumovaList.add(11);
        abakumovaList.add(22);
        abakumovaList.add(33);
        abakumovaList.add(44);

        AbakumovaList <Integer>  abakumovaList2 = new AbakumovaList<Integer> (2);


        abakumovaList2.add(88);
        abakumovaList2.add(54);
        abakumovaList2.add(77);

        System.out.println(abakumovaList.retainAll(abakumovaList2));
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
