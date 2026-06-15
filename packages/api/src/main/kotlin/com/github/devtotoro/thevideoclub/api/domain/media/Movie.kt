package com.github.devtotoro.thevideoclub.api.domain.media

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "movies")
class Movie(
    title: String,
    description: String,
    thumbnailKey: String,
    releaseDate: LocalDate,
    @Embedded
    var playback: Playback? = null,
) : Media(title, description, thumbnailKey, releaseDate)
