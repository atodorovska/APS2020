package class01;

import given.DLL;
import given.DLLNode;

import java.util.Scanner;

public class ListOfListsTest {
    public static long findMagicNumber(DLL<DLL<Integer>> list) {
        long product = 1;
        DLLNode<DLL<Integer>> outside = list.getFirst();

        while (outside != null) {
            DLLNode<Integer> inside = outside.getElement().getFirst();
            long sum = 0;

            while (inside != null) {
                sum += inside.getElement();
                inside = inside.getSucc();
            }
            product *= sum;
            outside = outside.getSucc();
        }
        return product;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        DLL<DLL<Integer>> list = new DLL<DLL<Integer>>();
        for (int i = 0; i < n; i++) {
            DLL<Integer> tmp = new DLL<Integer>();
            for (int j = 0; j < m; j++) {
                tmp.insertLast(in.nextInt());
            }
            list.insertLast(tmp);
        }
        in.close();
        System.out.println(findMagicNumber(list));
    }
}
