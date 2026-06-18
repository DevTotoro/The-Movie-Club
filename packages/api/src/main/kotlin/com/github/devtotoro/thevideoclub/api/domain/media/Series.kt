package com.github.devtotoro.thevideoclub.api.domain.media

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "series")
class Series(
    title: String,
    description: String,
    thumbnailKey: String,
    releaseDate: LocalDate,
    @OneToMany(mappedBy = "series", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    @OrderBy("seasonNumber ASC")
    var seasons: MutableList<Season> = mutableListOf(),
) : Media(title, description, thumbnailKey, releaseDate)
