package com.example.CommandLineRunner.utility;

import com.example.CommandLineRunner.repo.BusinessIntegrityException;
import com.example.CommandLineRunner.repo.StoreRepo;
import com.example.CommandLineRunner.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Scanner;

@Component
public class StoreUtility {
    @Autowired
    StoreRepo storeRepo;
    @Autowired
    StoreService storeService;

    Scanner scanner = new Scanner(System.in);

    public void commandMethod() throws BusinessIntegrityException{

        boolean loop=true;
        while (loop) {
            System.out.println("...Please Enter Command Below...\n"
                    + "...ADD      => Add any item to database...\n"
                    + "...EDIT     => Edit any item from database...\n"
                    + "...DELETE   => Delete any item from database...\n"
                    + "...CHECKOUT => Checkout all item from database...\n"
                    + "...EXIT     => Exit from program...\n");
            storeService.checkOutItemList();
            storeService.checkoutListSize();
            String input = inputFromTerminal();
            if (input.equalsIgnoreCase("ADD")) {
                storeService.checkOutItemList();
                storeService.checkoutListSize();
                System.out.println("...Please Enter Item Name...\n");
                storeService.addItemtoDatabase(inputFromTerminal());
                continue;

            } else if (input.equalsIgnoreCase("EDIT")) {
                if(storeService.checkoutListSize().equals(false)){
                    continue;
                }else{
                storeService.checkOutItemList();
                System.out.println("...Please Enter Item Name...\n");
                storeService.editItemFromDatabase(inputFromTerminal());

                continue;
                }

            } else if (input.equalsIgnoreCase("DELETE")) {
                if(storeService.checkoutListSize().equals(false)){
                    continue;
                }else{
                storeService.checkOutItemList();
                System.out.println("...Please Enter Item Name...\n");
                storeService.deleteItemFromDatabase(inputFromTerminal());
                continue;
                }

            } else if (input.equalsIgnoreCase("CHECKOUT")) {
                if(storeService.checkoutListSize().equals(false)){
                    continue;
                }else{
                storeService.checkOutItemList();
                continue;
                }

            } else if(input.equalsIgnoreCase("EXIT")){
                storeService.checkOutItemList();
                storeService.checkoutListSize();
                System.out.println("...Exit from Program...\n");
                System.exit(0);
            } else {
                System.out.println("...Invalid command. Retry...\n");
                commandMethod();
            }
        }
    }

    public String inputFromTerminal() throws BusinessIntegrityException {
        String input = scanner.nextLine();
        return input;
    }

}
