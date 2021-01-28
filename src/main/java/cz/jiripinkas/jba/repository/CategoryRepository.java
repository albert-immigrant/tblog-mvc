package cz.jiripinkas.jba.repository;


import cz.jiripinkas.jba.entity2.Category;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

/**
 * 栏目文档操作类
 * @author tangzhiqiang
 */

@Repository
@Service
//public interface CategoryRepository extends PagingAndSortingRepository<Category,String> {
//public interface CategoryRepository extends PagingAndSortingRepository<Category,String> {
public interface CategoryRepository extends JpaRepository<Category,String> {

    /**
     * 目录名字必须唯一
     * @param catDir 栏目英文目录名称
     * @return
     */

    Category findByid(Long id);
   // List<Category> findByCatDir(String catDir);
   @Query("SELECT c From Category c Where c.catname like %:catname%")
    List<Category> findBycatname(@Param("catname") String Name);
    List<Category> findBycatdir(@Param("catname") String Name);


  //  List<Category> findBycatdir(String catdir);

//    Optional<Category> findById(long parseLong);
    Optional<Category> findById(long parseLong);
    @Query("DELETE Category AS c WHERE c.id=:id")
    void deleteById(@Param("id") String id);
}
