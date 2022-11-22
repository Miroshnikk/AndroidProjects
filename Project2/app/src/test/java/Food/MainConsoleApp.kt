package com.foodapplication

import Food.DairyProduct
import Food.Food
import Food.ProteinProduct
import Food.WholeGrain

fun main() {
    val milk = DairyProduct(Food.Servings.AVERAGE, true, "dairy", "milk")
    val cheese = DairyProduct(Food.Servings.AVERAGE, true, "dairy", "cheese")
    val yogurt = DairyProduct(Food.Servings.AVERAGE, true, "dairy", "yogurt")
    val dairy = listOf(milk, cheese, yogurt)

    val meat = ProteinProduct(Food.Servings.AVERAGE, true, "protein", "meat")
    val fish = ProteinProduct(Food.Servings.AVERAGE, true, "protein", "fish")
    val protein = listOf(meat, fish)

    val bread = WholeGrain(Food.Servings.LARGE, true, "grain", "bread")
    val cereal = WholeGrain(Food.Servings.LARGE, true, "grain", "cereal")
    val grain = listOf(bread, cereal)

    val product = listOf(cereal, fish, cheese)

    product.forEach{
        it.Produtcs(it.environment)
    }


    for (i in 0..dairy.size - 1 step 1) {
        dairy[i].stringDairyProductId()
    }
    dairy.forEach {
        it.fridge()
    }


    for (i in 0..protein.size - 1 step 1) {
        protein[i].stringProteinProductId()
    }
    protein.forEach {
        it.freezer()
    }

    for (i in 0..grain.size - 1 step 1) {
        grain[i].stringWholeGrainId()
    }
    grain.forEach {
        it.room()
    }


    val food = object {
        val apple = "apple"
        val kiwi = "kiwi"
        val peach = "peach"
        val pear = "pear"
        override fun toString() = "List of fruits: $apple, $kiwi, $peach, $pear"


    }

    print(food.toString())

}

