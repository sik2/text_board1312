package org.example.article;

import org.example.Global;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArticleController {
    List<Article> articleList = new ArrayList<>();
    int lastArticleId = 1;

    public void create () {
        if (Global.getLoginedMember() == null) {
            System.out.println("해당기능은 로그인 후 가능합니다.");
            return;
        }

        System.out.printf("제목 : ");
        String title = Global.getScanner().nextLine();
        System.out.printf("내용 : ");
        String content = Global.getScanner().nextLine();

        Article article = new Article(lastArticleId, title, content, Global.getLoginedMember().getUserId(), Global.nowDateTime());
        articleList.add(article);

        lastArticleId++;
    }
    public void list () {
        System.out.println("번호 / 제목 / 내용 / 작성자 / 등록일");
        System.out.println("--------------------------------------");
        for (Article article : articleList) {
            System.out.printf("%d,   %s,   %s,   %s,   %s\n", article.getId(), article.getTitle(), article.getContent(), article.getAuthor(), article.getRegDate());
        }
    }
    public void delete () {
        if (Global.getLoginedMember() == null) {
            System.out.println("해당기능은 로그인 후 가능합니다.");
            return;
        }

        System.out.println("삭제할 id를 입력하세요.");
        System.out.printf("ID : ");
        int removeId = Integer.parseInt(Global.getScanner().nextLine().trim());

        // 해당 article 객체 받아오기
        Article article = _articleFindById(removeId);

        if (article == null) {
            System.out.println("해당 게시글은 존재하지 않습니다.");
            return;
        }

        if (article.getAuthor() != Global.getLoginedMember().getUserId()) {
            System.out.println("해당 작성자만 삭제가 가능합니다.");
            return;
        }

        articleList.remove(article);

        System.out.println(removeId + "번 게시글이 삭제 되었습니다.");
    }
    public void update () {
        if (Global.getLoginedMember() == null) {
            System.out.println("해당기능은 로그인 후 가능합니다.");
            return;
        }

        System.out.println("수정할 id를 입력하세요.");
        System.out.printf("ID : ");
        int modifyId = Integer.parseInt(Global.getScanner().nextLine().trim());

        // 해당 article 객체 받아오기
        Article article = _articleFindById(modifyId);

        if (article == null) {
            System.out.println("해당 게시글은 존재하지 않습니다.");
            return;
        }

        if (article.getAuthor() != Global.getLoginedMember().getUserId()) {
            System.out.println("해당 작성자만 수정이 가능합니다.");
            return;
        }


        System.out.printf("기존 제목 : %s \n", article.getTitle());
        System.out.printf("수정할 제목 : ");
        String title = Global.getScanner().nextLine();
        System.out.printf("기존 내용 : %s \n", article.getContent());
        System.out.printf("수정할 내용 : ");
        String content = Global.getScanner().nextLine();

        article.setTitle(title);
        article.setContent(content);

        System.out.println(modifyId + "번 게시글이 수정 되었습니다.");
    }

    private Article _articleFindById(int id) {
        for (int i = 0; i < articleList.size(); i++) {
            if (id == articleList.get(i).getId()) {
                return articleList.get(i);
            }
        }
        return null;
    }
}
