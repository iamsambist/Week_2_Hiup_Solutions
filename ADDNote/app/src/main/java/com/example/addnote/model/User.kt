package com.example.addnote.model

data class User(var id :Int =0,var username : String,var password : String) {

    fun validate(): String {
       if(username != "user") return "Invalid User Name"
        else if(password!="pass") return "Invalid Password"
        else{
            return "good"
       }
    }
}