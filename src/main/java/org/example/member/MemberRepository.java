package org.example.member;

import org.example.Global;

public class MemberRepository {
    public MemberRepository () {
//        Member member1 = new Member(1, "user1", "1234", Global.nowDateTime());
//        memberList.add(member1);
//        Member member2 = new Member(2, "user2", "1234", Global.nowDateTime());
//        memberList.add(member2);
//        Member member3 = new Member(3, "user3", "1234", Global.nowDateTime());
//        memberList.add(member3);
    }

    public int join (String userId, String password) {
        String sql = String.format("INSERT INTO member SET userId='%s', password='%s', regDate = now();", userId, password);

        int id = Global.getDBConnection().insert(sql);

        return id;
    }

    public Member memberFindByUserId (String userId) {
//        for (Member member : memberList) {
//            if (userId.equals(member.getUserId())) {
//                return member;
//            }
//        }
        return null;
    }
}
