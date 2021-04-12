package mytest.repository;

import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;

/**
 * @Description
 * @ClassName BaseDAO
 * @Author wangDi
 * @date 2021-03-23 17:11
 */
public abstract class BaseDAO {

    @Id
    @GeneratedValue
    public long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
