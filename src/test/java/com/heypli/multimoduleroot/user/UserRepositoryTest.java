package com.heypli.multimoduleroot.user;

import com.heypli.repo.domain.User;
import com.heypli.repo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@EnableJpaRepositories(basePackages = "com.heypli.repo.repository")
@EntityScan(basePackages = "com.heypli.repo.domain")
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void addUser() {
        userRepository.save(new User("test", "at@naver.com"));
        Optional<User> saved = userRepository.findById(1L);
        if(saved.isPresent()) {
            assertThat(saved.get().getName(), is("test"));
        } else {
            System.out.println("test fail...");
        }
    }
}
