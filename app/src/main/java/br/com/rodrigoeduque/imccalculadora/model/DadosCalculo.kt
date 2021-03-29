package br.com.rodrigoeduque.imccalculadora.model

import java.math.BigDecimal

class DadosCalculo(
    var sexo: Sexo = Sexo.MASCULINO,
    var idade: Int,
    var altura: BigDecimal,
    var peso: BigDecimal,
    var tipoAtividade: TipoAtividade
) {


    fun calcularIMC(altura: Double, peso: Double): Double {
        return altura / (peso * peso)
    }

    fun relacaoAlturaPeso(resultadoImc: Double): String {

        when {
            resultadoImc < 18.5 -> return "Estado : Magreza"
            resultadoImc < 24.9 -> return "Estado : Normal"
            resultadoImc < 30.0 -> return "Estado : SobrePeso"
            else -> return "Estado : Obesidade"
        }

    }

}