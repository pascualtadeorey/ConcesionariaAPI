package com.concesionaria.ms_vendedor.bootstrap;

import com.concesionaria.ms_vendedor.model.Seller;
import com.concesionaria.ms_vendedor.repository.SellerDAO;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;

@Configuration
public class BootstrapSeller {
    @Autowired
    private SellerDAO sellerDAO;

    @PostConstruct
    public void seed(){
        sellerDAO.save(new Seller("Pascual","Rey","121212",2L));
        sellerDAO.save(new Seller("Juan","Carlos","111111",2L));
        sellerDAO.save(new Seller("Facundo","Rodriguez","999999",3L));
    }
}
