package org.example;

import org.example.article.ArticleController;
import org.example.member.MemberController;

public class App {

    ArticleController articleController;
    MemberController memberController;

    App () {
        articleController = new ArticleController();
        memberController = new MemberController();
    }

    public void run () {
        System.out.println("== 시스템 시작 ==");

        while (true) {
            System.out.printf("명령) ");
            String command = Global.getScanner().nextLine().trim();

            switch (command) {
                case "종료":
                    return;
                case "등록":
                    articleController.create();
                    break;
                case "목록":
                    articleController.list();
                    break;
                case "삭제":
                    articleController.delete();
                    break;
                case "수정":
                    articleController.update();
                    break;
                case "회원가입":
                    memberController.join();
                    break;
                case "로그인":
                    memberController.login();
                    break;
                case "로그아웃":
                    memberController.logout();
                    break;
            }
        }
    }
}
