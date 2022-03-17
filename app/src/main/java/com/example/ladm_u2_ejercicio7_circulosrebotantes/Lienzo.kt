package com.example.ladm_u2_ejercicio7_circulosrebotantes

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class Lienzo(act:MainActivity):View(act) {
    val act=act
    val circulos=Array<Circulo>(100,{Circulo(this)}) //Ta,año y como se inicializa
    var fondo=Color.BLACK

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
        c.drawColor(fondo)

        for(circ in circulos) {//como for each
            circ.mover()
            circ.pintar(c)
        }
           //(0..circulos.size-1).forEach{
           //circulos[it].mover
           //circulos[it].pintar(c)}



    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        //event.action //3 estados (Presionar, Arrastrar y Soltar)
        event.x //X del toque
        event.y //y del toque
        when(event.action){
            MotionEvent.ACTION_DOWN->{ //Presionar

            }

            MotionEvent.ACTION_MOVE->{ //Arrastrar

            }

            MotionEvent.ACTION_UP->{ //Soltar
                if(event.y<300){
                    (0..circulos.size-1).forEach{
                        //circulos[it].acelerar()}

                    else{
                        fondo=Color.rgb(rand(255).toInt(),rand(255).toInt(),rand(255).toInt())
                    }
                }
            }
        }
        return true
    }

    private fun rand(hasta : Int):Float{
        return Random.nextInt(hasta).toFloat()
    }
}