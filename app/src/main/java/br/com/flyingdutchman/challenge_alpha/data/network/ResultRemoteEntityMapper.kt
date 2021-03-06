package br.com.flyingdutchman.challenge_alpha.data.network

import br.com.flyingdutchman.challenge_alpha.commons.formatAmenities
import br.com.flyingdutchman.challenge_alpha.data.model.ImageUrl
import br.com.flyingdutchman.challenge_alpha.data.model.Result
import br.com.flyingdutchman.challenge_alpha.data.ResultData
import br.com.flyingdutchman.challenge_alpha.commons.formatForBrazilianCurrency
import br.com.flyingdutchman.challenge_alpha.data.model.Gallery

class ResultRemoteEntityMapper() :
    RemoteEntityMapper<List<Result>, List<ResultData>> {
    override fun mapFromRemote(type: List<Result>): List<ResultData> {
        return type.map {
            ResultData(
                it.id,
                it.name,
                it.url,
                it.description,
                it.smallDescription,
                it.gallery.map { image ->

                    val url = ensureHttpsDueToAndroidP(image)
                    ImageUrl(url)
                },
                it.freeCancelation,
                it.price.amount.formatForBrazilianCurrency(),
                it.price.oldPrice.formatForBrazilianCurrency(),
                if (it.stars > 0) it.stars else 1, // Use this in order to easiest the process of grouping packages which has no stars at all
                it.address.city,
                it.amenities.formatAmenities(),
                it.isHotel
            )
        }

    }

    private fun ensureHttpsDueToAndroidP(image: Gallery): String {
        val url = image.url
        return url.replace("http://", "https://")
    }
}