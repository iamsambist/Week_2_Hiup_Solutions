package com.example.addnote.model

class CategoryHandler {
    companion object {
        var catgories: MutableList<Category> = mutableListOf(Category(1,"Fruits"), Category(2,"Vegetables") )

        public fun addCategory(category: Category) {
            catgories.add(category)
        }

        public fun  removeCategory(category: Category) {
            catgories.removeAll {it.id == category.id }
        }

        public fun updateCategory(id: Int,newName : String) {
            val category = catgories.find { it.id == id }
            if (category != null) {
                category.name = newName}
        }
        public fun size() : Int {
            return catgories.size
        }
    }
}