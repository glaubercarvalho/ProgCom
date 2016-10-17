package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

    public static EntityManagerFactory ConnectionFactory() {
        return Persistence.createEntityManagerFactory("trabalho-jpa");
    }

}
