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

            if (command.equals("종료")) {
                break;
            } else if (command.equals("등록")) {
                articleController.create();
            } else if (command.equals("목록")) {
                articleController.list();
            } else if (command.equals("삭제")) {
                articleController.delete();
            } else if (command.equals("수정")) {
                articleController.update();
            } else if (command.equals("회원가입")) {
                memberController.join();
            } else if (command.equals("로그인")) {
                memberController.login();
            } else if (command.equals("로그아웃")) {
                memberController.logout();
            }
        }
    }
}
