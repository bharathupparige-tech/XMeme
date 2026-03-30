package com.crio.starter.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.crio.starter.entity.MemeEntity;
import com.crio.starter.service.MemeService;
@RestController
@RequestMapping("/memes")
public class MemeController {

    @Autowired
    private MemeService memeService;

    @PostMapping
    public ResponseEntity<Map<String, String>> createMeme(@RequestBody MemeEntity meme) {

        if (meme.getName() == null || meme.getName().isEmpty() ||
            meme.getCaption() == null || meme.getCaption().isEmpty() ||
            meme.getUrl() == null || meme.getUrl().isEmpty()) {

            return ResponseEntity.badRequest().build();
        }

        MemeEntity saved = memeService.createMeme(meme);

        return ResponseEntity
                .status(201)
                .body(Map.of("id", saved.getId()));
    }

    @GetMapping({"", "/"})
    public List<MemeEntity> getMemes() {
        return memeService.getLatestMemes();
    }

    @GetMapping("/{id}")
    public MemeEntity getMemeById(@PathVariable String id) {
        return memeService.getMemeById(id);
    }
}