package mytest.repository;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

/**
 * @Description
 * @ClassName WriterDAO
 * @Author wangDi
 * @date 2021-03-23 16:24
 */
@Introspected
@MappedEntity(value="writer")
public class WriterDAO extends BaseDAO{


    private  long bookId;

    private String writerName;

    public WriterDAO() {
    }


    public long getBookId() {
        return bookId;
    }

    public void setBookId(long bookId) {
        this.bookId = bookId;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }
}
