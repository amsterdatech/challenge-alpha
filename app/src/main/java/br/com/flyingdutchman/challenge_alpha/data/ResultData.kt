package br.com.flyingdutchman.challenge_alpha.data

import br.com.flyingdutchman.challenge_alpha.data.model.ImageUrl

data class ResultData(
    val id: String,
    var name: String,
    var url: String,
    var description: String,
    var shortDescription:String,
    var gallery:List<ImageUrl>
)