package com.br.alura.challenge.AluraFlix.controller.form;

import com.br.alura.challenge.AluraFlix.modelo.Video;
import com.br.alura.challenge.AluraFlix.repository.VideoRepository;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VideoForm {

    @NotNull @NotEmpty @Length(min = 5)
    private String titulo;

    @NotNull @NotEmpty @Length(min = 10)
    private String descricao;

    @NotNull @NotEmpty @Length(min = 20)
    private String url;

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


    public Video converter(VideoRepository videoRepository) {
        Video video = videoRepository.findByTitulo(titulo);
        return new Video(titulo, descricao, url);
    }

}
