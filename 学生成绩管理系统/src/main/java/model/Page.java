package model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;

@Getter
@Setter
@ToString
public class Page {
    private String searchText;//表格搜索内容
    private String sortOrder;//排序方式
    private Integer pageSize;//每页数量
    private Integer pageNumber;//当前第几页

    private Page() {}

    public static Page parse(HttpServletRequest req) {
        Page p = new Page();
        p.searchText = req.getParameter("searchText");
        p.sortOrder = req.getParameter("sortOrder");
        p.pageSize = Integer.parseInt(req.getParameter("pageSize"));
        p.pageNumber = Integer.parseInt(req.getParameter("pageNumber"));
        return p;
    }
}
