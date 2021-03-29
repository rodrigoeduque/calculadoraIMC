package br.com.rodrigoeduque.imccalculadora

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        val btCalcular = botao_calcular
        val resultado = text_resultado

        fun calcularIMC(altura: Double, peso: Double): Double {
            return peso / (altura  * altura)
        }

        fun relacaoAlturaPeso(resultadoImc: Double): String {

            return when {
                resultadoImc < 18.5 -> "Estado : Magreza"
                resultadoImc < 24.9 -> "Estado : Normal"
                resultadoImc < 30.0 -> "Estado : SobrePeso"
                else -> "Estado : Obesidade"
            }

        }

        btCalcular.setOnClickListener {
            var resultadoImc = calcularIMC(
                altura = edit_text_altura.text.toString().toDouble(),
                peso = edit_text_peso.text.toString().toDouble()
            )
            resultado.text = (resultadoImc.absoluteValue).toString()

            var resultadoPesoAltura = relacaoAlturaPeso(resultadoImc)

            resultado.text = resultadoPesoAltura.toString() + "\n" + "Indice de Massa Corporal : " + resultadoImc


        }



    }


}