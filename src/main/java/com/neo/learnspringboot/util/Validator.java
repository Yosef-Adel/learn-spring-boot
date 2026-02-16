package com.neo.learnspringboot.util;

import java.util.Objects;

public abstract class Validator<T> {

    private Validator<T> next;

    public Validator<T> chain(Validator<T> next) {
        if (Objects.isNull(this.next)) {
            this.next = next;
            return next;
        }
        Validator<T> chain = this.next;
        while (Objects.nonNull(chain.next)) {
            chain = chain.next;
        }
        chain.next = next;
        return chain;
    }

    public abstract boolean check(T data);

    public boolean checkNext(T data) {
        if (Objects.isNull(next)) {
            return true;
        }
        return next.check(data);
    }

}
