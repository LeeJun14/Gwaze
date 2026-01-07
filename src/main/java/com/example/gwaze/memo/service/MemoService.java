package com.example.gwaze.memo.service;

import com.example.gwaze.member.entity.Member;
import com.example.gwaze.member.repository.MemberRepository;
import com.example.gwaze.memo.dto.MemoCreateRequest;
import com.example.gwaze.memo.dto.MemoCreateResponse;
import com.example.gwaze.memo.dto.MemoGetResponse;
import com.example.gwaze.memo.entity.Memo;
import com.example.gwaze.memo.repository.MemoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemoService {
    private final MemoRepository memoRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public MemoCreateResponse save(MemoCreateRequest request) {
        Member member = memberRepository.findById(request.getMemoId()).orElseThrow(
                () -> new IllegalArgumentException("없는 멤버입니다.")
        );
        Memo memo = new Memo(request.getText(), member);
        Memo memoSaved = memoRepository.save(memo);
        return new MemoCreateResponse(memoSaved.getMemoId(), memoSaved.getText());
    }

    @Transactional(readOnly = true)
    public MemoGetResponse findOne(Long memoId) {
        Memo memo = memoRepository.findById(memoId).orElseThrow(
                () -> new IllegalArgumentException("없는 메모입니다.")
        );
        Member member = memo.getMember();
        return new MemoGetResponse(memo.getMemoId(), memo.getText(), member.getMemberId(), member.getMemberName());
    }
}
