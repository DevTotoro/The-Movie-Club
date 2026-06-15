package com.github.devtotoro.thevideoclub.api.domain.media

import com.github.devtotoro.thevideoclub.api.domain.common.BaseEntity
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(
    name = "episodes",
    uniqueConstraints = [
        UniqueConstraint(name = "uq_episodes_season_id_episode_number", columnNames = ["season_id", "episode_number"]),
    ],
)
class Episode(
    @Column(name = "title", nullable = true)
    var title: String?,
    @Column(name = "description", nullable = true, columnDefinition = "TEXT")
    var description: String?,
    @Column(name = "episode_number", nullable = false)
    var episodeNumber: Int,
    @Column(name = "release_date", nullable = false)
    var releaseDate: LocalDate,
    @Column(name = "thumbnail_key", nullable = true, length = 512)
    var thumbnailKey: String? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "season_id", nullable = false)
    var season: Season,
    @Embedded
    var playback: Playback? = null,
) : BaseEntity()
