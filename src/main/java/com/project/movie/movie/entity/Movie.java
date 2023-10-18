package com.project.movie.movie.entity;

import com.project.movie.cinema.entity.MovieTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long movieId;
    @Column(name = "movie_title", nullable = false)
    private String movieTitle;

    @Enumerated(EnumType.STRING)
    @Column(name = "movie_genre", nullable = false)
    private MovieGenre movieGenre;

    @Enumerated(EnumType.STRING)
    @Column(name = "movie_rate", nullable = false)
    private MovieRate movieRate;

    @Column(name = "movie_director", nullable = false)
    private String movieDirector;

    @Column(name = "movie_acter", nullable = false)
    private String movieActor;

    @Column(name = "movie_running_time", nullable = false)
    private String movieRunningTime;

    @Column(name = "movie_content", nullable = false, columnDefinition = "TEXT")
    private String movieContent;

    @Column(name = "movie_release_date", nullable = false)
    private String movieReleaseDate;
    @Column(name = "movie_deleted", nullable = false)
    private boolean movieDeleted;
    @OneToMany(mappedBy = "movie")
    private List<MovieTime> movieTimes = new ArrayList<>();

    public void markAsDeleted() {
        this.movieDeleted = true;
    }
    public void updateFrom(Movie updateMovieDto) {
        if (updateMovieDto.getMovieTitle() != null) {
            this.movieTitle = updateMovieDto.getMovieTitle();
        }
        if (updateMovieDto.getMovieGenre() != null) {
            this.movieGenre = updateMovieDto.getMovieGenre();
        }
        if (updateMovieDto.getMovieRate() != null) {
            this.movieRate = updateMovieDto.getMovieRate();
        }
        if (updateMovieDto.getMovieDirector() != null) {
            this.movieDirector = updateMovieDto.getMovieDirector();
        }
        if (updateMovieDto.getMovieActor() != null) {
            this.movieActor = updateMovieDto.getMovieActor();
        }
        if (updateMovieDto.getMovieRunningTime() != null) {
            this.movieRunningTime = updateMovieDto.getMovieRunningTime();
        }
        if (updateMovieDto.getMovieContent() != null) {
            this.movieContent = updateMovieDto.getMovieContent();
        }
        if (updateMovieDto.getMovieReleaseDate() != null) {
            this.movieReleaseDate = updateMovieDto.getMovieReleaseDate();
        }
    }
}
