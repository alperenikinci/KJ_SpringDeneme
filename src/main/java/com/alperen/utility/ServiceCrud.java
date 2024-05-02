package com.alperen.utility;

import java.util.List;
import java.util.Optional;

public interface ServiceCrud<T, ID> {

    List<T> findAll();
    T save (T t);
    T update (T t);
    void delete (T t);
    void deleteById(ID id);
    Optional<T> findById(ID id);

}
