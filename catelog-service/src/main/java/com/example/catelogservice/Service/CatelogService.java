package com.example.catelogservice.Service;

import com.example.catelogservice.Model.CatelogModel;
import com.example.catelogservice.Repository.CatelogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CatelogService implements CatelogPrint{

    @Autowired
    private CatelogRepository repo;

    public CatelogModel addProduct(CatelogModel catelog)
    {
        return repo.save(catelog);
    }

    public Iterable<CatelogModel> findall() {
        return repo.findAll();
    }

    public CatelogModel findById(Integer id)
    {
        return repo.findById(id).orElse(null);
    }

    public Iterable<CatelogModel> findByPName(String PName)
    {
        return repo.findByPName(PName);
    }

    public String[] getPNamesByDietary(String Dietary)
    {
        List<CatelogModel> list = repo.getPNamesByDietary(Dietary);
        String[] arr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            // Assuming CatelogModel has a method to get the desired string property, e.g., getName()
            arr[i] = list.get(i).getPName(); // Replace getName() with the actual method to retrieve the string
        }
        return arr;
    }

    public String[] getPNamesByCousin(String Cousin)
    {
        List<CatelogModel> list = repo.getPNamesByCousin(Cousin);
        String[] arr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            // Assuming CatelogModel has a method to get the desired string property, e.g., getName()
            arr[i] = list.get(i).getPName(); // Replace getName() with the actual method to retrieve the string
        }
        return arr;
    }

    public String[] getPNamesByAllergies(String Allergies)
    {
        List<CatelogModel> list = repo.getPNamesByAllergies(Allergies);
        String[] arr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            // Assuming CatelogModel has a method to get the desired string property, e.g., getName()
            arr[i] = list.get(i).getPName(); // Replace getName() with the actual method to retrieve the string
        }
        return arr;
    }

    public Iterable<CatelogModel> recommand(String Dietary,String Cousin,String Allergies)
    {
        Iterable<CatelogModel> rec=null;
        Iterable<CatelogModel> inlist=null;
        String[] alist =getPNamesByAllergies(Allergies);
        String[] byDietary =getPNamesByDietary(Dietary);
        String[] ByCousin =getPNamesByCousin(Cousin);
        Integer size=byDietary.length;
        Integer[] counter= new Integer[size];

        for(int i=0; i <size;i++)
       {
            for(int j=0; j <ByCousin.length;j++)
            {
                if(byDietary[i]==ByCousin[j])
                {
                    counter[i]=counter[i]+1;
                }
            }
            for(int l=0; l <alist.length;l++)
            {
                if(byDietary[i]==alist[l])
                {
                    counter[i]=counter[i]+1;
                }
            }
        }
        //covert iteraterble to list
        List<CatelogModel> modellist = new ArrayList<>();
        rec.forEach(modellist::add);

        for(int k=0;k<byDietary.length;k++)
        {
            if(counter[k]>=1)
            {
                inlist=findByPName(byDietary[k]);
                List<CatelogModel> model1 = new ArrayList<>();
                inlist.forEach(model1::add);
                modellist.add((CatelogModel) inlist);
            }
        }

        Iterable<CatelogModel> recnew = modellist;
        return rec;
    }
    public void delete (CatelogModel catelog)
    {
        repo.delete(catelog);
    }

}
