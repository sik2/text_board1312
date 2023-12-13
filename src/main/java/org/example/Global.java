package org.example;

import org.example.member.Member;

import java.time.LocalDate;
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

    public static String nowDateTime() {
        String now = LocalDate.now().toString();
        return now;
    }

}
