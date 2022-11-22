package Food

abstract class Food(val environment: Servings) {
    abstract fun purpose()

    open fun healthBenefits(){
        println("Appropriate impact on health")
    }

    enum class Servings{
        LARGE, AVERAGE, SMALL
    }

   open fun Produtcs(environment: Servings)
   {
       println("Servings: $environment")
   }




}