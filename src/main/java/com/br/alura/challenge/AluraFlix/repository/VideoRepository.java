package com.br.alura.challenge.AluraFlix.repository;

import com.br.alura.challenge.AluraFlix.modelo.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long> {

    Video findByTitulo(String titulo);

}
