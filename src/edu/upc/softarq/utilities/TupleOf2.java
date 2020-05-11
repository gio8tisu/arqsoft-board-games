package edu.upc.softarq.utilities;

import java.util.Objects;

public class TupleOf2<T1, T2> {
    private T1 first;
    private T2 second;

    public TupleOf2(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }

    public T2 getSecond() {
        return this.second;
    }

    public void setSecond(T2 second) {
        this.second = second;
    }

    public T1 getFirst() {
        return this.first;
    }

    public void setFirst(T1 first) {
        this.first = first;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (null == o || this.getClass() != o.getClass()) return false;
        TupleOf2<?, ?> tupleOf2 = (TupleOf2<?, ?>) o;
        return this.first.equals(tupleOf2.first) &&
                this.second.equals(tupleOf2.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.first, this.second);
    }
}
