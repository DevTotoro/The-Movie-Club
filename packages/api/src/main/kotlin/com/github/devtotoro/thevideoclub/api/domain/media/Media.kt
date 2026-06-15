package com.github.devtotoro.thevideoclub.api.domain.media

import com.github.devtotoro.thevideoclub.api.domain.common.BaseEntity
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "media")
abstract class Media(
    @Column(name = "title", nullable = false)
    var title: String,
    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    var description: String,
    @Column(name = "thumbnail_key", nullable = false, length = 512)
    var thumbnailKey: String,
    @Column(name = "release_date", nullable = false)
    var releaseDate: LocalDate,
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name = "media_genres",
        joinColumns = [JoinColumn(name = "media_id")],
        inverseJoinColumns = [JoinColumn(name = "genre_id")],
    )
    var genres: MutableSet<Genre> = mutableSetOf(),
) : BaseEntity()
