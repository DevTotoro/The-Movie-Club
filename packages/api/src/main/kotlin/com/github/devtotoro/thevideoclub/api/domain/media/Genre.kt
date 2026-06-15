package com.github.devtotoro.thevideoclub.api.domain.media

import com.github.devtotoro.thevideoclub.api.domain.common.BaseEntity
import jakarta.persistence.*

@Entity
@Table(
    name = "genres",
    uniqueConstraints = [
        UniqueConstraint(name = "uq_genres_name", columnNames = ["name"]),
    ],
)
class Genre(
    @Column(name = "name", nullable = false, length = 64)
    var name: String,
) : BaseEntity()
