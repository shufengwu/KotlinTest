package com.delta.test.kotlintest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val a: Int = 1
    var b = 2
    val c: Int = 3
    val str: String = "abc"
    val s: String = "success"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        println(sum(5, 20))
        println("a=$a,b=$b,c=$c")
        println(str is String)
        println(a is Int)
        when (s) {
            is String -> {
                Toast.makeText(this, "is String", Toast.LENGTH_SHORT).show()
                when (s) {
                    "success" -> Toast.makeText(this, "success", Toast.LENGTH_SHORT).show()
                }
            }
            else -> {
                Toast.makeText(this, "is not String", Toast.LENGTH_SHORT).show()
            }

        }

        var student = Student()
        student.eat("apple", 1)

        student.eat2("apple", 1)

        student.run("5 km")
        Student.eat("apple", 1)
        val c = Student::class
        println("类的名称：" + c.simpleName)
        println("类的全称：${c.qualifiedName}")
        println("类的全称：${c.members}")

        var numbers = listOf(1, 2, 3, 4, 5)
        numbers.filter(::isOdd).forEach(::println)

        println(::bb.get())
        println(::bb.name)
        println(::cc.get())
        println(::cc.name)
        ::cc.set(222)
        println(::cc.get())


    }




    fun initView() {
        var text: String = "hehe"
        tv_content.text = text
        btn_test.setOnClickListener {
            var toastContent: String = "success!"
            Toast.makeText(this, toastContent, Toast.LENGTH_SHORT).show()
        }
    }

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    interface People {
        fun run(s: String) {
            println("run $s")
        }

        fun eat(f: String, a: Int)
    }

    class Student : People {
        override fun eat(f: String, a: Int) {
            println("eat $f $a kg")
        }

        override fun run(s: String) {
            super.run(s)
        }

        //伴随对象
        companion object ComObject {
            fun eat(f: String, a: Int) {
                println("eat $f $a kg")
            }
        }
    }

    fun Student.eat2(f: String, a: Int) {
        println("eat $f $a g")
    }


}

val bb = 2
var cc = 333

//是否为奇数
fun isOdd(x: Int): Boolean = x % 2 != 0

