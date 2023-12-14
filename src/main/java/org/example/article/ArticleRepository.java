package org.example.article;

import org.example.Global;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ArticleRepository {
    public int save (String title, String content) {
        String sql = String.format("INSERT INTO article SET title='%s', content='%s', memberId=%d, regDate=now();", title, content, Global.getLoginedMember().getId());

        int id = Global.getDBConnection().insert(sql);

        return id;
    }

    public List<Article> findByAll() {
        List<Article> articleList = new ArrayList<>();

        List<Map<String, Object>> rows =  Global.getDBConnection().selectRows("select * from article");

        for (Map<String, Object> row : rows) {
            Article article = new Article(row);

            articleList.add(article);
        }

        return articleList;
    }

    public void delete(Article article) {
        String sql = String.format("DELETE FROM article where id=%d;", article.getId());
        Global.getDBConnection().delete(sql);
    }

    public void update(Article article, String title, String content) {
        String sql = String.format("UPDATE article set title='%s', content='%s' where id=%d;", title, content, article.getId());

        Global.getDBConnection().update(sql);
    }

    public Article articleFindById(int id) {
        List<Article> articleList = this.findByAll();
        for (int i = 0; i < articleList.size(); i++) {
            if (id == articleList.get(i).getId()) {
                return articleList.get(i);
            }
        }
        return null;
    }
}
