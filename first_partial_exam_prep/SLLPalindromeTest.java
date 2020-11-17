package class01;

import given.SLL;
import given.SLLNode;

import java.util.Scanner;

public class SLLPalindromeTest {

    public static int isPalindrome(SLL<Integer> list){
        SLL<Integer> mirrorList = new SLL<>();
        SLLNode<Integer> tmp1 = list.getFirst();
        while (tmp1 != null) {
            mirrorList.insertLast(tmp1.getElement());
            tmp1 = tmp1.getSucc();
        }
        mirrorList.mirror();
        tmp1 = list.getFirst();
        SLLNode<Integer> tmp2 = mirrorList.getFirst();

        while (tmp1 != null && tmp2 != null) {
            if(!tmp1.getElement().equals(tmp2.getElement())) return -1;
            tmp1 = tmp1.getSucc();
            tmp2 = tmp2.getSucc();
        }
        return 1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        SLL<Integer> list = new SLL<Integer>();
        for (int i = 0; i < n; i++) {
            list.insertLast(in.nextInt());
        }
        in.close();
        System.out.println(isPalindrome(list));
    }
}
