package class01;

import given.DLL;
import given.DLLNode;

import java.util.Scanner;

public class DLLPalindromeTest {

    public static int isPalindrome(DLL<Integer> list) {
        DLLNode<Integer> first = list.getFirst();
        DLLNode<Integer> last = list.getLast();

        while (first != null && last != null && first != last) {
            if (!first.getElement().equals(last.getElement())) return -1;
            first = first.getSucc();
            last = last.getPred();
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        DLL<Integer> list = new DLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(in.nextInt());
        }
        in.close();
        System.out.println(isPalindrome(list));
    }
}
