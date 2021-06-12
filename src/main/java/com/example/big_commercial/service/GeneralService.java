package com.example.big_commercial.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.Optional;

public interface GeneralService<T ,ID extends Serializable> {
    Page<T> findPaging(Pageable pageable);

    Iterable<T> findAll();

    Optional<T> findById(ID id);

    T save(T t);

    T update(ID id, T t);

    void remove(ID id);
}
