package application;

import java.util.Date;
import java.util.List;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();
        
        System.out.println("==== TEST 1: seller findById ====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);
        
        System.out.println("\n==== TEST 2: seller findByDepartment ====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller s : list) {
            System.out.println(s);
        }
        
        System.out.println("\n==== TEST 3: seller findAll ====");
        list = sellerDao.findAll();
        for (Seller s : list) {
            System.out.println(s);
        }
        
        System.out.println("\n==== TEST 4: seller insert ====");
        Seller newSeller = new Seller(null, "Bill", "bill@gmail.com", new Date(), 3600.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());
        
        System.out.println("\n==== TEST 4: seller update ====");
        seller = sellerDao.findById(1);
        seller.setName("Tony Stark");
        seller.setBaseSalary(8000.0);
        sellerDao.update(seller);
        System.out.println("Update completed");
        
    }
}
