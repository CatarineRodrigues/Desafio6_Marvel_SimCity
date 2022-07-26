package br.com.zup.marvel.data.repository

import br.com.zup.marvel.*
import br.com.zup.marvel.data.model.Marvel
import br.com.zup.marvel.utils.*

class MarvelRepository {
    fun getMarvelList(): List<Marvel> {
        val marvelList = mutableListOf<Marvel>()

        marvelList.add(
            Marvel(
                R.drawable.gamora,
                GAMORA_NOME,
                GAMORA_DESCRICAO
            )
        )

        marvelList.add(
            Marvel(
                R.drawable.homem_ferro,
                HOMEM_FERRO_NOME,
                HOMEM_FERRO_DESCRICAO
            )
        )

        marvelList.add(
            Marvel(
                R.drawable.mulher_invisivel,
                MULHER_INVISIVEL_NOME,
                MULHER_INVISIVEL_DESCRICAO
            )
        )

        return marvelList
    }
}