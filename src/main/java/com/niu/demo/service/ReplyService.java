package com.niu.demo.service;

import com.niu.demo.entity.Reply;
import com.niu.demo.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReplyService {
    @Autowired
    private ReplyRepository replyRepository;


    public Reply addReply(Reply reply) {
        return replyRepository.save(reply);
    }
}