package bai.javatest4.model;


public class Page {
    private int pageSize;
    private int page;
    private String sort = "ASC";

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageSize=" + pageSize +
                ", page=" + page +
                ", sort='" + sort + '\'' +
                '}';
    }
}
