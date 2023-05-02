package com.istad.thymeleafwebapp.repositories;

import com.istad.thymeleafwebapp.models.Article;
import com.istad.thymeleafwebapp.models.Author;
import com.istad.thymeleafwebapp.models.Category;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
@Getter
public class StaticRepository {

    private List<Article> articles;
    private List<Author> authors;
    private List<Category> categories;
    private Faker faker;

    @Autowired
    public void setFaker(Faker faker) {
        this.faker = faker;
    }

    @PostConstruct
    void init() {
        Author author = new Author(
                1, "MuyleangIng",
                "Muyleanging", "male",
                "muyleanging@gmail.com",
                "ISTAD",
                "https://robohash.org/cupiditatererumquos.png",
                "/resources/img/default/article.jpg"
        );

        authors = new ArrayList<>(){{
            add(author);
            add(new Author(
                    2, "Shi No Shi Ke",
                    "ShiNoShiKe", "male",
                    "muyleanging@gmail.com",
                    "ISTAD",
                    "https://robohash.org/laboriosamfacilisrem.png",
                    "https://i.pinimg.com/originals/af/97/98/af979833dc3c10cec2d84d6f3b0a212f.png"
            ));

            add(new Author(
                    3, "Nothing to Know me",
                    "Terrill", "male",
                    "muyleanging@gmail.com",
                    "ISTAD",
                    "https://robohash.org/facilisdignissimosdolore.png",
                    "/resources/img/default/article.jpg"
            ));

        }};

        categories = new ArrayList<>(){{
            for (int i = 1; i < 10; i++){
                add(new Category(i,faker.job().title(), faker.color().hex()));
            }
        }};
        Random random = new Random();
        articles = new ArrayList<>() {{

            for (int i = 0; i < 10; i++) {

                add(
                        new Article(
                                UUID.randomUUID(),
                                faker.book().title(),
                                "/resources/img/default/article"+ (i%2==0?"2":"") +".jpg",
                                authors.get(random.nextInt(authors.size())),
                                faker.lorem().paragraphs(10).toString(),
                                categories.stream().filter(cat->cat.getId().equals(random.nextInt(categories.size())))
                                        .collect(Collectors.toList())
                        )
                );
            }
        }};

    }
}
