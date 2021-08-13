package com.br.alura.challenge.AluraFlix.controller;

import com.br.alura.challenge.AluraFlix.controller.dto.VideoDto;
import com.br.alura.challenge.AluraFlix.controller.form.AtualizacaoVideoForm;
import com.br.alura.challenge.AluraFlix.controller.form.VideoForm;
import com.br.alura.challenge.AluraFlix.modelo.Video;
import com.br.alura.challenge.AluraFlix.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import javax.validation.Valid;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/videos")
public class VideoController {

    @Autowired
    private VideoRepository videoRepository;

    @GetMapping
    public List<VideoDto> lista(){
            List<Video> videos = videoRepository.findAll();
            return VideoDto.converter(videos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoDto> buscaId(@PathVariable Long id) {
        Optional<Video> video = videoRepository.findById(id);
        if(video.isPresent()) {
            return ResponseEntity.ok(new VideoDto(video.get()));
        }

        return ResponseEntity.notFound().build();
    }



    @PostMapping
    @Transactional
    public ResponseEntity<VideoDto> cadastrar(@RequestBody VideoForm form, UriComponentsBuilder uriBuilder){
        Video video = form.converter(videoRepository);
        videoRepository.save(video);

        URI uri = uriBuilder.path("/videos/{id}").buildAndExpand(video.getId()).toUri();
        return ResponseEntity.created(uri).body(new VideoDto(video));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<VideoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoVideoForm form){
        Optional<Video> optional = videoRepository.findById(id);
    if(optional.isPresent()) {
        Video video = form.atualizar(id, videoRepository);
        return ResponseEntity.ok(new VideoDto(video));
    }

    return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable long id) {
        Optional<Video> optional = videoRepository.findById(id);
        if(optional.isPresent()) {
            videoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}
