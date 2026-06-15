package com.github.devtotoro.thevideoclub.api.domain.media

import jakarta.persistence.*

@Embeddable
class Playback(
    @Column(name = "duration_seconds", nullable = false)
    var durationSeconds: Int,
    @Column(name = "manifest_key", nullable = false, length = 512)
    var manifestKey: String,
    @Enumerated(EnumType.STRING)
    @Column(name = "streaming_format", nullable = false, length = 16)
    var streamingFormat: StreamingFormat,
)
