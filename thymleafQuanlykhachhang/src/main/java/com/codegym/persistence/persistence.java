package com.codegym.persistence;

import java.util.ArrayList;

public interface persistence<E> {
    ArrayList<E> findAll();

    E findById(int id);

    E findByName(String name);

    void save(E e);

    void edit(E e);

    void remove(int id);
}
