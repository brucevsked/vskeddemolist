package com.jat.demo5;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository<T, ID>
 * 继承自extends PagingAndSortingRepository<T, ID>, QueryByExampleExecutor<T>
 */
public interface PersonRepository extends JpaRepository<PersonEntity,Long> {

    /**
     * <strong>特别注意！不要解开这片注释，本注释只为讲解JpaRepository提供哪些方法</strong>
     *    List<T> findAll(); 查询所有记录，返回一个集合
     *
     *     List<T> findAll(Sort var1); 根据排序查找记录，返回一个集合
     *
     *     List<T> findAllById(Iterable<ID> var1); 根据多个唯一标识查找记录，返回一个集合
     *
     *     <S extends T> List<S> saveAll(Iterable<S> var1); 保存多条记录
     *
     *     void flush(); 立即持久到库，如果同一事务中有其他方法不需要等待整个事务所有方法执行完成再提交事务
     *
     *     <S extends T> S saveAndFlush(S var1); 保存并立即持久到数据库,，如果同一事务中有其他方法不需要等待整个事务所有方法执行完成再提交事务
     *
     *     <S extends T> List<S> saveAllAndFlush(Iterable<S> var1);
     * 继承自PagingAndSortingRepository方法:
     *     Iterable<T> findAll(Sort var1); 根据排序返回一个实体集合
     *     Page<T> findAll(Pageable var1); 根据分页返回一个分页后集合
     *     <S extends T> S save(S var1); 保存方法,如果事务中有其他操作会等待其他方法执行完后整个事务一起提交<br>
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
     *
     * 继承自QueryByExampleExecutor方法:<br>
     *     <S extends T> Optional<S> findOne(Example<S> var1); 根据自定义条件查询一个对象<br>
     *     <S extends T> Iterable<S> findAll(Example<S> var1); 根据自定义条件查询集合<br>
     *     <S extends T> Iterable<S> findAll(Example<S> var1, Sort var2);根据自定义条件与排序查询集合<br>
     *     <S extends T> Page<S> findAll(Example<S> var1, Pageable var2);根据自定义条件与分页查询集合<br>
     *     <S extends T> long count(Example<S> var1); 根据自定义条件查询数量<br>
     *     <S extends T> boolean exists(Example<S> var1);根据自定义条件查询是否存在记录<br>
     */
}
