package cz.jiripinkas.jba.service.impl;


import cz.jiripinkas.jba.entity2.Category;
import cz.jiripinkas.jba.repository.CategoryRepository;
import cz.jiripinkas.jba.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * @author tangzhiqiang
 */
@Service
public class CategoryServiceImpl implements CategoryService {



  //  private CategoryRepository categoryRepository;
    @Autowired
   // @Qualifier("CategoryRepository")
    private CategoryRepository categoryRepository;



    @Override
    public boolean isCategoryExisted(String catdir) {
        List<Category> catList=new LinkedList<>() ;
      //  List<Category> catList=categoryRepository.findBycatdir(catdir);
        if(null!=catList&&!catList.isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public Category addCategory(Category cat) {
      return  categoryRepository.save(cat);
    }

    @Override
    public Category findById(String id) {
        Optional<Category> optional=categoryRepository.findById(Long.parseLong(id));
        return optional.isPresent()?optional.get():null;
    }

    /**
     * 注意：这里Page的页码是从0开始，所以取值需要传递过来的页码减去1
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Override
    public Page<Category> findByPage(int pageNo, int pageSize) {
      //  Sort sort = Sort.by(Sort.Direction.DESC, "createat");
        Sort sort = new Sort(Sort.Direction.DESC, "createat");
        PageRequest request= new PageRequest(pageNo-1, pageSize, sort);
       // Pageable pageable =PageRequest.of(pageNo-1, pageSize, sort);
        Pageable pageable =request.first();
        return categoryRepository.findAll(pageable);
    }

    @Override
    public List<Category> findAll() {
        return (List<Category>)categoryRepository.findAll();
    }

    @Override
    public Category updateById(Category cat, String id) {
        Category catInDB=findById(id);
        if(null==catInDB){
            return null;
        }
        cat.setId(Long.parseLong(id));
        /*
        if(catInDB.getCreateAt()==null){
            cat.setCreateAt((java.sql.Date) new Date());
        }
        else {
            cat.setCreateAt(  catInDB.getCreateAt());
        }
*/
        return categoryRepository.save(cat);
    }

    @Override
    public void deleteCategory(String id) {
        categoryRepository.deleteById(id);
    }
}
