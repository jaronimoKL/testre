package com.example.testre

data class feelings(val success: Boolean , val data : List<Data> )
data class Data(val id: Int, val title:String,val image:String, val position:Int)
data class quotes(val success: Boolean , val data : List<quotes_data> )
data class quotes_data(val id: Int, val title:String,val image:String,val description:String)