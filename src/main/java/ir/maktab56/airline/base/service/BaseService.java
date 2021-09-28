package ir.maktab56.airline.base.service;



import ir.maktab56.airline.base.domain.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseService<E extends BaseEntity<ID>
        , ID extends Serializable> {

    E save(E e);

    void delete(E e);

    E findById(ID id);

    List<E> findAll();

    boolean existById(ID id);
}
