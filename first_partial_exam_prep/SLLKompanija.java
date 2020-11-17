package class01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SLLNode {
    protected int id;
    protected int plata;
    protected SLLNode succ;

    public SLLNode(int id, int plata, SLLNode succ) {
        this.id = id;
        this.plata = plata;
        this.succ = succ;
    }
}

class SLL {
    private SLLNode first;

    public SLL() {
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            SLLNode tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;
    }

    public void insertFirst(int id, int plata) {
        SLLNode ins = new SLLNode(id, plata, first);
        first = ins;
    }

    public void insertLast(int id, int plata) {
        if (first != null) {
            SLLNode tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode ins = new SLLNode(id, plata, null);
            tmp.succ = ins;
        } else {
            insertFirst(id, plata);
        }
    }

    public SLLNode getFirst() {
        return first;
    }

    public SLL brisi_pomali_od(int iznos) {
        SLLNode node = this.first;
        SLLNode pred = this.first;

        while (node != null) {
            if (node.plata >= iznos) {
                pred = node;
                node = node.succ;
            } else {
                if (node == this.first) {
                    this.first = node.succ;
                    pred = this.first;
                    node = this.first;
                } else {
                    pred.succ = node.succ;
                    node = node.succ;
                }
            }
        }
        return this;
    }

    public SLL sortiraj_opagacki() {
        SLLNode node, tmp, pred1, pred2;

        for (int i = 0; i < this.length(); i++) {
            node = this.first.succ;
            pred1 = this.first;
            pred2 = this.first;

            while (node != null) {
                if (pred1.id < node.id) {
                    tmp = node.succ;
                    node.succ = pred1;
                    pred1.succ = tmp;

                    if (pred1 == this.first) {
                        this.first = node;
                    } else {
                        pred2.succ = node;
                    }
                    pred2 = node;
                    node = tmp;
                } else {
                    if (pred1 != this.first) {
                        pred2 = pred2.succ;
                    }
                    pred1 = pred1.succ;
                    node = node.succ;
                }
            }
        }
        return this;
    }

    public void pecati(SLL lista) {
        SLLNode p = lista.first;
        while (p != null) {
            System.out.println(p.id + " " + p.plata);
            p = p.succ;
        }
    }
}

public class SLLKompanija {
    public static void main(String[] args) throws IOException {
        SLL lista1 = new SLL();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);

        for (int i = 0; i < N; i++) {
            s = stdin.readLine();
            String s1 = stdin.readLine();
            lista1.insertLast(Integer.parseInt(s), Integer.parseInt(s1));
        }
        s = stdin.readLine();

        lista1 = lista1.brisi_pomali_od(Integer.parseInt(s));
        if (lista1 != null) {
            lista1 = lista1.sortiraj_opagacki();
            if (lista1.length() == 0) {
                System.out.println("nema");
                return;
            }
            lista1.pecati(lista1);
        }
    }
}
