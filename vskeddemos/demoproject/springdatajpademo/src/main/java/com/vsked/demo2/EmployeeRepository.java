package com.vsked.demo2;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *   PagingAndSortingRepository继承自CrudRepository,并新添加两个方法<br>
 *
 */
public interface EmployeeRepository extends PagingAndSortingRepository<EmployeeEntity,Long> {

    /**
     * <strong>特别注意！不要解开这片注释，本注释只为讲解PagingAndSortingRepository提供哪些方法</strong>
     * 新加方法1：Iterable<T> findAll(Sort var1); 根据排序返回一个实体集合
     *
     * 新加方法2 Page<T> findAll(Pageable var1); 根据分页返回一个分页后集合
     *
     * 继承自CrudRepository方法:
     *     <S extends T> S save(S var1); 保存方法<br>
     *     <S extends T> Iterable<S> saveAll(Iterable<S> var1); 保存一个集合<br>
     *     Optional<T> findById(ID var1); 根据主键查找<br>
     *     boolean existsById(ID var1); 唯一标识记录是否存在<br>
     *     Iterable<T> findAll(); 查找所有<br>
     *     Iterable<T> findAllById(Iterable<ID> var1); 根据多个唯一标识查找，多个唯一标识只要是可迭代集合即可如list,set<br>
     *     long count(); 数量<br>
     *     void deleteById(ID var1); 根据编号删除<br>
     *     void delete(T var1); 根据实体全部信息删除<br>
     *     void deleteAllById(Iterable<? extends ID> var1);根据多个唯一标识删除，多个唯一标识只要是可迭代集合即可如list,set<br>
     *     void deleteAll(Iterable<? extends T> var1);根据多个实体全部信息删除，多个实体全部信息只要是可迭代集合即可如list,set<br>
     *     void deleteAll(); 删除所有<br>
     */
}
