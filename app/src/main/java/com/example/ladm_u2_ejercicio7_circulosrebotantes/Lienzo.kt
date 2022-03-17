package com.example.ladm_u2_ejercicio7_circulosrebotantes

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Lienzo(act:MainActivity):View(act) {
    val act=act
    val circulos=Array<Circulo>(200,{Circulo(this)}) //Ta,año y como se inicializa

    val corutina=GlobalScope.launch {
        while(true){
            act.runOnUiThread{
                invalidate()
            }
            delay(20L)
        }
    }

    override fun onDraw(c: Canvas) {
        super.onDraw(c)

        var p=Paint(); //Paint(Acuarela)

      c.drawColor(Color.BLACK)
        for(circ in circulos) {//como for each
            circ.mover()
            circ.pintar(c)
        }
           //(0..circulos.size-1).forEach{
           //circulos[it].mover
           //circulos[it].pintar(c)}



    }
}