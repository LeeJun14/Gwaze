package com.example.gwaze.memo.dto;

import lombok.Getter;

@Getter
public class MemoCreateRequest {
    private Long memoId;
    private String text;
}
