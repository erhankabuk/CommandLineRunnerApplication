package com.example.CommandLineRunner.repo;

import com.example.CommandLineRunner.dao.CommandLineRunnerDAO;
import com.example.CommandLineRunner.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Objects;

@Repository
public class StoreRepo  {

    @Autowired
    CommandLineRunnerDAO commandLineRunnerDAO;

    public boolean isThisItemExist(String inputFromTerminal) throws BusinessIntegrityException {
        Store databaseInfo = commandLineRunnerDAO.findByName(inputFromTerminal);
        return Objects.nonNull(databaseInfo);
    }

    public void  addItem(String inputFromTerminal) throws BusinessIntegrityException {
        Store store = new Store();
        store.setName(inputFromTerminal);
        commandLineRunnerDAO.save(store);
    }

   public void deleteItem(String inputFromTerminal) throws BusinessIntegrityException{
        commandLineRunnerDAO.delete(commandLineRunnerDAO.findByName(inputFromTerminal));
   }

   public void editItem(String inputFromTerminal, String edittedItem) throws BusinessIntegrityException{
        Store store = commandLineRunnerDAO.findByName(inputFromTerminal);
        store.setName(edittedItem);
        commandLineRunnerDAO.save(store);
   }

    public void checkOutItem() throws BusinessIntegrityException {
       List<Store> itemList = commandLineRunnerDAO.findAll();
       for ( Store item: itemList) {
           System.out.println("- "+ item.getName());
       }
    }

    public Boolean listSize() throws BusinessIntegrityException {
        List<Store> itemList = commandLineRunnerDAO.findAll();
        if(!(itemList.size()>0)){
            return false;
        }
        return true;
    }

}





















