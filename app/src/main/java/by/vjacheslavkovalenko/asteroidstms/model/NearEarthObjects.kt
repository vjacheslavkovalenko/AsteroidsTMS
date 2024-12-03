package by.vjacheslavkovalenko.asteroidstms.model

import by.vjacheslavkovalenko.asteroidstms.domain.Asteroid

data class NearEarthObjects(
    val nearEarthObjects: Map<String, List<Asteroid>>
)
