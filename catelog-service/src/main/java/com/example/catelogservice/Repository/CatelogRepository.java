package com.example.catelogservice.Repository;

import com.example.catelogservice.Model.CatelogModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CatelogRepository extends JpaRepository<CatelogModel,Integer> {
    Iterable<CatelogModel> findByPName(String PName);
    //List<String> getPNamesByDietary(String Dietary);
    //List<String> getPNamesByCousin(String Cousin);
    //List<String> getPNamesByAllergies(String Allergies);

    public List<CatelogModel> getPNamesByDietary(String dietary);
    public List<CatelogModel> getPNamesByCousin(String Cousin);
    public List<CatelogModel> getPNamesByAllergies(String Allergies);

}
