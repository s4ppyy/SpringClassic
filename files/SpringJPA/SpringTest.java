package ru.itmo.razrab;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.support.Repositories;
import ru.itmo.razrab.persistence.model.ColorCat;
import ru.itmo.razrab.persistence.repository.ColorCatRepository;
import ru.itmo.razrab.persistence.services.impl.ColorCatServiceImpl;

import java.util.Optional;

public class SpringTest {

    @Autowired
    ApplicationContext ctx=new ClassPathXmlApplicationContext("springDataConfig.xml");

    @Test
    public void testSpring() throws Exception {
        /*
        DriverManagerDataSource dtSource = ctx.getBean("dataSource", DriverManagerDataSource.class);
        EntityManagerFactory emf = (EntityManagerFactory)
                ctx.getBean("myEmf", javax.persistence.EntityManagerFactory.class);
        EntityManager em = emf.createEntityManager();
        System.out.println(em.isOpen());
        em.close();
        System.out.println(em.isOpen());
        */
        Repositories repositories = new Repositories(ctx);
        ColorCat colorCatWork = new ColorCat();

        ColorCatServiceImpl colorCatService = new ColorCatServiceImpl();
        colorCatService.colorCatRepository= (ColorCatRepository) repositories.getRepositoryFor(colorCatWork.getClass()).get();
	colorCatWork=colorCatService.findById(1l).get();
        System.out.println(colorCatWork);

        colorCatWork = colorCatService.findByNaim("Черная");
        System.out.println(colorCatWork);

        /*
        JpaRepository myRepo = (JpaRepository) repositories.getRepositoryFor(colorCatWork.getClass()).get();
        colorCatWork= (ColorCat) myRepo.getById(1l);
        System.out.println(colorCatWork);
*/

    }
}
