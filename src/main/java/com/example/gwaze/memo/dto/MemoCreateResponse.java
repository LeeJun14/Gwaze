package com.example.gwaze.memo.dto;

import lombok.Getter;

@Getter
public class MemoCreateResponse {

    private final Long memoId;
    private final String text;

    public MemoCreateResponse(Long memoId, String text) {
        this.memoId = memoId;
        this.text = text;
    }
}
