package com.oncampus.controller;

import com.oncampus.model.Notice;
import com.oncampus.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/educator/notice")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    // CREATE
    @PostMapping("/create")
    public Notice createNotice(@RequestBody Notice notice) {
        return noticeService.createNotice(notice);
    }

    // READ ALL
    @GetMapping("/all")
    public List<Notice> getAllNotices() {
        return noticeService.getAllNotices();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Notice getNoticeById(@PathVariable String id) {
        return noticeService.getNoticeById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Notice updateNotice(
            @PathVariable String id,
            @RequestBody Notice notice) {

        return noticeService.updateNotice(id, notice);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public String deleteNotice(@PathVariable String id) {
        return noticeService.deleteNotice(id);
    }
}