public class Main {
    public static void main(String[] args) throws Exception {
        AbakumovaList<Integer> abakumovaList = new AbakumovaList<>(3);
        System.out.println("abakumovaList.size() = " + abakumovaList.size());
        abakumovaList.add(0);
        abakumovaList.add(11);
        abakumovaList.add(22);
        abakumovaList.add(33);
        abakumovaList.add(44);
        printList(abakumovaList);

        System.out.println(abakumovaList.remove(1));
        printList(abakumovaList);

        System.out.println(abakumovaList.remove(abakumovaList.get(2)));
        printList(abakumovaList);
    }

    public static void printList(AbakumovaList abakumovaList) {
        System.out.print("AbakumovaList ("+abakumovaList.size()+") = ");
        for (int i = 0; i < abakumovaList.size(); i++) {
            System.out.print(abakumovaList.get(i) + ", ");
        }
        System.out.println();
    }
}
