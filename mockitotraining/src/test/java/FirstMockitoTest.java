/**
 * Created by pawel on 2017-02-22.
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FirstMockitoTest {
    @Mock
    Database databaseMock;

    @Test
    public void testAddingBook() {
        BookShop bookShop = new BookShop(databaseMock);

        when(databaseMock.insert(anyString())).thenReturn(true);

        assertThat(bookShop.addBook("First Book", "Author 1")).isTrue();
        verify(databaseMock).insert(anyString());
    }

    @Test
    public void testGettingBookAuthor() {
        BookShop bookShop = new BookShop(databaseMock);

        when(databaseMock.select(anyString())).thenReturn(Arrays.asList(new String[]{"Author 2", "Author 3"}));

        assertThat(bookShop.getBookAuthor("Second Book")).isEqualTo("Author 2");
        verify(databaseMock).select(contains("Second Book"));
        verify(databaseMock, times(1)).select(anyString());
    }
}
