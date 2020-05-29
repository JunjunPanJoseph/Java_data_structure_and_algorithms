package No01_SingleLinkedList;


public class Test {
    public static void main(String[] args) {
        System.out.println("Test - empty");
        SingleLinkedList<Integer> list = new SingleLinkedList<>();
        System.out.println(list);
        assert(list.size() == 0);
        list.insert(1);
        assert (list.size() == 1);
        assert (list.getHead() == 1);
        assert (list.getTail() == 1);
        list.insert(2);
        list.insert(3);
        assert (list.size() == 3);
        assert (list.getHead() == 1);
        assert (list.getTail() == 3);
        list.pop();
        assert (list.size() == 2);
        assert (list.getHead() == 2);
        System.out.println(list);

    }
}
