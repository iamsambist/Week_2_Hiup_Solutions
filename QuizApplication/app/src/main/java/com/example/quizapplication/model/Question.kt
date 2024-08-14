package com.example.quizapplication.model

class Question<T>(
    val questionText : String,
    val answer : T,
    val difficulty : Difficulty
){

}
enum class Difficulty{
    EASY,MEDIUM,HARD
}