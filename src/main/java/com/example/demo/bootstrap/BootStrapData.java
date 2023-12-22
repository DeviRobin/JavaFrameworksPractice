package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (partRepository.count()==0) {
            OutsourcedPart lotion= new OutsourcedPart();
            lotion.setCompanyName("BLOOP");
            lotion.setName("Body Lotion");
            lotion.setInv(5);
            lotion.setPrice(25.0);
            lotion.setId(101L);
            lotion.setMinInv(5);
            lotion.setMaxInv(20);
            outsourcedPartRepository.save(lotion);

            OutsourcedPart sunCream= new OutsourcedPart();
            sunCream.setCompanyName("BLOOP");
            sunCream.setName("Sun Screen");
            sunCream.setInv(5);
            sunCream.setPrice(15.0);
            sunCream.setId(102L);
            sunCream.setMinInv(5);
            sunCream.setMaxInv(20);
            outsourcedPartRepository.save(sunCream);

            OutsourcedPart serum= new OutsourcedPart();
            serum.setCompanyName("FANCYSTUFF");
            serum.setName("Serum");
            serum.setInv(5);
            serum.setPrice(50.0);
            serum.setId(103L);
            serum.setMinInv(5);
            serum.setMaxInv(20);
            outsourcedPartRepository.save(serum);

            OutsourcedPart toner= new OutsourcedPart();
            toner.setCompanyName("MISHA");
            toner.setName("Toner");
            toner.setInv(5);
            toner.setPrice(10.0);
            toner.setId(104L);
            toner.setMinInv(5);
            toner.setMaxInv(20);
            outsourcedPartRepository.save(toner);

            OutsourcedPart nightCream= new OutsourcedPart();
            nightCream.setCompanyName("FANCYSTUFF");
            nightCream.setName("Night Cream");
            nightCream.setInv(5);
            nightCream.setPrice(25.0);
            nightCream.setId(105L);
            nightCream.setMinInv(5);
            nightCream.setMaxInv(20);
            outsourcedPartRepository.save(nightCream);

            OutsourcedPart dayCream= new OutsourcedPart();
            dayCream.setCompanyName("MISHA");
            dayCream.setName("Day Cream");
            dayCream.setInv(5);
            dayCream.setPrice(20.0);
            dayCream.setId(106L);
            dayCream.setMinInv(5);
            dayCream.setMaxInv(20);
            outsourcedPartRepository.save(dayCream);

            OutsourcedPart thePart=null;
            List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for(OutsourcedPart part:outsourcedParts){
                if(part.getName().equals("out test"))thePart=part;
            }
            System.out.println(thePart.getCompanyName());
        }
        else{
            List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for(OutsourcedPart part:outsourcedParts){
                System.out.println(part.getName()+" "+part.getCompanyName());
            }
        }



        if (productRepository.count()==0) {
            Product completeSetBox= new Product("Complete Set Box",100.0,15);
            productRepository.save(completeSetBox);

            Product dayTimeBox= new Product("Day Time Skin Care Box",75.0,15);
            productRepository.save(dayTimeBox);

            Product nightTimeBox= new Product("Night Time Skin Care Box",75.0,15);
            productRepository.save(nightTimeBox);

            Product winterBox= new Product("Winter Season Box",75.0,15);
            productRepository.save(winterBox);

            Product summerBox= new Product("Summer Season Box",75.0,15);
            productRepository.save(summerBox);
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products: "+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts: "+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
