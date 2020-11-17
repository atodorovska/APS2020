package class01;

import given.LinkedQueue;
import given.LinkedStack;
import given.Queue;
import given.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CardTrick {
    public static int count(int N) {
        Queue<Integer> cards = new LinkedQueue<>();
        Stack<Integer> shuffle = new LinkedStack<>();

        for (int i = 1; i <= 51; i++) {
            cards.enqueue(i);
        }
        int totalShuffles = 0;

        while (cards.peek() != N) {

            for (int i = 0; i < 7; i++) {
                shuffle.push(cards.dequeue());
            }

            while (!shuffle.isEmpty()) {
                cards.enqueue(shuffle.pop());
                cards.enqueue(cards.dequeue());
            }
            totalShuffles++;
        }
        return totalShuffles;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(count(Integer.parseInt(br.readLine())));
    }
}
