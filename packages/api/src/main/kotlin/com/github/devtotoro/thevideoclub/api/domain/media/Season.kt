package com.github.devtotoro.thevideoclub.api.domain.media

import com.github.devtotoro.thevideoclub.api.domain.common.BaseEntity
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(
    name = "seasons",
    uniqueConstraints = [
        UniqueConstraint(name = "uq_seasons_series_id_season_number", columnNames = ["series_id", "season_number"]),
    ],
)
class Season(
    @Column(name = "season_number", nullable = false)
    var seasonNumber: Int,
    @Column(name = "release_date", nullable = false)
    var releaseDate: LocalDate,
    @Column(name = "thumbnail_key", nullable = true, length = 512)
    var thumbnailKey: String? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "series_id", nullable = false)
    var series: Series,
    @OneToMany(mappedBy = "season", cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
    @OrderBy("episodeNumber ASC")
    var episodes: MutableList<Episode> = mutableListOf(),
) : BaseEntity()
