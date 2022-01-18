package com.dtarasiuk.module3.repository;

import java.util.List;

public interface IGenericRepository<T, ID>{
    T getByID(ID id);
    List<T> getAll();
    T save(T t);
    T update(T t);
    void deleteById(ID id);
}
