import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        AbakumovaList<Integer> abakumovaList = new AbakumovaList<>(3);

        abakumovaList.add(90);
        abakumovaList.add(11);
        abakumovaList.add(22);
        abakumovaList.add(33);
        abakumovaList.add(44);

       Integer[] a=new Integer[2];
        var res=abakumovaList.toArray();
        for (int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }

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
