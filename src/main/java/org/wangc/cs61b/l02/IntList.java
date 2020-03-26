package org.wangc.cs61b.l02;

public class IntList {

    public int first;
    public IntList rest;

    public IntList(int n, IntList r) {
        this.first = n;
        this.rest = r;
    }

    /**
     * 递归获取List的元素数目
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
     * 循环获取list的元素数目
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

    public int get(int position) {
        if (position == 0) {
            return this.first;
        } else {
            return this.rest.get(position - 1);
        }

    }

    public void add(int value) {
        if (this.rest == null) {
            this.rest = new IntList(value, null);
        } else {
            this.rest.add(value);
        }
    }

    public int smallest() {
        if (this.rest == null) {
            return this.first;
        } else {
            int next = this.rest.smallest();
            if (this.first <= next) {
                return this.first;
            } else {
                return next;
            }
        }
    }

    public int squaredSum() {
        if (this.rest == null) {
            return this.first * this.first;
        } else {
            return this.first * this.first + this.rest.squaredSum();
        }
    }

    /**
     * 连接两个IntList，其中A元素被改掉了
     *
     * @param a
     * @param b
     * @return
     */
    public static IntList dcatenate(IntList a, IntList b) {
        if (a == null) {
            return b;
        }
        a.rest = dcatenate(a.rest, b);
        return a;
    }

    public static IntList catenate(IntList a, IntList b) {
        if(a == null){
            return b;
        }
        return new IntList(a.first,catenate(a.rest,b));
    }

    @Override
    public String toString() {
        if (rest != null) {
            return "" + first + " " + rest;
        } else {
            return "" + first;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntList intList = (IntList) o;
        return first == intList.first &&
                com.google.common.base.Objects.equal(rest, intList.rest);
    }

    @Override
    public int hashCode() {
        return com.google.common.base.Objects.hashCode(first, rest);
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
