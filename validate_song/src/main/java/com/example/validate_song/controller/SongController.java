package com.example.validate_song.controller;

import com.example.validate_song.dto.SongRequestDto;
import com.example.validate_song.model.Song;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.validate_song.service.ISongService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/songs")
public class SongController {
    private ISongService songService;

    public SongController(ISongService songService) {
        this.songService = songService;
    }

    @GetMapping("")
    public String showList(@PageableDefault(page = 0, size = 5, sort = "nameSong", direction = Sort.Direction.ASC) Pageable pageable, Model model) {
        Page<Song> songPage = songService.findAll(pageable);
        model.addAttribute("songPage", songPage);
        return "song/list";
    }

    @GetMapping("/add")
    public String showFormAdd(Model model) {
        model.addAttribute("songRequestDto", new SongRequestDto());
        return "song/add";
    }

    @PostMapping("/save")
    public String save(@Validated @ModelAttribute SongRequestDto songRequestDto, BindingResult bindingResult) {
        Song song = new Song();
        new SongRequestDto().validate(songRequestDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "song/add";
        }
        BeanUtils.copyProperties(songRequestDto, song);
        songService.add(song);
        return "redirect:/songs";
    }

    @GetMapping("/{id}/update")
    public String showFormUpdate(@PathVariable Long id, Model model) {
        model.addAttribute("songRequestDto", songService.findById(id));
        model.addAttribute("songId", id);
        return "song/update";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id, @Validated @ModelAttribute SongRequestDto songRequestDto, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {
        new SongRequestDto().validate(songRequestDto, bindingResult);
        if (bindingResult.hasErrors()) {
            model.addAttribute("songId", id);
            return "song/update";
        }
        songService.update(id, songRequestDto);
        redirectAttributes.addFlashAttribute("success", "Cập Nhập Thông Tin Bài Hát Thành Công");
        return "redirect:/songs";
    }

}
