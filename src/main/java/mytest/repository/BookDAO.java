package mytest.repository;

import io.micronaut.core.annotation.Introspected;
import io.micronaut.data.annotation.GeneratedValue;
import io.micronaut.data.annotation.Id;
import io.micronaut.data.annotation.MappedEntity;

/**
 * @Description
 * @ClassName BookDAO
 * @Author wangDi
 * @date 2021-03-23 17:10
 */
@Introspected
@MappedEntity(value="book")
public class BookDAO extends BaseDAO {
    private String title;

    private Long pages;

    private Long pageId;

    public BookDAO() {
    }

    public BookDAO(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPages() {
        return pages;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public Long getPageId() {
        return pageId;
    }

    public void setPageId(Long pageId) {
        this.pageId = pageId;
    }
}
