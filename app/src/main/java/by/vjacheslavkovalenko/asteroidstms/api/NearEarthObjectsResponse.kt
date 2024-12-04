package by.vjacheslavkovalenko.asteroidstms.api

import by.vjacheslavkovalenko.asteroidstms.domain.Asteroid

data class NearEarthObjectsResponse(
    val nearEarthObjects: Map<String, List<Asteroid>>
)
