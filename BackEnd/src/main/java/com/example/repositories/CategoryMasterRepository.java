package com.example.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import jakarta.transaction.Transactional;
import com.example.entity.CategoryMaster;

@Repository
@Transactional
public interface CategoryMasterRepository extends JpaRepository<CategoryMaster,Integer>
{
	@Query(value = "SELECT * FROM Category_Master where sub_cat_id =:cat_id", nativeQuery = true)
    public List<CategoryMaster> findBycatId(@Param("cat_id") String catId);
    
    public List<CategoryMaster> findBysubCatId(String subCatId);
    
    @Query(value = "SELECT cat_Id FROM Category_Master GROUP BY cat_Id", nativeQuery = true)
    public List<String> findAllDistinctCatIds(); 
    
    @Query(value = "SELECT sub_cat_id FROM Category_Master GROUP BY sub_cat_id", nativeQuery = true)
    public List<String> findAllDistinctsubCatIds(); 
    
    @Query(value = "SELECT flag from Category_master where cat_id=:cat_id", nativeQuery = true)
    public String getflag(@Param("cat_id")String catId); 
    
}
