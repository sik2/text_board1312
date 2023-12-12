package org.example;

import lombok.Getter;
import lombok.Setter;
import org.example.member.Member;

import java.util.Scanner;

public class Global {
    private static Scanner scanner;
    private static Member loginedMember;

    public static void initScanner() {
        scanner = new Scanner(System.in);
    }

    public static void exitScanner() {
        scanner.close();
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static Member getLoginedMember() {
        return loginedMember;
    }

    public static void setLoginedMember(Member member) {
        loginedMember = member;
    }

}
