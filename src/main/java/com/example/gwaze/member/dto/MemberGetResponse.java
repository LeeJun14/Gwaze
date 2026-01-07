package com.example.gwaze.member.dto;

import lombok.Getter;

@Getter
public class MemberGetResponse {
    private final Long memberId;
    private final String memberName;

    public MemberGetResponse(Long memberId, String memberName) {
        this.memberId = memberId;
        this.memberName = memberName;
    }
}
