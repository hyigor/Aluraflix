package com.br.alura.challenge.AluraFlix.controller.dto;

import com.br.alura.challenge.AluraFlix.modelo.Video;

import java.util.List;
import java.util.stream.Collectors;

public class VideoDto {

    private Long id;
    private String titulo;
    private String descricao;
    private String url;

    public VideoDto(Video video) {
        this.id = video.getId();
        this.titulo = video.getTitulo();
        this.descricao = video.getDescricao();
        this.url = video.getUrl();

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static List<VideoDto> converter(List<Video> videos) {
        return videos.stream().map(VideoDto::new).collect(Collectors.toList());
    }
}
