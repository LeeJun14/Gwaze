package com.example.gwaze.member.dto;

import lombok.Getter;

@Getter
public class MemberCreateResponse {
    private final Long memberId;
    private final String memberName;

    public MemberCreateResponse(Long memberId, String memberName) {
        this.memberId = memberId;
        this.memberName = memberName;
    }
}
