package org.wangc.cs61b;

public class IntList {

    public int first;
    public IntList rest;

    public IntList(int n, IntList r) {
        this.first = n;
        this.rest = r;
    }

    /**
     * return the size of the list
     *
     * @return
     */
    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    /**
     *
     */
    public int iterativeSize() {
        int totalSize = 0;
        IntList p = this;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    public int get(int i) {
        if(i == 0){
            return this.first;
        } else {
            return this.rest.get(i-1);
        }

    }

    public static void main(String[] args) {
        IntList l = new IntList(15, null);
        l = new IntList(10, l);
        l = new IntList(5, l);

        System.out.println(l.size());
        System.out.println(l.iterativeSize());
        System.out.println(l.get(1));
    }


}
