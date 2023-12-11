package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("== 시스템 시작 ==");

        List<Member> memberList = new ArrayList<>();


        List<Article> articleList = new ArrayList<>();
        int lastId = 1;

        while (true) {
            System.out.printf("명령) ");
            String command = sc.nextLine().trim();

            if (command.equals("종료")) {
                break;
            } else if (command.equals("등록")) {
                System.out.printf("제목 : ");
                String title = sc.nextLine();
                System.out.printf("내용 : ");
                String content = sc.nextLine();

                Article article = new Article(lastId, title, content);
                articleList.add(article);

                lastId++;
            } else if (command.equals("목록")) {
                System.out.println("번호 / 제목 / 내용");
                System.out.println("-------------------");
                for (Article article : articleList) {
                    System.out.printf("%d,   %s,   %s\n", article.getId(), article.getTitle(), article.getContent());
                }
            } else if (command.equals("삭제")) {
                System.out.println("삭제할 id를 입력하세요.");
                System.out.printf("ID : ");
                int removeId = Integer.parseInt(sc.nextLine().trim());

                for (int i = 0; i < articleList.size(); i++) {
                    if (removeId == articleList.get(i).getId()) {
                        articleList.remove(i);
                    }
                }
                System.out.println(removeId + "번 게시글이 삭제 되었습니다.");
            } else if (command.equals("수정")) {
                System.out.println("수정할 id를 입력하세요.");
                System.out.printf("ID : ");
                int modifyId = Integer.parseInt(sc.nextLine().trim());

                for (int i = 0; i < articleList.size(); i++) {
                    if (modifyId == articleList.get(i).getId()) {
                        Article article = articleList.get(i);
                        System.out.printf("기존 제목 : %s \n", article.getTitle());
                        System.out.printf("수정할 제목 : ");
                        String title = sc.nextLine();
                        System.out.printf("기존 내용 : %s \n", article.getContent());
                        System.out.printf("수정할 내용 : ");
                        String content = sc.nextLine();

                        article.setTitle(title);
                        article.setContent(content);
                    }
                }
                System.out.println(modifyId + "번 게시글이 수정 되었습니다.");
            } else if (command.equals("회원가입")) {

                // 중복 아이디 검증
                while (true) {
                    System.out.printf("아이디 : ");
                    String userId = sc.nextLine().trim();
                    for (Member member : memberList) {
                        if (userId.equals(member.getUserId())) {
                            System.out.println("중복 아이디가 존재합니다.");
                            continue;
                        }
                    }
                    break;
                }

                // 비밀번호 확인 검증
                // 1. 비번 입력
                // 2. 비빌번호 확인
                // 3. 비번 != 확인 틀렸고 안내해주고 다시입력 받기
                
                
                Member member = new Member(1, "test", "1234", "123");
                memberList.add(member);
            }

        }

        sc.close();
    }
}