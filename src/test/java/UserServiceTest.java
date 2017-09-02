import com.User;
import com.UserDao;
import com.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;

public class UserServiceTest {

    UserDao userDao;

    User mockUser;

    UserService userService;

    @Before
    public void setUp() {
        userDao = Mockito.mock(UserDao.class);
        userService = new UserService(userDao);
        mockUser = new User();
        mockUser.setId(UUID.randomUUID().toString());
        mockUser.setFirstName("test");
        mockUser.setLastName("test");
        mockUser.setAge(40);
    }

    @Test
    public void testSave() throws Exception {
        //Using argument captor to test the values passed to the UserDao.save method
        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
        userService.save("bala", "samy", 35);
        Mockito.verify(userDao).save(userArgumentCaptor.capture());
        //Test the method called once
        Mockito.verify(userDao, times(1)).save(any());
        User storedUser = userArgumentCaptor.getValue();
        assertEquals("bala", storedUser.getFirstName());
        assertEquals("samy", storedUser.getLastName());
        assertEquals(35, storedUser.getAge());

    }

    @Test
    public void testGetUsingSpy() throws Exception {
        UserService userService = new UserService(userDao);
        UserService spy = Mockito.spy(userService);
        Mockito.when(spy.get(mockUser.getId())).thenReturn(mockUser);
        assertEquals(mockUser, spy.get(mockUser.getId()));
    }

    @Test
    public void testGetWithMock() throws Exception {
        Mockito.when(userDao.get(mockUser.getId())).thenReturn(mockUser);
        assertEquals(mockUser, userService.get(mockUser.getId()));
    }

    @Test
    public void testSaveWithMock() throws Exception {
        Mockito.when(userDao.save(any())).thenReturn(mockUser.getId());
        String value = userService.save(mockUser.getFirstName(), mockUser.getLastName(), mockUser.getAge());
        assertEquals(mockUser.getId(), value);
    }

    @Test
    public void testRemoveWithMock() throws Exception {
        Mockito.when(userDao.remove(any())).thenReturn(mockUser.getId());
        assertEquals(mockUser.getId(),userService.remove(mockUser.getId()));
    }

}
