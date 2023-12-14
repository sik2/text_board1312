package org.example.member;

import org.example.Global;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    public int join (String userId, String password) {
        String sql = String.format("INSERT INTO member SET userId='%s', password='%s', regDate = now();", userId, password);

        int id = Global.getDBConnection().insert(sql);

        return id;
    }

    public Member memberFindByUserId (String userId) {
        List<Member> memberList = this.findByAll();

        for (Member member : memberList) {
            if (userId.equals(member.getUserId())) {
                return member;
            }
        }
        return null;
    }

    public Member memberFindById(int id) {
        List<Member> memberList = this.findByAll();

        for (Member member : memberList) {
            if (id == member.getId()) {
                return member;
            }
        }
        return null;
    }

    public List<Member> findByAll() {
        List<Member> memberList = new ArrayList<>();

        String sql = "select * from `member`;";

        List<Map<String, Object>> rows = Global.getDBConnection().selectRows(sql);

        for (Map<String, Object> row : rows) {
            Member member = new Member(row);
            memberList.add(member);
        }
        return memberList;
    }
}
