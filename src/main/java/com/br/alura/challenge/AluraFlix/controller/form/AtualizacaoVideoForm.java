package com.br.alura.challenge.AluraFlix.controller.form;

import com.br.alura.challenge.AluraFlix.modelo.Video;
import com.br.alura.challenge.AluraFlix.repository.VideoRepository;
import com.sun.istack.NotNull;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class AtualizacaoVideoForm {

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

    public Video atualizar(Long id, VideoRepository videoRepository) {
        Video video = videoRepository.getOne(id);

        video.setTitulo(this.titulo);
        video.setDescricao(this.descricao);
        video.setUrl(this.url);

        return video;
    }

}
