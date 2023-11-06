package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;
    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository = outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Add 5 parts using the provided format
       OutsourcedPart part1 = new OutsourcedPart();
        part1.setCompanyName("Western Governors University");
        part1.setName("Windows 10");
        part1.setInv(50);
        part1.setPrice(25.0);
        outsourcedPartRepository.save(part1);

        OutsourcedPart part2 = new OutsourcedPart();
        part2.setCompanyName("Western Governors University");
        part2.setName("Windows 11");
        part2.setInv(60);
        part2.setPrice(28.0);
        outsourcedPartRepository.save(part2);

        OutsourcedPart part3 = new OutsourcedPart();
        part3.setCompanyName("Western Governors University");
        part3.setName("Windows 12");
        part3.setInv(45);
        part3.setPrice(30.0);
        outsourcedPartRepository.save(part3);

        OutsourcedPart part4 = new OutsourcedPart();
        part4.setCompanyName("Western Governors University");
        part4.setName("Windows 13");
        part4.setInv(55);
        part4.setPrice(32.0);
        outsourcedPartRepository.save(part4);

        OutsourcedPart part5 = new OutsourcedPart();
        part5.setCompanyName("Western Governors University");
        part5.setName("Windows 15");
        part5.setInv(70);
        part5.setPrice(35.0);
        outsourcedPartRepository.save(part5);

        // Retrieve the part with name "Windows 10"
        OutsourcedPart thePart = null;
        List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for (OutsourcedPart part : outsourcedParts) {
            if (part.getName().equals("Windows 10")) {
                thePart = part;
                break;
            }
        }

        if (thePart != null) {
            System.out.println("Company Name: " + thePart.getCompanyName());
        } else {
            System.out.println("Part not found!");
        }

       Product Macbook= new Product("Macbook",100.0,15);
        Product Windows= new Product("Windows",100.0,15);
        Product MacbookPro= new Product("Macbook Pro",100.0,15);
        Product WindowsPro= new Product("Windows Pro",100.0,15);
        Product ThinkPad= new Product("ThinkPad",100.0,15);
        productRepository.save(Macbook);
        productRepository.save(Windows);
        productRepository.save(MacbookPro);
        productRepository.save(WindowsPro);
        productRepository.save(ThinkPad);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products: " + productRepository.count());
        System.out.println("Number of Parts: " + outsourcedPartRepository.count());
    }
}

