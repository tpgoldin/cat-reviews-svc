package com.tpg.cat.reviews;

public interface GivenWhenThen<T> extends And<T> {
    T given();
    T when();
    T then();
}
