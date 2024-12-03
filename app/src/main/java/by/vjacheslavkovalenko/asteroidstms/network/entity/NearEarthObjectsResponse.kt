package by.vjacheslavkovalenko.asteroidstms.network.entity

import by.vjacheslavkovalenko.asteroidstms.domain.Asteroid

data class NearEarthObjectsResponse(
    val nearEarthObjects: Map<String, List<Asteroid>>
)
