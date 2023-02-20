package com.sandbox.jpademo.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

//@ExtendWith(SpringExtension.class)
//@ActiveProfiles("dev")
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DataJpaTest
public class BookEntityTest {

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void givenBookEntityRepository_whenSaveAndRetreiveEntity_thenOK(){
        BookEntity testBook = BookEntity.builder()
                .title("Dune")
                .price(34.55)
                .build();

        bookRepository.save(testBook);

        BookEntity foundBook = bookRepository.getReferenceById(testBook.getId());
        Assertions.assertNotNull(foundBook);
        Assertions.assertEquals(testBook, foundBook);

    }

}
