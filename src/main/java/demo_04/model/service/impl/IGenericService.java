package demo_04.model.service.impl;

import org.springframework.data.domain.Page;

public interface IGenericService <T,E>{
    Page<T> findAll(String name,int page,int size);
    T findById(E id);
    void save(T t);
    void delete(E id);
}
