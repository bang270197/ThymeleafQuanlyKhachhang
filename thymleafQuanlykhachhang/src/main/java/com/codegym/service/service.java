package com.codegym.service;

import java.util.ArrayList;

public interface service<E> {
    ArrayList<E> findAll();

    E findById(int id);

    E findByName(String name);

    void save(E e);

    void edit (E e);

    void remove(int id);
}
