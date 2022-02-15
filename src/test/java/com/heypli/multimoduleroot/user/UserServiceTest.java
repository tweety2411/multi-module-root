package com.heypli.multimoduleroot.user;


import com.heypli.repo.domain.User;
import com.heypli.repo.repository.UserRepository;
import com.heypli.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserServiceTest {

    @MockBean
    private UserRepository repository;

    @InjectMocks
    private UserService userService = new UserService(this.repository);

    @Test
    public void findAllUser() {

        User user = new User("Test", "22@naver.com");

        // repository에서 리턴할 값 지정
        given(repository.findAll()).willReturn(List.of(user));

        // when
        List<User> list = userService.findAll();

        // then
        Assertions.assertEquals(1, list.size());
        Assertions.assertEquals(user.getName(), list.get(0).getName());

    }

    @Test
    public void addUser() {

        User user = new User("Test", "aa@naver.com");

        given(repository.save(user)).willReturn(user);

        User savedUser = userService.setUser(user);

        Assertions.assertNotNull(savedUser);

        assertThat(savedUser.getName(), is("Test"));
    }
}
