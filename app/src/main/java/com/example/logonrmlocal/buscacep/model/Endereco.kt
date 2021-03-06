package com.example.logonrmlocal.buscacep.model

import com.google.gson.annotations.SerializedName

data class Endereco (
        val cep: String,
        val logradouro: String,
        val complemento: String,
        val bairro: String,
        val localidade: String,
        @SerializedName(value = "uf") val estado: String,
        val unidade: String,
        val ibge: Int,
        val gia: Int
)