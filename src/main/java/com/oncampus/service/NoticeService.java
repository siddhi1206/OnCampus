package com.oncampus.service;

import com.oncampus.model.Notice;
import com.oncampus.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeService {

    @Autowired
    private NoticeRepository noticeRepository;

    // CREATE
    public Notice createNotice(Notice notice) {
        return noticeRepository.save(notice);
    }

    // READ ALL
    public List<Notice> getAllNotices() {
        return noticeRepository.findAll();
    }

    // READ ONE
    public Notice getNoticeById(String id) {
        return noticeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notice not found"));
    }

    // UPDATE
    public Notice updateNotice(String id, Notice updatedNotice) {

        Notice notice = getNoticeById(id);

        notice.setTitle(updatedNotice.getTitle());
        notice.setContent(updatedNotice.getContent());
        notice.setCategory(updatedNotice.getCategory());

        return noticeRepository.save(notice);
    }

    // DELETE
    public String deleteNotice(String id) {

        Notice notice = getNoticeById(id);

        noticeRepository.delete(notice);

        return "Notice deleted successfully";
    }
}